package LeetCode.May;

import java.util.*;

public class Week1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findComplement(20));
		String a = "asda";
		System.out.println(a.replaceFirst("a", ""));
		System.out.println(lengthOfLongestSubstring("aab"));
		
		System.out.println(firstUniqChar("loveleetcode"));
	}
	
	
	/* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */
	public static int firstBadVersion(int n, int badPos) {
		int left=1;
        int right=n;
        while(left<right){
            int mid= left+(right-left)/2;
//            if(isBadVersion(mid)){ //if mid is false;
//                right = mid; // right point to mid as it may not be the first bad pos
//            }
//            else{
//                left=mid+1;
//            }
        }
        return left;
    }
	
	public static int findComplement(int num) {
        int compInt = 0, decVal=1;
        for(int i=0; i<getBinLength(num); i++){
        	compInt=compInt+decVal;
        	decVal*=2;
        }
        return compInt-num;
    }
	public static int getBinLength(int n){
        List<Integer> l = new ArrayList();
        while (n>0){
            l.add(n%2);
            n=n/2;
        }
        return l.size();
    }
	
	public static boolean canConstruct(String ransomNote, String magazine) {
		int[] cntChar = new int[26];
        for(int i=0; i<magazine.length();i++){
        	cntChar[magazine.charAt(i)-'a']++;
        }
        
		for(int i=0; i<ransomNote.length();i++){
            if(cntChar[ransomNote.charAt(i)-'a']<=0) return false;
            else cntChar[ransomNote.charAt(i)-'a']--;
        }
        return true;
    }
	
	public static int lengthOfLongestSubstring(String s) {
		if(s.length()==1) return 1;
        if(s.length()==0) return 0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int max=0;
        char[] charArray = s.toCharArray();
        for(int i=0; i<charArray.length; i++) {
        	if(map.isEmpty()) map.put(charArray[i], i);
        	else {
        		if(map.containsKey(charArray[i])) {
        			max = Math.max(max, map.size());
        			i=map.get(charArray[i]);
        			map = new HashMap<Character,Integer>();
        		}else {
        			map.put(charArray[i], i);
        		}
        	}
        }
        return Math.max(max, map.size());
    }
	
	public static int firstUniqChar(String s) {
        HashMap<Character, Integer> hm = new HashMap();
        for(int i=0; i<s.length(); i++) {
        	char ch = s.charAt(i);
        	if(hm.containsKey(ch)){
        		int nVal = hm.get(ch)+1;
        		hm.put(ch, nVal);
        	}else
        		hm.put(ch, 1);
        }
        for(int i=0; i<s.length(); i++) {
        	char ch = s.charAt(i);
        	if(hm.get(ch)==1){
        		return i;
        	}
        }
		return -1;
    }
	
	public int majorityElement(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//        int size = nums.length;
//        for(int i=0;i<size;i++){
//            if(!map.containsKey(nums[i]))
//            	map.put(nums[i], 1);
//            else {
//            	int a = map.get(nums[i]);
//            	map.put(nums[i], a++);
//            }
//        }
//        double mVal = size/2;
//        for()
        return 0;
    }
	

}
