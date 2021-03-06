package models;


import java.util.List;



public class Map 
{
	
    List<NodeMap> nodes;
    List<Arc> arcs;
    


	public List<NodeMap> getNodes() 
	{
		return nodes;
	}
	public void setNodes(List<NodeMap> nodes) 
	{
		this.nodes = nodes;
	}
	public List<Arc> getArcs() 
	{
		return arcs;
	}
	public void setArcs(List<Arc> arcs) 
	{
		this.arcs = arcs;
	}
	
    
}
