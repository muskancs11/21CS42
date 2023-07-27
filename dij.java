import java.util.Scanner;

public class dij {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cost[][]=new int[10][10];
		int visited[]=new int[10];
		int dist[]=new int[10];
		int i,j,k,sv,u=0,w=0,n,min;
		System.out.println("Enter the number of vertices: ");
		n = sc.nextInt();
		System.out.println("Enter the cost matrix: ");
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				cost[i][j]=sc.nextInt();
			}
		}
		System.out.println("Enter the source Vertex: ");
		sv = sc.nextInt();
		for(i=1;i<=n;i++)
		{
			visited[i]=0;
			dist[i]=cost[sv][i];
		}
		visited[sv]=1;
		dist[sv]=0;
		for(k=2;k<=n;k++)
		{
			min = 999;
			for(w=1;w<=n;w++)
			{
				if (visited[w]==0 && dist[w]<min)
				{
					min = dist[w];
					u=w;
				}
			}
			visited[u] = 1;
			for(w=1;w<=n;w++)
			{
				if (visited[w]==0)
				{
					if((dist[u]+cost[u][w])<dist[w])
						dist[w]=dist[u]+cost[u][w];
				}
			}
		}
		System.out.println("\n\n\t Dijkstra's Algorithm\n");
		System.out.println("\n\tSource Destination cost");
		for(i=1;i<=n;i++)
			System.out.println("\t"+sv+"\t\t"+i+"\t"+dist[i]);
	}
}
