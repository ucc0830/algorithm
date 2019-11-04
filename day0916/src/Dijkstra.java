//백준 최단경로 1753
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra {
    static int[] dist;
    static int nE, nV;
    static final int INF = Integer.MAX_VALUE; 
    static ArrayList<Node>[] list;
    static boolean[] visited =  null;
    static class Node implements Comparable<Node>{
    	int index;
    	int cost;
		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
		public int compareTo(Node o) {
			return cost == o.cost ? index - o.index : cost - o.cost;
		}    	
    }
    
    static void dijkstra(int start) {
    	
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
    	dist[start] = 0;
    	pq.offer(new Node(start, dist[start]));
    	Node node;

    	while(!pq.isEmpty()) {
//    		남은 정점에서 최소값 정점 찾기
    		node = pq.poll();
    		int minIndex = node.index;
    		visited[node.index] = true;
    		
//    		기존의 거리비용보다 최소값 정점을 거쳐가는 비용이 더 작으면 수정한다.
    		for(int j = 0; j < list[node.index].size(); j++) {
    			Node tempNode = list[node.index].get(j);
    			
    			if(	dist[tempNode.index] >  tempNode.cost + dist[minIndex] ) {
    				dist[tempNode.index] = tempNode.cost + dist[minIndex];
    				pq.offer(new Node(tempNode.index, dist[tempNode.index]));
    			}
    		}
    		
    	}
    	for(int i = 1 ; i < nV+1;  i++ ) {
    		 if (dist[i]!= INF) {
                 System.out.println(dist[i]);
             } else {
                 System.out.println("INF");
             }
    	}
    }
	public static void main(String[] args) throws IOException{
//		System.setIn(new FileInputStream("input.txt"));
		Scanner scan = new Scanner(System.in);
		
        nV = scan.nextInt();        
        nE = scan.nextInt(); 
        int K = scan.nextInt(); 
        dist = new int[nV+1];
        visited = new boolean[nV +1];
        Arrays.fill(dist, INF);
        list = new ArrayList[nV + 1];
        for (int i = 0; i <= nV; i++) {
            list[i] = new ArrayList<Node>();
        }
 
        for (int i = 0; i < nE; i++) {
            list[scan.nextInt()].add(new Node(scan.nextInt(), scan.nextInt()));
        }
//        for(int i = 0; i < nE; i++){
//            int t1, t2, t3;
//            t1 = scan.nextInt();	            
//            t2 = scan.nextInt();            
//            t3 = scan.nextInt();            
//            ad[t1][t2] = t3;
//        }
        dijkstra(K);
	}

}