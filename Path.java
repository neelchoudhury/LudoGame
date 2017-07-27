import java.io.*;
import java.awt.*;
import java.util.*;

public class Path
{

	Vector <Point> bluePath = new Vector <Point> ();
	Vector <Point> redPath = new Vector <Point> ();
	Vector <Point> greenPath = new Vector <Point> ();
	Vector <Point> yellowPath = new Vector <Point> ();

	Point p = new Point(1, 6);

	int x =1, y=6;

	Path()
	{
		makeBluePath();
		makeRedPath();
		makeGreenPath();
		makeYellowPath();
		addLastBLocks();
	}

	private void makeBluePath()
	{
		bluePath.addElement(p);
		
		for(int i = 0; i<4; i++)
		{
			x ++;
			p = new Point(x,y);
			bluePath.addElement(p);
		}
		
		x ++;
		p = new Point(x,y);
		for(int i=0; i<6; i++)
		{
			y --;
			p = new Point(x,y);
			bluePath.addElement(p);
		}
		x++;
		p = new Point(x,y);
		bluePath.addElement(p);
		x++;
		p = new Point(x,y);
		bluePath.addElement(p);
		for(int i = 0; i<5; i++)
		{
			y++;
			p = new Point(x,y);
			bluePath.addElement(p);
		}
		y++;
		p = new Point(x,y);
		for(int i =0; i<6; i++)
		{
			x++;
			p = new Point(x,y);
			bluePath.addElement(p);
		}
		y++;
		p = new Point(x,y);
		bluePath.addElement(p);
		y++;
		p = new Point(x,y);
		bluePath.addElement(p);
		for(int i =0;i<5; i++)
		{
			x--;
			p = new Point(x,y);
			bluePath.addElement(p);
		}
		x--;
		p = new Point(x,y);
		for(int i = 0; i<6; i++)
		{
			y++;
			p = new Point(x,y);
			bluePath.addElement(p);
		}
		x--;
		p = new Point(x,y);
		bluePath.addElement(p);
		x--;
		p = new Point(x,y);
		bluePath.addElement(p);
		for(int i=0; i<5; i++)
		{
			y--;
			p = new Point(x,y);
			bluePath.addElement(p);
		}
		y--;
		p = new Point(x,y);
		for(int i=0; i<6; i++)
		{
			x--;
			p = new Point(x,y);
			bluePath.addElement(p);
		}
		y--;
		p = new Point(x,y);
		bluePath.addElement(p);
		y--;
		p = new Point(x,y);
		bluePath.addElement(p);
	}

	private void makeRedPath()
	{
		for(int i = 0; i<52; i++)
		{
			p = bluePath.elementAt((i+13)%52 );
			redPath.addElement(p);
		}
	}

	private void makeGreenPath()
	{
		for(int i = 0; i<52; i++)
		{
			p = redPath.elementAt((i+13)%52 );
			greenPath.addElement(p);
		}
	}

	private void makeYellowPath()
	{
		for(int i = 0; i<52; i++)
		{
			p = greenPath.elementAt((i+13)%52 );
			yellowPath.addElement(p);
		}
	}

	private void addLastBLocks()
	{
		y=7;
		x=0;
		bluePath.remove(51);
		redPath.remove(51);
		greenPath.remove(51);
		yellowPath.remove(51);
		for(int i=0; i<5; i++)
		{
			x++;
			p = new Point(x,y);
			bluePath.addElement(p);
			// System.out.println(bluePath.lastElement().x + " qqq " + bluePath.lastElement().y);
		}
		y=0;
		x=7;
		for(int i=0; i<5; i++)
		{
			y++;
			p = new Point(x,y);
			redPath.addElement(p);
			// System.out.println(bluePath.lastElement().x + " qqq " + bluePath.lastElement().y);
		}
		y=7;
		x=14;
		for(int i=0; i<5; i++)
		{
			x--;
			p = new Point(x,y);
			greenPath.addElement(p);
			// System.out.println(bluePath.lastElement().x + " qqq " + bluePath.lastElement().y);
		}
		x=7;
		y=14;
		for(int i=0; i<5; i++)
		{
			y--;
			p = new Point(x,y);
			yellowPath.addElement(p);
			// System.out.println(bluePath.lastElement().x + " qqq " + bluePath.lastElement().y);
		}

	}

	public static void main(String[] args) {
		
		new Path();
	}
}