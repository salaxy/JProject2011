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
import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;
import org.orm.PersistentException;
import org.orm.PersistentSession;

public class DocumentManager {
	
	private DocumentDA docuDA;
	private ProjectDA projectDA;
	private String path="F:/";
	
	private static final Logger logger = Logger.getLogger(ProjectManager.class);
	
	public DocumentManager(ProjectRolesManager projectRolesManager, GlobalRolesManager globalRolesManager){
		
		projectDA = DAFactory.getDAFactory().getProjectDA();
		docuDA = DAFactory.getDAFactory().getDocumentDA();
	}
	
	// !!! Dokument Actions !!!
	
	public void addNewDocu(String projectName, List<FileItem> fields)throws ProjectException{
		clearSession();
		
		logger.info("addNewDocu()");
		logger.debug("String projectName("+projectName+")");
		
		Document docu=null;
		Project project = null;
		Document[] doculiste=null;
		boolean vorhanden=false;
		
		//EIGENTLICHE AKTIONEN
		try {
			project=projectDA.getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Project nicht finden! "+ e1.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine projectName mitgegeben! "+ e.getMessage());
		}
		
		doculiste=project.document.toArray();
		
		Iterator<FileItem> it = fields.iterator();
		while (it.hasNext()) {
			
			FileItem fileItem = it.next();	
			
			if (fileItem.getFieldName().equals("do")){
				fileItem = it.next();
			}
			
			for(int i=0;i<doculiste.length;i++){
				if (doculiste[i].getDateiname().equalsIgnoreCase(fileItem.getName())){
					vorhanden=true;
				}
			}
			
			logger.debug("File "+ fileItem.getName());
			
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
				}
				catch (IOException e) {
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
			
			

			
			//docu speichern

			vorhanden=false;
		}
		
	}
		
	public void deleteDocu(int docuId, String projectName)throws ProjectException {
		
		Document docu = null;
		File docuFile=null;
		
		//debuglogging
		logger.info("deleteDocu()");
		logger.debug("int docuId("+docuId+")");
		
		clearSession();

		//EIGENTLICHE AKTIONEN
		
		//hole der docu
		try {
			docu=docuDA.getDocumentByORMID(docuId);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Document nicht finden! "+ e.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine DocuId mitgegeben! "+ e.getMessage());
		}catch(IllegalArgumentException e){
			throw new ProjectException("DocuId fehlerhaft! "+ e.getMessage());
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
	
	public void downloadDocu(){}
	
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
	
	public void updateDocu(String projectName, List<FileItem> fields, int docuID)throws ProjectException{
		
		this.addNewDocu(projectName, fields);
		
	}
	
	public Document showDocu(int docuID)throws ProjectException{
		
		Document docu = null;
		
		//hole der docu
		try {
			docu=docuDA.getDocumentByORMID(docuID);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Document nicht finden! "+ e.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine DocuId mitgegeben! "+ e.getMessage());
		}catch(IllegalArgumentException e){
			throw new ProjectException("DocuId fehlerhaft! "+ e.getMessage());
		}
		
		return docu;
	}
	
	public String showDocuContent(String projectName, int docuID)throws ProjectException{
		
		Document docu = null;
		
		//hole der docu
		try {
			docu=docuDA.getDocumentByORMID(docuID);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Document nicht finden! "+ e.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine DocuId mitgegeben! "+ e.getMessage());
		}catch(IllegalArgumentException e){
			throw new ProjectException("DocuId fehlerhaft! "+ e.getMessage());
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
			throw new ProjectException("Konnte Session nicht clearen! "+ e.getMessage());
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
