import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n , arr[];
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str; //입력 없을때 까지 받기
        while((str = br.readLine()) != null) {
            n = Integer.parseInt(str);

            //0이 _
            int temp = (int) Math.pow(3,n);
            arr = new int[temp];
            divide(temp,0,temp-1);
            
            StringBuilder sb = new StringBuilder();

            for(int i=0;i<arr.length;i++) {
                if(arr[i]==0) sb.append("-");
                else sb.append(" ");
            }
            System.out.println(sb.toString());
        }
        

    }
    private static void divide(int range,int start,int end) {
        
        
        if(range==1 ) {
            return;
        }
        
        else {
            int temp = range/3;
            for(int i=start+temp;i<temp*2+start;i++) {
                arr[i] = 1;
            }

            divide(temp,start,start+temp-1);
            divide(temp,end-temp+1,end);
        }
    }
}