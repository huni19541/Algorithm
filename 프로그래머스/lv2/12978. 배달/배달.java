import java.util.*;

class Solution {
    
    static class Node {
        int vertex;
        int weight;
        Node next;
        
        public Node(int vertex, int weight, Node next) {
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }
    }
    
    static int[] dist;
    static boolean[] visited;
    static Node[] adjList;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        adjList = new Node[N+1];
        
        for(int i=0; i<road.length; i++) {
            adjList[road[i][0]] = new Node(road[i][1], road[i][2], adjList[road[i][0]]);
            adjList[road[i][1]] = new Node(road[i][0], road[i][2], adjList[road[i][1]]);
        }
        
        dist = new int[N+1];
        visited = new boolean[N+1];
        
        for(int i=1; i<=N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        
        dijkstra(1);
        
        for(int i=1; i<=N; i++) {
            if(dist[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
    
    // pq를 이용
    static public void dijkstra(int start) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        dist[start] = 0;
        pq.offer(new int[]{start, 0});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curV = cur[0];
            
            if(visited[curV]) continue;
            
            visited[curV] = true;
            
            for(Node temp = adjList[curV]; temp != null; temp = temp.next) {
                if(dist[temp.vertex] > dist[curV] + temp.weight) {
                    dist[temp.vertex] = dist[curV] + temp.weight;
                    pq.offer(new int[]{temp.vertex, dist[temp.vertex]});
                }
            }
        }
        
        
    }
}