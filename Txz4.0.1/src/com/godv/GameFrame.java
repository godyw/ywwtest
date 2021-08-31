package com.godv;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameFrame extends JFrame {
	private int nowindex = 1;
	private JPanel panel = null;
	private JLabel[] boxs = null;
	private JLabel[] goals = null;
	private JLabel[] workers = null;
	private JLabel[] walls = null;
	private String[] workerImagepath = null;
	
	//调用父类的构造方法
	public GameFrame(String title) {
		super(title);
		super.setSize(32 * 48 + 15, 20 * 48 + 38);
		super.setResizable(false);
		super.setLocationRelativeTo(null);
		
		
	}
	
	public void InitPanel() {
		this.panel = new JPanel();
		this.panel.setBackground(Color.BLUE);
		this.panel.setLayout(null);
		super.setContentPane(panel);
	}
	
	JLabel[] InitLabel(String imagePath, int[][] locations) {
		ImageIcon icon = new ImageIcon("imgs/" + imagePath);
		JLabel[] labels = new JLabel[locations.length];
		for (int i = 0; i < labels.length; i++) {
			int location[] = locations[i];
			labels[i] = new JLabel(icon);
			panel.add(labels[i]);
			labels[i].setBounds(location[0] * 48, location[1] * 48, 48, 48);
		}
		return labels;
	}
	void InitWalls(String wallImagPath, int [][] wallsLocations) {
		ImageIcon icon = new ImageIcon("imgs/" + wallImagPath);
		this.walls = new JLabel[32 * 3 + 20 * 2 + wallsLocations.length];
		for (int i = 0; i < walls.length; i++) {
			walls[i] = new JLabel(icon);
		}
		int index = 0;
		for (int i = 0; i < 32; i++) {
			
		}
	}
	
}
