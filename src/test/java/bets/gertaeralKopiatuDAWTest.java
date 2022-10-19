package bets;

import static org.junit.Assert.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import configuration.UtilDate;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import businessLogic.BLFacade;
import dataAccess.DataAccess;
import domain.Event;
import exceptions.EventFinished;
import gui.ApplicationLauncher;
import gui.MainGUI;

import org.junit.Test;

public class gertaeralKopiatuDAWTest {
	/*
	 * private BLFacade businessLogic = MainGUI.getBusinessLogic();
	 * 
	 * 
	 * 
	 * @Test public void testGertaerakKopiatu1() { ApplicationLauncher.main(null);
	 * java.util.Date date = new Date(1,11,2022); businessLogic =
	 * MainGUI.getBusinessLogic(); List<Event> a = businessLogic.getEventsAll();
	 * businessLogic.gertaerakKopiatu(a.get(0), date);
	 * assertFalse(businessLogic.gertaerakKopiatu(a.get(0), date)); }
	 * 
	 * @Test public void testGertaerakKopiatu2() { ApplicationLauncher.main(null);
	 * java.util.Date date = new Date(2,11,2022); businessLogic =
	 * MainGUI.getBusinessLogic(); List<Event> a = businessLogic.getEventsAll();
	 * assertTrue(businessLogic.gertaerakKopiatu(a.get(0), date)); }
	 */
	DataAccess sut;
	TestDataAccess testDA;
	Event ev;

	@Test
	public void test1() {
		sut = new DataAccess();
		sut.open(true);
		Date d = UtilDate.newDate(2070, 2, 2);
		List<Event> le = sut.getEventsAll();
		if (le.size() > 0) {
			ev = le.get(0);
			System.out.println(ev.getEventNumber());
			System.out.println(ev.getEventDate());
			boolean b = sut.gertaerakKopiatu(ev, d);
			assertTrue(b);
			if (b) {
				testDA = new TestDataAccess();
				testDA.open();
				Event ev2 = testDA.getEvent(d, ev.getDescription());
				testDA.close();

				boolean b2 = sut.gertaeraEzabatu(ev2);
				assertTrue(b2);
			}
		}
		sut.close();
	}
	
	@Test
	public void test2() {
		sut = new DataAccess();
		sut.open(true);
		List<Event> le = sut.getEventsAll();
		if (le.size() > 0) {
			ev = le.get(0);
			System.out.println(ev.getEventNumber());
			System.out.println(ev.getEventDate());
			boolean b = sut.gertaerakKopiatu(ev, ev.getEventDate());
			assertFalse(b);
			
		}
		sut.close();
	}
}
