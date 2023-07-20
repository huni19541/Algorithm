import java.util.Scanner;

public class Main {

	// 변수 선언
	static String doc;
	static String word;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		// space도 포함 -> next() 대신 nextLine()
		doc = sc.nextLine();
		word = sc.nextLine();
		
		int res = find(doc, word);
		System.out.println(res);
		
		sc.close();
	}

	// 중복 검색 횟수 반환해주는 함수
	static int find(String doc, String word)
	{
		int cnt = 0;

		// word크기 만큼 남았을 때까지 for문
		for(int i=0; i<=doc.length()-word.length();)
		{
			boolean check = true;

			// 한 문자씩 비교
			for(int j=0; j<word.length(); j++)
			{
				if(doc.charAt(i+j) != word.charAt(j))
				{
					check = false;
					break;
				}
			}

			// 일치하면 word 길이 만큼 idx늘리기
			if(check == true)
			{
				cnt++;
				i += word.length();
			}

			// 불일치 -> idx++
			else
				i++;
		}
		
		return cnt;
	}
	
}
