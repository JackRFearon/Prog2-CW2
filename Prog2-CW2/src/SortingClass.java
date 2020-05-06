public class SortingClass 
{
	/**
	 * @param ParcelSort Sorts the Package into if its a Letter, Small or Medium Parcel then Changes the kg to Nkg to work propperly with GetPackageCost
	 * @return 
	 */
	public static double ParcelSort(double w, double l, double h, String kg, int[] ServiceID) 
	{
		double Nkg = Double.parseDouble(kg);
		if (Nkg <= 750 && l <= 35.5 && w <= 25 && h <= 2.5) // Letter
		{
			ServiceID[1] = 1;
		}
		else if (Nkg <= 2000 && l <= 45 && w <= 35 && h <= 16) // Small Parcel
		{
			ServiceID[1] = 2;
		}
		else if (Nkg <= 20000 && l <= 61 && w <= 46 && h <= 46) // Medium Parcel
		{
			ServiceID[1] = 3;
		}
		kg = WeightSort(Nkg, ServiceID); // Changes Nkg to a specific value to work properly with GetShipCost		
		return PriceDataClass.GetShipCost(kg, ServiceID);
	}
	/**
	 * @param WeightSort Takes Nkg as a double and returns it normliased to work with the CSV's then returns that double as a String
	 * @Return Weight Sorted to Match one listed in the CSV
	 */
	private static String WeightSort(double Nkg, int[] ServiceID) 
	{	// TODO Make it so the Array Ints below get updated from imported CSV's instead of being preset (OPTIONAL)
		int[] LetterWeights = {0, 100, 200, 250, 300, 400, 500, 600, 700, 750};
		int[] SmallParcelWeights = {0, 1000, 2000};
		int[] LargeParcelWeights = {0, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 80000, 9000, 10000, 11000, 12000, 13000, 14000, 15000, 16000, 17000, 180000, 19000, 20000};
		boolean Match = false;
		switch(ServiceID[1]) 
		{
		case 1: // Letters
			 for (int i = 0; Match == false; i++) 
			 {
				 if (LetterWeights[i] >= Nkg) 
				 {
					 Nkg = LetterWeights[i];
					 Match = true;
				 }
			 }
			break;
		case 2: // Small Parcels
			for (int i = 0; Match == false; i++) 
			 {
				 if (SmallParcelWeights[i] >= Nkg) 
				 {
					 Nkg = SmallParcelWeights[i];
					 Match = true;
				 }
			 }
			break;
		case 3: // Large Parcels
			for (int i = 0; Match == false; i++) 
			 {
				 if (LargeParcelWeights[i] >= Nkg) 
				 {
					 Nkg = LargeParcelWeights[i];
					 Match = true;
				 }
			 }
			break;
		}
		int xyz = (int) Nkg;
		return Integer.toString(xyz);
	}
}