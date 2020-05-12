package LeetCode.May;

import java.util.HashMap;

public class Problems_Set_1 {

	public static void main(String[] args) {
		
		convert("HELLOWORLDZHEN", 5);
		System.out.println(reverse(-2345));
		System.out.println(myAtoi("  -00000000000123456.78"));	
		System.out.println(isPalindrome(123221));
		System.out.println(isMatch("missaaaps","m.s..*ps"));
		System.out.println(uniquePaths(3,3));
		System.out.println(climbStairs(2));
		
		int[][] map= new int[][] {{0,0},{1,0}};
		System.out.println(uniquePathsWithObstacles(map));
		
	}
	
	/* 6. ZigZag Conversion */
	public static String convert(String s, int numRows) {
		if(s.length()<=numRows || numRows==1)
			return s;
		
		StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString(); 
    }
	
	/* 7. Reverse Integer*/
	public static int reverse(int x) {
		int MIN = Integer.MIN_VALUE;
		int MAX = Integer.MAX_VALUE;
		int result=0;
		while(x!=0) {
			int rem = x%10;
			if(result<MIN/10 || result>MAX/10) return 0;
			else result=result*10+rem;
			x/=10;
		}
		
		return result;
    }
	/* 8. String to Integer (atoi)*/
	public static int myAtoi(String str) {
		str = str.trim();
		if("".equals(str) || " ".equals(str)) return 0;
		int a = 1;
		int ind=0;
		if(str.charAt(0)=='-') {
			a = -1;
			ind=1;
		}else if(str.charAt(0)=='+') {
			ind=1;
		}
		String s = "";
		for(int i=ind ;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch=='0' && "".equals(s)) {
				// do nothing
			}else {
				if(ch-'0'>=0 && ch-'9'<=0)
					s+=ch;
				else
					break;
			}
		}
		if(s.length()>=(Integer.MIN_VALUE+"").length())
			s=s.substring(0, (Integer.MIN_VALUE+"").length());
		try {
			long res = Long.parseLong(s)*a;
			if(res>Integer.MAX_VALUE) return Integer.MAX_VALUE;
			else if(res<Integer.MIN_VALUE) return Integer.MIN_VALUE;
			else return (int)res;
		}catch(Exception e) {
			return 0;
		}
    }
	
	/* 9. Palindrome Number*/
	public static boolean isPalindrome(int x) {
        String s = x+"";
        for(int i=0, j=s.length()-1; i<j; i++, j--) {
        	if(s.charAt(i)!=s.charAt(j))
        		return false;
        }
        return true;
    }
	/* 10. Regular Expression Matching*/
	public static boolean isMatch(String s, String p) {
//        char temp='#';
//        int j=0;
//		for(int i=0; i<s.length(); i++) {
//			char sCh = s.charAt(i);
//			char pCh = p.charAt(j);
//			if(pCh=='.' || pCh==sCh){
//				temp=sCh;
//				j++;
//			}
//			if(pCh=='*') {
//				if(sCh!=temp) return false;
//			}
//		}
        
		return true;
    }
	
	/* 62. Unique Paths*/
	public static int uniquePaths(int m, int n) {
        int[][] p=new int[m][n];
        
        if(m==1 || n==1) return 1;
        
        for(int i = 0; i<m;++i){
            p[i][0] = 1;
        }
        for(int j = 0; j<n;++j){
            p[0][j] = 1;
        }
        
        for(int i=1; i<m;i++)
        {
        	for(int j=1; j<n; j++) {
        		p[i][j]=p[i-1][j]+p[i][j-1];
        	}
        }        
        
        return p[m-1][n-1];
    }
	
	/* 63. Unique Paths II*/
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m=obstacleGrid.length,
			n=obstacleGrid[0].length;
		
		int[][] p=new int[m][n];
        
        if(m==1 && n==1) {
        	if(obstacleGrid[0][0]==1)
        		return 0;
        	else
        		return 1;
        }
        
        int val=1;
        for(int i = 0; i<m;++i){
        	if(obstacleGrid[i][0]==1)
        		val=0;
            p[i][0] = val;
        }
        val=1;
        for(int j = 0; j<n;++j){
        	if(obstacleGrid[0][j]==1)
        		val=0;
            p[0][j] = val;
        }
        
        for(int i=1; i<m;i++)
        {
        	for(int j=1; j<n; j++) {
        		if(obstacleGrid[i][j]==1)
        			p[i][j]=0;
        		else
        			p[i][j]=p[i-1][j]+p[i][j-1];
        	}
        }        
        
        return p[m-1][n-1];
    }
	
	/*70. Climbing Stairs*/
	public static int climbStairs(int n) {
        int[] nums=new int[n+1];
        nums[0]=1;
        nums[1]=1;
        
        if(n==0 || n==1) return nums[n];
        
        for(int i=2; i<=n; i++) {
        	nums[i]=nums[i-1]+nums[i-2];
        }
        return nums[n];
    }

}
