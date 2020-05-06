import java.util.HashMap;

public class PriceDataClass 
{
	// HashMap KG-£ values
	// Royal Mail 1st
	public static HashMap<String, String> RM1L = new HashMap<String, String>(); // Letter
	public static HashMap<String, String> RM1SP = new HashMap<String, String>(); // Small Parcel
	public static HashMap<String, String> RM1MP = new HashMap<String, String>(); // Medium Parcel
	// Royal Mail 2nd
	public static HashMap<String, String> RM2L = new HashMap<String, String>(); // Letter
	public static HashMap<String, String> RM2SP = new HashMap<String, String>(); // Small Parcel
	public static HashMap<String, String> RM2MP = new HashMap<String, String>(); // Medium Parcel
	// Royal Mail 1st Signed
	public static HashMap<String, String> RM1LS = new HashMap<String, String>(); // Letter Signed
	public static HashMap<String, String> RM1SPS = new HashMap<String, String>(); // Small Parcel Signed
	public static HashMap<String, String> RM1MPS = new HashMap<String, String>(); // Medium Parcel Signed
	// Royal Mail 2nd Signed
	public static HashMap<String, String> RM2LS = new HashMap<String, String>(); // Letter Signed
	public static HashMap<String, String> RM2SPS = new HashMap<String, String>(); // Small Parcel Signed
	public static HashMap<String, String> RM2MPS = new HashMap<String, String>(); // Medium Parcel Signed
	/**
	 * @param GetShipCost Routes the packages depending on the type of service, i.e. RM1, RM2, RM1S, RM2S
	 * @return Raw-Shipping-cost
	 */
	public static double GetShipCost(String kg, int[] ServiceID)
	{
		switch(ServiceID[0]) 
		{
		case 1:
			return RM1GetPrice(kg,ServiceID[1]);
		case 2:
			return RM2GetPrice(kg,ServiceID[1]);
		case 3:
			return RM1SGetPrice(kg,ServiceID[1]);
		case 4:
			return RM2SGetPrice(kg,ServiceID[1]);
		}
		return 999.99; // Should not reach this / Here only to stop Error
	}
	/**
	 * @param RM2S Routes to appropriate SubSerivice then sends back the Price by comparing the given kg against the list in the linked HashMaps
	 * @return Shipping-cost
	 */
	private static double RM2SGetPrice(String kg, int i)
	{ // ServiceID { 4 , i } Royal Mail 2nd Signed...
		switch(i) 
		{
		case 1: // ServiceID { 4 , 1 } Royal Mail Signed - Letter
			return Double.parseDouble(RM2LS.get(kg));
		case 2: // ServiceID { 4 , 2 } Royal Mail Signed - Small Parcel
			return Double.parseDouble(RM2SPS.get(kg));
		case 3: // ServiceID { 4 , 3 } Royal Mail Signed - Medium Parcel
			return Double.parseDouble(RM2MPS.get(kg));
		}
		return 999.9; // Should not reach this / Here only to stop Error
	}
	/**
	 * @param RM2S Routes to appropriate SubSerivice then sends back the Price by comparing the given kg against the list in the linked HashMaps
	 * @return Shipping-cost
	 */
	private static double RM1SGetPrice(String kg, int i)
	{ // ServiceID { 3 , i } Royal Mail 1st Signed..
		switch(i) 
		{
		case 1: // ServiceID { 3 , 1 } Royal Mail 1st Signed - Letter
			return Double.parseDouble(RM1LS.get(kg));
		case 2: // ServiceID { 3 , 2 } Royal Mail 1st Signed - Small Parcel
			return Double.parseDouble(RM1SPS.get(kg));
		case 3: // ServiceID { 3 , 3 } Royal Mail 1st Signed - Medium Parcel
			return Double.parseDouble(RM1MPS.get(kg));
		}
		return 999; // Should not reach this / Here only to stop Error
	}
	/**
	 * @param RM2S Routes to appropriate SubSerivice then sends back the Price by comparing the given kg against the list in the linked HashMaps
	 * @return Shipping-cost
	 */
	private static double RM2GetPrice(String kg, int i)
	{ // ServiceID { 2 , i } Royal Mail 2nd...
		switch(i) 
		{
		case 1: // ServiceID { 2 , 1 } Royal Mail 2nd - Letter
			return Double.parseDouble(RM2L.get(kg));
		case 2: // ServiceID { 2 , 2 } Royal Mail 2nd - Small Parcel
			return Double.parseDouble(RM2SP.get(kg));
		case 3: // ServiceID { 2 , 3 } Royal Mail 2nd - Medium Parcel
			return Double.parseDouble(RM2MP.get(kg));
		}
		return 99; // Should not reach this / Here only to stop Error
	}
	/**
	 * @param RM2S Routes to appropriate SubSerivice then sends back the Price by comparing the given kg against the list in the linked HashMaps
	 * @return Shipping-cost
	 */
	private static double RM1GetPrice(String kg, int i) 
	{ // ServiceID { 1 , i } Royal Mail 1st...
		switch(i) 
		{
		case 1: // ServiceID { 1 , 1 } Royal Mail 1st - Letter
			return Double.parseDouble(RM1L.get(kg));
		case 2: // ServiceID { 1 , 2 } Royal Mail 1st - Small Parcel
			return Double.parseDouble(RM1SP.get(kg));
		case 3: // ServiceID { 1 , 3 } Royal Mail 1st - Medium Parcel
			return Double.parseDouble(RM1MP.get(kg));
		}
		return 9; // Should not reach this / Here only to stop Error
	}
}