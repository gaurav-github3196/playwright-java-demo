package suitebase;

import java.io.IOException;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;

public class TestngXMLSuite {

	static TestngXMLSuite objtestng = new TestngXMLSuite(); 
	
	public static void main(String[] args) {
		TestNG testng = new TestNG();
		String xmlFileName = System.getProperty("user.dir") + "\\src\\main\\resources\\testng.xml";
		List<XmlSuite> suite;
		
		try {
			suite = (List<XmlSuite>) new Parser(xmlFileName).parse();
			testng.setXmlSuites(suite);
			testng.run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
