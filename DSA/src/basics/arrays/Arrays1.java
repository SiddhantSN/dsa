package basics.arrays;

public class Arrays1 {
	
	public static int getConsecutiveOnes(int [] arr) {
		int n = 0;
		int v = 0;
		for (int i : arr) {
			if(i==1) {
				n++;
			}
			else {
				if(v<n) {
					v=n;
					n=0;
				}
			}
		}
		return v;
	}
}
