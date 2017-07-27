import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


//To run this as a standalone class, extends to JFrame, not JPanel

//To make this class OOPy, extend this class from Dot than from JPanel

public class Board extends JPanel
{
	ArrayList <Dot> blueDot = new ArrayList <Dot> ();
	ArrayList <Dot> redDot = new ArrayList <Dot> ();
	ArrayList <Dot> greenDot = new ArrayList <Dot> ();
	ArrayList <Dot> yellowDot = new ArrayList <Dot> ();
	Iterator blueIt, redIt, greenIt, yellowIt;
	Dot b;
	int dotSize = 30;
	int offsetx = 10, offsety = 10;
	int side = 40;

	
	Board()
	{
		paintBoard();
	}

	private void paintBoard()
	{
		setSize(800, 800);
		setLayout(null);

		
		addBlueDots();
		addRedDots();
		addGreenDots();
		addYellowDots();

		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		// setLocationRelativeTo(null);


		setVisible(true);
	}

	private void addBlueDots()
	{
		
		int ind = 0;
		for(int i = 2; i < 4; i++)
		{
			for(int j = 2; j < 4; j++)
			{
				b = new Dot(Color.BLUE, dotSize);
				b.setBounds(offsetx + i*side+1, offsety + j*side+1, dotSize, dotSize);
				// add(b);
				//b.addMouseListener(this);
				blueDot.add(b);
			}
		}

		blueIt = blueDot.iterator();

		while(blueIt.hasNext() )
		{
			this.add(((Dot)blueIt.next()));
		}

		
	}

	private void addRedDots()
	{
		
		int ind = 0;
		for(int i = 11; i < 13; i++)
		{
			for(int j = 2; j < 4; j++)
			{
				b = new Dot(Color.red, dotSize);
				b.setBounds(offsetx + i*side+1, offsety + j*side+1, dotSize, dotSize);
				// add(b);
				redDot.add(b);
			}
		}

		redIt = redDot.iterator();

		while(redIt.hasNext() )
		{
			this.add(((Dot)redIt.next()));
		}

		
	}

	private void addYellowDots()
	{
		
		int ind = 0;
		for(int i = 2; i < 4; i++)
		{
			for(int j = 11; j < 13; j++)
			{
				b = new Dot(Color.YELLOW, dotSize);
				b.setBounds(offsetx + i*side+1, offsety + j*side+1, dotSize, dotSize);
				// add(b);
				yellowDot.add(b);
			}
		}

		yellowIt = yellowDot.iterator();

		while(yellowIt.hasNext() )
		{
			this.add(((Dot)yellowIt.next()));
		}

		
	}

	private void addGreenDots()
	{
		
		int ind = 0;
		for(int i = 11; i < 13; i++)
		{
			for(int j = 11; j < 13; j++)
			{
				b = new Dot(Color.GREEN, dotSize);
				b.setBounds(offsetx + i*side+1, offsety + j*side+1, dotSize, dotSize);
				// add(b);
				greenDot.add(b);
			}
		}

		greenIt = greenDot.iterator();

		while(greenIt.hasNext() )
		{
			this.add(((Dot)greenIt.next()));
		}

		
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		setBackground(Color.WHITE);

		drawGrid(g);

		drawBlueSection(g);
		
		drawRedSection(g);

		drawGreenSection(g);
		
		drawYellowSection(g);
		
		repaintDots();	
		
	}

	private void drawGrid(Graphics g)
	{
		g.setColor(Color.BLACK);
		
		for(int i = 0; i < 15; i++)
		{
			for(int j = 0; j < 15; j++)
			{
				g.drawRect(offsetx + i*side, offsety + j*side, side, side);
			}
		}

		for(int i = 6; i <9; i++)
		{
			for(int j = 6; j < 9; j++)
			{
				// if(i == 9 || j == 9 || i == 14 || j == 14)
				g.fillRect(offsetx + i*side+1, offsety + j*side+1, side-1, side-1);
			}
		}
	}

