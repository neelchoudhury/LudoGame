import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Screen extends JFrame implements ActionListener, MouseListener
{
	int turnNo = 3;
	Board board;
	DiceModel dice;
	NextTurn turn;
	Path path;
	boolean turnOver ;

	Dot dot;
	boolean valid;


	//Don't know why dice.value was changing value in between
	//After introding this diceVal = dice.value
	//The bug got removed
	int diceVal = 0;

	int countSix = 0;

	Screen()
	{
		setSize(1000, 1000);

		board = new Board();
		board.setBounds(0,0,650, 650);
		dice = new DiceModel();
		dice.setBounds(670, 0, 300, 300);
		dice.roll.addActionListener(this);
		turn = new NextTurn();
		turn.setBounds(700,350, 300, 300);
		turn.next.addActionListener(this);
		
		add(board);
		add(dice);
		add(turn);

		addListenersOnDots();
		disableAll();

		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

		path = new Path();
		turnOver = false;
		valid  = false;

		turn.next.setEnabled(false);
		dice.roll.setEnabled(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		// if(ae.getSource().equals(turn.next))
		// {
			

		// 	//Enter prompt here for dice roll
		// 	//Implement the multiple turns for 6s later

		// 	setTurnMotion();
			

		// 	dice.roll.setEnabled(true);

		// 	turn.next.setEnabled(false);
		// }

		// else if(ae.getSource().equals(dice.roll))
		{
			if(diceVal != 6 || countSix ==0)
				turnNo = (turnNo + 1)%4;

			Random random = new Random();

			int numRoll = ((Math.abs(random.nextInt()))%15 + 1);

			for(int i = 0; i < numRoll; i++)
			{
				dice.repaint();
				
			}
			
			// Turn this on after this turn completes

			// dice.roll.setEnabled(false);
			
			System.out.println("Dice0: " + dice.value + " " + turnNo);
			diceVal = dice.value;
			valid = validExists();
			System.out.println("Valid: " + valid);
			System.out.println("Dice1: " + dice.value);
			
			System.out.println("Dice2: " + diceVal);

			

			if(!valid)
			{
				// setTurnMotion();
				System.out.println("Dice: " + diceVal);
				disableAll();
				modifyLabel();
				board.repaint();
				// dice.roll.setEnabled(true);
			}
			else if(valid)
			{
				// disableAll();
				System.out.println("Dice: " + diceVal);
				setTurnMotion();
				modifyLabel();
				board.repaint();
				dice.roll.setEnabled(false);
				// turn.next.setEnabled(true);
			}
		}
	}

	private void setTurnMotion()
	{
		// turnNo = (turnNo + 1)%4;
		for(int i = 0; i < 4; i++)
		{
			if(turnNo == i)
			{
				
				setOnMotion(i, true);
				
			}
			else
			{
				setOnMotion(i, false);
			}
		}
	}

	private void setOnMotion(int col, boolean set)
	{
		
		if(col == 0)
		{
			if(set)
				System.out.println("Blue enabled");
			board.blueIt = board.blueDot.iterator();
			while(board.blueIt.hasNext())
			{
				((Dot)board.blueIt.next()).setEnabled(set);
			}
		}
		if(col == 1)
		{
			if(set)
				System.out.println("red enabled");
			board.redIt = board.redDot.iterator();
			while(board.redIt.hasNext())
			{
				((Dot)board.redIt.next()).setEnabled(set);
			}
		}
		if(col == 2)
		{
			if(set)
				System.out.println("green enabled");
			board.greenIt = board.greenDot.iterator();
			while(board.greenIt.hasNext())
			{
				((Dot)board.greenIt.next()).setEnabled(set);
			}
		}
		if(col == 3)
		{
			if(set)
				System.out.println("yellow enabled");
			board.yellowIt = board.yellowDot.iterator();
			while(board.yellowIt.hasNext())
			{
				((Dot)board.yellowIt.next()).setEnabled(set);
			}
		}
		
		
	}

	public void addListenersOnDots()
	{
		board.blueIt = board.blueDot.iterator();
		while(board.blueIt.hasNext() )
		{
			((Dot)board.blueIt.next()).addMouseListener(this);
		}

		board.redIt = board.redDot.iterator();
		while(board.redIt.hasNext() )
		{
			((Dot)board.redIt.next()).addMouseListener(this);
		}

		board.greenIt = board.greenDot.iterator();
		while(board.greenIt.hasNext() )
		{
			((Dot)board.greenIt.next()).addMouseListener(this);
		}

		board.yellowIt = board.yellowDot.iterator();
		while(board.yellowIt.hasNext() )
		{
			((Dot)board.yellowIt.next()).addMouseListener(this);
		}

	}

	public void mousePressed(MouseEvent me)
	{
		Dot dot = ((Dot)me.getSource());
		System.out.println("In" + turnNo + "dice: " + diceVal);
		
		
		if(dot.isEnabled())
		{
			// turnOver = true;
			System.out.println("Heyey");
			if(isValid(dot) )
			{
				System.out.println("isValid");
				if(turnNo == 0 && (dot.start == true || diceVal == 6) )
				{
					if(dot.start == false)
					{
						dot.currInd = 0;
					}
					else
					{
						dot.currInd = (dot.currInd + diceVal)%56;
					}
					dot.start = true;
					dot.xLoc = path.bluePath.elementAt(dot.currInd).x;
					dot.yLoc = path.bluePath.elementAt(dot.currInd).y;
					dot.setBounds(board.offsetx+dot.xLoc*board.side, board.offsety+dot.yLoc*board.side, dot.size, dot.size);
				}

				if(turnNo == 1 && (dot.start == true || diceVal == 6) )
				{
					if(dot.start == false)
					{
						dot.currInd = 0;
					}
					else
					{
						dot.currInd = (dot.currInd + diceVal)%56;
					}
					dot.start = true;
					dot.xLoc = path.redPath.elementAt(dot.currInd).x;
					dot.yLoc = path.redPath.elementAt(dot.currInd).y;
					dot.setBounds(board.offsetx+dot.xLoc*board.side, board.offsety+dot.yLoc*board.side, dot.size, dot.size);
				}

				if(turnNo == 2 && (dot.start == true || diceVal == 6) )
				{
					if(dot.start == false)
					{
						dot.currInd = 0;
					}
					else
					{
						dot.currInd = (dot.currInd + diceVal)%56;
					}
					dot.start = true;
					dot.xLoc = path.greenPath.elementAt(dot.currInd).x;
					dot.yLoc = path.greenPath.elementAt(dot.currInd).y;
					dot.setBounds(board.offsetx+dot.xLoc*board.side, board.offsety+dot.yLoc*board.side, dot.size, dot.size);
				}

				if(turnNo == 3 && (dot.start == true || diceVal == 6) )
				{
					if(dot.start == false)
					{
						dot.currInd = 0;
					}
					else
					{
						dot.currInd = (dot.currInd + diceVal)%56;
					}
					dot.start = true;
					dot.xLoc = path.yellowPath.elementAt(dot.currInd).x;
					dot.yLoc = path.yellowPath.elementAt(dot.currInd).y;
					dot.setBounds(board.offsetx+dot.xLoc*board.side, board.offsety+dot.yLoc*board.side, dot.size, dot.size);
				}
				if(diceVal == 6 && countSix <3)
				{
					countSix ++;
				}
				else
				{
					countSix = 0;
					disableAll();
				}
				
				dice.roll.setEnabled(true);
				modifyLabel();
				board.repaint();
			}

			

		}
		

		
	}

	public void mouseExited(MouseEvent me)
	{

	}

	public void mouseEntered(MouseEvent me)
	{

	}

	public void mouseClicked(MouseEvent me)
	{

	}

	public void mouseReleased(MouseEvent me)
	{
		
	}

	public void disableAll()
	{
		board.blueIt = board.blueDot.iterator();
		while(board.blueIt.hasNext() )
		{
			((Dot)board.blueIt.next()).setEnabled(false);
		}

		board.redIt = board.redDot.iterator();
		while(board.redIt.hasNext() )
		{
			((Dot)board.redIt.next()).setEnabled(false);
		}

		board.greenIt = board.greenDot.iterator();
		while(board.greenIt.hasNext() )
		{
			((Dot)board.greenIt.next()).setEnabled(false);
		}

		board.yellowIt = board.yellowDot.iterator();
		while(board.yellowIt.hasNext() )
		{
			((Dot)board.yellowIt.next()).setEnabled(false);
		}
	}

	public void modifyLabel()
	{
		//Give notif for the next turn to come, that is why i+1
		if(turnNo == 0)
		{
			turn.notif.setText("Blue's turn : Dice: " + diceVal);
		}
		if(turnNo == 1)
		{
			turn.notif.setText("Red's turn : Dice: " + diceVal);
		}
		if(turnNo == 2)
		{
			turn.notif.setText("Green's turn : Dice: " + diceVal);
		}
		if(turnNo == 3)
		{
			turn.notif.setText("Yellow's turn : Dice: " + diceVal);
		}

		if(!valid)
		{
			turn.validity.setText("NO VALID MOVE EXISTS.");
		}
		else
		{
			turn.validity.setText("VALID MOVE EXISTS.");
		}
	}

	public boolean validExists()
	{
		System.out.println("TurnNo " + turnNo + " dice value " + diceVal);
		if(turnNo == 0)
		{
			board.blueIt = board.blueDot.iterator();
			while(board.blueIt.hasNext() )
			{	
				dot = (Dot)board.blueIt.next();
				if(dot.start)
				{
					//Add rule for ending later
					return true;
				}
				else if(!dot.start && diceVal == 6)
				{
					return true;
				}
			}
			return false;
		}

		if(turnNo == 1)
		{
			board.redIt = board.redDot.iterator();
			while(board.redIt.hasNext() )
			{	
				dot = (Dot)board.redIt.next();
				if(dot.start)
				{
					//Add rule for ending later
					return true;
				}
				else if(!dot.start && diceVal == 6)
				{
					return true;
				}
			}
			return false;
		}

		if(turnNo == 2)
		{
			board.greenIt = board.greenDot.iterator();
			while(board.greenIt.hasNext() )
			{	
				dot = (Dot)board.greenIt.next();
				if(dot.start)
				{
					//Add rule for ending later
					return true;
				}
				else if(!dot.start && diceVal == 6)
				{
					return true;
				}
			}
			return false;
		}

		if(turnNo == 3)
		{
			board.yellowIt = board.yellowDot.iterator();
			while(board.yellowIt.hasNext() )
			{	
				dot = (Dot)board.yellowIt.next();
				if(dot.start)
				{
					//Add rule for ending later
					return true;
				}
				else if(!dot.start && diceVal == 6)
				{
					return true;
				}
			}
			return false;
		}

		//Why does removing this give error "Missing return stmt" ?
		//Absence of else ?
		//Ans: probably yes.
		return false;
	}

	public boolean isValid(Dot dot)
	{
		System.out.println("detected " + diceVal);
		if(dot.start == false && diceVal != 6)
		{
			return false;
		}
		else
		{
			System.out.println("heere ");
			//Add rule for ending later
			return true;
		}
	}

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(()-> {
			new Screen();
		});
		
	}
}