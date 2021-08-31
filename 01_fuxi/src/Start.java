
public class Start {
	public static void main(String[] args) {
		GameFrame gameframe = new GameFrame("111");
		LevelData level = LevelManager.getNowIndex(1);
		gameframe.loadLevelData(level);
		gameframe.setVisible(true);
	}
}
