import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author 24248134
 * @version 0.1
 */
//import java.util.HashMap;

public class PriceDataClass 
{
	// HashMap KG-£ values
	private static HashMap<String, String> RM1L = new HashMap<String, String>(); // Royal Mail 1st Letter
	private static HashMap<String, String> RM1SP = new HashMap<String, String>(); // Royal Mail 1st Small Parcel
	private static HashMap<String, String> RM1MP = new HashMap<String, String>(); // Royal Mail 1st Medium Parcel
	private static HashMap<String, String> RM2L = new HashMap<String, String>(); // Royal Mail 2nd Letter
	private static HashMap<String, String> RM2SP = new HashMap<String, String>(); // Royal Mail 2nd Small Parcel
	private static HashMap<String, String> RM2MP = new HashMap<String, String>(); // Royal Mail 2nd Medium Parcel
	private static HashMap<String, String> RM1LS = new HashMap<String, String>(); // Royal Mail 1st Letter Signed
	private static HashMap<String, String> RM1SPS = new HashMap<String, String>(); // Royal Mail 1st Small Parcel Signed
	private static HashMap<String, String> RM1MPS = new HashMap<String, String>(); // Royal Mail 1st Medium Parcel Signed
	private static HashMap<String, String> RM2LS = new HashMap<String, String>(); // Royal Mail 2nd Letter Signed
	private static HashMap<String, String> RM2SPS = new HashMap<String, String>(); // Royal Mail 2nd Small Parcel Signed
	private static HashMap<String, String> RM2MPS = new HashMap<String, String>(); // Royal Mail 2nd Medium Parcel Signed
	/**
	 * @param GetShipCost Calls the method that links to ServiceID[0] then returns the value from that method
	 * @return Shipping-cost
	 */
	public double GetShipCost(int kg, int[] ServiceID)
	{
		switch(ServiceID[0]) 
		{
		case 1:
			return RM1(kg,ServiceID[1]);
		case 2:
			return RM2(kg,ServiceID[1]);
		case 3:
			return RMT24(kg,ServiceID[1]);
		case 4:
			return RMT48(kg,ServiceID[1]);
		case 5:
			return RM1S(kg,ServiceID[1]);
		case 6:
			return RM2S(kg,ServiceID[1]);
		}
		return 999.999; // Should not reach this >_<
	}
	private double RM2S(int kg, int i) 
	{
		// TODO Create Table
		return 0;
	}
	private double RM1S(int kg, int i)
	{
		// TODO Create Table
		return 0;
	}
	private double RM2(int kg, int i) 
	{
		// TODO Create Table
		return 0;
	}
	private double RM1(int kg, int i) 
	{
		// TODO Create Table
		return 0;
	}
	/**
	 * @param updateCSV updates the CSV ratio table for a given sheet
	 */
	public static void updateCSV() // reads file and returns contents as a string
	{
		BufferedReader in = null;
		String[] PathNames = {"RM1L","RM1LS","RM1MP","RM1MPS","RM1SP","RM1SPS","RM2L","RM2LS","RM2MP","RM2MPS","RM2SP","RM2SPS"};
		String Path = "C:\\Users\\fearo\\git\\Prog2-CW2\\Prog2-CW2\\src\\CSV";
		for (int i = 0; i != PathNames.length; i++) 
		{
			try
			{
				in = new BufferedReader(new FileReader((Path + PathNames[i])));
				try
				{
					String line = "";	// Creates an empty string
					while ((line = in.readLine()) != null) // makes line equal to the next line of the file until next line is null
					{
						String[] x = line.split(",");				
						PathNames[i].put(x[0],x[1]);
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
