package util;

import java.io.File;
import java.util.Hashtable;
import java.util.Map;





import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XmlReader {


	public static Map<String, String> getObjectRepo(String repoFileName){

		Map<String,String> objectMap = new Hashtable<String,String>();
		// read xml

		try {
			File fXmlFile = new File("C:/Users/Chitranjan/Media_Platform/TestAutomation_Framework/objectRepo/"+repoFileName+".xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			NodeList nodeList =doc.getElementsByTagName("element");
			for (int i=0;i<nodeList.getLength();i++){

				if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element ele=(Element) nodeList.item(i);
					String elementName=ele.getAttribute("name");
					String locatorType=ele.getAttribute("locatorType");
					String locatorValue=ele.getAttribute("locatorValue");
					System.out.println("Name: "+elementName);
					System.out.println("Locator Type: "+locatorType);
					System.out.println("Locator value: "+locatorValue);	
					
					objectMap.put(elementName, locatorType+"_TBR_"+locatorValue);
					
					
				}


			}

		} catch (Exception e) {
			e.printStackTrace();
		}


		return objectMap;
	}

	/*public static void main(String[] args) {
		System.out.println(getObjectRepo("login"));
	}*/

}
