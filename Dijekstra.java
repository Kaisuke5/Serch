import java.util.*;
public class Dijekstra {
	static int n=6;
	static ArrayList <Integer> Path=new ArrayList <Integer> ();
	static int [][] w=new int [n][n]; //root weight 
	static int start=0;
	static int[] d=new int[n];        //all distance of start to i
	static int visit[]=new int[n];    //if node has a minimum access
	
	
	
	
	
	//Efficiency type
	public static void Dk(){
		Queue <Integer>q=new LinkedList<Integer>();
		int c=1;
		q.add(start);
		d[0]=0;              //this is important 
		
		
		while(!q.isEmpty()){
			int p=q.poll();
			visit[p]=c++;         //p has a minimum root
			if(allVisited()) break;
			int min=0,mind=Integer.MAX_VALUE;
			
			
			for(int i=0;i<w[p].length;i++){
				
				if(visit[i]>0) continue;
				if(d[i]>w[p][i]+d[p]&&w[p][i]!=Integer.MAX_VALUE){
					d[i]=w[p][i]+d[p];
					
				}
				if(mind>d[i]){
					min=i;
					mind=d[i];
				}
				
			}
			q.add(min);
		}
		
	}
	
	
	
	//Light type
	/*このアルゴリズムは全経路の最短距離を求める
	 *なおかつ大きいノードから小さいノードにいくことはない
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	public static void dk(){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				for(int k=0;k<n;k++){
					System.out.printf("(%d,%d):%d (%d,%d):%d + (%d,%d):%d\n",i,j,w[i][j],i,k,w[i][k],k,j,w[k][j]);
					if(w[i][k]==Integer.MAX_VALUE||w[k][j]==Integer.MAX_VALUE) continue;
					if(w[i][j]>w[i][k]+w[k][j]){
						w[i][j]=w[i][k]+w[k][j];
						System.out.println("move!");
					}
					
				}
			}
		}
	}
	
	
	
	public static boolean allVisited(){
		for(int i=0;i<n;i++){
			if(visit[i]==0)return false;
		}
		return true;
	}
	
	public static void main(String args[]){
		
		for(int i=0;i<n;i++)Arrays.fill(w[i],Integer.MAX_VALUE);
		Arrays.fill(d,Integer.MAX_VALUE);
		w[0][1]=15;
		w[0][2]=1;
		w[2][3]=5;
		w[2][4]=1;
		w[4][5]=1;
		w[5][3]=1;
		Dk();
		for(int i=0;i<n;i++) System.out.printf("start to %d: %d\n",i,w[start][i]);
		for(int i=0;i<n;i++) System.out.printf("start to %d: %d\n",i,d[i]);
	}
	
}

