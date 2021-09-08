package seleniumHandsOn;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Log4JHandsOn {
	
	Logger log = Logger.getLogger(Log4JHandsOn.class);
	
	@Test
	public void BasicConfig() {
		
		BasicConfigurator.configure();
		log.debug("This is a Debug Log");
		log.info("This is a Info Log");
		
	}
	
	@Test
	public void PropConfig() {
		
		Logger logfile = Logger.getLogger(Log4JHandsOn.class);
		
		PropertyConfigurator.configure("PropLog.properties");
		
		logfile.debug("Debug Log of Property File");
		logfile.warn("Warning Log of Property File");
		logfile.error("Error Log of Property File");
	}

	@Test
	public void DOMConfig() {
		Logger logxmlFile = Logger.getLogger(Log4JHandsOn.class);
		
		DOMConfigurator.configure("XMLDOM.xml");
		 logxmlFile.fatal("Fatal Log of XML DOM File");
		
	}
}
