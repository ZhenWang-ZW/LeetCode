package LeetCode.May;

import java.util.*;

public class Week2 {

	public static void main(String[] args) {
		System.out.println(isPerfectSquare(2147483647));
		
//		int[][]line = {{1,2},{2,4},{3,4},{4,5},{5,6},{6,7}};
//		int[][]line = {{-3,-2},{-1,-2},{2,-2},{-2,-2},{0,-2}};
		int[][]line = {{0,1},{1,3},{-4,-7},{5,11}};
		System.out.println(checkStraightLine(line));
		
		int[][]image = {{0,0,0},{0,0,0}};
		System.out.println(floodFill(image,0,0,2));
		
		int[][] trust= {{1,3},{1,4},{2,3},{2,4},{4,3}};
		System.out.println(findJudge(4,trust));
		
		int[] nums= {1,1,2};
		System.out.println(singleNonDuplicate(nums));
		
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
	
	/* Flood Fill */
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0, 1}};
        List<int[]> newFlood = new ArrayList();
        int[] startPos= {sr,sc};
        newFlood.add(startPos);
        
        int orgColor = image[sr][sc];
        
        image[sr][sc] = newColor;
        
        int rsize=image.length,
        	csize=image[0].length;
        
        while(newFlood.size()>0) {
        	int[] firstPosInList = newFlood.get(0);
        	for(int i=0; i<dirs.length; i++) {
        		int nr=dirs[i][0]+firstPosInList[0],
        			nc=dirs[i][1]+firstPosInList[1];
        		if(nr>=0 && nr<rsize && nc>=0 && nc<csize && image[nr][nc]!=newColor && image[nr][nc]==orgColor) {
        			image[nr][nc]=newColor;
        			int[] newPos= {nr, nc};
        			newFlood.add(newPos);
        		}
        	}
        	newFlood.remove(0);
        }
        
		return image;
    }
	
	/* Find the Town Judge*/
	public static int findJudge(int N, int[][] trust) {
		if(trust.length==0) return N;
		if(trust.length==1) return trust[0][1];
		
		int[]trustOthers = new int[N+1];
		int[]otherTrusts = new int[N+1];
		
		for(int i=0; i<trust.length; i++) {
			trustOthers[trust[i][0]]++;
			otherTrusts[trust[i][1]]++;
		}
		
		for(int i=1; i<=N; i++) {
			if(trustOthers[i]==0 && otherTrusts[i]==N-1)
				return i;
		}
		return -1;
    }
	
	/* Single Element in a Sorted Array - O(log n) time and O(1) */
	public static int singleNonDuplicate(int[] nums) {
        if(nums.length==1) return nums[0];
		for(int i=0; i<nums.length;i+=2) {
			if(i==nums.length-1) return nums[i];
        	if(nums[i]!=nums[i+1])return nums[i];
        }
        return -1;
    }

}
