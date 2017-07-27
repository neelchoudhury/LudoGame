import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NextTurn extends JPanel 
{
	public JButton next;
	public JLabel notif;
	public JLabel info;
	public JLabel validity;

	NextTurn()
	{
		setSize(300, 300);
		next = new JButton("Next");
		next.setBounds(40, 50, 100, 50);

		notif = new JLabel("Blue's Turn.");
		notif.setBounds(50, 110, 250, 40);

		info = new JLabel("Press Next and Roll");
		info.setBounds(25, 160, 200, 40);

		validity = new JLabel();
		validity.setBounds(25, 210, 200, 40);

		add(next);
		add(notif);
		add(info);
		add(validity);

		setLayout(null);
		setVisible(true);
	}

}