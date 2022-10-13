package bets;



import dataAccess.DataAccess;
import domain.Event;
import domain.Question;
import domain.Quote;
import domain.Registered;
import domain.Team;



public class apustuaEginDABTest {
	/*DataAccess sut;
	TestDataAccess test;
	Registered user1, user2;
	Vector<Quote> quotes;
	Quote quo1, quo2;
	Event ev1;
	Question q1;
	
	@BeforeEach
	void setUp() throws Exception {
		sut = new DataAccess();
		test = new TestDataAccess();
		user1 = new Registered("user1", "123", 123, false);
		user2 = new Registered("user2", "456", 456, false);
		quotes = new Vector<Quote>();
		quo1 = new Quote(1.0, "Team A wins.");
		ev1 = new Event(2022, "A-B", new Date(), new Team("A"), new Team("B"));
		q1 = sut.createQuestion(ev1, "A-B", 1);
		quo2 = sut.storeQuote("Team A will win.", 1.0, q1);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test1() {
		assertThrows(Exception.class, () -> sut.ApustuaEgin(null, null, null, null));
	}
	
	@Test
	void test2() {
		assertThrows(Exception.class, () -> sut.ApustuaEgin(user1, quotes, 1.0, -1));
	}
	
	@Test
	void test3() {
		try{
			sut.storeRegistered("user1", "123", 123);
			quotes.add(quo1);
			
			assertTrue(sut.ApustuaEgin(user1, quotes, 1.0, -1));
		}
		catch(Exception e) {
			e.printStackTrace();
			fail();
		}
		finally {
			test.removeUser(user1);
		}
	}
	
	@Test
	void test4() {
		try{
			sut.storeRegistered("user1", "123", 123);
			sut.DiruaSartu(user1, 10.0, new Date(), "euro");
			quotes.add(quo1);
			
			sut.storeRegistered("user2", "456", 456);
			sut.jarraitu(user2, user1, 10.0);
			
			assertTrue(sut.ApustuaEgin(user1, quotes, 1.0, -1));
		}
		catch(Exception e) {
			e.printStackTrace();
			fail();
		}
		finally {
			test.removeUser(user1);
			test.removeUser(user2);
		}
	}
	
	@Test
	void test5() {
		try{
			sut.storeRegistered("user1", "123", 123);
			sut.DiruaSartu(user1, 10.0, new Date(), "euro");
			quotes.add(quo1);
			quotes.add(quo2);
			
			assertTrue(sut.ApustuaEgin(user1, quotes, 1.0, 0));
		}
		catch(Exception e) {
			e.printStackTrace();
			fail();
		}
		finally {
			test.removeUser(user1);
		}
	}*/
}
