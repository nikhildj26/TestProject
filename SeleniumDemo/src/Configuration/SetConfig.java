package Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class SetConfig {

	File configfile;
	FileInputStream fis;
	Properties pro;
	
	public SetConfig() {
		
		try {
			File configfile =new File("./Configuration/Config.Property");
			fis = new FileInputStream(configfile);
			pro=new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	public String getFirefixDriverPath() {
	
	String FirefoxDriverPath=pro.getProperty("FirefoxDriver");
	return FirefoxDriverPath;
	}
	
	public String getTestDataPath() {
		
		String TestDataPath=pro.getProperty("TestDataPath");
		return TestDataPath;
		}
	
	public String getApplicationURL() {
		String ApplicationURL=pro.getProperty("ApplicationURL");
		return ApplicationURL;
	}
	
	public String getIEDriver() {
		String IEDriver=pro.getProperty("IEDriver");
		return IEDriver;
	}
	
}
