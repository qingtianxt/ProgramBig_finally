package zh;

import java.util.ArrayList;
import java.util.List;


public class Folyd_text {
	private int[][] dist;
	private int[][] path;
	public List result = new ArrayList();
	int m = Integer.MAX_VALUE;
/*
	public static void main(String arg[]) {
		
		Folyd_text graph = new Folyd_text(5);
		int[][] matrix = { 
				{ 0, 3, 8, INF, 4 },
				{ INF, 0, INF, 1, 7 },
				{ INF, 4, 0, INF, INF },
				{ 2, INF, 5, 0, INF },
				{ INF, INF, INF, 6, 0 } 
				};
		int begin = 4;
		int end = 1;
		graph.findCheapestPath(begin, end, matrix);
		List list = graph.result;
		System.out.println("The shortest path " + begin + " -> " + end + " is: ");
		System.out.println(list.toString());
		System.out.println();
		System.out.println("The length of shortest path is " + graph.dist[begin][end]);
	}
*/
	public void findCheapestPath(int begin, int end, int[][] matrix) {
		Floyd(matrix);
		result.add(begin);
		findPath(begin, end);
		result.add(end);
	}

	public void findPath(int i, int j) {
		int k = path[i][j];
		if (k == -1)
			return;
		findPath(i, k);
		result.add(k);
		findPath(k, j);
	}

	public void Floyd(int[][] matrix) {
		int size = matrix.length;
		for (int i = 0; i < size; i++) 
		{
			for (int j = 0; j < size; j++) 
			{
				path[i][j] = -1;
				dist[i][j] = matrix[i][j];
			}
		}
		for (int k = 0; k < size; k++) 
		{
			for (int i = 0; i < size; i++) 
			{
				for (int j = 0; j < size; j++) 
				{
					if (dist[i][k] != m && dist[k][j] != m
							&& dist[i][k] + dist[k][j] < dist[i][j]) 
					{
						dist[i][j] = dist[i][k] + dist[k][j];
						path[i][j] = k;
					}
				}
			}
		}
		/*System.out.println("The Matrix:");
		for(int i = 0; i < size; i++)
		{
			System.out.println();
			for(int j = 0; j < size; j++)
			{
				System.out.print(dist[i][j] + " ");
			}
		}
		System.out.println("\n");
		*/
	}
	public Folyd_text(int size)
	{
		this.path = new int[size][size];
		this.dist = new int[size][size];
	}
}
