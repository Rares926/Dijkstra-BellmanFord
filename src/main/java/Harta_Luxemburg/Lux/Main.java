package Harta_Luxemburg.Lux;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Afisare_Harta.Afisare_harta;
import algorithms.Creare_map;

public class Main 
{
	public static void main(String argv[]) throws ParserConfigurationException, SAXException, IOException 
	{
	Creare_map Lux=new Creare_map();
	Lux.setMap();
	Afisare_harta afis=new Afisare_harta();
	afis.draw();
	
	}
	
}
