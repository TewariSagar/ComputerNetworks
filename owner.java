import java.io.*;
import java.util.*;
import java.net.*;


public class owner extends Thread
{
	private Thread _threadObject;
	private String ownerMainThread;
	private ServerSocket ss;
	//HashMap<SocketAddress, int> hs = new HashMap<SocketAddress, int>();
	public owner(int listeningPort, String ownerMainThread) throws IOException
	{
		this.ownerMainThread = ownerMainThread;
		ss = new ServerSocket(listeningPort);// created a Server Socket
		ss.setSoTimeout(10000);
	}

	@Override
	public void run()
	{
		while(true)
		{
			try
			{
				System.out.println("Waiting for client on port " + ss.getLocalPort() + "...");
				Socket ownerSocket = ss.accept();	//socket object instantiated to talk to the client through TCP
				System.out.println("Connection established to client: " + ownerSocket.getRemoteSocketAddress());
				SocketAddress var = ownerSocket.getRemoteSocketAddress();
				//int value = 
				//hashmap to KEY: IP ADDRESS, VALUE: name of peer
				//hs.put(var , value);
				//switch()
				//need a switch case badly................................
				InputStream is = ownerSocket.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(is);
				checkClient to = (checkClient)ois.readObject();
				/*if (to != null)
					{
						System.out.println(to.clientName);
						System.out.println(to.clientValue);
					}*/
					if (to != null)
					{
						int peerValue = to.clientValue;
						//System.out.println("DEBUG peerValue: " + peerValue);
						switch(peerValue)
						{
							case 1:
							System.out.println("Peer 1 connected");
							break;

							case 2:
							System.out.println("Peer 2 connected");
							break;
						}
					}
				is.close();
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
			catch(Exception e)
			{System.out.println(e);}
		}
	}

	@Override
	public void start()
	{
		System.out.println("Starting the thread: " + ownerMainThread);
		// instantiating an owner thread object
		if(_threadObject == null)
		{
			_threadObject = new Thread(this, ownerMainThread);
			//calls the run method
			_threadObject.start();
		}
	}

	public static void main(String args[])  throws IOException
	{
		fileSplit f = new fileSplit("test.M4a");
		f.readInpFile();
		//f.printHashMap();
		// main thread to look for peer connections
		try
		{
			owner o = new owner(1111, "Owners MAIN thread");
			o.start();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}