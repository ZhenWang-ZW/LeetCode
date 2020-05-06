package LeetCode.May;

import java.util.HashMap;

public class Problems_Set_1 {

	public static void main(String[] args) {
		
		convert("HELLOWORLDZHEN", 5);
		System.out.println(reverse(-2345));
		System.out.println(myAtoi("  -00000000000123456.78"));	
		System.out.println(isPalindrome(123221));
		System.out.println(isMatch("missaaaps","m.s..*ps"));
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
//        
        
		return true;
    }

}
