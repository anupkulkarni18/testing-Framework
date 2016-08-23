package util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

public class ReadPropertyFile {
	
	public static Map<String,String> getTestDataInMap(String fileName) throws Exception {
		
		Map<String, String> configFileVal = new Hashtable<String,String>();
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File(fileName)));
		for(int i=0;i<prop.keySet().size();i++){
			configFileVal.put(prop.keySet().toArray()[i].toString(), prop.values().toArray()[i].toString());
		}
		return configFileVal ;
	}
	
}
