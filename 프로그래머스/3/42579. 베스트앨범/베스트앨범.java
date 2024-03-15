import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        Map<String, Integer> playMap = new HashMap<>();
        Map<String, List<int[]>> idMap = new HashMap<>();
        
        for(int i=0; i<genres.length; i++) {
            playMap.put(genres[i], playMap.getOrDefault(genres[i], 0) + plays[i]);
            List<int[]> playList = idMap.getOrDefault(genres[i], new ArrayList<>());
            playList.add(new int[]{i, plays[i]});
            idMap.put(genres[i], playList);
        }
        
        List<String> genreList = new ArrayList<>(playMap.keySet());
        genreList.sort((o1, o2) -> playMap.get(o2).compareTo(playMap.get(o1)));
        
        List<Integer> answerList = new ArrayList<>();
        
        for(int i=0; i<genreList.size(); i++) {
            List<int[]> temp = idMap.get(genreList.get(i));
            if(!temp.isEmpty()) {
                temp.sort((o1, o2) -> o2[1] - o1[1]);
                answerList.add(temp.get(0)[0]);
                if(temp.size() > 1) {
                    answerList.add(temp.get(1)[0]);
                }
            }
        }
        
        answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}