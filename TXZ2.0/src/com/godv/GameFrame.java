package com.godv;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameFrame extends JFrame {
	JPanel panel = null;
	JLabel box = null;
	JLabel worker = null;
	JLabel goal = null;
	JLabel[] walls = null;
	
	public GameFrame(String title) {
		super(title);
		super.setSize(22 * 48 + 16, 13 * 48 + 40);
		super.setResizable(false);
		super.setLocationRelativeTo(null);
		InitPanel();
		this.box = InitLabel("box2.png", 3, 4);
		this.goal = InitLabel("goal2.png", 13, 2);
		this.worker = InitLabel("workerRight2.png", 8, 9);
		InitWalls();
		addevent();
	}
	void InitPanel() {
		this.panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setLayout(null);
		super.setContentPane(panel);
	}
	JLabel InitLabel(String imgPath, int x, int y) {
		ImageIcon icon = new ImageIcon("imgs/" + imgPath);
		JLabel label = new JLabel(icon);
		panel.add(label);
		label.setBounds(x * 48, y * 48, 48, 48);
		return label;
	}
	void InitWalls() {
		ImageIcon wallimg = new ImageIcon("imgs/wall2.png");
		this.walls = new JLabel[22 * 2 + (13 - 2) * 2 + 5 + 7 + 5 + 7];
		for (int i = 0; i < walls.length; i++) {
			walls[i] = new JLabel(wallimg);
		}
		int index = 0;
		for (int i = 0; i < 22; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds(i * 48, 0 * 48, 48, 48);
			panel.add(walls[index]);
			walls[index++].setBounds(i * 48, 12 * 48, 48, 48);
		}
		
		for (int i = 1; i <= 11; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds(0 * 48, i * 48, 48, 48);	
			panel.add(walls[index]);
			walls[index++].setBounds(21 * 48, i * 48, 48, 48);
		}
		for (int i = 0; i < 5; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds((6 + i) * 48, 3 * 48, 48, 48);
		}
		for (int i = 0; i < 7; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds(12 * 48, (3 + i) * 48, 48, 48);
		}
		for (int i = 0; i < 5; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds((3 + i) * 48, (5 + i) * 48, 48, 48);
		}
		for (int i = 0; i < 7; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds(20 * 48, (3 + i) * 48, 48, 48);
		}
	}
	void addevent() {
		super.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				int keycode = e.getKeyCode();
				int x = 0, y = 0;
				String workerimgpath = "workerDown2.png";
				if (keycode == KeyEvent.VK_LEFT || keycode == KeyEvent.VK_A) {
					workerimgpath = "workerLeft2.png";
					x = -48;
				} else if (keycode == KeyEvent.VK_RIGHT || keycode == KeyEvent.VK_D) {
					workerimgpath = "workerRight2.png";
					x = 48;
				} else if (keycode == KeyEvent.VK_UP || keycode == KeyEvent.VK_W) {
					workerimgpath = "workerUp2.png";
					y = -48;
				} else if (keycode == KeyEvent.VK_DOWN || keycode == KeyEvent.VK_S) {
					workerimgpath = "workerDown2.png";
					y = 48;
				}
				ImageIcon img = new ImageIcon("imgs/" + workerimgpath);
				worker.setIcon(img);
				worker.setBounds(worker.getBounds().x + x, worker.getBounds().y + y, 48, 48);
				for (int i = 0; i < walls.length; i++) {
					if (worker.getBounds().contains(walls[i].getBounds())) {
						worker.setBounds(worker.getBounds().x - x, worker.getBounds().y - y, 48, 48);
						break;
					}
				}
			}
		});
//		super.addKeyListener(new KeyListener() {
//			@Override
//			public void keyTyped(KeyEvent e) {}
//			@Override
//			public void keyReleased(KeyEvent e) {}
//			@Override
//			public void keyPressed(KeyEvent e) {
//				int keyCode = e.getKeyCode();
//				int x = 0,y = 0;
//				String workerImagePath = "workerDown.png"; 
//				if(keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
//					workerImagePath = "workerRight2.png";
//					x = 48;
//				} else if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
//					workerImagePath = "workerLeft2.png";
//					x = -48;
//				} else if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
//					workerImagePath = "workerUp2.png";
//					y = -48;
//				} else if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
//					workerImagePath = "workerDown2.png";
//					y = 48;
//				}
//				ImageIcon img = new ImageIcon("imgs/" + workerImagePath);
//				worker.setIcon(img);
//				worker.setBounds(worker.getBounds().x + x, worker.getBounds().y + y , 48, 48);
//				//ÅÐ¶Ï¹¤ÈËÊÇ·ñ´©Ç½
//				for (int i = 0; i < walls.length; i++) {
//					if (worker.getBounds().contains(walls[i].getBounds())) {
//						worker.setBounds(worker.getBounds().x - x, worker.getBounds().y - y, 48, 48);
//						break;
//					}
//					
//					if (worker.getBounds().contains(box.getBounds())) {
//						box.setBounds(box.getBounds().x + x, box.getBounds().y + y, 48, 48);
//					}
//					for (int j = 0; j < walls.length; j++) {
//						if (box.getBounds().contains(walls[i].getBounds())) {
//							box.setBounds(box.getBounds().x - x, box.getBounds().y - y, 48, 48);
//							worker.setBounds(worker.getBounds().x - x, worker.getBounds().y - y, 48, 48);
//							break;
//						}
//					}
//					
//					if (box.getBounds().contains(goal.getBounds())) {
//						JOptionPane.showMessageDialog(null, "¹§Ï²Äú¹ý¹Ø");
//						System.exit(0);
//					}
//				}
//				
//			}
//		});
	}
}
