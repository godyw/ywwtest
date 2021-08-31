import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Test {
	public static void main(String[] args) {
		JFrame gameFrame = new JFrame("推箱子测试");
		gameFrame.setSize(32 * 48 + 15, 20 * 48 + 38);
		gameFrame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setLayout(null);
		
		gameFrame.setContentPane(panel);
		
		ImageIcon boxImage = new ImageIcon("imgs/box2.png");
		JLabel box = new JLabel(boxImage);
		panel.add(box);
		box.setBounds(4 * 48, 6 * 48, 48, 48);
		
		ImageIcon workerImage = new ImageIcon("imgs/workerLeft2.png");
		JLabel worker = new JLabel(workerImage);
		panel.add(worker);
		worker.setBounds(8 * 48, 9 * 48, 48, 48);
		
		ImageIcon goalImage = new ImageIcon("imgs/goal2.png");
		JLabel goal = new JLabel(goalImage);
		panel.add(goal);
		goal.setBounds(12 * 48, 14 * 48, 48, 48);
		
		ImageIcon wallImage = new ImageIcon("imgs/wall2.png");
		JLabel walls[] = new JLabel[32 * 2 + (20 - 2) * 2 + 8 + 10 + 9];
		for (int i = 0; i < walls.length; i++) {
			walls[i] = new JLabel(wallImage);
		}
		//添加上下围墙
		int index = 0;
		for (int i = 0; i < 32; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds(i * 48, 0 * 48, 48, 48);
			panel.add(walls[index]);
			walls[index++].setBounds(i * 48, 19 * 48, 48, 48);
		}
		for (int i = 1; i <= 18; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds(0 * 48, i * 48, 48, 48);
			panel.add(walls[index]);
			walls[index++].setBounds(31 * 48, i * 48, 48, 48);
		}
		
		for (int i = 0; i < 8; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds((7 + i) * 48, 5 *48, 48, 48);
		}
		for (int i = 0; i < 10; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds(20 * 48, (5 + i) *48, 48, 48);
		}
		for (int i = 0; i < 9; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds((4 + i) * 48, (7 + i) *48, 48, 48);
		}
		
		gameFrame.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				int x = 0, y = 0;
				String workerimage  = "workerDown2.png";
				if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
					workerimage = "workerRight2.png";
					x = 48;
				}else if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
					workerimage = "workerLeft2.png";
					x = -48;
				}else if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
					workerimage = "workerUp2.png";
					y = -48;
				}else if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
					workerimage = "workerDown2.png";
					y = 48;
				}
				ImageIcon img = new ImageIcon("imgs/" + workerimage);
				worker.setIcon(img);
				worker.setBounds(worker.getBounds().x + x, worker.getBounds().y + y, 48, 48);
				for (int i = 0; i < walls.length; i++) {
					if (worker.getBounds().contains(walls[i].getBounds())) {
						worker.setBounds(worker.getBounds().x - x, worker.getBounds().y - y, 48, 48);
						break;
					}
					if (worker.getBounds().contains(box.getBounds())) {
						box.setBounds(box.getBounds().x + x, box.getBounds().y + y, 48, 48);
					}
					if (box.getBounds().contains(walls[i].getBounds())) {
						box.setBounds(box.getBounds().x - x, box.getBounds().y - y , 48, 48);
						worker.setBounds(worker.getBounds().x - x, worker.getBounds().y - y, 48, 48);
					}
				}
				if (box.getBounds().contains(goal.getBounds())) {
					JOptionPane.showMessageDialog(null, "下一关");
					System.exit(0);
				}
			}
		});
		
		
		gameFrame.setVisible(true);
	}
}
