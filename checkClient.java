import java.net.*;
import java.io.*;

public class checkClient implements Serializable
{
	int clientValue ;
	String clientName;
	public  checkClient(int v, String s)
	{
		this.clientValue=v;
		this.clientName=s;
	}
}