package com.gmail.rohzek.rollingxor;

import java.awt.EventQueue;

public class Main 
{
	static final String BLKWTHMN = "73166206741b6b4b794e60536749784c7e506554";
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Gui frame = new Gui();
					frame.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
}
