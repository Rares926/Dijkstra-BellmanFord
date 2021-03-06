package algorithms;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import models.Map;


public class ReadingMap 
{
	public static Map read_Map(Map map) throws Exception 
	{
		ObjectMapper mapper=new XmlMapper();
		InputStream inputStream=new FileInputStream(new File("map.xml"));
		TypeReference<Map> typeReference=new TypeReference<Map>() {};
		 map=mapper.readValue(inputStream, typeReference); 
		return map;
	

	}
}
