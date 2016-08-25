package pageController;

import java.util.Map;

import util.XmlReader;

public class BasePageController {
	static Map <String,String> objectMap= null;
	
	public static Map <String,String> getObjectMap(){
		StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
		return objectMap=XmlReader.getObjectRepo(Thread.currentThread().getStackTrace()[2].getFileName().split(".java")[0]);
	}
}
