import java.util.Arrays;

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
		boolean Signedbool = Boolean.parseBoolean(Data[7]);
		switch(Data[6]) 
		{
		case "1": // Royal Mail 1st class...
			if (Signedbool == true) // Signed
			{
				ServiceID[0] = 3; // Signed
			}
			else if (Signedbool  ==  false) 
			{
				ServiceID[0] = 1; // Not Signed
			}
			break;
		case "2": // Royal Mail 2nd class...
			if (Signedbool == true) // Signed
			{
				ServiceID[0] = 4; // Signed
			}
			else if (Signedbool  ==  false) 
			{
				ServiceID[0] = 2; // Not Signed
			}
			break;
		}		
		this.Price = SortingClass.ParcelSort(this.width, this.length, this.height, this.weight, ServiceID);
	}
	public String[] ToExport() 
	{ // Exports all Data to ExportData[][] ready to be passed to ExporterClass/Export.CSV
		String[] tempArray = 
			{
					PackageID, // 0
					(Double.toString(height)), // 1
					(Double.toString(width)), // 2
					(Double.toString(length)), // 3
					weight, // 4
					(Boolean.toString(fragile)), // 5
					("1"), // 6
					(Double.toString(Price)) // 7
			};
		switch(ServiceID[0])
		{
			case 1:
				tempArray[6] = "Royal Mail 1st";
				break;
			case 2:
				tempArray[6] = "Royal Mail 2nd";
				break;
			case 3:
				tempArray[6] = "Royal Mail 1st - Signed";
				break;
			case 4: 
				tempArray[6] = "Royal Mail 2nd - Signed";
				break;
		}
		return tempArray;
	}
	public String PrintDebug() // DEBUG
	{
		String x = "[";
		x += PackageID + ", ";
		x += height + ", ";
		x += width + ", ";
		x += length + ", ";
		x += weight + ", ";
		x += fragile + ", ";
		x += Arrays.toString(ServiceID) + ", ";
		x += Price + "]";
		return x;
	}
}
