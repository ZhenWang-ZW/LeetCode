package LeetCode.May;

public class Problems_Set_1 {

	public static void main(String[] args) {
		
		convert("HELLOWORLDZHEN", 5);
		System.out.println(reverse(-2345));
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

}
