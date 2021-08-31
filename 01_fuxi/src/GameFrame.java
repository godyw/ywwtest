import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameFrame extends JFrame{
	private int nowindex = 1;
	private JPanel panel = null;
	private JLabel[] box = null;
	private JLabel[] goal = null;
	private JLabel worker = null;
	private JLabel[] walls = null;
	private String workerImgPath = null;
	public GameFrame(String title) {
		super(title);
		super.setSize(32 * 48 + 15, 20 * 48 + 38);
		super.setResizable(false);
		super.setLocationRelativeTo(null);
		InitPanel();
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
		panel.add(label);
		label.setBounds(location[0] * 48, location[1] * 48, 48, 48);
		return label;
	}
	
	public JLabel[] InitLabel(String ImgPath, int[][] locations) {
		ImageIcon img = new ImageIcon("imgs/" + ImgPath);
		JLabel[] labels = new JLabel[locations.length];
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(img);
			int[] location = locations[i];
			panel.add(labels[i]);
			labels[i].setBounds(location[0] * 48, location[1] * 48, 48, 48);
		}
		return labels;
	}
	
	public void InitWalls (String wallsImgPath, int[][] wallslocation) {
		ImageIcon wallsimg = new ImageIcon("imgs/" + wallsImgPath);
		this.walls = new JLabel[32 * 2 + 18 * 2 + wallslocation.length];
		for (int i = 0; i < walls.length; i++) {
			walls[i] = new JLabel(wallsimg);
		}
		int index = 0;
		for (int i = 0; i < 32; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds(i * 48, 0 * 48, 48, 48);
			panel.add(walls[index]);
			walls[index++].setBounds(i * 48, 19 * 48, 48, 48);
		}
		for (int i = 1; i <= 18; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds(0 * 48, i* 48, 48, 48);
			panel.add(walls[index]);
			walls[index++].setBounds(31 * 48, i * 48, 48, 48);
		}
		for (int i = 0; i < wallslocation.length; i++) {
			int[] location = wallslocation[i];
			panel.add(walls[index]);
			walls[index++].setBounds(location[0] * 48, location[1] * 48, 48, 48);
		}
	}
	
	public void loadLevelData(LevelData level) {
		super.setTitle(level.getTitle());
		panel.setBackground(level.getBackground());
		
		this.workerImgPath = level.getWorkerImgPath();
		worker = InitLabel(workerImgPath, level.getWorkerLocation());
		
		
		this.box = InitLabel(level.getBoxsImgPath(), level.getBoxsLocation());
//		int[][] boxlocations = level.getBoxsLocation();
//		this.box = new JLabel[boxlocations.length];
//		for (int i = 0; i < boxlocations.length; i++) {
//			this.box[i] = InitLabel(level.getBoxsImgPath(), boxlocations[i]);
//		}
		
		int[][] goallocations = level.getGoalsLocation();
		this.goal = new JLabel[goallocations.length];
		for (int i = 0; i < goallocations.length; i++) {
			this.goal[i] = InitLabel(level.getGoalsImgPath(), goallocations[i]);
		}
		this.InitWalls(level.getWallsImgPath(), level.getWallsLocation());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
