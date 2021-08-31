import java.util.Random;

public class Test {
	public static void main(String[] args) {
		int[] rednums = new int[6];
		Random random = new Random();
		int a = 0;
		for (int i = 0; i < rednums.length; i++) {
			rednums[i] = random.nextInt(32) + 1;
			for (int j = a; j < i; j++) {
				if (rednums[i] == rednums[j]) {
					rednums[i] = random.nextInt(32) + 1;
					a = 0;
					break;
				 }
			}

		}
		for (int i = 0;  i < rednums.length - 1; i++) {
			for (int j = 0; j < rednums.length - i - 1; j++) {
				if (rednums[j] > rednums[j + 1]) {
					int temp = rednums[j];
					rednums[j] = rednums[j + 1];
					rednums[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < rednums.length; i++) {
			System.out.println("本期双色球红球分别是"+ i + "=" + rednums[i]);
		}
		int blueball = random.nextInt(16) + 1;
		System.out.println("本期双色球蓝球是" + blueball);
	}
}
