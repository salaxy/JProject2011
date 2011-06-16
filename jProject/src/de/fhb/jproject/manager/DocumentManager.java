package de.fhb.jproject.manager;

import de.fhb.jproject.data.DAFactory;
import de.fhb.jproject.data.Document;
import de.fhb.jproject.data.DocumentSetCollection;
import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.repository.da.DocumentDA;
import de.fhb.jproject.repository.da.ProjectDA;

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
 * 
 * @author Tino Reuschel
 *
 */
public class DocumentManager {
	
	private DocumentDA docuDA;
	private ProjectDA projectDA;
	private String path="F:/";
	
	private static final Logger logger = Logger.getLogger(DocumentManager.class);
	
	/**
	 * Default-Construtor
	 */
	public DocumentManager(){
		
		projectDA = DAFactory.getDAFactory().getProjectDA();
		docuDA = DAFactory.getDAFactory().getDocumentDA();
	}
	
	/**
	 * hinzufügen eines Documents in Datenbank und Filesystem
	 * 
	 * @param projectName:String
	 * @param fields:List<FileItem>
	 * @throws ProjectException
	 */
	public void addNewDocu(String projectName, List<FileItem> fields)throws ProjectException{
		clearSession();
		
		logger.info("addNewDocu()");
		logger.debug("String projectName("+projectName+")");
		logger.debug("List<FileItem> fields("+fields.toString()+")");
		
		Document docu=null;
		Project project = null;
		Set<Document> doculiste=null;
		boolean vorhanden=false;
		
		//EIGENTLICHE AKTIONEN
		//document holen
		try {
			project=projectDA.getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Project nicht finden! "+ e1.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine projectName mitgegeben! "+ e.getMessage());
		}
		
		doculiste=project.document.getCollection();
		
		//schleife für alle elemente der liste
		Iterator<FileItem> it = fields.iterator();
		while (it.hasNext()) {
			
			FileItem fileItem = it.next();	
			
			if (fileItem.getFieldName().equals("do")){
				fileItem = it.next();
			}
			
			//schauen ob document vorhanden
			for (Object o : doculiste) {
				Document document=(Document)o;
				if (document.getDateiname().equals(fileItem.getName())){
					vorhanden=true;
				}
			}

			
			logger.debug("File "+ fileItem.getName());
			
			//entsprechend ob vorhanden oder nicht reagieren
			if(!vorhanden){
				//docu erzeugen und parameter setzen
				docu=docuDA.createDocument();
				//project setzen
				docu.setProject(project);
				//setzen weiterer attribute
				docu.setDateiname(fileItem.getName());
				
				try {
					// alles speichern
					docuDA.save(docu);
					saveDocument(fileItem, project.getName());
				} catch (PersistentException e) {
					throw new ProjectException("Konnte Document nicht speichern! "+ e.getMessage());
				} catch (IOException e) {
					try {
					docuDA.delete(docu);
					} catch (PersistentException g){
						throw new ProjectException("Konnte Dokument nach Fehlschlag nicht aus der Datenbank lï¿½schen!");
					}
					throw new ProjectException("Konnte Document nicht speichern! "+ e.getMessage());
				}
				
			} else {
				try {
					// alles speichern
					saveDocument(fileItem, project.getName());
				}catch (IOException e) {
					throw new ProjectException("Konnte Document nicht speichern! "+ e.getMessage());
				}
			}
			vorhanden=false;
		}
		
	}
	
	/**
	 * methode zum löschen eine documents aus der datenbank und dem filesystems
	 * @param documentId:int
	 * @param projectName:String
	 * @throws ProjectException
	 */
	public void deleteDocu(int documentId, String projectName)throws ProjectException {
		
		clearSession();
		
		Document docu = null;
		File docuFile=null;
		
		//debuglogging
		logger.info("deleteDocu()");
		logger.debug("int documentId("+documentId+") " +
				"String projectName("+ projectName + ")");

		//EIGENTLICHE AKTIONEN
		
		//hole der docu
		try {
			docu=docuDA.getDocumentByORMID(documentId);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Document nicht finden! "+ e.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine documentId mitgegeben! "+ e.getMessage());
		}catch(IllegalArgumentException e){
			throw new ProjectException("documentId fehlerhaft! "+ e.getMessage());
		}
		
		docuFile=new File(path + projectName + "/Document/" + docu.getDateiname());
		
		//loeschen
		try {	
			clearSession();
			
			//task loeschen
			docuDA.delete(docu);
			docuFile.delete();
		} catch (PersistentException e) {
			throw new ProjectException("Kann Document nicht loeschen! "+ e.getMessage());
		}
		
		
	}
	
	public File downloadDocu(int documentId, String projectName) throws ProjectException{
		
		clearSession();
		
		Document docu = null;
		File docuFile;
		//hole der docu
		try {
			docu=docuDA.getDocumentByORMID(documentId);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Document nicht finden! "+ e.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine documentId mitgegeben! "+ e.getMessage());
		}catch(IllegalArgumentException e){
			throw new ProjectException("documentId fehlerhaft! "+ e.getMessage());
		}
		
		docuFile=new File(path + projectName + "/Document/" + docu.getDateiname());
		
		return docuFile;
	}
	
	public DocumentSetCollection showAllDocu(String projectName)throws ProjectException{
		
		Project project=null;
		
		clearSession();
		
		//debuglogging
		logger.info("showAllTasks()");
		
		//projekt holen
		try {
			project=projectDA.getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Projekt nicht finden! "+ e1.getMessage());
		}	
		
		return project.document;
		
	}
	
	public void updateDocu(String projectName, List<FileItem> fields, int documentId)throws ProjectException{
		
		this.addNewDocu(projectName, fields);
		
	}
	
	public Document showDocu(int documentId)throws ProjectException{
		
		clearSession();
		
		Document docu = null;
		
		//hole der docu
		try {
			docu=docuDA.getDocumentByORMID(documentId);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Document nicht finden! "+ e.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine documentId mitgegeben! "+ e.getMessage());
		}catch(IllegalArgumentException e){
			throw new ProjectException("documentId fehlerhaft! "+ e.getMessage());
		}
		
		return docu;
	}
	
	
	public String showDocuContent(String projectName, int documentId)throws ProjectException{
		
		Document docu = null;
		
		//hole der docu
		try {
			docu=docuDA.getDocumentByORMID(documentId);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Document nicht finden! "+ e.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine documentId mitgegeben! "+ e.getMessage());
		}catch(IllegalArgumentException e){
			throw new ProjectException("documentId fehlerhaft! "+ e.getMessage());
		}
		
		try {
			return getDocuContent(docu.getDateiname(),projectName);
		} catch (IOException e){
			throw new ProjectException("Datei konnte nicht gelesen werden!");
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
			throw new NullPointerException();
		}
		
	}
	
	private void saveDocument(FileItem fileItem, String projectName) throws IOException{
		File file = new File(path + projectName + "/Document/" + fileItem.getName());
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
	
	private String getDocuContent(String filename, String projectName) throws IOException{
		File file = new File(path + projectName + "/Document/" + filename);
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
