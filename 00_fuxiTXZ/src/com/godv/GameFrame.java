package com.godv;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameFrame extends JFrame {
	private int nowindex = 1;
	private JPanel panel = null;
	private JLabel[] box = null;
	private JLabel[] goal = null;
	private JLabel worker = null;
	private JLabel[] walls = null;
	private String workerImgPath = null;
	public GameFrame(String title) throws HeadlessException {
		super(title);
		super.setSize(32 * 48 + 15, 20 * 48 + 38);
		super.setResizable(false);
		super.setLocationRelativeTo(null);
		InitPanel();
		addEvent();
	}
	public void InitPanel() {
		this.panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setLayout(null);
		super.setContentPane(panel);
	}
	public JLabel InitLabel(String ImgPath, int[] location) {
		ImageIcon Img = new ImageIcon("imgs/" + ImgPath);
		JLabel label = new JLabel(Img);
		this.panel.add(label);
		label.setBounds(location[0] * 48, location[1] * 48, 48, 48);
		return label;
	}
	public JLabel[] InitLabel(String ImgPath, int[][]locations) {
		ImageIcon Img = new ImageIcon("imgs/" + ImgPath);
		JLabel[] labels = new JLabel[locations.length];
		for (int i = 0; i < locations.length; i++) {
			labels[i] = new JLabel(Img);
			this.panel.add(labels[i]);
			int[] location = locations[i];
			labels[i].setBounds(location[0] * 48, location[1] * 48, 48, 48);
		}
		return labels;
	}
	public void InitWalls(String wallImgPath, int[][] wallsLocations) {
		 ImageIcon wallsImg = new ImageIcon("imgs/" + wallImgPath);
		 this.walls = new JLabel[32 * 2 + (20 - 1) * 2 + wallsLocations.length];
		 for (int i = 0; i < walls.length; i++) {
			walls[i] = new JLabel(wallsImg);
		 }
		 int index = 0;
		 for (int i = 0; i < 32; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds(i * 48, 0 * 48, 48, 48);
			panel.add(walls[index]);
			walls[index++].setBounds(i * 48, 19 * 48, 48, 48);
		 }
		 for (int i = 0; i <= 18; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds(0 * 48, i * 48, 48, 48);
			panel.add(walls[index]);
			walls[index++].setBounds(31 * 48, i * 48, 48, 48);
		 }
		 for (int i = 0; i < wallsLocations.length; i++) {
			int[] locations = wallsLocations[i];
			panel.add(walls[index]);
			walls[index++].setBounds(locations[0] * 48, locations[1] * 48, 48, 48);
			
		}
	}
	public void loadLevelData(LevelData level) {
		super.setTitle(level.getTitle());
		panel.setBackground(level.getBackground());
		
		this.workerImgPath = level.getWorkerImgPath();
		worker = InitLabel(workerImgPath, level.getWorkerLocation());
		
		int[][] boxslocations = level.getBoxLocations();
		this.box = new JLabel[boxslocations.length];
		for (int i = 0; i < boxslocations.length; i++) {
			this.box[i] = InitLabel(level.getBoxImgPath(), boxslocations[i]);
		}
		
		int[][] goalslocations = level.getGoalLocations();
		this.goal = new JLabel[goalslocations.length];
		for (int i = 0; i < goalslocations.length; i++) {
			this.goal[i] = InitLabel(level.getGoalImgPath(), goalslocations[i]);
		}
		
		this.InitWalls(level.getWallsImgPath(), level.getWallsLocations());
		
	}
	
	void addEvent() {
		super.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				int keycode = e.getKeyCode();
				int x = 0, y = 0;
				String workerImg = workerImgPath;
				if (keycode == KeyEvent.VK_LEFT || keycode == KeyEvent.VK_A) {
					x = -48;
				} else if (keycode == KeyEvent.VK_UP || keycode == KeyEvent.VK_W) {
					y = -48;
				} else if (keycode == KeyEvent.VK_RIGHT || keycode == KeyEvent.VK_D) {
					x = 48;
				} else if (keycode == KeyEvent.VK_DOWN || keycode == KeyEvent.VK_S) {
					y = 48;
				}
				ImageIcon workerImag = new ImageIcon("imgs/" + workerImg);
				worker.setIcon(workerImag);
				worker.setBounds(worker.getBounds().x + x, worker.getBounds().y + y, 48, 48);
				
				for (int i = 0; i < walls.length; i++) {
					if (worker.getBounds().contains(walls[i].getBounds())) {
						worker.setBounds(worker.getBounds().x - x, worker.getBounds().y - y, 48, 48);
					}
				}
				for (int i = 0; i < box.length; i++) {
					if (worker.getBounds().contains(box[i].getBounds())) {
						box[i].setBounds(box[i].getBounds().x + x, box[i].getBounds().y + y, 48, 48);
					}
					for (int j = 0; j < box.length; j++) {
						if(j == i) continue;
						if (box[j].getBounds().contains(box[i].getBounds())) {
							box[i].setBounds(box[i].getBounds().x - x, box[i].getBounds().y - y, 48, 48);
							worker.setBounds(worker.getBounds().x - x, worker.getBounds().y - y, 48, 48);
						}
					}
				}
				for (int i = 0; i < box.length; i++) {
					for (int j = 0; j < walls.length; j++) {
						if (box[i].getBounds().contains(walls[j].getBounds())) {
							worker.setBounds(worker.getBounds().x - x, worker.getBounds().y - y, 48, 48);
							box[i].setBounds(box[i].getBounds().x - x, box[i].getBounds().y - y, 48, 48);
						}
					}
				}
				int count = 0;
				for (int i = 0; i < goal.length; i++) {
					for (int j = 0; j < box.length; j++) {
						if (goal[i].getBounds().contains(box[j].getBounds())) {
							count++;
							break;
						}
					}
				}
				if (count == goal.length) {
					LevelData level = LevelMananger.getNowLevelData(nowindex + 1);
					if (level == null) {
						JOptionPane.showMessageDialog(null, "通关");
						System.exit(0);
					}else {
						int result = JOptionPane.showConfirmDialog(null, "第" + nowindex + "关通过", 
								"请选择", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (result == JOptionPane.YES_OPTION) {
							nowindex++;
							loadLevelData(level);
						}else {
							JOptionPane.showMessageDialog(null, "欢迎下次再见");
							System.exit(0);
						}
					} 
				}
			}
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
