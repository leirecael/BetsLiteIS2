package bets;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import exceptions.EventFinished;


import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;




public class GertaerakSortuMockIntTest {
	DataAccess dataAccess=Mockito.mock(DataAccess.class);
	

	BLFacade sut=new BLFacadeImplementation(dataAccess);
	
	/*@Test
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
			//configure Mock
			Mockito.doReturn(false).when(dataAccess).gertaerakSortu(Mockito.any(String.class), Mockito.any(Date.class), Mockito.any(String.class));
			
			//invoke System Under Test(sut)
			resp = sut.gertaerakSortu(description, eventDate, sport);
			
			//verify the results
			assertFalse(resp);
			
			ArgumentCaptor<String> descriptionCaptor = ArgumentCaptor.forClass(String.class);
			ArgumentCaptor<Date> eventDateCaptor = ArgumentCaptor.forClass(Date.class);
			ArgumentCaptor<String> sportCaptor = ArgumentCaptor.forClass(String.class);
			
			Mockito.verify(dataAccess,Mockito.times(1)).gertaerakSortu(descriptionCaptor.capture(), eventDateCaptor.capture(), sportCaptor.capture());
			
			assertEquals(descriptionCaptor.getValue(),description);
			assertEquals(eventDateCaptor.getValue(),eventDate);
			assertEquals(sportCaptor.getValue(),sport);
			
			
		} catch (EventFinished e) {
			fail();
		}
		
	}
	
	@Test
	//sut.gertaerakSortu: Meter evento valido, devuelve true, fecha valida 
	public void test2() {
		String description = "Real Madrid-Barcelona";
		String sport = "Futbol";
		boolean resp;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date eventDate=null;;
		try {
			//si da error cambiar fecha a un dia posterior al actual
			eventDate = sdf.parse("20/10/2022");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			//configure mock
			Mockito.doReturn(true).when(dataAccess).gertaerakSortu(Mockito.any(String.class), Mockito.any(Date.class), Mockito.any(String.class));
			
			//invoke System Under Test(sut)
			resp = sut.gertaerakSortu(description, eventDate, sport);
			
			//verify results
			assertTrue(resp);
			
			ArgumentCaptor<String> descriptionCaptor = ArgumentCaptor.forClass(String.class);
			ArgumentCaptor<Date> eventDateCaptor = ArgumentCaptor.forClass(Date.class);
			ArgumentCaptor<String> sportCaptor = ArgumentCaptor.forClass(String.class);
			
			Mockito.verify(dataAccess,Mockito.times(1)).gertaerakSortu(descriptionCaptor.capture(), eventDateCaptor.capture(), sportCaptor.capture());
			
			assertEquals(descriptionCaptor.getValue(),description);
			assertEquals(eventDateCaptor.getValue(),eventDate);
			assertEquals(sportCaptor.getValue(),sport);
			
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	//sut.gertaerakSortu: Event finished exception
	public void test3() {
		String description = "Real Madrid-Barcelona";
		String sport = "Futbol";
		boolean resp;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date eventDate=null;;
		try {
			//fecha de creacion, 9/10/2022
			eventDate = sdf.parse("9/10/2022");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		try {
			//configure mock
			Mockito.doReturn(true).when(dataAccess).gertaerakSortu(Mockito.any(String.class), Mockito.any(Date.class), Mockito.any(String.class));
			
			//invoke System Under Test(sut)
			resp = sut.gertaerakSortu(description, eventDate, sport);
			
			
			//verify results
			ArgumentCaptor<String> descriptionCaptor = ArgumentCaptor.forClass(String.class);
			ArgumentCaptor<Date> eventDateCaptor = ArgumentCaptor.forClass(Date.class);
			ArgumentCaptor<String> sportCaptor = ArgumentCaptor.forClass(String.class);
			
			Mockito.verify(dataAccess, Mockito.times(0)).gertaerakSortu(descriptionCaptor.capture(), eventDateCaptor.capture(), sportCaptor.capture());
			
			assertEquals(descriptionCaptor.getValue(),description);
			assertEquals(eventDateCaptor.getValue(),eventDate);
			assertEquals(sportCaptor.getValue(),sport);
			
		} catch (EventFinished e) {
			assertTrue(true);
		}
		
	}
	
	@Test
	//sut.gertaerakSortu:  Evento ya existete, da false
	public void test4() {
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
			//configure Mock
			Mockito.doReturn(false).when(dataAccess).gertaerakSortu(Mockito.any(String.class), Mockito.any(Date.class), Mockito.any(String.class));
			
			//invoke System Under Test(sut)
			resp = sut.gertaerakSortu(description, eventDate, sport);
			
			//verify the results
			assertFalse(resp);
			
			ArgumentCaptor<String> descriptionCaptor = ArgumentCaptor.forClass(String.class);
			ArgumentCaptor<Date> eventDateCaptor = ArgumentCaptor.forClass(Date.class);
			ArgumentCaptor<String> sportCaptor = ArgumentCaptor.forClass(String.class);
			
			Mockito.verify(dataAccess,Mockito.times(1)).gertaerakSortu(descriptionCaptor.capture(), eventDateCaptor.capture(), sportCaptor.capture());
			
			assertEquals(descriptionCaptor.getValue(),description);
			assertEquals(eventDateCaptor.getValue(),eventDate);
			assertEquals(sportCaptor.getValue(),sport);
			
			
		} catch (EventFinished e) {
			fail();
		}
		
	}*/
	
	
	

}
