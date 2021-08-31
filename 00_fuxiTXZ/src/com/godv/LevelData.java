package com.godv;

import java.awt.Color;

public class LevelData {
	private String title;
	private Color background;
	
	private String workerImgPath;
	private int[] workerLocation;
	
	private String boxImgPath;
	private int[][] boxLocations;
	
	private String goalImgPath;
	private int[][] goalLocations;
	
	private String wallsImgPath;
	private int[][] wallsLocations;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Color getBackground() {
		return background;
	}
	public void setBackground(Color background) {
		this.background = background;
	}
	public String getWorkerImgPath() {
		return workerImgPath;
	}
	public void setWorkerImgPath(String workerImgPath) {
		this.workerImgPath = workerImgPath;
	}
	public int[] getWorkerLocation() {
		return workerLocation;
	}
	public void setWorkerLocation(int[] workerLocation) {
		this.workerLocation = workerLocation;
	}
	public String getBoxImgPath() {
		return boxImgPath;
	}
	public void setBoxImgPath(String boxImgPath) {
		this.boxImgPath = boxImgPath;
	}
	public int[][] getBoxLocations() {
		return boxLocations;
	}
	public void setBoxLocations(int[][] boxLocations) {
		this.boxLocations = boxLocations;
	}
	public String getGoalImgPath() {
		return goalImgPath;
	}
	public void setGoalImgPath(String goalImgPath) {
		this.goalImgPath = goalImgPath;
	}
	public int[][] getGoalLocations() {
		return goalLocations;
	}
	public void setGoalLocations(int[][] goalLocations) {
		this.goalLocations = goalLocations;
	}
	public String getWallsImgPath() {
		return wallsImgPath;
	}
	public void setWallsImgPath(String wallsImgPath) {
		this.wallsImgPath = wallsImgPath;
	}
	public int[][] getWallsLocations() {
		return wallsLocations;
	}
	public void setWallsLocations(int[][] wallsLocations) {
		this.wallsLocations = wallsLocations;
	}
	
}
