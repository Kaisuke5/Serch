
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Bfs {
	static int n=6;
	static int[] map=new int[n];
	static int[][] d=new int[n][n];
	static Queue <Integer> q =new LinkedList<Integer>();
	
	
	public static int bfs(int start,int goal){
		q.add(start);
		map[start]=1;
		while(!q.isEmpty()){
			int p=q.poll();
			
			if(p==goal) return map[goal];
			for(int i=0;i<d[p].length;i++){
				if(d[p][i]!=Integer.MAX_VALUE&&map[i]==0){   //if (p,i) and not visited i
					System.out.println("q"+p+"i"+i);
					map[i]=map[p]+1;                         //count start to p is map[p]
					q.add(i);
				}
				
			}
		}
		return -1;
	}
	
	public static void main(String args[]){
		for(int i=0;i<n;i++) Arrays.fill(d[i], Integer.MAX_VALUE);
		d[0][1]=1;
		d[1][2]=4;
		d[2][4]=5;
		d[1][5]=2;
		d[4][3]=2;
		System.out.println(bfs(0,3));
		
		
	}
}
