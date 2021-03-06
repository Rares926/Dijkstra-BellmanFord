package Afisare_Harta;



import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.SwingUtilities;







public class Afisare_harta //implements ActionListener
{
	
   // public Converter converter = new Converter();//(5.734153,6.531256, 50.182918, 49.441140,400,650);// 400, 768);
    
	JFrame frame = new JFrame();

	public ImageIcon image=new ImageIcon("blue.jpg");
	JButton button ;
	boolean exist=true;
	
	public Afisare_harta()
	{
		
	}

	public void draw() 
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run() 
			{
		            	initUI(); 
		    }
		}
		);		
	}
	
	private void initUI() 
	{
		final Harta harta=new Harta();
	    harta.setBounds(0, 0, 500, 800);
	    harta.setBackground(Color.LIGHT_GRAY);
	    harta.setVisible(false);
	    
	    
	    final Harta2 harta2=new Harta2();
	    harta2.setBounds(0,0,500,800);
	    harta2.setBackground(Color.LIGHT_GRAY);
	    harta2.setVisible(false);

		final JButton button=new JButton("Dijkstra");
		button.setBounds(600, 200, 150, 50);
		button.setBackground(Color.pink);
		 button.setFocusable(false);
		
		JButton button2=new JButton("Bellman-Ford");
		button2.setBounds(600, 260, 150, 50);
		button2.setBackground(Color.pink);

		 button2.setFocusable(false);
		
		JButton button3=new JButton("Erase");
		button3.setBounds(620, 400, 100, 50);
		button3.setBackground(Color.red);
		button3.setBackground(new Color(0xee9595));
		 button3.setFocusable(false);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(null);
		
		frame.setSize(800,750); 
		frame.setTitle("Luxemburg");
		frame.setVisible(true);//making the frame visible
	    frame.setIconImage(image.getImage());
	    //frame.setBackground(Color.pink);
	    frame.getContentPane().setBackground(Color.white);
	   // frame.getContentPane().setBackground(new Color(0x00917c));
	    frame.add(button);
	    frame.add(button2);
	    frame.add(button3);
	    frame.add(harta);
	    frame.add(harta2);
	   // frame.pack();
	    button.addActionListener(new ActionListener() 
        {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getActionCommand().equals("Dijkstra"))
				{
					harta.setVisible(true);
				
					System.out.println("Button 1 was pressed");
				}
			} 
        });
	    button2.addActionListener(new ActionListener() 
        {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getActionCommand().equals("Bellman-Ford"))
				{
					harta2.setVisible(true);
					//frame.add(harta2);
					System.out.println("Button 2 was pressed");	
				}
			}
        });
	    
	    button3.addActionListener(new ActionListener() 
	    		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getActionCommand().equals("Erase"))
				{
					harta.setVisible(false);
					harta2.setVisible(false);
					
					System.out.println("Button 3 was pressed");
								}
			}
        });
	    final JLabel label = new JLabel();     
	    label.setHorizontalAlignment(JLabel.RIGHT);    
        label.setSize(500,100);
	    button.addItemListener(new ItemListener() 
        {    
             public void itemStateChanged(ItemEvent e) 
             {                 
               label.setText("Java Checkbox: "     
                + (e.getStateChange()==1?"checked":"unchecked"));   
               frame.getContentPane().remove(harta);
             }    
          }); 
	}
	




}