import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ImporterClass
{
	/**
	 * @param ImportPackages Imports Package Data from Import.CSV
	 */
	public static void ImportPackages()
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
		if (p < 0) {p = 4;}
		Main.ImportData = new String[p][8];
		Main.ExportData = new String[p][8];
		try{
			tmp = new BufferedReader(new FileReader(Path));
			try{
				String line = "";	// Creates an empty string
				while ((line = tmp.readLine()) != null) // makes line equal to the next line of the file until next line is null
				{
					if (FirstLine == false) {FirstLine = true;}
					else 
					{
						Main.ImportData[k] = line.split(",");
						k++;
					}
				}
			}
			catch(IOException e) {}
			finally{tmp.close();}
		}
		catch (FileNotFoundException e) {}
		catch (IOException e) {}
	}
	/**
	 * @param ImportHashMapData Imports Data for the KG - ££ HashMaps
	 */
	public static void ImportHashMapData() 
	{
		BufferedReader in = null;
		String[] PathNames = {"RM1L","RM1LS","RM1MP","RM1MPS","RM1SP","RM1SPS","RM2L","RM2LS","RM2MP","RM2MPS","RM2SP","RM2SPS"};
		String Path = "src\\Data\\"; 
		for (int i = 0; i != PathNames.length; i++) 
		{
			try
			{
				in = new BufferedReader(new FileReader((Path + PathNames[i] + ".CSV")));
				try
				{
					String line = "";	// Creates an empty string
					while ((line = in.readLine()) != null) // makes line equal to the next line of the file until next line is null
					{
						String[] x = line.split(",");
						switch(i)
						{
						 case 0: PriceDataClass.RM1L.put(x[0],x[1]); break; // Validated
						 case 1: PriceDataClass.RM1LS.put(x[0],x[1]); break; // validated
						 case 2: PriceDataClass.RM1MP.put(x[0],x[1]); break; // validated
						 case 3: PriceDataClass.RM1MPS.put(x[0],x[1]); break; // validated
						 case 4: PriceDataClass.RM1SP.put(x[0],x[1]); break;// validated
						 case 5: PriceDataClass.RM1SPS.put(x[0],x[1]); break;// validated
						 case 6: PriceDataClass.RM2L.put(x[0],x[1]); break;// validated
						 case 7: PriceDataClass.RM2LS.put(x[0],x[1]); break;// validated
						 case 8: PriceDataClass.RM2MP.put(x[0],x[1]); break;// validated
						 case 9: PriceDataClass.RM2MPS.put(x[0],x[1]); break; // Error
						 case 10: PriceDataClass.RM2SP.put(x[0],x[1]); break; // Validated
						 case 11: PriceDataClass.RM2SPS.put(x[0],x[1]); break; // Validated
						} 		
					}
				}
				catch(IOException e) {}
				finally{in.close();}
			}
			catch (FileNotFoundException e) { }
			catch (IOException e) { }	
		}
	}
}