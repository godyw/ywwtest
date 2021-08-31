package com.godv;

public class Test02 {
	public static void main(String[] args) {
		int[] nums = new int[] {21, 34, 2, 543, 543, 65};
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i] + " ");
		}
		for (int i = 0; i < nums.length / 2; i++) {
			int temp = nums[i];
			nums[i] = nums[nums.length - i - 1];
			nums[nums.length - i - 1] = temp;
			System.out.println(nums[i] + " ");
		}
		
		
	}
}
