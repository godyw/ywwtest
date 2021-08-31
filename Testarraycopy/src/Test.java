
public class Test {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6};
		System.arraycopy(nums, 3, nums, 2, nums.length - 2 -1);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
	
}
