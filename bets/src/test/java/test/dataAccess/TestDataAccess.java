package test.dataAccess;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import configuration.ConfigXML;
import domain.Event;

public class TestDataAccess {
	protected  EntityManager  db;
	protected  EntityManagerFactory emf;

	ConfigXML  c=ConfigXML.getInstance();


	public TestDataAccess()  {
		
		System.out.println("Creating TestDataAccess instance");

		open();
		
	}

	
	public void open(){
		
		System.out.println("Opening TestDataAccess instance ");

		String fileName=c.getDbFilename();
		
		if (c.isDatabaseLocal()) {
			  emf = Persistence.createEntityManagerFactory("objectdb:"+fileName);
			  db = emf.createEntityManager();
		} else {
			Map<String, String> properties = new HashMap<String, String>();
			  properties.put("javax.persistence.jdbc.user", c.getUser());
			  properties.put("javax.persistence.jdbc.password", c.getPassword());

			  emf = Persistence.createEntityManagerFactory("objectdb://"+c.getDatabaseNode()+":"+c.getDatabasePort()+"/"+fileName, properties);

			  db = emf.createEntityManager();
    	   }
		
	}
	public void close(){
		db.close();
		System.out.println("DataBase closed");
	}

	public boolean removeEvent(Date eventDate, String desc) {
		System.out.println(">> DataAccessTest: removeEvent");
		Event event = null;
		TypedQuery<Event> Equery = db.createQuery("SELECT e FROM Event e WHERE e.getEventDate() =?1 ",Event.class);
		Equery.setParameter(1, eventDate);
		for(Event ev: Equery.getResultList()) {
			if(ev.getDescription().equals(desc)) {
				event = ev;
			}
		}
		if (event!=null) {
			db.getTransaction().begin();
			db.remove(event);
			db.getTransaction().commit();
			return true;
		} else 
		return false;
    }
	
	public boolean eventExists(Date eventDate, String desc) {
		System.out.println(">> DataAccessTest: removeEvent");
		TypedQuery<Event> Equery = db.createQuery("SELECT e FROM Event e WHERE e.getEventDate() =?1 ",Event.class);
		Equery.setParameter(1, eventDate);
		for(Event ev: Equery.getResultList()) {
			if(ev.getDescription().equals(desc)) {
				return true;
			}
		}
		return false;
    }
	
	public Event getEvent(Date eventDate, String desc) {
		System.out.println(">> DataAccessTest: removeEvent");
		TypedQuery<Event> Equery = db.createQuery("SELECT e FROM Event e WHERE e.getEventDate() =?1 ",Event.class);
		Equery.setParameter(1, eventDate);
		for(Event ev: Equery.getResultList()) {
			if(ev.getDescription().equals(desc)) {
				return ev;
			}
		}
		return null;
    }
		
		
}

