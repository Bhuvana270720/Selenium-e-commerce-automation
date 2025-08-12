package TestMethod;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	Properties properties;
	
	public ConfigReader()
	{
		properties = new Properties();
		try
		{
			FileReader file = new FileReader("src//test//resources//Configurationsetup.properties");
			properties.load(file);
			file.close();
			
		}
		catch (IOException e)
		{
			  e.printStackTrace();
		}
	}
	
	public String getProperty(String key)
	{
		return properties.getProperty(key);
	}

}
