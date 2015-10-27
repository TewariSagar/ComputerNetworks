import java.io.*;
import java.net.*;

public class clientTwo implements Runnable
{
private Socket secondClient;
	//(int ownerPort, String ownerName, int uploadNeighbour, int downloadNeighbour)

	/*public clientTwo(int ownerPort, String ownerName)
	{
		try
		{
			secondClient = new Socket(ownerName, ownerPort);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*

	}*/
	public void twoFunction(int ownerPort, String ownerName)
	{
		try
		{
			secondClient = new Socket(ownerName, ownerPort);
			System.out.println("Connection established to localhost: " + secondClient.getRemoteSocketAddress());
			OutputStream os = secondClient.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			checkClient to = new checkClient(2,"object from client");
			oos.writeObject(to);
			oos.close();
			os.close();
			secondClient.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void run()
	{
		System.out.println("IN THE RUN BLOCK OF PEER 2");
		try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
	}
	public static void main(String args[])
	{
		//update for (int ownerPort, String ownerName, int uploadNeighbour, int downloadNeighbour)
		clientTwo co = new clientTwo();
		co.twoFunction(1111, "localhost");
	}

}