/*
Program to implement k means clustering algorithm
*/
import java.util.Scanner;

public class Clustering {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // to get input from user
		int sampleSize = 0, k = 0;
		int[][] coordinates;
		double[][] centroid;
		System.out.println("****************** K MEANS CLUSTERING***************");
		System.out.println("Enter number of coordinates:");
		sampleSize = input.nextInt();// stores total number of coordinates
		System.out.println("Enter number of clusters(k values):");
		k = input.nextInt();// stores number of clusters
		coordinates = new int[sampleSize][2];
		centroid = new double[k][2];
		System.out.println("Enter coordinates");
		for (int i = 0; i < sampleSize; i++) {
			for (int j = 0; j < 2; j++) {
				coordinates[i][j] = input.nextInt();
			} // end j for
		} // end i for
		System.out.println("Sample Entered:");
		for (int i = 0; i < sampleSize; i++) {
			System.out.print("(");
			for (int j = 0; j < 2; j++) {
				System.out.print(coordinates[i][j]);
				if (j == 0)
					System.out.print(",");
			}
			System.out.println(")");
		}
		// initial cluster points
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < 2; j++) {
				centroid[i][j] = coordinates[i][j];
			} // end j for

		} // end i for
		double[] clusterList = new double[sampleSize];
		clusterList = distance(coordinates, centroid);
	}

	static double[] distance(int[][] points, double[][] centroid) {
		double clusterList[] = new double[points.length];
		double clusterCopy[] = new double[points.length];
		double temDistance[] = new double[centroid.length];
		int flag = 0;
		int tempCount[] = new int[centroid.length];
		// copy clusterList
		for (int j = 0; j < points.length; j++) {
			clusterCopy[j] = 0;
		} // end for copy
		while (flag == 0) {
			int i = 0, k = 0;
			for (int j = 0; j < tempCount.length; j++) {
				tempCount[j] = 0;
			}
			// copy clusterList
			for (int j = 0; j < points.length; j++) {
				clusterCopy[j] = clusterList[j];
			} // end for copy
			while (i != points.length) {// while i
				k = 0;
				while (k != centroid.length) {// while k
					temDistance[k] = difference(centroid[k][0], centroid[k][1], points[i][0], points[i][1]);
					k++;
				} // end while k
				double cluster = temDistance[0];
				k = 0;
				Double minNum = Double.MAX_VALUE;
				double it = 0;
				int minIndex = 0;
				for (int j = 0; j < temDistance.length; j++) {
					it = temDistance[j];
					if ((it < minNum) && (it != 0)) {
						minNum = it;
						minIndex = j;
					}
				}
				clusterList[i] = minIndex;
				i++;
			} // end while i
				// copy clusterList
			for (i = 0; i < points.length; i++) {

				if (clusterCopy[i] != clusterList[i]) {
					flag = 0;
					break;
				} else
					flag = 1;
			} // end for copy
				// calculate new centroid positions
			for (int row = 0; row < centroid.length; row++) {
				for (int col = 0; col < 2; col++) {
					centroid[row][col] = 0;
				}
			}
			while (k != centroid.length) {
				for (int j = 0; j < clusterCopy.length; j++) {
					if (clusterList[j] == k) {
						centroid[k][0] += points[j][0];
						centroid[k][1] += points[j][1];
					}
				}
				k++;
			}
			k = 0;
			while (k != centroid.length) {
				int count = 0;
				for (int j = 0; j < points.length; j++) {
					if (clusterList[j] == k)
						count++;
				}
				tempCount[k] = count;
				k++;
			}
			for (int row = 0; row < centroid.length; row++) {
				for (int col = 0; col < 2; col++) {
					centroid[row][col] = (centroid[row][col]) / tempCount[row];
				}
			}
			// end calculate new centroid positions
		} // while flag
		System.out.println("*******************Final Centroid Positions*******************");
		for (int row = 0; row < centroid.length; row++) {
			System.out.print("Cluster-"+(row+1)+"centroid: (");
			for (int col = 0; col < 2; col++) {
				System.out.print(centroid[row][col]);
				if (col == 0)
					System.out.print(",");
			}
			System.out.println(")");
			
		}
		
		int k=0;
		while(k!=centroid.length){
			System.out.print("Cluster-"+(k+1)+"points:");
			System.out.println();
			for (int i = 0; i < clusterList.length; i++) {
				if(clusterList[i]==k)				
							System.out.println("("+points[i][0]+","+points[i][1]+")");
			}
			k++;
			}
		return clusterList;

	}

	static double difference(double x2, double y2, double x1, double y1) {
		double diff = 0;
		diff = Math.abs(x2 - x1) + Math.abs(y2 - y1);
		return diff;
	}

}
