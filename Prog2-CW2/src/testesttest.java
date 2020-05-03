import java.util.Arrays;
public class testesttest 
{	
	public static void main(String[] args) 
	{ 
		String[][] IAA = 
			{
					{"0","1","2"}, // Array One
					{"3","4","5"}, // Array Two
					{"6","7","8"} // Array Three
			};
		for(int i = 0; i != IAA.length;i++) 
		{
				String temp = Arrays.toString(IAA[i]);
				System.out.println(temp);
		}

	}

}
