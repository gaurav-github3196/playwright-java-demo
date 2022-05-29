package suiteUtility;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;





public class XMLFileUtil {
	
	public static void main(String[] args) {
		XMLFileUtil read = new XMLFileUtil();
		Document xmlReader = read.readXML(new File(System.getProperty("user.dir") + "\\src\\main\\resources\\config\\suiteConfig.xml"));
		
		System.out.println(xmlReader.getElementsByTagName("setProxy").item(0).getTextContent());
		System.out.println(xmlReader.getElementsByTagName("zap").item(0).hasAttributes());
	}
	
	public Document readXML(File xmlfile) {
		Document document = null;
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
			        .newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(xmlfile);	
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return document;
	}
		
	
	
	

}
