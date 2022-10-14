package bets;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import dataAccess.DataAccess;
import domain.*;


public class ApustuaEginDABTest {
	DataAccess sut;
	TestDataAccess testDA;
	Registered r1, r2;
	Quote quo1, quo2, quo3;
	Vector<Quote> q;
	
	/**
	 * Exception for JUnit4: If JUnit version is changed for a more recent one change for assertThrows().
	 */
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		sut = new DataAccess(false);
		testDA = new TestDataAccess();
		
		r1 = new Registered("user1", "123", 001);
		r2 = new Registered("user2", "123", 002);
		sut.storeRegistered(r1.getUsername(), r1.getPassword(), r1.getBankAccount());
		sut.storeRegistered(r2.getUsername(), r2.getPassword(), r2.getBankAccount());
		
		quo1 = testDA.storeQuote("t1", "t2", "t1 vs. t2", new Date(2022, 1, 1), "Dance", "Who will win?", 1.0, 1.5, "t1");
		quo2 = testDA.storeQuote("t3", "t4", "t3 vs. t4", new Date(2022, 1, 2), "Baseball", "Who will win?", 1.0, 1.5, "t3");
		quo3 = testDA.storeQuote("t5", "t6", "t5 vs. t6", new Date(2022, 1, 2), "Golf", "Who will win?", 1.0, 1.5, "t5");
		q = new Vector<Quote>();
	}

	@After
	public void tearDown() throws Exception {
		testDA.removeQuote(quo1);
		testDA.removeQuote(quo2);
		testDA.removeSport("Dance");
		testDA.removeSport("Baseball");
		testDA.removeSport("Golf");
		testDA.removeUser(r1);
		testDA.removeUser(r2);
	}

	@Test
	public void test01() {
		exception.expect(NullPointerException.class);
		sut.ApustuaEgin(null, null, null, null);
	}
	
	@Test
	public void test02() {
		Registered unregistered1 = new Registered("unreg1", "123", 003);
		q.add(quo1);
		
		exception.expect(NullPointerException.class);
		sut.ApustuaEgin(unregistered1, q, 2.0, -1);
	}
	
	@Test
	public void test03() {	
		q.add(quo1);
		
		assertFalse(sut.ApustuaEgin(r1, q, 1.0, 0));
	}
	
	@Test
	public void test04() {
		sut.DiruaSartu(r1, 100.0, new Date(), "euro");
		sut.DiruaSartu(r2, 100.0, new Date(), "euro");
		q.add(quo1);
		q.add(quo2);
		q.add(quo3);
		
		assertTrue(sut.jarraitu(r2, r1, 100.0));
		assertTrue(sut.jarraitu(r1, r2, 100.0));
		
		assertTrue(sut.ApustuaEgin(r1, q, 12.0, -1));
	}

	@Test
	public void test05() {	
		sut.DiruaSartu(r1, 100.0, new Date(), "euro");
		sut.DiruaSartu(r2, 100.0, new Date(), "euro");
		q.add(quo1);
		q.add(quo2);
		q.add(quo3);
		
		assertTrue(sut.jarraitu(r2, r1, 100.0));
		assertTrue(sut.jarraitu(r1, r2, 100.0));
		
		assertTrue(sut.ApustuaEgin(r1, q, 12.0, -1));
		
		q.add(quo1);
		q.add(quo2);
		q.add(quo3);
		
		assertTrue(sut.ApustuaEgin(r1, q, 12.0, 0));
	}
	
		/**
		 * Casos de valores limite:
		 */
	
	/**
	 * sueldo < coste_apuestas
	 */
	@Test
	public void test06() {	
		sut.DiruaSartu(r1, 11.0, new Date(), "euro");
		q.add(quo1);
		
		assertFalse(sut.ApustuaEgin(r1, q, 12.0, -1));
	}
	
	/**
	 * sueldo = coste_apuestas
	 */
	@Test
	public void test07() {	
		sut.DiruaSartu(r1, 12.0, new Date(), "euro");
		q.add(quo1);
		
		assertTrue(sut.ApustuaEgin(r1, q, 12.0, -1));
	}
	
	/**
	 * sueldo > coste_apuestas
	 */
	@Test
	public void test08() {	
		sut.DiruaSartu(r1, 13.0, new Date(), "euro");
		q.add(quo1);
		
		assertTrue(sut.ApustuaEgin(r1, q, 12.0, -1));
	}
}