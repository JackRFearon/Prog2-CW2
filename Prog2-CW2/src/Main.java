import java.util.Arrays;

public class Main 
{
	public static String ImportData[][];
	public static String ExportData[][];
	public static void main(String[] args)
	{
		// Stage 1 - Importing / Starting up
		ImporterClass.ImportPackages(); // Imports Package Data
		ImporterClass.ImportHashMapData(); // Imports HashMap Data		
		
		// Stage 2 - Data Processing
		for(int i = 0; i != ImportData.length; i++) 
		{
			PackageClass x = new PackageClass(ImportData[i]);
			ExportData[i] = x.ToExport();
		}
		
		
		// Debugging Array Print
		System.out.println();
		for(int i = 0; i != ImportData.length; i++) 
		{
			System.out.println(Arrays.toString(ImportData[i]) + " : Import Data" + i);
		}
		System.out.println();
		for(int i = 0; i != ImportData.length; i++) 
		{
			System.out.println(Arrays.toString(ExportData[i]) + " : Export Data" + i);
		}
		
		
	}
}
