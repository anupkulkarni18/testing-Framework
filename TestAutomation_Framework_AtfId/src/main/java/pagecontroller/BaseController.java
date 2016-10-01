package pagecontroller;

import java.util.Map;

import com.util.XmlReader;

public class BaseController {
	static Map<String,String> objectMap ;
	
	public static Map<String, String> getObjectMap() throws Exception{
		StackTraceElement[] stEle = Thread.currentThread().getStackTrace();
		System.out.println(stEle[1].getFileName());
		return objectMap = XmlReader.getObjectRepo(stEle[2].getFileName().split("java")[0]);
	}
	
	public static void main(String[] args) throws Exception {
		getObjectMap();
	}

}
