import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int idx = 0;
        for(int t=0, cl=commands.length; t<cl; t++)
        {
        	int i = commands[t][0];
        	int j = commands[t][1];
        	int k = commands[t][2];
        	
        	int[] arr = new int[j-i+1];
        	
        	int tidx = 0;
        	for(int tt=i-1; tt<j; tt++)
        	{
        		arr[tidx++] = array[tt];
        	}
        	// bubbleSort(arr);
            Arrays.sort(arr);
        	answer[idx++] = arr[k-1]; 
        }
        
        return answer;
    }
	
	// public static void bubbleSort(int[] arr)
	// {
	// 	int len = arr.length;
	// 	for(int i=0; i<len-1; i++)
	// 	{
	// 		for(int j=i+1; j<len; j++)
	// 		{
	// 			if(arr[j-1]>arr[j])
	// 			{
	// 				int temp = arr[j];
	// 				arr[j] = arr[j-1];
	// 				arr[j-1] = temp;
	// 			}
	// 		}
	// 	}
	// }
}