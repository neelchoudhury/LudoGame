import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test extends MouseAdapter
{
	

	public JButton next;
	JButton b;
	JFrame jp;
	Test()
	{
		jp = new JFrame();
		jp.setSize(200, 200);
		b = new JButton("bing");
		jp.add(b);
		b.addMouseListener(this);
		b.setBounds(50, 50, 50, 50);
		jp.setLayout(null);
		jp.setVisible(true);
	}

	public void mouseClicked(MouseEvent me)
	{
		b.setBounds(100, 100, 50, 50);
	}

	public static void main(String[] args) {
		
		new Test();
	}

}