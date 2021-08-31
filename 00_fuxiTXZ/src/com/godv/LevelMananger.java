package com.godv;

import java.awt.Color;

public class LevelMananger {
	public static LevelData getNowLevelData(int index) {
		LevelData level = new LevelData();
		if (index == 1) {
			level.setTitle("121");
			level.setBackground(Color.BLACK);
			
			String workerImgPath = "workerRight2.png";
			level.setWorkerImgPath(workerImgPath);
			level.setWorkerLocation(new int[] {5,9});
			
			level.setBoxImgPath("box2.png");
			int[][] boxslocations = {{1,2},{2,3}};
			level.setBoxLocations(boxslocations);
			
			level.setGoalImgPath("goal2.png");
			int[][] goalslocations = {{6,9},{7,10}};
			level.setGoalLocations(goalslocations);
			
			level.setWallsImgPath("wall2.png");
			int[][] wallslocations = {{3,3}, {9,9}};
			level.setWallsLocations(wallslocations);
			
			return level;
		} else {
			return null;
		}
		
	}
}
