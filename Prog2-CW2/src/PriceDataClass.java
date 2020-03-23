/**
 * @author 24248134
 *
 */
//import java.util.HashMap;

public class PriceDataClass 
{
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
	private double RMT48(int kg, int i)
	{
		// TODO Create Table
		return 0;
	}
	private double RMT24(int kg, int i) 
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
}
