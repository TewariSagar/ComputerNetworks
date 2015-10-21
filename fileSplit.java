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
	private static int chunkSize = 100;
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
					File n = new File("C:/UF_study/Computer Networks/Project", "video" + String.valueOf(counter) + ".MP4");
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
		fileSplit f = new fileSplit("video.MP4");
		f.readInpFile();
	}
}





