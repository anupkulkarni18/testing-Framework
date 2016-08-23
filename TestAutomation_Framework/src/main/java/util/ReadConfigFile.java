package util;

import java.io.File;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ReadConfigFile {
	
	public static void readConfig() {
		String filePath = System.getProperty("user.dir")+"\\configuration.config";
		System.out.println(filePath);
		Config conf = ConfigFactory.parseFile(new File(filePath));
		
		System.out.println(conf.getString("Login.password.identifier"));
		
	}
	
	public static void main(String[] args) {
		ReadConfigFile.readConfig();
	}

}
