import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class DiceModel extends JPanel 
{
	public JButton roll;
	public int value = 1;

	DiceModel()
	{
		setSize(300, 300);

		roll = new JButton("Roll");
		roll.setBounds(100, 50, 100, 50);

		add(roll);

		setLayout(null);
		setVisible(true);
	}

	//Do something about the paint method later.
	//Not showing values properly

	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.BLACK);
		g.drawRect(75, 130, 150, 150);

		Random random = new Random();
		value = (Math.abs(random.nextInt()))%6 + 1;
		g.drawString(Integer.toString(value), 150, 200);
	}

	

	// public static void main(String[] args) {
		
	// 	new DiceModel();
	// }
}