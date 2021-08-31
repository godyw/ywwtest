import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameFrame extends JFrame{
	//�����жϹؿ�
	private int nowindex = 1;
	private JPanel panel = null;
	private JLabel[] box = null;
	private JLabel[] goal = null;
	private JLabel worker = null;
	private JLabel[] walls = null;
	private String[] workerImgPaths = null;
	
	
	public GameFrame(String title) {
		//���ø��๹�췽��
		super(title);
		super.setSize(32 * 48 + 15, 20 * 48 + 38);
		super.setResizable(false);
		super.setLocationRelativeTo(null);
		InitPanel();
		addEvent();
	}
	
	public void InitPanel(){
		this.panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setLayout(null);
		super.setContentPane(panel);
	}
	//��Ӷ��ͬ�������	
	JLabel[] InitLabel(String imgPath, int[][] locations) {
		ImageIcon icon = new ImageIcon("imgs/" + imgPath);
		JLabel[] labels = new JLabel[locations.length];
		for (int i = 0; i < labels.length; i++) {
			int[] location = locations[i];
			labels[i] = new JLabel(icon);
			panel.add(labels[i]);
			labels[i].setBounds(location[0] * 48, location[1] * 48, 48, 48);
		}
		return labels;
	} 
	//���������ӱ�ǩ
	JLabel InitLabel(String imgPath, int[] location) {
		ImageIcon icon = new ImageIcon("imgs/" + imgPath);
		JLabel label = new JLabel(icon);
		panel.add(label);
		label.setBounds(location[0] * 48, location[1] * 48, 48, 48);
		return label;
	}
	void InitWalls(String wallImgPath, int[][]wallsLocation) {
		ImageIcon wallImg = new ImageIcon("imgs/" + wallImgPath);
		this.walls = new JLabel[32 * 3 + 20 * 2 + wallsLocation.length];
		for (int i = 0; i < walls.length; i++) {
			walls[i] = new JLabel(wallImg);
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
			walls[index++].setBounds(0 * 48, i * 48, 48, 48);
			
			panel.add(walls[index]);
			walls[index++].setBounds(31 * 48, i * 48, 48, 48);
		}
		for (int i = 0; i < wallsLocation.length; i++) {
			int[] location = wallsLocation[i];
			panel.add(walls[index]);
			walls[index++].setBounds(location[0] * 48, location[1] * 48, 48, 48);
		}
		
	}
	//������Ϸ�ؿ�����
	public void loadLevelData(Level level) {
		this.panel.removeAll();
		super.setTitle("������4.0");
		
		int[][] locations = level.getBoxLocations();
		this.box = new JLabel[locations.length];
		for (int i = 0; i < locations.length; i++) {
			this.box[i] = InitLabel(level.getBoxImgPath(), locations[i]);
		}
		
		locations = level.getGoalLocations();
		this.goal = new JLabel[locations.length];
		for (int i = 0; i < locations.length; i++) {
			this.goal[i] = InitLabel(level.getGoalImagPath(), locations[i]);
		}
		
		this.workerImgPaths = level.getWorkerImgPaths();
		this.worker = InitLabel(workerImgPaths[0], level.getWorkerLocation());
		
		this.InitWalls(level.getWallImgPath(), level.getWallsLocations());
		this.panel.repaint();
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
				int workerImgIndex = 0;
				if(keycode == KeyEvent.VK_LEFT || keycode == KeyEvent.VK_A) {
					x = -48;
				} else if (keycode == KeyEvent.VK_UP || keycode == KeyEvent.VK_W) {
					y = -48;
					workerImgIndex = 1;
				} else if (keycode == KeyEvent.VK_RIGHT || keycode == KeyEvent.VK_D) {
					x = 48;
					workerImgIndex = 2;
				} else if (keycode == KeyEvent.VK_DOWN || keycode == KeyEvent.VK_S){
					y = 48;
					workerImgIndex = 3;
				}
				ImageIcon img = new ImageIcon("imgs/" + workerImgPaths[workerImgIndex]);
				worker.setIcon(img);
				worker.setBounds(worker.getBounds().x + x, worker.getBounds().y + y, 48, 48);
				//�жϹ����Ƿ�ǽ
				for (int i = 0; i < walls.length; i++) {
					if (worker.getBounds().contains(walls[i].getBounds())) {
						worker.setBounds(worker.getBounds().x - x, worker.getBounds().y - y, 48, 48);
						break;
					}
				}
				//�ù����ƶ�����
				for (int i = 0; i < box.length; i++) {
					if (worker.getBounds().contains(box[i].getBounds())) {
						box[i].setBounds(box[i].getBounds().x + x, box[i].getBounds().y + y, 48, 48);
					}
					for (int j = 0; j < box.length; j++) {
						if (j == i) continue;
						if (box[j].getBounds().contains(box[i].getBounds())) {
							worker.setBounds(worker.getBounds().x - x, worker.getBounds().y - y, 48, 48);
							box[i].setBounds(box[i].getBounds().x - x, box[i].getBounds().y - y, 48, 48);
						}
					}
				}
				//�ж������Ƿ�ǽ
				for (int i = 0; i < box.length; i++) {
					for (int j = 0; j < walls.length; j++) {
						if (box[i].getBounds().contains(walls[j].getBounds())) {
							worker.setBounds(worker.getBounds().x - x, worker.getBounds().y - y, 48, 48);
							box[i].setBounds(box[i].getBounds().x - x, box[i].getBounds().y - y, 48, 48);
						}
					}
				}
				//�ж���Ӯ
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
					Level level = LevelManager.getNowLevel(nowindex + 1);
					if(level == null) {
						JOptionPane.showMessageDialog(null, "ͨ��");
						System.exit(0);
					} else {
						int result = JOptionPane.showConfirmDialog(null, "��" + nowindex + "��ͨ�����Ƿ������һ�أ�",
								"��ѡ��", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
						if (result == JOptionPane.YES_OPTION) {
							nowindex++;
							loadLevelData(level);
						} else {
							JOptionPane.showMessageDialog(null, "��ӭ�´μ������ټ���");
							System.exit(0);
						}
						
					}
				}
			}
		});
	}
}
