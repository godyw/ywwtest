import java.awt.Color;

public class LevelManager {
	public static LevelData GetNowIndex(int index) {
		LevelData level = new LevelData();
		if (index == 1) {
			
		level.setTitle("gshdga");
		level.setBackground(Color.GREEN);
		
		level.setBoxImgPath("box2.png");
		int[][] boxLocation = {{13,5}, {17,9}, {5,6}};
		level.setBoxLocation(boxLocation);
			
		level.setGoalImgPath("goal2.png");
		int[][] goalLocation = {{4,5}, {7,9}, {13,11}};
		level.setGoalLocation(goalLocation);	
		
		level.setWallsImgPath("wall2.png");
		int[][] wallsLocation = {{4,4}, {8,8}, {13,13}};
		level.setWallsLocation(wallsLocation);
		
		String workerImgPath = "workerRight2.png";
		level.setWorkerImgPath(workerImgPath);
		level.setWorkerLocation(new int[] {7,6});
			
			return level;
		} else {
			return null;
		}
	}
}