	private void drawBlueSection(Graphics g)
	{
		g.setColor(Color.BLUE);
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 6; j++)
			{
				if(i == 0 || j == 0 || i == 5 || j == 5)
					g.fillRect(offsetx + i*side+1, offsety + j*side+1, side-1, side-1);
			}
		}

		for(int i = 2; i < 4; i++)
		{
			for(int j = 2; j < 4; j++)
			{
				g.fillRect(offsetx + i*side+1, offsety + j*side+1, side-2, side-2);
			}
		}

		g.fillRect(offsetx + 1*side+1, offsety + 6*side+1, side-1, side-1);
		for(int i = 1; i<6; i++)
		{
			g.fillRect(offsetx + i*side+1, offsety + 7*side+1, side-1, side-1);
		}
	}

	private void drawRedSection(Graphics g)
	{
		g.setColor(Color.RED);
		for(int i = 9; i < 15; i++)
		{
			for(int j = 0; j < 6; j++)
			{
				if(i == 9 || j == 0 || i == 14 || j == 5)
					g.fillRect(offsetx + i*side+1, offsety + j*side+1, side-1, side-1);
			}
		}

		for(int i = 11; i < 13; i++)
		{
			for(int j = 2; j < 4; j++)
			{
				g.fillRect(offsetx + i*side+1, offsety + j*side+1, side-2, side-2);
			}
		}

		g.fillRect(offsetx + 8*side+1, offsety + 1*side+1, side-1, side-1);
		for(int i = 1; i<6; i++)
		{
			g.fillRect(offsetx + 7*side+1, offsety + i*side+1, side-1, side-1);
		}
	}

	private void drawGreenSection(Graphics g)
	{
		g.setColor(Color.GREEN);
		for(int i = 9; i < 15; i++)
		{
			for(int j = 9; j < 15; j++)
			{
				if(i == 9 || j == 9 || i == 14 || j == 14)
					g.fillRect(offsetx + i*side+1, offsety + j*side+1, side-1, side-1);
			}
		}

		for(int i = 11; i < 13; i++)
		{
			for(int j = 11; j < 13; j++)
			{
				g.fillRect(offsetx + i*side+1, offsety + j*side+1, side-2, side-2);
			}
		}

		g.fillRect(offsetx + 13*side+1, offsety + 8*side+1, side-1, side-1);
		for(int i = 9; i<14; i++)
		{
			g.fillRect(offsetx + i*side+1, offsety + 7*side+1, side-1, side-1);
		}
	}

	private void drawYellowSection(Graphics g)
	{
		g.setColor(Color.YELLOW);
		for(int i = 0; i < 6; i++)
		{
			for(int j = 9; j < 15; j++)
			{
				if(i == 0 || j == 9 || i == 5 || j == 14)
					g.fillRect(offsetx + i*side+1, offsety + j*side+1, side-1, side-1);
			}
		}

		for(int i =2; i < 4; i++)
		{
			for(int j = 11; j < 13; j++)
			{
				g.fillRect(offsetx + i*side+1, offsety + j*side+1, side-2, side-2);
			}
		}

		g.fillRect(offsetx + 6*side+1, offsety + 13*side+1, side-1, side-1);
		for(int i = 9; i<14; i++)
		{
			g.fillRect(offsetx + 7*side+1, offsety + i*side+1, side-1, side-1);
		}
	}

	private void repaintDots()
	{
		blueIt = blueDot.iterator();
		while(blueIt.hasNext())
		{
			((Dot)blueIt.next()).repaint();
			
		}

		redIt = redDot.iterator();
		while(redIt.hasNext())
		{
			((Dot)redIt.next()).repaint();
			
		}

		yellowIt = yellowDot.iterator();
		while(yellowIt.hasNext())
		{
			((Dot)yellowIt.next()).repaint();
			
		}
		
		greenIt = greenDot.iterator();
		while(greenIt.hasNext())
		{
			((Dot)greenIt.next()).repaint();
			
		}
	}


	// public static void main(String[] args) {
		
	// 	EventQueue.invokeLater(() -> {
	// 	    Board ex = new Board();

	// 	});
	// }
}