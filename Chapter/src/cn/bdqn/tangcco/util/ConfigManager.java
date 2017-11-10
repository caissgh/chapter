package cn.bdqn.tangcco.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//读取配置文件（属性文件）的工具类
public class ConfigManager {
	private static ConfigManager configManager;
	private static Properties properties;
	
	public ConfigManager(){
		String configFile="database.properties";
		properties=new Properties();
		InputStream in=ConfigManager.
					class.getClassLoader().getResourceAsStream(configFile);
		try {
			properties.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//通过单例模式设置实例化的个数
	public static ConfigManager getInstance(){
		if (configManager==null) {
			configManager=new ConfigManager();
		}
		return configManager;
	}
	public String getString(String key){
		return properties.getProperty(key);
	}
}
