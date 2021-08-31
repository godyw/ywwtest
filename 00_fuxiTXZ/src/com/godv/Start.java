package com.godv;

public class Start {
	public static void main(String[] args) {
		GameFrame gameframe = new GameFrame("tui");
		LevelData level = LevelMananger.getNowLevelData(1);
		gameframe.loadLevelData(level);
		gameframe.setVisible(true); 
	}
}
