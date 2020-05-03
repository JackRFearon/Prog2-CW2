import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author 24248134
 */
public class PriceDataClass 
{
	// HashMap KG-£ values
	// Royal Mail 1st
	private static HashMap<String, String> RM1L = new HashMap<String, String>(); // Letter
	private static HashMap<String, String> RM1SP = new HashMap<String, String>(); // Small Parcel
	private static HashMap<String, String> RM1MP = new HashMap<String, String>(); // Medium Parcel
	// Royal Mail 2nd
	private static HashMap<String, String> RM2L = new HashMap<String, String>(); // Letter
	private static HashMap<String, String> RM2SP = new HashMap<String, String>(); // Small Parcel
	private static HashMap<String, String> RM2MP = new HashMap<String, String>(); // Medium Parcel
	// Royal Mail 1st Signed
	private static HashMap<String, String> RM1LS = new HashMap<String, String>(); // Letter Signed
	private static HashMap<String, String> RM1SPS = new HashMap<String, String>(); // Small Parcel Signed
	private static HashMap<String, String> RM1MPS = new HashMap<String, String>(); // Medium Parcel Signed
	// Royal Mail 2nd Signed
	private static HashMap<String, String> RM2LS = new HashMap<String, String>(); // Letter Signed
	private static HashMap<String, String> RM2SPS = new HashMap<String, String>(); // Small Parcel Signed
	private static HashMap<String, String> RM2MPS = new HashMap<String, String>(); // Medium Parcel Signed
	/**
	 * @param GetShipCost Routes the packages depending on the type of service, i.e. RM1, RM2, RM1S, RM2S
	 * @return Raw-Shipping-cost
	 */
	public static double GetShipCost(String kg, int[] ServiceID)
	{
		switch(ServiceID[0]) 
		{
		case 1:
			return RM1(kg,ServiceID[1]);
		case 2:
			return RM2(kg,ServiceID[1]);
		case 3:
			return RM1S(kg,ServiceID[1]);
		case 4:
			return RM2S(kg,ServiceID[1]);
		}
		return 999.999; // Should not reach this >_<
	}
	/**
	 * @param RM2S Routes to appropriate SubSerivice then sends back the Price by comparing the given kg against the list in the linked HashMaps
	 * @return Shipping-cost
	 */
	private static double RM2S(String kg, int i) // ServiceID { 4 , i } Royal Mail 2nd Signed...
	{
		switch(i) 
		{
		case 1: // ServiceID { 4 , 1 } Royal Mail Signed - Letter
			return Double.parseDouble(RM2LS.get(kg));
		case 2: // ServiceID { 4 , 2 } Royal Mail Signed - Small Parcel
			return Double.parseDouble(RM2SPS.get(kg));
		case 3: // ServiceID { 4 , 3 } Royal Mail Signed - Medium Parcel
			return Double.parseDouble(RM2MPS.get(kg));
		}
		return 999.999; // Should not reach this >_<
	}
	/**
	 * @param RM2S Routes to appropriate SubSerivice then sends back the Price by comparing the given kg against the list in the linked HashMaps
	 * @return Shipping-cost
	 */
	private static double RM1S(String kg, int i) // ServiceID { 3 , i } Royal Mail 1st Signed..
	{
		switch(i) 
		{
		case 1: // ServiceID { 3 , 1 } Royal Mail 1st Signed - Letter
			return Double.parseDouble(RM1LS.get(kg));
		case 2: // ServiceID { 3 , 2 } Royal Mail 1st Signed - Small Parcel
			return Double.parseDouble(RM1SPS.get(kg));
		case 3: // ServiceID { 3 , 3 } Royal Mail 1st Signed - Medium Parcel
			return Double.parseDouble(RM1MPS.get(kg));
		}
		return 999.999; // Should not reach this >_<
	}
	/**
	 * @param RM2S Routes to appropriate SubSerivice then sends back the Price by comparing the given kg against the list in the linked HashMaps
	 * @return Shipping-cost
	 */
	private static double RM2(String kg, int i) // ServiceID { 2 , i } Royal Mail 2nd...
	{
		switch(i) 
		{
		case 1: // ServiceID { 2 , 1 } Royal Mail 2nd - Letter
			return Double.parseDouble(RM2L.get(kg));
		case 2: // ServiceID { 2 , 2 } Royal Mail 2nd - Small Parcel
			return Double.parseDouble(RM2SP.get(kg));
		case 3: // ServiceID { 2 , 3 } Royal Mail 2nd - Medium Parcel
			return Double.parseDouble(RM2MP.get(kg));
		}
		return 999.999; // Should not reach this >_<
	}
	/**
	 * @param RM2S Routes to appropriate SubSerivice then sends back the Price by comparing the given kg against the list in the linked HashMaps
	 * @return Shipping-cost
	 */
	private static double RM1(String kg, int i) // ServiceID { 1 , i } Royal Mail 1st...
	{
		switch(i) 
		{
		case 1: // ServiceID { 1 , 1 } Royal Mail 1st - Letter
			return Double.parseDouble(RM1L.get(kg));
		case 2: // ServiceID { 1 , 2 } Royal Mail 1st - Small Parcel
			return Double.parseDouble(RM1SP.get(kg));
		case 3: // ServiceID { 1 , 3 } Royal Mail 1st - Medium Parcel
			return Double.parseDouble(RM1MP.get(kg));
		}
		return 999.999; // Should not reach this >_<
	}
	/**
	 * @param updateCSV updates the CSV ratio table for a given sheet
	 */
	public static void updateCSV() 
	{
		BufferedReader in = null;
		String[] PathNames = {"RM1L","RM1LS","RM1MP","RM1MPS","RM1SP","RM1SPS","RM2L","RM2LS","RM2MP","RM2MPS","RM2SP","RM2SPS"};
		String Path = "C:\\Users\\fearo\\git\\Prog2-CW2\\Prog2-CW2\\src\\CSV"; // TODO Fix and make this it so it looks to a universal local place intead of this
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
						switch(i)
						{
						 case 1: RM1L.put(x[0],x[1]); break;
						 case 2: RM1LS.put(x[0],x[1]); break;
						 case 3: RM1MP.put(x[0],x[1]); break;
						 case 4: RM1MPS.put(x[0],x[1]); break;
						 case 5: RM1SP.put(x[0],x[1]); break;
						 case 6: RM1SPS.put(x[0],x[1]); break;
						 case 7: RM2L.put(x[0],x[1]); break;
						 case 8: RM2LS.put(x[0],x[1]); break;
						 case 9: RM2MP.put(x[0],x[1]); break;
						 case 10: RM2MPS.put(x[0],x[1]); break;
						 case 11: RM2SP.put(x[0],x[1]); break;
						 case 12: RM2SPS.put(x[0],x[1]); break;
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