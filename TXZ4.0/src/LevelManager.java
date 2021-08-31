
public class LevelManager {
	public static Level getNowLevel(int index) {
		Level level = new Level();
		if(index == 1) {
			level.setBoxImgPath("box2.png");
			int[][] boxlocations = {{12,8},{13,9}};
			level.setBoxLocations(boxlocations);
			level.setGoalImagPath("goal2.png");
			int[][] goalLocations = {{ 15, 10 }, { 15, 11 }};
			level.setGoalLocations(goalLocations);
			
			level.setWorkerLocation(new int[] {14, 10});
			String[] workerImgPaths = { "workerLeft2.png", "workerUp2.png", "workerRight2.png", "workerDown2.png"}; 
			level.setWorkerImgPaths(workerImgPaths);
			
			level.setWallImgPath("wall2.png");
			int[][] wallsLocations = {{10,5}, {11,5}, {12,5}, {13,5}, {14,5}, {10,6}, {10,7}, {10,8}, {10,9}, {11,9}, {11,10}, 
					{12,10}, {12,11}, {12,12}, {13,12}, {14,12}, {15,12}, {16,12},{17,12}, 
					{18,12}, {18,11}, {18,10}, {18,9}, {17,9}, {16,9}, {15,9}, {15,8}, {15,7}, {14,6}};
			level.setWallsLocations(wallsLocations);
			return level; 
		} else if(index == 2){
			level.setBoxImgPath("box.png");
			int[][] boxLocations =  {{12,10}, {13,8}, {13,7}, {14,7}};
			level.setBoxLocations(boxLocations);
			
			level.setGoalImagPath("goal.png");
			int[][] goalLocations = {{12,8}, {11,8}, {11,7}, {10,7}};
			level.setGoalLocations(goalLocations);
			
			level.setWorkerLocation(new int[] {11, 9});
			String[] workerImgPaths = { 
					"workerLeft.png", 
					"workerUp.png", 
					"workerRight.png", 
					"workerDown.png"}; 
			level.setWorkerImgPaths(workerImgPaths);
			
			level.setWallImgPath("wall.png");
			int[][] wallsLocations = {{9,6}, {10,6}, {11,6}, {12,6}, {12,5}, {13,5}, {14,5}, {15,5}, {16,5}, {17,5}, {17,6}, 
					{17,7}, {17,8}, {17,9}, {18,8}, {19,8}, {20,8}, {21,8}, {21,9}, {21,10}, {21,11}, {21,12}, {20,12}, {19,12}, 
					{18,12}, {18,11}, {17,11}, {16,11}, {15,11}, {14,11}, {13,11}, {12,11}, {12,12}, {11,12}, {10,12}, 
					{9,12}, {9,11}, {9,10}, {9,9}, {9,8}, {9,7}, {12,7}, {12,9}, {14,9}	};
			level.setWallsLocations(wallsLocations);
			return level;
		} else {
			return null;
		}
	}
}
