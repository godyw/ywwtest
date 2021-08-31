import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameFrame extends JFrame{
	private int nowIndex = 1;
	private JPanel panel = null;
	private JLabel worker = null;
	private JLabel[] boxs = null;
	private JLabel[] goals = null;
	private JLabel[] walls = null;
	private String workerImgPath;
	public GameFrame(String title) throws HeadlessException {
		super(title);
		super.setSize(32 * 48 + 15, 20 * 48 + 38);
		super.setResizable(false);
		super.setLocationRelativeTo(null);
		InitPanel();
	}
	public void InitPanel() {
		this.panel = new JPanel();
		this.panel.setBackground(Color.BLUE);
		this.panel.setLayout(null);
		super.setContentPane(panel);
	}
	public JLabel InitLabel(String ImgParh, int[] location) {
		ImageIcon Img = new ImageIcon("imgs/" + ImgParh);
		JLabel label = new JLabel(Img);
		this.panel.add(label);
		label.setBounds(location[0] * 48, location[1] * 48, 48, 48);
		return label;
	}
	public JLabel[] InitLabel(String imagePath, int[][] locations) {
		ImageIcon img = new ImageIcon("imgs/" + imagePath);
		JLabel[] labels = new JLabel[locations.length];
		for (int i = 0; i < locations.length; i++) {
			labels[i] = new JLabel(img);
			int[] location = locations[i];
			panel.add(labels[i]);
			labels[i].setBounds(location[0] * 48, location[1] * 48, 48, 48);
		}
		return labels;
	}
	public void InitWalls (String wallsImgPath, int[][] wallsLocations) {
		ImageIcon img = new ImageIcon("imgs/" + wallsImgPath);
		this.walls = new JLabel[wallsLocations.length + 32 * 2 + 18 * 2];
		for (int i = 0; i < walls.length; i++) {
			walls[i] = new JLabel(img);
		}
		int index = 0;
		for (int i = 0; i < 32; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds(i * 48, 0, 48, 48);
			panel.add(walls[index]);
			walls[index++].setBounds(i * 48, 19 * 48, 48, 48);
		}
		for (int i = 1; i <= 18; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds(0, i * 48, 48, 48);
			panel.add(walls[index]);
			walls[index++].setBounds(31 * 48, i * 48, 48, 48);
		}
		for (int i = 0; i < wallsLocations.length; i++) {
			int[] location = wallsLocations[i];
			panel.add(walls[index]);
			walls[index].setBounds(location[0] * 48, location[1] * 48, 48, 48);
		}
	}
	public void LoadLevelData(LevelData Level) {
		super.setTitle(Level.getTitle());
		panel.setBackground(Level.getBackground());
		
		this.workerImgPath = "workerRight2.png";
		worker = InitLabel(workerImgPath, Level.getWorkerLocation());
		
		this.boxs = InitLabel(Level.getBoxImgPath(), Level.getBoxLocation());
		
		this.goals = InitLabel(Level.getGoalImgPath(), Level.getGoalLocation());
		
		this.InitWalls(Level.getWallsImgPath(), Level.getWallsLocation());
	}
	//事件处理
	void addEvent() {
		super.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				int x = 0, y = 0;
				int keyCode = e.getKeyCode();
				String workerImg = "workerRight2.png";
				if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
					x = -48;
				}
				if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
					y = -48;
				}
				if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
					x = 48;
				}
				if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
					x = 48;
				}
				ImageIcon img = new ImageIcon("imgs/" + workerImg);
				worker.setIcon(img);
				worker.setBounds(worker.getBounds().x + x, worker.getBounds().y + y, 48, 48);
				
				for (int i = 0; i < walls.length; i++) {
					if (worker.getBounds().contains(walls[i].getBounds())) {
						worker.setBounds(worker.getBounds().x - x, worker.getBounds().y - y, 48, 48);
					}
				}
				for (int i = 0; i < boxs.length; i++) {
					if (worker.getBounds().contains(boxs[i].getBounds())) {
						boxs[i].setBounds(boxs[i].getBounds().x + x, boxs[i].getBounds().y + y, 48, 48);
					}
					for (int j = 0; j < boxs.length; j++) {
						if (j == i) continue;
						if (boxs[i].getBounds().contains(boxs[i].getBounds())) {
							boxs[i].setBounds(boxs[i].getBounds().x - x, boxs[i].getBounds().y - y, 48, 48);
							worker.setBounds(worker.getBounds().x - x, worker.getBounds().y - y, 48, 48);
						}
					}
				}
				
				for (int i = 0; i < boxs.length; i++) {
					for (int j = 0; j < walls.length; j++) {
						if (boxs[i].getBounds().contains(walls[i].getBounds())) {
							worker.setBounds(worker.getBounds().x - x, worker.getBounds().y - y, 48, 48);
							boxs[i].setBounds(boxs[i].getBounds().x - x, boxs[i].getBounds().y - y, 48, 48);
						}
					}
				}
				int count = 0;
				for (int i = 0; i < goals.length; i++) {
					for (int j = 0; j < boxs.length; j++) {
						if (boxs[j].getBounds().contains(goals[i].getBounds())) {
							count++;
							break;
						}
					}
				}
				if (count == goals.length) {
					LevelData level = LevelManager.GetNowIndex(nowIndex + 1);
					if (level == null) {
						JOptionPane.showMessageDialog(null, "111");
					}
					
				}
			}
			
		});
		
		
		
		
		
		
		
		
	}
}
