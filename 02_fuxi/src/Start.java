
public class Start {
	public static void main(String[] args) {
		GameFrame gameframe = new GameFrame("lll");
		LevelData level = LevelManager.GetNowIndex(1);
		gameframe.LoadLevelData(level);
		gameframe.setVisible(true);
		
	}
}
