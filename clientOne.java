import java.io.*;
import java.net.*;

public class clientOne implements Runnable
{
	private Socket firstClient;
	//(int ownerPort, String ownerName, int uploadNeighbour, int downloadNeighbour)
	/*public clientOne(int ownerPort, String ownerName)
	{
		try
		{
		//	firstClient = new Socket(ownerName, ownerPort);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}*/
	

	public void oneFunction(int ownerPort, String ownerName)
	{
		try
		{
			firstClient = new Socket(ownerName, ownerPort);
			System.out.println("Connection established to localhost: " + firstClient.getRemoteSocketAddress());
			OutputStream os = firstClient.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			checkClient to = new checkClient(1,"object from client");
			oos.writeObject(to);
			oos.close();
			os.close();
			firstClient.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void run()
	{
		System.out.println("In the RUN BLOCK OF PEER 1");
		try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
	}

	public static void main(String args[])
	{
		//update for (int ownerPort, String ownerName, int uploadNeighbour, int downloadNeighbour)
		clientOne co = new clientOne();
		co.oneFunction(1111, "localhost");
		
	}

}