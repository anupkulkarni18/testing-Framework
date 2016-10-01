package com.util;

import java.io.File;
import java.util.Hashtable;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlReader {

	public static Map<String, String> getObjectRepo(String xmlFile1) throws Exception {
		Map<String, String> objectMap = new Hashtable<String, String>();
		File xmlFile = new File(System.getProperty("user.dir") + File.separator+ "objectRepository" +File.separator+ xmlFile1+".xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document doc = documentBuilder.parse(xmlFile);
		System.out.println(doc.getDocumentElement().getNodeName());

		NodeList nodeList = doc.getElementsByTagName("element");
		System.out.println("lenth " + nodeList.getLength());
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			Element element = (Element) node;
			/*System.out.println("Name: " + element.getAttribute("name"));
			System.out.println("LocatorType: "+ element.getAttribute("locatorType"));
			System.out.println("Locatorvalue "+ element.getAttribute("locatorValue"));*/
			
			objectMap.put(element.getAttribute("name"), element.getAttribute("locatorType")+"_TBR_"+element.getAttribute("locatorValue"));
		}
		return objectMap;
	}
	public void test_1() throws Exception{
		getObjectRepo("");
	}

	public static void main(String[] args) throws Exception {
		Map<String, String> obj = XmlReader.getObjectRepo("Login_Page");
		System.out.println(obj);
		System.out.println(obj.get("password"));
		
	}

}
