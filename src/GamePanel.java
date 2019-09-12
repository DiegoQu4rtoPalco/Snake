import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	public static final int WIDHT = 500, HEIGHT = 500;
	
	private Thread thread;
	
	private boolean running;

	public GamePanel() {
		setPreferredSize(new Dimension(WIDHT, HEIGHT));
		start();
	}
	
	public void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void tick() {
		
	}
	
	public void paint(Graphics g) {
		for(int i = 0; i < WIDHT/10; i++) {
			g.drawLine(i * 10, 0, i * 10, HEIGHT);
		}
		for(int i = 0; i < HEIGHT/10; i++) {
			g.drawLine(0, i * 10, HEIGHT, i * 10);
		}
	}
	
	public void run() {
		while(running) {
			tick();
			repaint();
		}
	}

}
