package LeetCode.May;

import java.util.*;

public class Week2 {

	public static void main(String[] args) {
		System.out.println(isPerfectSquare(2147483647));
		
//		int[][]line = {{1,2},{2,4},{3,4},{4,5},{5,6},{6,7}};
//		int[][]line = {{-3,-2},{-1,-2},{2,-2},{-2,-2},{0,-2}};
		int[][]line = {{0,1},{1,3},{-4,-7},{5,11}};
		System.out.println(checkStraightLine(line));
	}
	
	public static boolean isPerfectSquare(int num) {
		int left = 1, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2; // to avoid overflow incase (left+right)>2147483647
            int res = num / mid, remain = num % mid;
            if (res == mid && remain == 0) return true; // check if mid * mid == num
            if (res > mid) { // mid is small -> go right to increase mid
                left = mid + 1;
            } else {
                right = mid - 1; // mid is large -> to left to decrease mid
            }
        }
        return false;
    }
	
	public static boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length<=2) return true;
    	int a1 = coordinates[0][0], b1=coordinates[0][1];
    	int a2 = coordinates[1][0], b2=coordinates[1][1];
    	
    	for(int i=2; i<coordinates.length; i++) {
    		int[] curr = coordinates[i];
    		int a3 = curr[0];
    		int b3 = curr[1];
    		if((b2 - b1)*(a3 - a1) != (a2 - a1)*(b3 - b1)) return false;
        }
        return true;
    }

}
