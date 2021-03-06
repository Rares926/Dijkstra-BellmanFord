package models;



public class Arc 
{
	private int from;
	private int to;
	private int length;

	private NodeMap start;
	private NodeMap finish;
	public Arc() 
	{
		this.start = new NodeMap();
		this.finish = new NodeMap();
		this.length = Integer.MAX_VALUE; //Simulate Infinity 
	}
	public int getFrom() 
	{
		return from;
	}
	public void setFrom(int from) 
	{
		this.from = from;
	}
	public int getTo() 
	{
		return to;
	}
	public void setTo(int to)
	{
		this.to = to;
	}
	public int getLength() 
	{
		return length;
	}
	public void setLength(int length) 
	{
		this.length = length;
	}
	public NodeMap getStart() 
	{
		return start;
	}
	public void setStart(NodeMap start) 
	{
		this.start = start;
	}
	public NodeMap getFinish() 
	{
		return finish;
	}
	public void setFinish(NodeMap finish) 
	{
		this.finish = finish;
	}
	
	

	
	
}
