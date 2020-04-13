package leetcode973;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[][] points = {{3,3},{5,-1},{-2,4}};
		int K = 2;
		
		System.out.println("Points: " + Arrays.deepToString(points));
		
		System.out.println("K: " + K);
		
		FindKClosestPointsFunction solution = new FindKClosestPointsFunction();
		
		System.out.println("Solution: " + Arrays.deepToString(solution.kClosest(points, K)));
	}
}
