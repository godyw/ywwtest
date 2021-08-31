package com.godv;

public class Test {
	public static void main(String[] args) {
		int[] nums = {68, 12, 682, 163, 76, 21};
		int max = nums[0], min = nums[0], sum = 0, avg = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] > max) max = nums[i];
			if(nums[i] < min) min = nums[i];
			sum += nums[i];
		}
		avg = sum / nums.length;
		System.out.println("sum = " + sum);
		System.out.println("avg = " + avg);
		System.out.println("max = " + max);
		System.out.println("min = " + min);
	}
}
