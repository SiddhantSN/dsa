package basics.arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class Arrays1 {
	
	public static int getConsecutiveOnes(int [] nums) {
		int cnt = 0;
    int maxi = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 1) {
            cnt++;
        } else {
            cnt = 0;
        }

        maxi = Math.max(maxi, cnt);
    }
    return maxi;
    }
	
    
	
	
	public  static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int length = 1;
        int reset = 0;
        
        if(nums.length==0) {
        	return 0;
        }
        for (int i = 0; i < nums.length-1; i++) {
			if(nums[i+1] - nums[i] == 1) {
				length++;
				reset = length;
			}
			else if (nums[i] != nums[i+1]) {
				
				length=1;
			}
		}
		return Math.max(length, reset);
    }
	
	// TLE
	public  static int longestConsecutive2(int[] nums) {
		int length = 0;
		int longest = 0;
		Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
		for (Integer integer : nums) {
			if(!set.contains(integer-1)) {
				length=0;
				while(set.contains(integer+length)) {
					length++;
				}
			}
			longest = Math.max(length, longest);
		}
		return longest;
	}
	
    public static int[] twoSum2(int[] nums, int target) {	
    	int l = 0, r = nums.length - 1;
	
	while (nums[l] + nums[r] != target) {
		if (nums[l] + nums[r] < target) l++;
		else r--;
	}

	return new int[] {l+1, r+1};}
	
	
	
	
	
	
	
	
	
	public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer integer : nums) {
			if(!set.add(integer)) {
				return true;
			}
		}
        return false;
    }
    
public boolean isAnagram(String s, String t) {
	char[] charS = s.toCharArray();
	char[] charT = t.toCharArray();
	
	Arrays.sort(charS);
	Arrays.sort(charT);
	
	for (int i = 0; i < charT.length; i++) {
		if(charT[i] != charS[i]) {
			return false;
		}
		
	}
	return true;
}
	
	public static int appearsOnce(int [] nums) {
		HashMap<Integer, Integer> count = new HashMap<>();
		Integer find = -1;
		for (int i : nums) {
			if(count.containsKey(i)) {
				count.put(i, count.get(i)+1);
			}
			else {
				count.put(i, 1);
			}
		}
		for(Integer i : count.keySet()) {
			if(count.get(i)==1) {
				find = i;
				return find;
			}
		}
		return find;
	}
	
	public static int BuySellPrice(int [] prices) {
		int buyPrice = prices[0];
		int sellMargin = 0;
		int sellPrice = 0;
		for (int i : prices) {
			if (buyPrice < i) {
				if(sellMargin< (i-buyPrice)) {
					sellPrice = i;
					sellMargin = sellPrice-buyPrice; //sellMarginCondition
				}
			}
			else {
				buyPrice = i;
			}
		}
		return sellMargin;
		
	}
	
	public static int longestSuccessiveElements(int[] a) {
        int n = a.length;
        if (n == 0)
            return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        // put all the array elements into set
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }

        // Find the longest sequence
        for (int it : set) {
            // if 'it' is a starting number
            if (!set.contains(it - 1)) {
                // find consecutive numbers
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
	}
	
	public static List<String> dnaSequences(String s) {
		HashSet<String> seen =  new HashSet<String>();
		HashSet<String> dnaSet =  new HashSet<String>();
		int windowEnd = 10;
		int windowStart = 0;
		while (windowEnd<= s.length()) {
			String dna = s.substring(windowStart,windowEnd);
			if(!seen.add(dna)) {
				dnaSet.add(dna);
			}
			windowStart = windowStart + 1;
			windowEnd = windowEnd + 1;
		}
		return dnaSet.stream().collect(Collectors.toList());
		
	}
	
	public List<String> summaryRanges(int[] nums) {
		List<String> strList = new ArrayList<>();
		int start = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == nums[i-1]+1) {
				if(start == nums[i-1]+1) {
					
				}
			}
		}
		return strList;
	}
	
	public static int binarySearch(int[] nums,int target) {
		int start = 0;
		int end = nums.length-1;
		
		while(start<=end) {
			int mid = start +(end-start)/2;
			if(target == nums[mid]) {
				return mid;
			}
			if(target>nums[mid]) {
				start = mid+1;
			}
			if(target<nums[mid]) {
				end = mid-1;
			}
		}
		return -1;
		
	}
	
	public static boolean isPalindrome(String str) {
		 str = str.replaceAll(" ", "").replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		int left = 0;
		int right = str.length()-1;
		while(left<right) {
			if(str.charAt(left)!=str.charAt(right)) {
				return false;
			}
			left++;
			right--;
			}
		return true;
		}
	
    public List<List<String>> groupAnagrams(String[] strs) {
    	Map<String, List<String>> map = new HashMap<>();
         for (String string : strs) {
			char[] strChars = string.toCharArray();
			Arrays.sort(strChars);
			String str = new String(strChars);
			
			if(!map.containsKey(str)) {
				map.put(str, new ArrayList<>());
			}
			map.get(str).add(string);
		}
		return new ArrayList<>(map.values());
    }
    
    public static int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> track = new HashMap<>();
       for (int i : nums) {
		if(!track.containsKey(i)) {
			track.put(i,1);
		}
		else {
			track.put(i, track.get(i)+1);
		}
	}
       track = track.entrySet()
    		    .stream()
    		    .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
    		    .collect(Collectors.toMap(
    		        Map.Entry::getKey,
    		        Map.Entry::getValue,
    		        (e1, e2) -> e1,
    		        LinkedHashMap::new
    		    ));
       List<Integer> ansList = new ArrayList<>();
       
    	   for (Integer i : track.keySet()) {
    			   ansList.add(i);
    			   if(ansList.size()>=k) {
    				   break;
    			   }
    		   
		}
       
       int[] array = new int[ansList.size()];
       for(int i = 0; i < ansList.size(); i++) array[i] = ansList.get(i);
	return array;
       
    }
    
public int[] twoSum(int[] nums, int target) {
	int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
        	for (int j = 0; j < nums.length; j++) {
				if(nums[i]+nums[j] == target && i != j) {
					result[0] = i;
					result[1] = i;
				}
				
			}
			
		}
		return result;
    }
    
    public static int[] productExceptSelf(int[] nums) {
    	List<Integer> list = new ArrayList<>();
    	List<Integer> ans = new ArrayList<>();
    	for (Integer integer : nums) {
			list.add(integer);
		}
    	for (Integer integer : nums) {
			List<Integer> temp = new ArrayList<>();
			for (Integer integer2 : nums) {
				temp.add(integer2);
			}
			temp.remove(integer);
			ans.add(temp.stream().reduce((x,y)->x*y).get());
		}
    	int[] array = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) array[i] = ans.get(i);
		return array;
    }
	
	public static boolean jumpGame(int [] nums) {
		int reachable = 0;
	       for(int i = 0; i < nums.length; i ++) {
	           if(i > reachable) return false;
	           reachable = Math.max(reachable, i + nums[i]);
	       } 
	       return true;
		}
	}
	
