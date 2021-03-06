package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

import models.Arc;
import models.Map;
import models.NodeMap;

public class Dijkstra_bun 
{
	static Map map=algorithms.Creare_map.map;
	public static ArrayList<LinkedList<Arc>> paths;
	
	public static Vector<NodeMap> Dijkstra(NodeMap start, NodeMap fin)
	{
	
		paths=new ArrayList<LinkedList<Arc>>(map.getArcs().size());
	       
	       for(int i = 0;i < map.getArcs().size(); i++) 
				paths.add(new LinkedList<Arc>());
	       
	       for(Arc j:map.getArcs())
	       {
	    	   paths.get(j.getFrom()).add(j);
	       }
	       

		int size= paths.size();
		Vector<NodeMap> predecesori = new Vector<NodeMap>(size);
		Vector<Boolean> vizitati = new Vector<Boolean>(size);
		Vector<Integer> distanta = new Vector<Integer>(size);
		

		for(int i=0;i<size;i++)
		{
			vizitati.add(false);
			predecesori.add(null);
			distanta.add(Integer.MAX_VALUE);
		}
		

		predecesori.set(start.getId(), start);
		distanta.set(start.getId(), 0);
		

		NodeMap currentNod=start;

		while(currentNod!=fin)
		{
			
			NodeMap min = minDist(distanta, vizitati);
			
			if(min.getId()!=-1)
			{
				LinkedList<Arc> currentNodeArcs=paths.get(min.getId());
				
				vizitati.set(min.getId(), true);
				
				for(int i=0;i<currentNodeArcs.size();i++)
				{
			
					int currentDist = distanta.get(min.getId()) + currentNodeArcs.get(i).getLength();
					
					
				
                if(!vizitati.get(currentNodeArcs.get(i).getFinish().getId()) && currentDist<distanta.get(currentNodeArcs.get(i).getFinish().getId()))
					{
                
						distanta.set(currentNodeArcs.get(i).getFinish().getId(), currentDist);
						predecesori.set(currentNodeArcs.get(i).getFinish().getId(), min);
						
					}
				}
				currentNod=min;			
			}
		}
		return predecesori;
	}
	
	static NodeMap minDist(Vector<Integer> dist, Vector<Boolean> viz)
	{
		int minDist=Integer.MAX_VALUE; 
		NodeMap minNod= new NodeMap(); 

		for(int i=0;i<map.getNodes().size();i++)
		{

			if(!viz.get(i) && dist.get(i)<minDist)
			{
				minDist=dist.get(i);
				minNod=map.getNodes().get(i);
			}
		}

		return minNod;
	}
}
