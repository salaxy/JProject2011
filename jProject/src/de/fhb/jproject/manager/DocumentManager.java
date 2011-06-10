package de.fhb.jproject.manager;

import de.fhb.jproject.data.DAFactory;
import de.fhb.jproject.data.Document;
import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.Member;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.repository.da.DocumentDA;
import de.fhb.jproject.repository.da.MemberDA;
import de.fhb.jproject.repository.da.ProjectDA;

import java.io.File;
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

	private ProjectRolesManager projectRolesManager;
	private GlobalRolesManager globalRolesManager;
	
	private MemberDA memberDA;
	private DocumentDA docuDA;
	private ProjectDA projectDA;
	
	private static final Logger logger = Logger.getLogger(ProjectManager.class);
	
	public DocumentManager(ProjectRolesManager projectRolesManager, GlobalRolesManager globalRolesManager){
		
		this.projectRolesManager=projectRolesManager;
		this.globalRolesManager=globalRolesManager;
		
		projectDA = DAFactory.getDAFactory().getProjectDA();
		memberDA = DAFactory.getDAFactory().getMemberDA();
		docuDA = DAFactory.getDAFactory().getDocumentDA();
	}
	
	// !!! Dokument Actions !!!
	
	public void addNewDocu(User aktUser, Project aktProject, List<FileItem> fields)throws ProjectException{
		clearSession();
		
		logger.info("addNewDocu()");
		//logger.debug("String projectName("+aktProject.getName()+")");//TODO
		
		Member memAktUser=null;	
		Document docu=null;
		Project project = null;
		
				
		if(aktUser == null){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		try {
			project=projectDA.getProjectByORMID(aktProject.getName());
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Project nicht finden! "+ e1.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine projectName mitgegeben! "+ e.getMessage());
		}
		
		if(!globalRolesManager.isAllowedAddNewDocuAction(aktUser.getGlobalRole())){
			//Projekt-Rolle des aktuellen Users holen
			memAktUser = getMember(aktUser, project);
			
			//RECHTE-ABFRAGE Projekt
			if(!projectRolesManager.isAllowedAddNewDocuAction(memAktUser.getProjectRole())){
				throw new ProjectException("Sie haben keine Rechte zum hinzufuegen eines Dokumentes!");
			}		
		}
		
		clearSession();
		//EIGENTLICHE AKTIONEN
		try {
			project=projectDA.getProjectByORMID(aktProject.getName());
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Project nicht finden! "+ e1.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine projectName mitgegeben! "+ e.getMessage());
		}
		
		Iterator<FileItem> it = fields.iterator();
		while (it.hasNext()) {
			
			FileItem fileItem = it.next();	
			
			if (fileItem.getFieldName().equals("do")){
				fileItem = it.next();
			}
			
			logger.debug("File "+ fileItem.getName());
			//docu erzeugen und parameter setzen
			docu=docuDA.createDocument();
			//project setzen
			docu.setProject(project);
			//setzen weiterer attribute
			docu.setDateiname(fileItem.getName());
			
			//docu speichern
			try {
				// alles speichern
				docuDA.save(docu);
				saveDocument(fileItem);
			} catch (PersistentException e) {
				throw new ProjectException("Konnte Document nicht speichern! "+ e.getMessage());
			}
			catch (IOException e) {
				throw new ProjectException("Konnte Document nicht speichern! "+ e.getMessage());
			}
		}
		
	}
		
	public void deleteDocu(User aktUser, int taskId, String projectName){}
	
	public void downloadDocu(){}
	
	public List<Document> showAllDocu(User aktUser, String projectName)throws ProjectException{return null;}
	
	public void updateDocu(){}
	
	public Document showDocu(User aktUser, String projectName, int documentId)throws ProjectException{return null;}
	
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
	private Member getMember(User aktUser, Project project)throws ProjectException{
		Member aktMember = null;
		try {
			aktMember=memberDA.getMemberByORMID(aktUser, project);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Member nicht finden! "+ e1.getMessage());
		}
		return aktMember;
	}
	
	private void saveDocument(FileItem fileItem) throws IOException{
		File file = new File(fileItem.getName());
		FileOutputStream out = new FileOutputStream(file);
		byte[] data = new byte[1024];
	    int offset = 0;
	    int length=0;
	    InputStream in = fileItem.getInputStream();
	    
	    //solange ich noch daten von inputstream erhalte speicher
	    while ((length=in.read(data))== 1024){
	    	out.write(data, offset, length);
	    	offset +=1024;
	    	System.out.println("Test:"+new String(data));
	    }
	    System.out.println("Test:"+ new String(data));
	    out.write(data,offset,length);	
	}
	
}
