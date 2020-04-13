package leetcode973;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class FindKClosestPointsFunction {
	// Just a simple way, O(nlogK) since we are to keep the minHeap sorted
	public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][];
        
        if(points.length == 0 || points == null){
            return new int[][]{};
        }

        // a - b will get the min heap, b - a will get max heap
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
        
        for(int[] point : points){
            minHeap.add(point);
        }
        
        while(K > 0){
            result[K - 1] = minHeap.remove();
            K--;
        }
        
        
        return result;
    }
	
	 public int[][] kClosest2(int[][] points, int K) {
	        int[][] result = new int[K][2];
	        
	        if(points.length == 0 || points == null){
	            return new int[][]{};
	        }
	        
	        // Arraylist to keep track which position is closest
	        HashMap<Double, ArrayList<Integer>> map = new HashMap<>();
	        
	        PriorityQueue<Double> minHeap = new PriorityQueue<>();
	        
	        for(int i = 0; i < points.length; i++){
	            int a = points[i][0] * points[i][0];
	            int b = points[i][1] * points[i][1];
	            
	            // The formula for the equation given
	            double sum = Math.sqrt(a + b);
	            
	            if(map.get(sum) == null){
	                map.put(sum, new ArrayList<>());
	            }
	            
	            // Add point index to the arraylist
	            map.get(sum).add(i);
	            
	            minHeap.add(sum);
	        }
	        
	        while(K > 0){
	        	// This will get the smallest value in the min heap
	            double current = minHeap.remove();
	            
	            int size = map.get(current).size();
	            
	            for(int j = 0; j < size; j++){
	                result[K - 1] = points[map.get(current).get(j)];
	                K--;
	            }
	        }

	        return result;
	    }
}
