package algorithms;


public class Converter 
{

	//public Converter converter = new Converter(5.734153,6.531256, 50.182918, 49.441140,400,650);// 400, 768);
	
	public static Double latx=5.734153;; // latitudinea minima posibila
	public static Double laty=6.531256; // latitudinea maxima posibila 
	static Double latyt=laty-latx; // laty - latx 
	
	public static Double lonx=50.182918; // longitudinea maxima posibila
	public static Double lony=49.441140; // longitudinea minima posibila 
	public static Double lonyt=lony-lonx;
	
	public static Integer screenWidth=400;
	public static Integer screenHeight=650;
	
	public Integer LatitudeToPx(Double lat) 
	{
		return (int)(screenWidth / (latyt/ (lat - latx)));
	}
	
	public Integer LongitudeToPx(Double lon)
	{
		return (int)(screenHeight / (lonyt/ (lon - lonx)));
	}
}
	
