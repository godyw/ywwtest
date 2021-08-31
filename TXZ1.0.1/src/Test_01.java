import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test_01 {
	public static void main(String[] args) {
		JFrame gameFrame = new JFrame("ÍÆÏä×Ó1.0.1");
		gameFrame.setSize(32 * 48 + 16, 20 * 48 + 38);
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(null);
		gameFrame.setContentPane(panel);
		
		
		ImageIcon workerImage = new ImageIcon("imgs/workerLeft2.png");
		JLabel worker = new JLabel(workerImage);
		panel.add(worker);
		worker.setBounds(4 * 48, 6 * 48, 48, 48);
		
		ImageIcon boxImage = new ImageIcon("imgs/box2.png");
		JLabel box = new JLabel(boxImage);
		panel.add(box);
		box.setBounds(7 * 48, 6 * 48, 48, 48);
		
		ImageIcon goalImage = new ImageIcon("imgs/goal2.png");
		JLabel goal = new JLabel(goalImage);
		panel.add(goal);
		goal.setBounds(10 * 48, 6 * 48, 48, 48);
		
		ImageIcon wallImage = new ImageIcon("imgs/wall2.png");
		JLabel walls[] = new JLabel[(32 * 2) + (20 -2 ) * 2];
		for (int i = 0; i < walls.length; i++) {
			walls[i] = new JLabel(wallImage);
		}
		
		int index = 0;
		for (int i = 0; i < 32; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds(i * 48, 0 * 48, 48, 48);
			panel.add(walls[index]);
			walls[index++].setBounds(i * 48, 19 * 48, 48, 48);
		}
		for (int i = 1; i < 19; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds(0 * 48, i * 48, 48, 48);
			panel.add(walls[index]);
			walls[index++].setBounds(31 * 48, i * 48, 48, 48);
		}
		
		gameFrame.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				int x = 0, y = 0;
				String workerPathImage = "workerLeft2.png";
				if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
					workerPathImage = "workerLeft2.png";
					x = -48;
				}else if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
					workerPathImage = "workerRight2.png";
					x = 48;
				}else if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
					workerPathImage = "workerUp2.png";
					y = -48;
				}else if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
					workerPathImage = "workerDown2.png";
					y = 48;
				}
				ImageIcon img = new ImageIcon("imgs/" + workerPathImage);
				worker.setIcon(img);
				worker.setBounds(worker.getBounds().x + x, worker.getBounds().y + y, 48, 48);
			}
		});
		
		gameFrame.setVisible(true);
	}
}
