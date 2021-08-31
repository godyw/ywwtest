package com.godv;


public class LevelManager {
	public static Level getNowLevel(int index) {
		Level level = new Level();
		if(index == 1) {
			level.setBoxImgPath("box2.png");
			level.setBoxlocation(new int[] {3,4});
			
			level.setGoalImgPath("goal2.png");
			level.setGoalLocation(new int[] {13,2});
			
			level.setWorkerLocation(new int[] {8,9});
			String[] WorkerImgPaths = {"workerDown2.png", 
					"workerLeft2.png", "workerRight2.png",
					"workerUp2.png"};
			
			level.setWorkerImgPaths(WorkerImgPaths);
			
			level.setWallImgPath("wall2.png");
			int[][] wallsLocations = {
					{4,7},
					{8,3},
					{5,9}
					
			};
			level.setWallsLocations(wallsLocations);
			return level;
		} else if (index == 2) {
			level.setBoxImgPath("box2.png");
			level.setBoxlocation(new int[] {3,4});
			
			level.setGoalImgPath("goal2.png");
			level.setGoalLocation(new int[] {13,2});
			
			level.setWorkerLocation(new int[] {8,9});
			String[] WorkerImgPaths = {"workerDown2.png", 
					"workerLeft2.png", "workerRight2.png",
					"workerUp2.png"};
			
			level.setWorkerImgPaths(WorkerImgPaths);
			
			level.setWallImgPath("wall2.png");
			int[][] wallsLocations = {
					{4,7},
					{8,3},
					{5,9}
					
			};
			level.setWallsLocations(wallsLocations);
			return level;
		} else {
			return null;
		}
	}
}