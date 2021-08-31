package com.godv;

import java.awt.Color;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Run {
	public static void main(String[] args) {
		JFrame gameFrame = new JFrame("推箱子1.0");
		//gameFrame.setSize(800, 600);
		//gameFrame.setLocation(100, 50);
		//gameFrame.setTitle("推箱子1.0");
		gameFrame.setSize(22 * 48 + 16, 13 * 48 + 40);
		//设置大小不可变
		gameFrame.setResizable(false);
		gameFrame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		//设置背景颜色
		panel.setBackground(Color.GRAY);
		//设置自定义布局
		panel.setLayout(null);
		//把panel与窗体联系起来
		gameFrame.setContentPane(panel);
		
		ImageIcon boxImage = new ImageIcon("imgs/box2.png");
		JLabel box = new JLabel(boxImage);
		panel.add(box);
		box.setBounds(3 * 48, 4 * 48, 48, 48);
		
		ImageIcon workerImage = new ImageIcon("imgs/workerRight2.png");
		JLabel worker = new JLabel(workerImage);
		panel.add(worker);
		worker.setBounds(13 * 48, 2 * 48, 48, 48);
		
		ImageIcon goalImage = new ImageIcon("imgs/goal2.png");
		JLabel goal = new JLabel(goalImage);
		panel.add(goal);
		goal.setBounds(8 * 48, 9 * 48, 48, 48);

		//添加围墙
		ImageIcon wallImage = new ImageIcon("imgs/wall2.png");
		JLabel[] walls = new JLabel[22 * 2 + (13 - 2) * 2 + 5 + 7 + 5];
		for (int i = 0; i < walls.length; i++) {
			walls[i] = new JLabel(wallImage);
		}
		//添加上围墙
		int index = 0;//记录使用
		for (int i = 0; i < 22; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds(i * 48, 0 * 48, 48, 48);
			//添加下围墙	
			panel.add(walls[index]);
			walls[index++].setBounds(i * 48, 12 * 48, 48, 48);
		}
		
		//添加左右围墙
		for (int i = 1; i <= 11; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds(0 * 48, i * 48, 48, 48);	
			panel.add(walls[index]);
			walls[index++].setBounds(21 * 48, i * 48, 48, 48);
		}
		//设置障碍物(横的)
		for (int i = 0; i < 5; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds((6 + i) * 48, 3 * 48, 48, 48);
		}
		//设置障碍物(竖的)
		for (int i = 0; i < 7; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds(12 * 48, (3 + i) * 48, 48, 48);
		}
		//设置障碍物斜的
		for (int i = 0; i < 5; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds((3 + i) * 48, (5 + i) * 48, 48, 48);
		}
		//添加事件处理（使人物可以移动）
		gameFrame.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				int x = 0,y = 0;
				String workerImagePath = "workerDown.png"; 
				if(keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
					workerImagePath = "workerRight2.png";
					x = 48;
				} else if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
					workerImagePath = "workerLeft2.png";
					x = -48;
				} else if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
					workerImagePath = "workerUp2.png";
					y = -48;
				} else if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
					workerImagePath = "workerDown2.png";
					y = 48;
				}
				ImageIcon img = new ImageIcon("imgs/" + workerImagePath);
				worker.setIcon(img);
				worker.setBounds(worker.getBounds().x + x, worker.getBounds().y + y , 48, 48);
				//判断工人是否穿墙
				for (int i = 0; i < walls.length; i++) {
					if (worker.getBounds().contains(walls[i].getBounds())) {
						worker.setBounds(worker.getBounds().x - x, worker.getBounds().y - y, 48, 48);
						break;
					}
					
					if (worker.getBounds().contains(box.getBounds())) {
						box.setBounds(box.getBounds().x + x, box.getBounds().y + y, 48, 48);
					}
					for (int j = 0; j < walls.length; j++) {
						if (box.getBounds().contains(walls[i].getBounds())) {
							box.setBounds(box.getBounds().x - x, box.getBounds().y - y, 48, 48);
							worker.setBounds(worker.getBounds().x - x, worker.getBounds().y - y, 48, 48);
							break;
						}
					}
					
					if (box.getBounds().contains(goal.getBounds())) {
						JOptionPane.showMessageDialog(null, "恭喜您过关");
						System.exit(0);
					}
				}
				
			}
		});
		
		gameFrame.setVisible(true);
	}
}
