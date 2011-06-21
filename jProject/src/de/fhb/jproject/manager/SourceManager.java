package de.fhb.jproject.manager;

import de.fhb.jproject.data.DAFactory;
import de.fhb.jproject.data.Document;
import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.Sourcecode;
import de.fhb.jproject.data.SourcecodeSetCollection;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.repository.da.DocumentDA;
import de.fhb.jproject.repository.da.ProjectDA;
import de.fhb.jproject.repository.da.SourcecodeDA;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;
import org.orm.PersistentException;
import org.orm.PersistentSession;

/**
 * diese Klasse kontrolliert dden Zugriff auf den SourceCode
 * @author Tino Reuschel
 *
 */
public class SourceManager {
	
	private SourcecodeDA sourceDA;
	private ProjectDA projectDA;
	private String path="F:/";
	
	private static final Logger logger = Logger.getLogger(SourceManager.class);
	
	/**
	 * Default-Construtor
	 */
	public SourceManager(){
		projectDA = DAFactory.getDAFactory().getProjectDA();
		sourceDA = DAFactory.getDAFactory().getSourcecodeDA();
	}
	
	/**
	 * hinzufuegen eines SourceCodes in Datenbank und Filesystem
	 * 
	 * @param projectName:String
	 * @param fields:List<FileItem>
	 * @throws ProjectException
	 */
	public void  addNewSource(String projectName, List<FileItem> fields)throws ProjectException{
		
		
		logger.info("addNewSource()");
		logger.debug("String projectName("+projectName+")");
		logger.debug("List<FileItem> fields("+fields.toString()+")");
		
		Sourcecode source=null;
		Project project = null;
		Set<Sourcecode> sourceliste=null;
		boolean vorhanden=false;
		
		//EIGENTLICHE AKTIONEN
		//sourcecode holen
		try {
			project=projectDA.getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Project nicht finden! "+ e1.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine projectName mitgegeben! "+ e.getMessage());
		}
		
		sourceliste=project.sourcecode.getCollection();
		
