package cn.bdqn.tangcco.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//��ȡ�����ļ��������ļ����Ĺ�����
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
	//ͨ������ģʽ����ʵ�����ĸ���
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
