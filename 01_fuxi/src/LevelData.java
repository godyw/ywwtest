import java.awt.Color;

public class LevelData {
	private String title;
	private Color background;
	
	private String workerImgPath;
	private int[] workerLocation;
	
	private String boxsImgPath;
	private int[][] boxsLocation;
	
	private String goalsImgPath;
	private int[][] goalsLocation;
	
	private String wallsImgPath;
	private int[][] wallsLocation;
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
	public String getBoxsImgPath() {
		return boxsImgPath;
	}
	public void setBoxsImgPath(String boxsImgPath) {
		this.boxsImgPath = boxsImgPath;
	}
	public int[][] getBoxsLocation() {
		return boxsLocation;
	}
	public void setBoxsLocation(int[][] boxsLocation) {
		this.boxsLocation = boxsLocation;
	}
	public String getGoalsImgPath() {
		return goalsImgPath;
	}
	public void setGoalsImgPath(String goalsImgPath) {
		this.goalsImgPath = goalsImgPath;
	}
	public int[][] getGoalsLocation() {
		return goalsLocation;
	}
	public void setGoalsLocation(int[][] goalsLocation) {
		this.goalsLocation = goalsLocation;
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
	
	
}
