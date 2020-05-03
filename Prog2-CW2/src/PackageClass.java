public class PackageClass 
{
	// imported variables
	private String PackageID;
	private double width;
	private double length;
	private double height;
	private String weight;
	private boolean fragile;
	// none-imported variables
	private int[] ServiceID = {0,0};
	private double Price;
	
	// Methods
	public PackageClass(String[] Data) 
	{
		this.PackageID = Data[0];
		this.height = Double.parseDouble(Data[1]);
		this.width = Double.parseDouble(Data[2]);
		this.length = Double.parseDouble(Data[3]);
		this.weight = Data[4];
		this.fragile = Boolean.parseBoolean(Data[5]);
		
		if (Data[6] == "1st") // RM1...
		{
			if ((Boolean.parseBoolean(Data[7])) == true) { this.ServiceID[0] = 1; } // RM1
			else { this.ServiceID[0] = 3; } // RM1S
		}
		else if (Data[6] == "2nd") // RM2...
		{
			if (Boolean.parseBoolean(Data[7]) == true) { this.ServiceID[0] = 2; } // RM2
			else { this.ServiceID[0] = 4; } // RM2S
		}
	}
}
