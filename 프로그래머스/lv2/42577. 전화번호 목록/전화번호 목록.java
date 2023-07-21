import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
		HashMap<String, Integer> map = new HashMap<>();

		int len = phone_book.length;

		for (int i = 0; i < len; i++)
			map.put(phone_book[i], i);
		
		for(int i=0; i<len; i++)
		{
			int slen = phone_book[i].length();
			for(int j=0; j<slen; j++)
			{
				if(map.containsKey(phone_book[i].substring(0, j)))
					return false;
			}
		}
		return true;
	}
}