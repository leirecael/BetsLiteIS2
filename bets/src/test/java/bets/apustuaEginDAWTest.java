package bets;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dataAccess.DataAccess;
import domain.*;

public class apustuaEginDAWTest {
	/*DataAccess sut;
	TestDataAccess test;
	Registered user1, user2;
	Vector<Quote> quotes;
	Quote quo1, quo2;
	Event ev1;
	Question q1, q2;
	
	@Before
	public void setUp() throws Exception {
		sut = new DataAccess();
		test = new TestDataAccess();
		user1 = new Registered("user1", "123", 123);
		sut.storeRegistered("user1", "123", 123);
		
		//Lista vacía:
		quotes = new Vector<Quote>();
		sut.gertaerakSortu("T-A", new Date(), "Futbol");
		q1 = sut.createQuestion(test.getEvent(new Date(), "T-A"), "q1", 1);
		
		ev1 = new Event(2022, "A vs. B", new Date(), new Team("teamA"), new Team("teamB"));
		q2 = new Question(123, "A team wins.", 0.5, ev1);
		quo1 = sut.storeQuote("q1", 0.1, q1);
		quo2 = sut.storeQuote("q2", 1.4, q1);
		
		user2 = new Registered("user2", "124", 124);
		sut.storeRegistered("user2", "124", 124);
	}

	@After
	public void tearDown() throws Exception {
		test.removeUser(user1);
		test.removeEvent2(q1.getEvent());
	}

	@Test
	public void test1() {
		sut.DiruaSartu(user1, 10.0, new Date(), "euro");
		quotes.add(quo1);
		
		try {
			assertFalse(sut.ApustuaEgin(user1, quotes, 12.0, -1));
		}catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void test2() {
		sut.DiruaSartu(user1, 100.0, new Date(), "euro");
		
		try {
			assertFalse(sut.ApustuaEgin(user1, quotes, 12.0, -1));
		}catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void test3() {
		sut.DiruaSartu(user1, 100.0, new Date(), "euro");
		quotes.add(quo1);
		
		try {
			assertTrue(sut.ApustuaEgin(user1, quotes, 12.0, -1));
		}catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void test4() {
		sut.DiruaSartu(user1, 100.0, new Date(), "euro");
		quotes.add(quo1);
		
		try {
			assertTrue(sut.ApustuaEgin(user1, quotes, 12.0, 0));
		}catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void test5() {
		sut.DiruaSartu(user1, 100.0, new Date(), "euro");
		quotes.add(quo2);
		
		try {
			assertTrue(sut.ApustuaEgin(user1, quotes, 12.0, 0));
		}catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void test6() {
		sut.DiruaSartu(user1, 100.0, new Date(), "euro");
		quotes.add(quo1);
		
		try {
			assertTrue(sut.ApustuaEgin(user1, quotes, 12.0, 0));
		}catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void test7() {
		sut.DiruaSartu(user1, 100.0, new Date(), "euro");
		sut.DiruaSartu(user2, 100.0, new Date(), "euro");
		
		sut.jarraitu(user1, user2, 100.0);
		
		quotes.add(quo1);
		
		try {
			assertTrue(sut.ApustuaEgin(user1, quotes, 12.0, 0));
		}catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void test8() {
		sut.DiruaSartu(user1, 100.0, new Date(), "euro");
		sut.DiruaSartu(user2, 100.0, new Date(), "euro");
		
		sut.jarraitu(user1, user2, 100.0);
		
		quotes.add(quo1);
		quotes.add(quo2);
		
		try {
			assertTrue(sut.ApustuaEgin(user1, quotes, 12.0, 0));
		}catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void test9() {
		sut.DiruaSartu(user1, 100.0, new Date(), "euro");
		sut.DiruaSartu(user2, 100.0, new Date(), "euro");
		
		sut.jarraitu(user1, user2, 100.0);
		
		quotes.add(quo1);
		quotes.add(quo2);
		quotes.add(quo1);
		
		try {
			assertTrue(sut.ApustuaEgin(user1, quotes, 12.0, 0));
		}catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void test10() {
		sut.DiruaSartu(user1, 100.0, new Date(), "euro");
		sut.DiruaSartu(user2, 2.0, new Date(), "euro");
		
		sut.jarraitu(user1, user2, 100.0);
		
		quotes.add(quo1);
		quotes.add(quo2);
		
		try {
			assertTrue(sut.ApustuaEgin(user1, quotes, 12.0, 0));
		}catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void test11() {
		sut.DiruaSartu(user1, 100.0, new Date(), "euro");
		sut.DiruaSartu(user2, 100.0, new Date(), "euro");
		
		sut.jarraitu(user1, user2, 100.0);
		sut.jarraitu(user2, user1, 100.0);
		
		quotes.add(quo1);
		quotes.add(quo2);
		
		try {
			assertTrue(sut.ApustuaEgin(user1, quotes, 12.0, 0));
		}catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}*/
}