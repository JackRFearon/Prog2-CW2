import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
public class testesttest 
{	
	public static void main(String[] args) 
	{ 
		boolean FirstLine = false;
		int p = -1;
		int k = 0;
		BufferedReader tmp = null;
		String Path = "src\\Import.csv";
		try{
			tmp = new BufferedReader(new FileReader(Path));
			try{
				@SuppressWarnings("unused")
				String line = "";	// Creates an empty string
				while ((line = tmp.readLine()) != null) // makes line equal to the next line of the file until next line is null
				{
					p++;
				}
			}
			catch(IOException e) {}
			finally{tmp.close();}
		}
		catch (FileNotFoundException e) {}
		catch (IOException e) {}
		String JobData[][] = new String[(p)][8];
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
						k++;
					}
				}
			}
			catch(IOException e) {}
			finally{tmp.close();}
		}
		catch (FileNotFoundException e) {}
		catch (IOException e) {}
		for(int i = 0; i != JobData.length;i++) 
		{
				String temp = Arrays.toString(JobData[i]);
				System.out.println(temp);
		}
	}
}
