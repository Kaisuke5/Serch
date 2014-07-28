import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Dfs {
	static int n=5;
	
	
	//dfs
	static int[][] d=new int [n][n];    //weight (s,t)   if you have no path MAXLENGTH
	static int[][] visit=new int[n][2];     //visit 0:first time 1:end time
	static ArrayList paths=new ArrayList();
	static ArrayList <Integer> path=new ArrayList<Integer>();
	static int st=0,et=0;
	///bfs
	static int[][] map=new int[n][n];  //minimum path count
	
	
	
	public static void main(String args[]){
		
		for(int i=0;i<n;i++) Arrays.fill(d[i], Integer.MAX_VALUE);
		d[0][1]=3;
		d[0][2]=2;
		d[2][3]=4;
		d[1][4]=5;

		
		dfs(0,4);
		for(int i=0;i<n;i++)System.out.printf("%d: start %d end %d\n",i,visit[i][0],visit[i][1]);
	}
	
	
	
	
	
	public static void dfs(int s,int e){           //recursion
		path.add(s);
		visit[s][0]=st++;
		
		for(int i=0;i<d[s].length;i++){
			if(s==e){
				//System.out.println(path);
				//paths.add(path);
				visit[s][0]=st++;
				visit[s][1]=et++;
				return;
			}
			if(d[s][i]!=Integer.MAX_VALUE&&visit[i][0]==0){ //if s has a node and not visited
				
				//System.out.println(path);
				dfs(i,e);
			}
		}
		visit[s][1]=et++;           //when all nodes of s is searched 
		path.remove(path.size()-1);
		
	}
	
	
	
	public static void dfs2(int s,int e){
		Stack <Integer>stk=new Stack<Integer>();
		
		ArrayList <Integer> path=new ArrayList<Integer>();
		
		path.add(s);
		//System.out.println(path);
		stk.add(s);
		while(!stk.isEmpty()){
			int p=stk.pop();
			if(p==e){
				//System.out.println(path);
				return;
			}
			
			
			for(int i=0;i<d[p].length;i++){

				if(d[p][i]!=Integer.MAX_VALUE&&visit[p][0]==0){
					path.add(i);
					stk.add(i);
					visit[p][0]=st++;
					//System.out.println(path);
				}
			}
			visit[p][2]=et++;
			
			
		}
		
	}
}
