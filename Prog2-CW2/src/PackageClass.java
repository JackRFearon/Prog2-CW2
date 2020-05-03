public class PackageClass 
{
	// Imported Details
	private String PackageID;
	private double width;
	private double length;
	private double height;
	private String weight;
	private boolean fragile;
	// COME UP WITH BETTER COMMENT NAMES IDEAS AAA
	private int[] ServiceID = {0,0};
	private double Price;
	
	// Methods
	public PackageClass(String S, double w, double l, double h, String Weight, boolean f,String test, boolean Signed) 
	{
		this.PackageID = S;
		this.width = w;
		this.length = l;
		this.height = h;
		this.weight = Weight;
		this.fragile = f;
		if (test == "1st") // RM1...
		{
			if (Signed == true) { this.ServiceID[0] = 1; } // RM1
			else { this.ServiceID[0] = 3; } // RM1S
		}
		else if (test == "2nd") // RM2...
		{
			if (Signed == true) { this.ServiceID[0] = 2; } // RM2
			else { this.ServiceID[0] = 4; } // RM2S
		}
	}
}
