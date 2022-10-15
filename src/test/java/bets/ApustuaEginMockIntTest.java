package bets;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.*;

public class ApustuaEginMockIntTest {
	DataAccess mockDA;
	BLFacadeImplementation sut;
	Registered unregistered1, user1, user2;
	Team t1, t2;
	Event e;
	Sport s;
	Question q;
	Quote quo1, quo2, quo3;
	Vector<Quote> quotes;
	
	@Before
	public void setUp() throws Exception {
		mockDA = Mockito.mock(DataAccess.class);
		sut = new BLFacadeImplementation(mockDA);
		
		unregistered1 = new Registered("unreg1", "123", 003);
		user1 = new Registered("user1", "123", 001);
		user2 = new Registered("user2", "123", 002);
		
		quotes = new Vector<Quote>();
		
		//Quotes creation:
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date eventDate;
		
		try {
			eventDate = sdf.parse("01/01/2022");
			t1 = new Team("team1");
			t2 = new Team("team2");
			
			e = new Event("team1 vs. team2", eventDate, t1, t2);
			
			s = new Sport("Football");
			s.addEvent(e);
			e.setSport(s);
			
			q = e.addQuestion("Who will win the match?", 1.0);
			
			quo1 = q.addQuote(1.5, "team1", q);
			quo2 = q.addQuote(1.5, "team2", q);
			quo3 = q.addQuote(1.5, "Tie", q);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	

	@Test
	public void test01() {
		Mockito.when(mockDA.ApustuaEgin(null, null, null, null)).thenThrow(new NullPointerException());
		
		try {
			sut.ApustuaEgin(null, null, null, null);
			fail();
		}
		catch (NullPointerException e) {}
	}
	
	@Test
	public void test02() {
		quotes.add(quo1);
		Mockito.when(mockDA.ApustuaEgin(Mockito.any(Registered.class), Mockito.anyListOf(Quote.class), Mockito.anyDouble(), Mockito.anyInt())).thenThrow(new NullPointerException());
		
		try {
			sut.ApustuaEgin(unregistered1, quotes, 2.0, -1);
			fail();
		}
		catch (NullPointerException e) {}
	}
	
	@Test
	public void test03() {
		user1.setDirukop(1.0);
		quotes.add(quo1);
		
		Mockito.doReturn(false).when(mockDA).ApustuaEgin(user1, quotes, 2.0, -1);
		
		assertFalse(sut.ApustuaEgin(user1, quotes, 2.0, -1));
	}
	
	@Test
	public void test04() {
		user1.setDirukop(100.0);
		user2.setDirukop(100.0);
		quotes.add(quo1);
		quotes.add(quo2);
		quotes.add(quo3);
		
		user1.addJarraitzailea(new Jarraitzailea(user1, user2));
		user2.addJarraitzailea(new Jarraitzailea(user2, user1));
		
		Mockito.doReturn(true).when(mockDA).ApustuaEgin(user1, quotes, 12.0, -1);
		
		assertTrue(sut.ApustuaEgin(user1, quotes, 12.0, -1));
	}

	@Test
	public void test05() {	
		user1.setDirukop(100.0);
		user2.setDirukop(100.0);
		quotes.add(quo1);
		quotes.add(quo2);
		quotes.add(quo3);
		
		user1.addJarraitzailea(new Jarraitzailea(user1, user2));
		user2.addJarraitzailea(new Jarraitzailea(user2, user1));
		
		Mockito.doReturn(true).when(mockDA).ApustuaEgin(Mockito.eq(user1), Mockito.anyListOf(Quote.class), Mockito.anyDouble(), Mockito.anyInt());
		
		assertTrue(sut.ApustuaEgin(user1, quotes, 12.0, -1));
		
		quotes.add(quo1);
		quotes.add(quo2);
		quotes.add(quo3);
		
		assertTrue(sut.ApustuaEgin(user1, quotes, 12.0, 0));
	}
	
		/**
		 * Casos de valores limite:
		 */
	
	/**
	 * sueldo < coste_apuestas
	 */
	@Test
	public void test06() {
		user1.setDirukop(11.0);
		quotes.add(quo1);
		
		Mockito.doReturn(false).when(mockDA).ApustuaEgin(Mockito.eq(user1), Mockito.anyListOf(Quote.class), Mockito.eq(12.0), Mockito.anyInt());
		
		assertFalse(sut.ApustuaEgin(user1, quotes, 12.0, -1));
	}
	
	/**
	 * sueldo = coste_apuestas
	 */
	@Test
	public void test07() {	
		user1.setDirukop(12.0);
		quotes.add(quo1);
		
		Mockito.doReturn(false).when(mockDA).ApustuaEgin(Mockito.eq(user1), Mockito.anyListOf(Quote.class), Mockito.eq(12.0), Mockito.anyInt());
		
		assertFalse(sut.ApustuaEgin(user1, quotes, 12.0, -1));
	}
	
	/**
	 * sueldo > coste_apuestas
	 */
	@Test
	public void test08() {	
		user1.setDirukop(13.0);
		quotes.add(quo1);
		
		Mockito.doReturn(false).when(mockDA).ApustuaEgin(Mockito.eq(user1), Mockito.anyListOf(Quote.class), Mockito.eq(12.0), Mockito.anyInt());
		
		assertFalse(sut.ApustuaEgin(user1, quotes, 12.0, -1));
	}
}