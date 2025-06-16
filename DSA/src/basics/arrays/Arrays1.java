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
import java.util.stream.IntStream;

public class Arrays1 {

	public static int getConsecutiveOnes(int[] nums) {
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
	
    public int numJewelsInStones(String jewels, String stones) {
    	HashMap<Character, Integer> stonesMap = new HashMap<>();
        for (Character stone: stones.toCharArray()) {
			stonesMap.put(stone, stonesMap.getOrDefault(stone, 0)+1);
		}
        int result = 0;
        for (Character jewel : jewels.toCharArray()) {
			result += stonesMap.getOrDefault(jewel,0);
		}
		return result;
    }
    
    public int[] twoSum3(int[] nums, int target) {
    	HashMap<Integer, Integer> map = new HashMap<>();
    	
    	for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(target-nums[i])) {
				return new int[] {map.get(target-nums[i]),i};
			}
			map.put(nums[i], i);
		}
		return new int [] {};
    	
    }
    public static int findMissingNumber(int [] arr, int n) {
    	int sumOfN = n*(n+1)/2;
    	int CS = 0;
    	for (int i : arr) {
			CS += i;
		}
    	return sumOfN-CS;
    }
	
public static HashMap<Character, Integer> countChars(String str){
	char[] charArray = str.toCharArray();
	HashMap<Character, Integer> map = new HashMap<>();
	for (char c : charArray) {
		 map.put(c,map.getOrDefault(c, 0)+1);
	}
	return map;
}

	public static int maxProfit(int[] prices) {
		int left = 0;
		int right = 1;
		int profit = Integer.MIN_VALUE;

		while (right < prices.length) {
			if (prices[left] > prices[right]) {
				left = right;
				right++;
			} else {
				profit = Math.max(profit, prices[right] - prices[left]);
				right++;
			}
		}
		return profit;

	}

	public static int lengthOfLongestSubstring(String s) {
		int left = 0;
		HashSet<Character> set = new HashSet<>();
		int res = 0;

		for (int right = 0; right < s.toCharArray().length; right++) {
			while (set.contains(s.charAt(right))) {
				set.remove(s.charAt(left));
				left++;
			}
			set.add(s.charAt(right));
			res = Math.max(res, right - left + 1);
		}
		return res;

	}

	public static int characterReplacement(String s, int k) {
		int left = 0;
		int maxLength = 0;
		int repl = 0;
		HashSet<Character> set = new HashSet<>();
		for (int right = 1; right < s.toCharArray().length; right++) {
			while (repl <= k) {
				while (!set.contains(s.charAt(right))) {
					repl++;
				}
				set.add(s.charAt(right));
				maxLength = Math.max(maxLength, set.size());
			}
		}
		return maxLength;
	}

	public static int search(int[] nums, int target) {

		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (target == nums[mid]) {
				return mid;
			}
			if (nums[start] <= nums[mid]) {
				if (target < nums[start] || target > nums[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else {
				if (target < nums[mid] || target > nums[end]) {
					end = mid - 1;
				} else {
					start = mid + 1;
					;
				}
			}
		}
		return -1;

	}

	public static boolean checkInclusion(String s1, String s2) {
		int left = 0;
		boolean result = false;
		int counter = 0;
		HashMap<Character, Integer> s1Map = new HashMap<>();
		HashMap<Character, Integer> s2Map = new HashMap<>();
		for (char str1 : s1.toCharArray()) {
			if (s1Map.get(str1) != null) {
				s1Map.put(str1, s1Map.get(str1) + 1);
			} else {
				s1Map.put(str1, 1);
			}
		}

		for (int right = 1; right < s2.length(); right++) {
			while (right - left == s1.length()) {
				String s3 = s2.substring(left, right);
				for (char str1 : s3.toCharArray()) {
					if (s2Map.get(str1) != null) {
						s2Map.put(str1, s2Map.get(str1) + 1);
					} else {
						s2Map.put(str1, 1);
					}
				}

				for (Character char1 : s1Map.keySet()) {
					if (s2Map.get(char1) != null) {
						counter++;
					}
				}

				if (counter == s1.length()) {
					return true;
				} else {
					left++;
				}
			}
		}
		return result;

	}

	public static int longestConsecutive(int[] nums) {
		Arrays.sort(nums);
		int length = 1;
		int reset = 0;

		if (nums.length == 0) {
			return 0;
		}
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i + 1] - nums[i] == 1) {
				length++;
				reset = length;
			} else if (nums[i] != nums[i + 1]) {

				length = 1;
			}
		}
		return Math.max(length, reset);
	}

	// TLE
	public static int longestConsecutive2(int[] nums) {
		int length = 0;
		int longest = 0;
		Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
		for (Integer integer : nums) {
			if (!set.contains(integer - 1)) {
				length = 0;
				while (set.contains(integer + length)) {
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
			if (nums[l] + nums[r] < target)
				l++;
			else
				r--;
		}

		return new int[] { l + 1, r + 1 };
	}

	public static boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (Integer integer : nums) {
			if (!set.add(integer)) {
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
			if (charT[i] != charS[i]) {
				return false;
			}

		}
		return true;
	}
	
    public static int  characterReplacement1(String s, int k) {
        HashMap<Character, Integer> map  = new HashMap<>();
    	int l= 0;
    	int res = 0;
        for (int r = 0; r < s.length(); r++) {
			map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1);
			
			while((r-l+1)-Collections.max(map.values())>k){
				map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0)-1);
				l++;
			}
			res = Math.max(res, r-l+1);
		}
		return res;
    	
    }

	public static int appearsOnce(int[] nums) {
		HashMap<Integer, Integer> count = new HashMap<>();
		Integer find = -1;
		for (int i : nums) {
			if (count.containsKey(i)) {
				count.put(i, count.get(i) + 1);
			} else {
				count.put(i, 1);
			}
		}
		for (Integer i : count.keySet()) {
			if (count.get(i) == 1) {
				find = i;
				return find;
			}
		}
		return find;
	}

	public static int BuySellPrice(int[] prices) {
		int buyPrice = prices[0];
		int sellMargin = 0;
		int sellPrice = 0;
		for (int i : prices) {
			if (buyPrice < i) {
				if (sellMargin < (i - buyPrice)) {
					sellPrice = i;
					sellMargin = sellPrice - buyPrice; // sellMarginCondition
				}
			} else {
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
		HashSet<String> seen = new HashSet<String>();
		HashSet<String> dnaSet = new HashSet<String>();
		int windowEnd = 10;
		int windowStart = 0;
		while (windowEnd <= s.length()) {
			String dna = s.substring(windowStart, windowEnd);
			if (!seen.add(dna)) {
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
			if (nums[i] == nums[i - 1] + 1) {
				if (start == nums[i - 1] + 1) {

				}
			}
		}
		return strList;
	}

	public static int binarySearch(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (target > nums[mid]) {
				start = mid + 1;
			} else if (target < nums[mid]) {
				end = mid - 1;
			}
		}
		return -1;
	}

	public static int timeToEat(int[] piles, int speed) {
		int totalTime = 0;
		for (int i : piles) {
			int eatPerDay = (int) Math.ceil(i / speed);
			totalTime += eatPerDay;
		}
		return totalTime;
	}

	public static int minEatingSpeed(int[] piles, int h) {
		Arrays.sort(piles);
		int start = piles[0];
		int end = piles[piles.length - 1];
		int[] array = IntStream.range(start, end).toArray();

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (Arrays1.timeToEat(piles, array[mid]) == h) {
				return mid;
			}
			else if(Arrays1.timeToEat(piles, array[mid])>h) {
				start = mid +1;
			}
			else if(Arrays1.timeToEat(piles, array[mid])<h) {
				end = mid-1;
			}
		}
		return -1;
	}

	public static boolean isPalindrome(String str) {
		str = str.replaceAll(" ", "").replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		int left = 0;
		int right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		for (int i = 0; i < matrix.length; i++) {
			int[] js = matrix[i];
			if (target > js[js.length - 1]) {
				continue;
			}
			int start = 0;
			int end = js.length - 1;

			while (start <= end) {
				int mid = start + (end - start) / 2;
				if (target == js[mid]) {
					return true;
				} else if (target > js[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return false;
	}

	public int findMin(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (!(nums[i] < nums[i + 1])) {
				return nums[i + 1];
			}

		}
		return nums[0];
	}

	public static int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int maxArea = 0;

		while (left < right) {
			int area = (right - left) * (Math.min(height[left], height[right]));
			maxArea = Math.max(maxArea, area);

			if (height[left] <= height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxArea;
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String string : strs) {
			char[] strChars = string.toCharArray();
			Arrays.sort(strChars);
			String str = new String(strChars);

			if (!map.containsKey(str)) {
				map.put(str, new ArrayList<>());
			}
			map.get(str).add(string);
		}
		return new ArrayList<>(map.values());
	}

	public static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> track = new HashMap<>();
		for (int i : nums) {
			if (!track.containsKey(i)) {
				track.put(i, 1);
			} else {
				track.put(i, track.get(i) + 1);
			}
		}
		track = track.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		List<Integer> ansList = new ArrayList<>();

		for (Integer i : track.keySet()) {
			ansList.add(i);
			if (ansList.size() >= k) {
				break;
			}

		}

		int[] array = new int[ansList.size()];
		for (int i = 0; i < ansList.size(); i++)
			array[i] = ansList.get(i);
		return array;

	}

	public int[] twoSum1(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[i] + nums[j] == target && i != j) {
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
			ans.add(temp.stream().reduce((x, y) -> x * y).get());
		}
		int[] array = new int[ans.size()];
		for (int i = 0; i < ans.size(); i++)
			array[i] = ans.get(i);
		return array;
	}

	public static boolean jumpGame(int[] nums) {
		int reachable = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > reachable)
				return false;
			reachable = Math.max(reachable, i + nums[i]);
		}
		return true;
	}
}
