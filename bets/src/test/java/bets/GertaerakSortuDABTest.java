package bets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;


import dataAccess.DataAccess;
import domain.Event;



public class GertaerakSortuDABTest {
	
	//sut:system under test
	 static DataAccess sut=new DataAccess();
	 
	 //additional operations needed to execute the test 
	 static TestDataAccess testDA=new TestDataAccess();
	
	@Test
	//sut.gertaerakSortu:  Deporte incorrecto, tiene que dar false 
	public void test1() {
		String description = "Real Madrid-Barcelona";
		String sport = "Patata";
		boolean resp;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date eventDate=null;;
		try {
			eventDate = sdf.parse("30/10/2022");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {	
			//invoke System Under Test (sut)
			sut.open(true);
			resp = sut.gertaerakSortu(description, eventDate, sport);
			sut.close();
			
			//verify the results
			assertFalse(resp);
			
			//event is NOT in database
			testDA.open();
			boolean exists = testDA.eventExists(eventDate, description);
			testDA.close();
			assertFalse(exists);
			
		} catch(Exception e) {
			fail();
		} finally {
			//Remove the created objects in the database (cascade removing)
			testDA.open();
	        boolean b=testDA.removeEvent(eventDate, description);
	        testDA.close();
	        System.out.println("Finally "+b);
		}
	}
	
	@Test
	//sut.gertaerakSortu:  Tiene que meter el evento en la BD, en esa fecha no hay más eventos 
	public void test2() {
		String description = "Real Madrid-Barcelona";
		String sport = "Futbol";
		boolean resp;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date eventDate=null;;
		try {
			eventDate = sdf.parse("30/10/2022");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {	
			
			//invoke System Under Test (sut)
			sut.open(true);
			resp = sut.gertaerakSortu(description, eventDate, sport);
			sut.close();
			
			//verify the results
			assertTrue(resp);
			testDA.open();
			Event ev = testDA.getEvent(eventDate, description);
			testDA.close();			
			assertEquals(ev.getDescription(),description);
			assertEquals(ev.getEventDate(),eventDate);
			assertEquals(ev.getSport().getIzena(),sport);
			
			//event IS in database
			testDA.open();
			boolean exists = testDA.eventExists(eventDate, description);
			testDA.close();
			assertTrue(exists);
			
		} catch(Exception e) {
			fail();
		} finally {
			//Remove the created objects in the database (cascade removing)
			testDA.open();
	        boolean b=testDA.removeEvent(eventDate, description);
	        testDA.close();
	        System.out.println("Finally "+b);
		}
	}
	
	
	@Test
	//sut.gertaerakSortu:  Está intentando meter 2 eventos iguales
	public void test3() {
		String description = "Real Madrid-Barcelona";
		String sport = "Futbol";
		boolean resp1;
		boolean resp2;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date eventDate=null;;
		try {
			eventDate = sdf.parse("30/11/2022");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {	
			//invoke System Under Test (sut) twice the same
			sut.open(true);
			resp1 = sut.gertaerakSortu(description, eventDate, sport);
			resp2 = sut.gertaerakSortu(description, eventDate, sport);
			sut.close();
			
			//verify the results
			assertTrue(resp1);
			assertFalse(resp2);
			testDA.open();
			Event ev = testDA.getEvent(eventDate, description);
			testDA.close();
			assertEquals(ev.getDescription(),description);
			assertEquals(ev.getEventDate(),eventDate);
			assertEquals(ev.getSport().getIzena(),sport);
			
			//event 1 IS in database
			testDA.open();
			boolean exists = testDA.eventExists(eventDate, description);
			testDA.close();
			assertTrue(exists);

			
		} catch(Exception e) {
			fail();
		} finally {
			//Remove the created objects in the database (cascade removing)
			testDA.open();
	        boolean b=testDA.removeEvent(eventDate, description);
	        testDA.close();
	        System.out.println("Finally "+b);
		}
	}

}
