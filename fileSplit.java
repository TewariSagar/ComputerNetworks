import java.util.*;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class fileSplit
{
	String inpFile;
	byte[] chunkarr;
	FileInputStream f = null;
	private static int chunkSize = 1024*1024;
 	public fileSplit(String inpFile)
	{
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
					counter++;
					System.out.println("Created a file");
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
	public static void main(String args[]) throws IOException
	{
		fileSplit f = new fileSplit("test.M4a");
		f.readInpFile();
		clientOne co = new clientOne(1111, "localhost");
		co.oneFunction();
	}
}





