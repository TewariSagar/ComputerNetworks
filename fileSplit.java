import java.util.*;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class fileSplit
{
	String inpFile;
	byte[] chunkarr;
	FileInputStream f = null;
	private static int chunkSize = 1024*1024;
	HashMap<Integer, String> h = new HashMap<Integer, String>();
 	public fileSplit(String inpFile)
	{
		System.out.println("Owner is splitting the file......");
		this.inpFile = inpFile;
	}

	public void readInpFile() throws IOException
	{
		chunkarr = new byte[chunkSize];
		int x = 0;
		int counter = 0;
		try
		{
			f  = new FileInputStream(inpFile);
			BufferedInputStream bis = new BufferedInputStream(f);
			
			while((x = bis.read(chunkarr, 0, chunkSize)) > 0)
			{
				try
				{
					File n = new File("C:/UF_study/Computer Networks/Project/Code", "test" + String.valueOf(counter) + ".M4a");
					FileOutputStream fo = new FileOutputStream(n);
					fo.write(chunkarr, 0, x);
					String value_string = "test" + String.valueOf(counter) + ".M4a";
					h.put(counter, value_string);
					counter++;
				}
				catch(IOException ex)
				{
					System.out.println(ex.toString());
				}
			}
			f.close();
		}
				catch(IOException ex)
				{
					System.out.println(ex.toString());
				}

	}

	public void printHashMap()
	{
		Set<Integer> keys = h.keySet();
		for (Integer key : keys)
	    System.out.println(key + " " + h.get(key));
	}
	
}