		//schleife fuer alle elemente der liste
		Iterator<FileItem> it = fields.iterator();
		while (it.hasNext()) {
			
			FileItem fileItem = it.next();	
			
			if (fileItem.getFieldName().equals("do")){
				fileItem = it.next();
			}
			
			//schauen ob sourcecode vorhanden
			for (Object o : sourceliste) {
				Sourcecode sourcecode=(Sourcecode)o;
				if (sourcecode.getDateiname().equals(fileItem.getName())){
					vorhanden=true;
				}
			}

			
			logger.debug("File "+ fileItem.getName());
			
			//entsprechend ob vorhanden oder nicht reagieren
			if(!vorhanden){
				//sourcecode erzeugen und parameter setzen
				source=sourceDA.createSourcecode();
				//project setzen
				source.setProject(project);
				//setzen weiterer attribute
				source.setDateiname(fileItem.getName());
				
				try {
					// alles speichern
					sourceDA.save(source);
					saveSourcecode(fileItem, project.getName());
				} catch (PersistentException e) {
					throw new ProjectException("Konnte SourceCode nicht speichern! "+ e.getMessage());
				} catch (IOException e) {
					try {
					sourceDA.delete(source);
					} catch (PersistentException g){
						throw new ProjectException("Konnte SourceCode nach Fehlschlag nicht aus der Datenbank loeschen!");
					}
					throw new ProjectException("Konnte SourceCode nicht speichern! "+ e.getMessage());
				}
				
			} else {
				try {
					// alles speichern
					saveSourcecode(fileItem, project.getName());
				}catch (IOException e) {
					throw new ProjectException("Konnte SourceCode nicht speichern! "+ e.getMessage());
				}
			}
			vorhanden=false;
		}
	}	
	
	/**
	 * methode zum loeschen eines Sourcecodes aus der Datenbank und dem Filesystems
	 * @param sourceId:int
	 * @param projectName:String
	 * @throws ProjectException
	 */
	public void  deleteSource(int sourceId, String projectName)throws ProjectException {
		
		
		Sourcecode source = null;
		File sourceFile=null;
		
		//debuglogging
		logger.info("deleteSource()");
		logger.debug("int sourceId("+sourceId+") " +
				"String projectName("+ projectName + ")");

		//EIGENTLICHE AKTIONEN
		
		//hole der sourcecode
		try {
			source=sourceDA.getSourcecodeByORMID(sourceId);
		} catch (PersistentException e) {
			throw new ProjectException("Kann SourceCode nicht finden! "+ e.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine sourceId mitgegeben! "+ e.getMessage());
		}catch(IllegalArgumentException e){
			throw new ProjectException("sourceId fehlerhaft! "+ e.getMessage());
		}
		
		sourceFile=new File(path + projectName + "/Sourcecode/" + source.getDateiname());
		
		//loeschen
		try {	
			
			
			//sourcecode loeschen
			sourceDA.delete(source);
			sourceFile.delete();
		} catch (PersistentException e) {
			throw new ProjectException("Kann Sourcecode nicht loeschen! "+ e.getMessage());
		}
		
	}	
	
	/**
	 * methode um ein Sourcecode zu downloaden
	 * @param sourceId:int
	 * @param projectName:String
	 * @return File
	 * @throws ProjectException
	 */
	public File downloadSource(int sourceId, String projectName) throws ProjectException{
		
		
		logger.info("downloadSource()");
		logger.debug("int sourceId("+sourceId+")"
				+ "String projectName("+projectName+")");
		
		Sourcecode source = null;
		File sourceFile;
		//hole der sourcecode
		try {
			source=sourceDA.getSourcecodeByORMID(sourceId);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Sourcecode nicht finden! "+ e.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine sourceId mitgegeben! "+ e.getMessage());
		}catch(IllegalArgumentException e){
			throw new ProjectException("sourceId fehlerhaft! "+ e.getMessage());
		}
		
		sourceFile=new File(path + projectName + "/Sourcecode/" + source.getDateiname());
		
		return sourceFile;
	}	
	
	/**
	 * Methode um ein Sourcecode aus der Datenbank zu holen
	 * @param sourceId:int
	 * @return Sourcecode
	 * @throws ProjectException
	 */
	public Sourcecode showSource(int sourceId)throws ProjectException{
		
		logger.info("showSource()");
		logger.debug("int sourceId("+sourceId+")");
		
		Sourcecode source = null;
		
		//hole der sourecode
		try {
			source=sourceDA.getSourcecodeByORMID(sourceId);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Sourcecode nicht finden! "+ e.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine sourceId mitgegeben! "+ e.getMessage());
		}catch(IllegalArgumentException e){
			throw new ProjectException("sourceId fehlerhaft! "+ e.getMessage());
		}
		
		return source;
	}
	
	/**
	 * methode zum Anzeigen aller Sourcecodes eines Projectes
	 * @param projectName:String
	 * @return SourcecodeSetCollection
	 * @throws ProjectException
	 */
	public SourcecodeSetCollection showAllSource(String projectName)throws ProjectException{
		Project project=null;
		
		
		
		//debuglogging
		logger.info("showAllSource()");
		logger.debug("String projectName("+projectName+")");
		
		//projekt holen
		try {
			project=projectDA.getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Projekt nicht finden! "+ e1.getMessage());
		}	
		
		return project.sourcecode;
	}	
	
	/**
	 * methode um ein Sourcecode neu hochzuladen ohne neuen Eintrag in die Datenbank
	 * @param projectName:String
	 * @param fields:List<FileItem>
	 * @param sourceId:int
	 * @throws ProjectException
	 */
	public void updateSource(String projectName, List<FileItem> fields, int sourceId)throws ProjectException{
		
		logger.info("updateSource()");
		logger.debug("String projectName("+projectName+")"
				+ "List<FileItem> fields("+fields.toString()+")"
				+ "int sourceID("+sourceId+")");
		
		this.addNewSource(projectName, fields);
	}

	/**
	 * Methode die den Inhalt eines Sourcecodes ausliest und in einen String umwandelt
	 * @param projectName
	 * @param sourceId
	 * @return
	 * @throws NullPointerException
	 * @throws ProjectException
	 */
	public String showSourceContent(String projectName, int sourceId)throws NullPointerException, ProjectException{
		
		
		
		logger.info("showDocuContent()");
		logger.debug("int sourceId("+sourceId+")"
				+ "String projectName("+projectName+")");
		
		Sourcecode source = null;
		
		//hole der sourecode
		try {
			source=sourceDA.getSourcecodeByORMID(sourceId);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Sourcecode nicht finden! "+ e.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine sourceId mitgegeben! "+ e.getMessage());
		}catch(IllegalArgumentException e){
			throw new ProjectException("sourceId fehlerhaft! "+ e.getMessage());
		}
		
		try {
			return getSourceContent(source.getDateiname(),projectName);
		} catch (IOException e){
			throw new NullPointerException("Konnte Sourcecode nicht lesen! "+e);
		}
	}
	
	private void clearSession() throws ProjectException{
		try {
			PersistentSession session;		
			//Session holen
			session = JProjectPersistentManager.instance().getSession();
			//und bereinigen
			session.clear();
		} catch (PersistentException e) {
			throw new ProjectException("Konnte Session nicht clearen! "+ e.getMessage());
		}
		
	}
	
	/**
	 * methode zum Speichern eines Sourcecode in das Filesystem
	 * @param fileItem:FileItem
	 * @param projectName:String
	 * @throws IOException
	 */
	private void saveSourcecode(FileItem fileItem, String projectName) throws IOException{
		//TODO debuginfo
		File file = new File(path + projectName + "/Sourcecode/" + fileItem.getName());
		FileOutputStream out = new FileOutputStream(file);
		byte[] data = new byte[1024];
	    int length=0;
	    InputStream in = fileItem.getInputStream();
		
		if (file.exists()) {
			file.delete();
		}
		
	    file.createNewFile();
		
		//solange ich noch daten von inputstream erhalte speicher
	    do {
	    	length=in.read(data);
	    	out.write(data, 0, length);
	    } while (length == 1024);
	    out.close();
	}
	
	/**
	 * methode zum Auslesen einer Datei und den Inhalt in einen String umwandeln
	 * @param filename:String
	 * @param projectName:String
	 * @return String
	 * @throws IOException
	 */
	private String getSourceContent(String filename, String projectName) throws IOException{
		//TODO debuginfo
		File file = new File(path + projectName + "/Sourcecode/" + filename);
		FileInputStream in=new FileInputStream(file); 
		byte[] data = new byte[1024];
		StringBuilder content=new StringBuilder("");
	    int length=0;
		
		if (file.exists()) {
			 do {
			    	length=in.read(data);
			    	content=content.append(new String(data));
			    } while (length == 1024);
			    in.close();
		}
		return content.toString();
	}
}
