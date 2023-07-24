import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

class Solution{
    public class Music
    {
        String gen;
        int cnt;
        int idx;

        public Music(String gen, int cnt, int idx)
        {
            this.gen = gen;
            this.cnt = cnt;
            this.idx = idx;
        }
    }

    public int[] solution(String[] genres, int[] plays)
    {
        int[] answer = {};

        HashMap<String, Integer> map = new HashMap<>();

        int len = genres.length;

        for(int i=0; i<len; i++)
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);

        ArrayList<String> genre_order = new ArrayList<>();

        while(map.size() != 0)
        {
            int max = -1;
            String max_key = "";

            for(String key : map.keySet())
            {
                int tmp_cnt = map.get(key);

                if(tmp_cnt > max)
                {
                    max_key = key;
                    max = tmp_cnt;
                }
            }

            genre_order.add(max_key);
            map.remove(max_key);
        }

        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0; i<genre_order.size(); i++)
        {
            ArrayList<Music> list = new ArrayList<>();
            for(int j=0; j<len; j++)
            {
                if(genre_order.get(i).equals(genres[j]))
                    list.add(new Music(genres[j], plays[j], j));
            }

            Collections.sort(list, new Comparator<Music>() {
                public int compare(Music o1, Music o2) {
                    return o2.cnt - o1.cnt;
                }
            });

            temp.add(list.get(0).idx);

            if(list.size() >= 2)
                temp.add(list.get(1).idx);

        }

        answer = new int[temp.size()];
        for(int i=0; i<answer.length; i++)
            answer[i] = temp.get(i).intValue();

        return answer;
    }

}
