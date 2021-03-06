package algorithms;


import java.awt.Point;


import models.Arc;
import models.Map;
import models.NodeMap;



public class Creare_map 
{
	public static Map map;
	public Converter converter=new Converter();
	
	
	public void setMap()
	{
		try {
			map=ReadingMap.read_Map(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(NodeMap i:map.getNodes())
	    {
			i.setLatitude(i.getLatitude()/100000);
			i.setLongitude(i.getLongitude()/100000);	
			//System.out.println(i.getId()+" "+i.getLatitude()+" "+i.getLongitude());
			i.setLatp(converter.LatitudeToPx(i.getLatitude()));
			i.setLongp(converter.LongitudeToPx(i.getLongitude()));
			System.out.println(i.getLatp()+" "+i.getLongp());
		}
		
		for(Arc j:map.getArcs())
		{
		   //aici trebuie sa setam campurile start si finish din clasa arc 
			
			j.setStart(map.getNodes().get(j.getFrom()));
			j.setFinish(map.getNodes().get(j.getTo()));
			//System.out.println(j.getStart().getLatitude()+" "+j.getStart().getLongitude()+" "+j.getFinish().getLatitude()+" "+j.getFinish().getLongitude());
		}
		
		  
	}
	
	public int findNod(Point a)
	{
        double distanta=99999.0;
        int id=-1;
        a.y=a.y-29;
        a.x=a.x-8;
				for(NodeMap i:map.getNodes())
					{
					//formula de distanta intre doua puncte = sqrt((xb-xa)^2+(yb-ya)^2)
		               if(Math.sqrt(Math.pow(a.getX()-i.getLatp(),2)+Math.pow(a.getY()-i.getLongp(), 2))<=distanta)
		               {
		            	   id=i.getId();
		            	   distanta=Math.sqrt(Math.pow((a.getX()-i.getLatp()),2)+Math.pow(a.getY()-i.getLongp(), 2));
		               }
					}
		return id;
	 
	
	}

	

}
