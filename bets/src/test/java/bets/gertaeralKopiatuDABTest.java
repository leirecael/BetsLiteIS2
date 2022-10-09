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
import domain.Event;
import exceptions.EventFinished;
import gui.ApplicationLauncher;
import gui.MainGUI;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import org.junit.Test;

public class gertaeralKopiatuDABTest {
	private BLFacade businessLogic = MainGUI.getBusinessLogic();
	

	
	@Test
	public void testGertaerakKopiatu3() {
		ApplicationLauncher.main(null);
		java.util.Date date = new Date(1,11,2022);
		businessLogic = MainGUI.getBusinessLogic();
		List<Event> a = businessLogic.getEventsAll();
		assertTrue(businessLogic.gertaerakKopiatu(a.get(0), date));
	}
	@Test
	public void testGertaerakKopiatu2() {
		ApplicationLauncher.main(null);
		java.util.Date date = new Date(17,11,2022);
		businessLogic = MainGUI.getBusinessLogic();
		List<Event> a = businessLogic.getEventsAll();
		assertTrue(businessLogic.gertaerakKopiatu(a.get(0), null));

	}
	@Test
	public void testGertaerakKopiatu1() {
		ApplicationLauncher.main(null);
		java.util.Date date = new Date(1,11,2022);
		businessLogic = MainGUI.getBusinessLogic();
		try {
		businessLogic.gertaerakKopiatu(null, date);
		fail();
		} catch(Exception e) {
			assertTrue(true);
		}
		
	}
}
