import java.io.*;
import java.net.*;

public class clientTwo
{
private Socket secondClient;
	//(int ownerPort, String ownerName, int uploadNeighbour, int downloadNeighbour)

	public clientTwo(int ownerPort, String ownerName)
	{
		try
		{
			secondClient = new Socket(ownerName, ownerPort);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	public void twoFunction()
	{
		try
		{
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
	public static void main(String args[])
	{
		//update for (int ownerPort, String ownerName, int uploadNeighbour, int downloadNeighbour)
		clientTwo co = new clientTwo(1111, "localhost");
		co.twoFunction();
	}

}