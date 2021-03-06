package Afisare_Harta;



import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import algorithms.Creare_map;
import javax.swing.JPanel;

import models.Arc;
import models.NodeMap;



public class Harta extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mouseClick=0;
	Point pointStart = null;
	Point pointEnd = null;
	int id_start=-1;
	int id_end=-1;
	NodeMap start_d=new NodeMap();
	NodeMap end_d=new NodeMap();
	//public Dijkstra d=new Dijkstra();
	//private static final long serialVersionUID = 1L;
    public Creare_map functii=new Creare_map();
	private static models.Map map=algorithms.Creare_map.map;
	
	Harta()
	{
		
		addMouseListener(new MouseAdapter() 
		{
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			 
			 if(mouseClick==0)
				{
				pointStart=e.getLocationOnScreen();
				
				 id_start=functii.findNod(pointStart);
				 
				 for(NodeMap j:map.getNodes())
					{
					 if(j.getId()==id_start)
					 {
						 start_d=j;
					 }
					}
					
				System.out.println("Nodul de start este:"+id_start);
				}
			 else if(mouseClick==1)
			   {
				pointEnd=e.getLocationOnScreen();

			
				 id_end=functii.findNod(pointEnd);
				System.out.println("Nodul de end este:"+id_end);

				 for(NodeMap j:map.getNodes())
					{
					 if(j.getId()==id_end)
					 {
						 end_d=j;
					 }
					}
			    }

			repaint();
			if(mouseClick>1)
				mouseClick=0;
			else mouseClick++;
		}

		});
		//repaint();
	   
	}
	
	public void paintComponent(Graphics g) 
	{

        Graphics2D g2 = (Graphics2D) g;
		g2.clearRect(0, 0, 2000, 2000);
		g.setFont(new Font("TimesNewRoman", Font.PLAIN, 15)); 
		g.setColor(Color.black);
		g.drawString("DIJKSTRA", 30, 40);
        g.setColor(Color.BLUE);
		for(Arc j:map.getArcs())
		{
			
			g.drawLine(j.getStart().getLatp(),j.getStart().getLongp(),j.getFinish().getLatp(),j.getFinish().getLongp());
		}
		
		if(mouseClick==0||mouseClick==1)
		g2.setColor(Color.red);
	

	    g.drawString("Nodul de start este: "+id_start, 300, 100);
	    g.drawString("Nodul final este :"+id_end, 300, 120);

		
		 if(mouseClick==2)
		{

			////aici trebuie sa fie recolorata ruta 
	
			Vector<NodeMap> path=algorithms.Dijkstra_bun.Dijkstra(start_d, end_d);
			NodeMap currentNod= end_d;
			while(!currentNod.getId().equals(start_d.getId()))
			{
				
				g2.setStroke(new BasicStroke(3));
				g2.setColor(Color.RED);
				g2.drawLine(currentNod.getLatp(), currentNod.getLongp(), path.get(currentNod.getId()).getLatp(), path.get(currentNod.getId()).getLongp());
			//	System.out.println("Arc: "+currentNod.getId()+" "+path.get(currentNod.getId()).getId());
				currentNod = path.get(currentNod.getId());
			}
		
		}

     }
	


	
}
