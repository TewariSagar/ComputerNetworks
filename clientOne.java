import java.io.*;
import java.net.*;

public class clientOne
{
private Socket firstClient;
	public clientOne(int ownerPort, String ownerName) 	// need to modify this as per the project needs
	{
		try
		{
			firstClient = new Socket(ownerName, ownerPort);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	public void oneFunction()
	{
		try
		{
			System.out.println("Connection established to server: " + firstClient.getRemoteSocketAddress());
			firstClient.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String args[])
	{
		clientOne co = new clientOne(1111, "localhost");
		co.oneFunction();
	}

}