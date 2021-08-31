package 文字游戏2;


import java.util.Random;

public class Test {
	public static void main(String[] args) {
		String str = "床前明月光，疑是地上霜，举头望明月，低头思故乡";
		String[] gushi = str.split(",");
		char[] zifu = new char[4];
		String[] answer = new String[4];
		Random random = new Random();
		for (int i = 0; i < gushi.length; i++) {
			int index = random.nextInt(gushi[i].length());
			zifu[i] = gushi[i].charAt(index);
			System.out.println(gushi[i].replace(zifu[i], '?') + ":" + zifu[i]);
		}
		int trueans = random.nextInt(4);
		answer[trueans] = zifu[0] + ", " + zifu[1] + ", " + zifu[2] + ", " + zifu[3];
		for (int i = 0; i < answer.length; i++) {
			if (i == trueans) continue;
			String temp = makeAn(zifu);
			boolean isExists = false;
			for (int j = 0; j < answer.length; j++) {
				if (temp.equals(answer[j])) {
					i--;
					isExists = true;
					break;
				}
			}
			if (!isExists) {
				answer[i] = temp;
			}
		}
		for (int i = 0; i < answer.length; i++) {
			System.out.println(i + ":" + answer[i]);
		}
	}
	static String makeAn(char[] zifu) {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int a = random.nextInt(4);
			int b = random.nextInt(4);
			char temp = zifu[a];
			zifu[a] = zifu[b];
			zifu[b] = temp;
		}
		String anstr = zifu[0] + ", " + zifu[1] + ", " + zifu[2] + ", " + zifu[3];
		return anstr;
	}
}

