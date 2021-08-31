package com.godv;

import java.util.Arrays;

public class Level {
	private int[] boxlocation;
	private String boxImgPath;
	private int[] goalLocation;
	private String goalImgPath;
	private int[] workerLocation;
	private String[] workerImgPaths;
	private String workerImgPath;
	private String wallImgPath;
	private int[][] wallsLocations;
	public int[] getBoxlocation() {
		return boxlocation;
	}
	public void setBoxlocation(int[] boxlocation) {
		this.boxlocation = boxlocation;
	}
	public String getBoxImgPath() {
		return boxImgPath;
	}
	public void setBoxImgPath(String boxImgPath) {
		this.boxImgPath = boxImgPath;
	}
	public int[] getGoalLocation() {
		return goalLocation;
	}
	public void setGoalLocation(int[] goalLocation) {
		this.goalLocation = goalLocation;
	}
	public String getGoalImgPath() {
		return goalImgPath;
	}
	public void setGoalImgPath(String goalImgPath) {
		this.goalImgPath = goalImgPath;
	}
	public int[] getWorkerLocation() {
		return workerLocation;
	}
	public void setWorkerLocation(int[] workerLocation) {
		this.workerLocation = workerLocation;
	}
	public String[] getWorkerImgPaths() {
		return workerImgPaths;
	}
	public void setWorkerImgPaths(String[] workerImgPaths) {
		this.workerImgPaths = workerImgPaths;
	}
	public String getWorkerImgPath() {
		return workerImgPath;
	}
	public void setWorkerImgPath(String workerImgPath) {
		this.workerImgPath = workerImgPath;
	}
	public String getWallImgPath() {
		return wallImgPath;
	}
	public void setWallImgPath(String wallImgPath) {
		this.wallImgPath = wallImgPath;
	}
	public int[][] getWallsLocations() {
		return wallsLocations;
	}
	public void setWallsLocations(int[][] wallsLocations) {
		this.wallsLocations = wallsLocations;
	}
	@Override
	public String toString() {
		return "Level [boxlocation=" + Arrays.toString(boxlocation) + ", boxImgPath=" + boxImgPath + ", goalLocation="
				+ Arrays.toString(goalLocation) + ", goalImgPath=" + goalImgPath + ", workerLocation="
				+ Arrays.toString(workerLocation) + ", workerImgPaths=" + Arrays.toString(workerImgPaths)
				+ ", workerImgPath=" + workerImgPath + ", wallImgPath=" + wallImgPath + ", wallsLocations="
				+ Arrays.toString(wallsLocations) + "]";
	}
	
	
	
	
}
