import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class testesttest 
{
	private static HashMap<String, String> RM1L = new HashMap<String, String>(); // Royal Mail 1st Letter
	
	public static void main(String[] args) 
	{    
	    String path = "C:\\Users\\fearo\\Documents\\test\\RM1-L.csv";
	    BufferedReader in = null;
		try
		{
			in = new BufferedReader(new FileReader(path));
			try
			{
				String H = in.readLine();
				String line = "";	// Creates an empty string
				while ((line = in.readLine()) != null) // makes line equal to the next line of the file until next line is null
				{
					String[] x = line.split(",");				
					RM1L.put(x[0],x[1]);
				}
			}
			
			// IDK
			catch(IOException e)
			{
				// Error while reading the file...
			}
			// Close the file stream when finished reading it.
			finally{in.close();}
		}
		catch (FileNotFoundException e) 
		{
			// File could not be found on the disc.
		}
		catch (IOException e)
		{
			//Could not open or close file.
		}	
		System.out.println(RM1L);
	}

}
