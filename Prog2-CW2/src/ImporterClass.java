import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ImporterClass
{
	public static void ImportPackages() 
	{
		boolean FirstLine = false;
		int k = 0;
		String JobData[][] = new String[k][8];
		BufferedReader tmp = null;
		String Path = "src\\Import.csv";
		try{
			tmp = new BufferedReader(new FileReader(Path));
			try{
				String line = "";	// Creates an empty string
				while ((line = tmp.readLine()) != null) // makes line equal to the next line of the file until next line is null
				{
					if (FirstLine == false) {FirstLine = true;}
					else 
					{
						JobData[k] = line.split(",");
					}
				}
			}
			catch(IOException e) {}
			finally{tmp.close();}
		}
		catch (FileNotFoundException e) {}
		catch (IOException e) {}	
	}
}