package bets;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Vector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.Event;
import domain.Question;
import domain.Quote;
import domain.Registered;
import domain.Team;

@RunWith(MockitoJUnitRunner.class)
public class ApostuaEginMockIntTest {
	DataAccess mockDA = Mockito.mock(DataAccess.class);
	BLFacadeImplementation sut = new BLFacadeImplementation(mockDA);
	
	Registered user1, user2;
	Vector<Quote> quotes;
	Quote quo1, quo2;
	Event ev1;
	Question q1;
	
	@BeforeEach
	void setUp() throws Exception {
		user1 = new Registered("user1", "user123", 123);
		quotes = new Vector<Quote>();
		user1 = new Registered("user1", "123", 123, false);
		user2 = new Registered("user2", "456", 456, false);
		quotes = new Vector<Quote>();
		quo1 = new Quote(1.0, "Team A wins.");
		ev1 = new Event(2022, "A-B", new Date(), new Team("A"), new Team("B"));
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
		Mockito.doReturn(user1).when(mockDA).findApustua(Mockito.any(Registered.class));
		assertThrows(Exception.class, () -> sut.ApustuaEgin(user1, quotes, 1.0, -1));
	}
	
	@Test
	void test3() {				
		Mockito.doReturn(user2).when(mockDA).findApustua(Mockito.any(Registered.class));
		assertThrows(Exception.class, () -> sut.ApustuaEgin(user1, quotes, 1.0, -1));
	}
	
	@Test
	void test4() {				
		Mockito.doReturn(user1).when(mockDA).findApustua(Mockito.any(Registered.class));
		Mockito.doReturn(10.0).when(mockDA).DiruaSartu(user1, Mockito.any(Double.class), Mockito.any(Date.class), Mockito.any(String.class));
		Mockito.doReturn(true).when(mockDA).jarraitu(user2, user1, Mockito.any(Double.class));
		
		assertTrue(sut.ApustuaEgin(user1, quotes, 1.0, 0));
	}
	
	@Test
	void test5() {				
		Mockito.doReturn(user1).when(mockDA).findApustua(Mockito.any(Registered.class));
		Mockito.doReturn(10.0).when(mockDA).DiruaSartu(user1, Mockito.any(Double.class), Mockito.any(Date.class), Mockito.any(String.class));
		Mockito.doReturn(true).when(mockDA).jarraitu(user2, user1, Mockito.any(Double.class));
		
		assertTrue(sut.ApustuaEgin(user1, quotes, 1.0, 0));
	}
}
