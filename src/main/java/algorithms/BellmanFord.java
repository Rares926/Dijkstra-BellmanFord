package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

import models.Arc;
import models.Map;
import models.NodeMap;

public class BellmanFord 
{
	static Map map=algorithms.Creare_map.map;
	public static ArrayList<LinkedList<Arc>> paths;
	
	public static Vector<NodeMap> Bellman(NodeMap start, NodeMap fin)
	{
		
		paths=new ArrayList<LinkedList<Arc>>(map.getArcs().size());
	       
	       for(int i = 0;i < map.getArcs().size(); i++) 
				paths.add(new LinkedList<Arc>());
	       
	       for(Arc j:map.getArcs())
	       {
	    	   paths.get(j.getFrom()).add(j);
	       }
	       
	       
	   	Vector<NodeMap> predecesori = new Vector<NodeMap>(paths.size());
		Vector<Integer> distanta = new Vector<Integer>(map.getArcs().size());
		

		for(int i=0;i<paths.size();i++)
                     {
			predecesori.add(null);
			distanta.add(Integer.MAX_VALUE);
                     }
		
		
			int []dis = new int[map.getNodes().size()];
			for (int i = 0; i < map.getNodes().size(); i++)
				dis[i] = Integer.MAX_VALUE;

			dis[start.getId()] = 0;
			predecesori.set(start.getId(), start);
	             

	for (int i = 0; i < map.getNodes().size() - 1; i++) 
		{

		for (int j = 0; j <map.getArcs().size(); j++) 
			{

        if (dis[map.getArcs().get(j).getFrom()] != Integer.MAX_VALUE && dis[map.getArcs().get(j).getFrom()] + map.getArcs().get(j).getLength() <dis[map.getArcs().get(j).getTo()])
            		{
        	dis[map.getArcs().get(j).getFinish().getId2()] = dis[map.getArcs().get(j).getStart().getId2()] + map.getArcs().get(j).getLength();

        	predecesori.set(map.getArcs().get(j).getFinish().getId2(), map.getArcs().get(j).getStart());
        
            		}
        
    		}
		}
	

		for (int i = 0; i <map.getArcs().size(); i++) 
			{
		            int x=map.getArcs().get(i).getFrom();
			        int y=map.getArcs().get(i).getTo();
			        int weight=map.getArcs().get(i).getLength();
					if (dis[x] != Integer.MAX_VALUE &&dis[x] + weight < dis[y])
							System.out.println("Graful contine cicluri negative");
			}

		 	System.out.println("Distanta de la nodul "+start.getId()+" la nodul "+fin.getId()+" este: "+dis[fin.getId()]);
				return predecesori;
	}
}
