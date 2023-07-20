import java.util.Scanner;

public class Main {

	static String doc;
	static String word;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		doc = sc.nextLine();
		word = sc.nextLine();
		
		int res = find(doc, word);
		System.out.println(res);
		
		sc.close();
	}
	
	static int find(String doc, String word)
	{
		int cnt = 0;
		
		for(int i=0; i<=doc.length()-word.length();)
		{
			boolean check = true;
			
			for(int j=0; j<word.length(); j++)
			{
				if(doc.charAt(i+j) != word.charAt(j))
				{
					check = false;
					break;
				}
			}
			
			if(check == true)
			{
				cnt++;
				i += word.length();
			}
			else
				i++;
		}
		
		return cnt;
	}
	
}
