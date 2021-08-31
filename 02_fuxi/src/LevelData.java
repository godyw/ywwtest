import java.awt.Color;

public class LevelData {
	private String workerImgPath;
	private int[] workerLocation;
	
	private String boxImgPath;
	private int[][] boxLocation;
	
	private String goalImgPath;
	private int[][] goalLocation;
	
	private String wallsImgPath;
	private int[][] wallsLocation;
	
	private String title;
	private Color background;
	public String getWorkerImgPath() {
		return workerImgPath;
	}
	public void setWorkerImgPath(String workerImgPath) {
		this.workerImgPath = workerImgPath;
	}
	public int[] getWorkerLocation() {
		return workerLocation;
	}
	public void setWorkerLocation(int[] workerLocation) {
		this.workerLocation = workerLocation;
	}
	public String getBoxImgPath() {
		return boxImgPath;
	}
	public void setBoxImgPath(String boxImgPath) {
		this.boxImgPath = boxImgPath;
	}
	public int[][] getBoxLocation() {
		return boxLocation;
	}
	public void setBoxLocation(int[][] boxLocation) {
		this.boxLocation = boxLocation;
	}
	public String getGoalImgPath() {
		return goalImgPath;
	}
	public void setGoalImgPath(String goalImgPath) {
		this.goalImgPath = goalImgPath;
	}
	public int[][] getGoalLocation() {
		return goalLocation;
	}
	public void setGoalLocation(int[][] goalLocation) {
		this.goalLocation = goalLocation;
	}
	public String getWallsImgPath() {
		return wallsImgPath;
	}
	public void setWallsImgPath(String wallsImgPath) {
		this.wallsImgPath = wallsImgPath;
	}
	public int[][] getWallsLocation() {
		return wallsLocation;
	}
	public void setWallsLocation(int[][] wallsLocation) {
		this.wallsLocation = wallsLocation;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Color getBackground() {
		return background;
	}
	public void setBackground(Color background) {
		this.background = background;
	}
}
