package basics.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
	
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
			if(!set.add(nums[i])) {
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
        if(charS.length != charT.length) {
        	return false;
        }
        for(int i=0;i<charS.length;i++) {
        	if(charS[i]!=charT[i]) {
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
	
	public static int binarySearch(int[] arr,int x) {
		int low = 0;
	
    int high = arr.length - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (arr[mid] == x) 
            return mid; // x found at index mid
        if (arr[mid] < x)
            low = mid + 1;
        else
            high = mid - 1;
    }

    return -1; // x not found}
	}
	
	public static boolean isPalindrome(String str) {
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
	
	
	public static boolean jumpGame(int [] nums) {
		int reachable = 0;
	       for(int i = 0; i < nums.length; i ++) {
	           if(i > reachable) return false;
	           reachable = Math.max(reachable, i + nums[i]);
	       } 
	       return true;
		}
	}
	
