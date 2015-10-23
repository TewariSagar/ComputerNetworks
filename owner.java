import java.io.*;
import java.util.*;
import java.net.*;


public class owner extends Thread
{
	private ServerSocket ss;
	public owner(int listeningPort) throws IOException
	{
		ss = new ServerSocket(listeningPort);// created a Server Socket
		ss.setSoTimeout(10000);
	}

	public void run()
	{
		while(true)
		{
			try
			{
				System.out.println("Waiting for client on port " + ss.getLocalPort() + "...");
				Socket ownerSocket = ss.accept();	//socket object instantiated to talk to the client through TCP
				System.out.println("Connection established to client: " + ownerSocket.getRemoteSocketAddress());
				ownerSocket.close();
			}
			catch(SocketTimeoutException s)
       	 	{
           		System.out.println("Socket timed out!");
       		}
			catch(IOException e)
        	{
            	e.printStackTrace();
			}
		}
	}
	public static void main(String args[])
	{
		try
		{
			Thread t = new owner(1111);
			t.start();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}