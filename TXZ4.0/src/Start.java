
public class Start {
	public static void main(String[] args) {
		GameFrame gameFrame = new GameFrame("������4.0");
		Level level = LevelManager.getNowLevel(1);
		gameFrame.loadLevelData(level);
		gameFrame.setVisible(true);
	}
}
