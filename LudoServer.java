import java.net.*;
import java.io.*;
import java.util.*;

public class LudoServer implements Runnable
{
	private static ArrayList <DataInputStream> from = new ArrayList <DataInputStream> ();
	private static ArrayList <DataOutputStream> to = new ArrayList <DataOutputStream> ();

	private Socket socket;
	private int index;
	private String name = "";
	private boolean first = true;
	private String message = "";

	private OutputStream out;
	private DataOutputStream toClient;
	private InputStream in;
	private DataInputStream fromClient;

	private Iterator iter1, iter2;

	LudoServer(Socket socket, int index)
	{
		this.socket = socket;
		this.index = index;
	}

	public void run()
	{
		try
		{
			System.out.println("New Client added at port: " + socket.getLocalPort() );

			out = socket.getOutputStream();
			toClient = new DataOutputStream(out);

			toClient.writeUTF("You are now connected.");

			in = socket.getInputStream();
			fromClient = new DataInputStream(in);

			// String msg;

			try
			{
				to.add(toClient);
				from.add(fromClient);
			}
			catch(NoSuchElementException exp)
			{
				System.out.println("Caught here : " + exp);
			}

			while(!message.equals("stop"))
			{
				Dot dot;
				try
				{
					message = fromClient.readUTF();
					System.out.println("Client" + index + ": " + message );
					broadcast(message, fromClient);
				}
				catch(IOException ioe)
				{
					//Caught
				}
				// catch(WriteAbortedException wae)
				// {
				// 	System.out.println("wae caught");
				// 	wae.printStackTrace();
				// }
				// catch(NotSerializableException nse)
				// {
				// 	System.out.println("nse caught");
				// }
				// if(first)
				// {
				// 	name = message;
				// 	first = false;
				// }
				// else
				// {
					
				// }
			}
		}
		catch(WriteAbortedException wae)
		{
			System.out.println("wae bing caught");
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("Exception at client: " + index);
		}
	}

	public void broadcast(String message, DataInputStream from)
	{
		try
		{
			
			iter1 = this.from.iterator();
			iter2 = to.iterator();

			while(iter1.hasNext() && iter2.hasNext() )
			{
				try
				{
					toClient = (DataOutputStream)iter2.next();
					fromClient = (DataInputStream)iter1.next();
					if(!fromClient.equals(from) )
					{
						try
						{
							System.out.println("Broadcasting + " + message);
							toClient.writeUTF(message);
						}
						catch(IOException ioe)
						{
							//Caught
						}
						// catch(NotSerializableException nse)
						// {
						// 	//System.out.println("nse caught");
						// }
					}
				}
				catch(NoSuchElementException noe)
				{
					System.out.println("Bing o" + noe);
				}
			}

		}
		catch(NoSuchElementException noe)
		{
			System.out.println(noe + " caught");
		}
	}

	public static void main(String args[])
	{
		int port = Integer.parseInt(args[0]);
		ServerSocket servSock;
		Socket socket;
		int clientNo = 1;
		while(true)
		{
			try
			{
				servSock = new ServerSocket(port);
				socket = servSock.accept();
				new Thread(new LudoServer(socket, clientNo) ).start();
				
				clientNo ++;

			}
			catch(Exception e)
			{
				// System.out.println("Exception in main() of ChatServer");
				//Exception occured
			}
		}
	}
}