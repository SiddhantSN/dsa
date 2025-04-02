package basics.arrays;

import java.util.HashMap;

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
}
