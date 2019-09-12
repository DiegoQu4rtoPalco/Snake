import java.awt.Color;
import java.awt.Graphics;

public class BodyPart {
	
	private int xCoor, yCoor, whidth, height;
	
	public BodyPart(int xCoor, int yCoor, int tileSize) {
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		whidth = tileSize;
		height = tileSize;
	}
	
	public void tick() {
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(xCoor * whidth, yCoor * height, whidth, height);
	}

	public int getxCoor() {
		return xCoor;
	}

	public void setxCoor(int xCoor) {
		this.xCoor = xCoor;
	}

	public int getyCoor() {
		return yCoor;
	}

	public void setyCoor(int yCoor) {
		this.yCoor = yCoor;
	}
	
	

}
