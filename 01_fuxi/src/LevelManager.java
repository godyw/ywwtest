import java.awt.Color;

public class LevelManager {
	public static LevelData getNowIndex(int index) {
		LevelData level = new LevelData();
		if (index == 1) {
			level.setTitle("ÍËÂ¬ÒÆËÍ");
			level.setBackground(Color.GRAY);
			
			String workerImagePath = "workerRight2.png";
			level.setWorkerImgPath(workerImagePath);
			level.setWorkerLocation(new int[] {6,9});
			
			level.setBoxsImgPath("box2.png");
			int[][] boxLocations = {{22,10}, {17,13}, {25,9}};
			level.setBoxsLocation(boxLocations);
			
			level.setGoalsImgPath("goal2.png");
			int[][] goalLocations = {{11,10}, {13,11}, {15,13}};
			level.setGoalsLocation(goalLocations);
			
			level.setWallsImgPath("wall2.png");
			int[][] wallsLocations = {{9,9}, {20,7}, {28,5}};
			level.setWallsLocation(wallsLocations);
			
			return level;
		} else {
			return null;
		}
		
	}
}
