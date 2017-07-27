import java.io.*;
import java.awt.*;
import javax.swing.*;

//A JPanel cannot run on its own. It has to be embedded in a JFrame.

//Serialize this class later and send objects over the network.

public class Dot extends JPanel
{
	Color dotColor;
	int size;
	int xLoc, yLoc;
	int currInd;
	boolean start;
	int move;

	Dot(Color col, int sz)
	{
		dotColor = col;
		size = sz;
		
		setSize(sz, sz);
		setLayout(null);
		setVisible(true);

		xLoc = 0;
		yLoc = 0;
		currInd = 0;
		start = false;
		move = 0;
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(dotColor);
		g.fillOval(0, 0, size, size);
	}

	public String toString()
	{
		return Integer.toString(size);
	}

	// public static void main(String[] args) 
	// {
		
	// 	Dot d = new Dot(Color.BLUE, 500);
	// }
}