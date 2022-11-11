package businessLogic;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import configuration.ConfigXML;
import dataAccess.DataAccess;

/**
 * Factory class for businessLogic
 * @author X
 *
 */
public class BLFactory {
	
	/**
	 * Method returns implementation of BLFacade. If is local, a DataAccess local data base will be implicitly created.
	 * @param c The ConfigXML file.
	 * @return The implementation of BLFacade.
	 * @throws MalformedURLException When reading the remote URL.
	 */
	public BLFacade getBusinessLogicFactory(ConfigXML c) throws MalformedURLException {
		BLFacade result;
		if (c.isBusinessLogicLocal()) {
			DataAccess da = new DataAccess(c.getDataBaseOpenMode().equals("initialize"));
			result = new BLFacadeImplementation(da);
		}
		
		else {
			String serviceName= "http://"+c.getBusinessLogicNode() +":"+ c.getBusinessLogicPort()+"/ws/"+c.getBusinessLogicName()+"?wsdl";
			URL url = new URL(serviceName);
	        QName qname = new QName("http://businessLogic/", "BLFacadeImplementationService");
	        Service service = Service.create(url, qname);
	        result = service.getPort(BLFacade.class);
		}
		return result;
	}
}
