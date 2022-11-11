package businessLogic;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import configuration.ConfigXML;
import domain.Event;

public class main {
	public static void main(String[] args) {
//		obtener el	objeto Facade	local
		int isLocal = 1;
		ConfigXML c = ConfigXML.getInstance();
		BLFacade blFacade;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
			
		try {
			blFacade = new BLFactory().getBusinessLogicFactory(c);
			try {
				
				date = sdf.parse("01/12/2022"); // 17 del mes que viene
				ExtendedIterator<Event> i = blFacade.getEventsIterator(date);
				Event e;
				System.out.println("_____________________");
				System.out.println("RECORRIDO	HACIA	ATRÁS");
				i.goLast(); // Hacia atrás
				while (i.hasPrevious()) {
					e = i.previous();
					System.out.println(e.toString());
				}
				System.out.println();
				System.out.println("_____________________");
				System.out.println("RECORRIDO	HACIA	ADELANTE");
				i.goFirst(); // Hacia adelante
				while (i.hasNext()) {
					e = i.next();
					System.out.println(e.toString());
				}
			} catch (ParseException e1) {
				System.out.println("Problems	with	date??	" + "17/12/2020");
			}
			
		} catch (MalformedURLException e2) {
			e2.printStackTrace();
		}
	}
}
