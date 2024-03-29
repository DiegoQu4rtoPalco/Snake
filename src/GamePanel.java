import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable, KeyListener {
	
	private static final long serialVersionUID = 1L;
	
	public static final int WIDHT = 500, HEIGHT = 500;
	
	private Thread thread;
	
	private boolean running;
	
	private BodyPart b;
	
	private ArrayList<BodyPart> snake;
	
	private Apple apple;
	private ArrayList<Apple> apples;	
	
	private Random r;
	
	private int xCoor = 10, yCoor = 10, size = 5;
	
	private int ticks =  0;
	
	private boolean right = true, left = false, up = false, down = false;

	public GamePanel() {
		setPreferredSize(new Dimension(WIDHT, HEIGHT));
		start();
		snake = new ArrayList<BodyPart>();
		setFocusable(true);
		addKeyListener(this);
		
		apples = new ArrayList<Apple>();
		
		r = new Random();
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
		if(snake.size() == 0) {
			b = new BodyPart(xCoor, yCoor, 10);
			snake.add(b);
		}
		ticks++;
		if(ticks > 300000) {
			if(right) xCoor++;
			if(left) xCoor--;
			if(up) yCoor--;
			if(down) yCoor++;
			
			ticks = 0;
			b = new BodyPart(xCoor, yCoor, 10);
			snake.add(b);
			if(snake.size() > size){
				snake.remove(0);
			}
		}
		
		if (apples.size() == 0) {
			int xCoor = r.nextInt(49);
			int yCoor = r.nextInt(49);
			
			apple = new Apple(xCoor, yCoor, 10);
			apples.add(apple);
		}
		
		for(int i = 0; i < apples.size(); i++) {
			if(xCoor == apples.get(i).getxCoor() && yCoor == apples.get(i).getyCoor()) {
				size++;
				apples.remove(i);
				i++;
			}
		}
		
	}
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, WIDHT, HEIGHT);
		for(int i = 0; i < WIDHT/10; i++) {
			g.drawLine(i * 10, 0, i * 10, HEIGHT);
		}
		for(int i = 0; i < HEIGHT/10; i++) {
			g.drawLine(0, i * 10, HEIGHT, i * 10);
		}
		for(int i = 0; i < snake.size(); i++) {
			snake.get(i).draw(g);
		}
		
		for(int i = 0; i < apples.size(); i++) {
			apples.get(i).draw(g);
		}
	}
	
	public void run() {
		while(running) {
			tick();
			repaint();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if( key == KeyEvent.VK_RIGHT && !left) {
			right=true;
			up=false;
			down=false;
		}
		if( key == KeyEvent.VK_LEFT && !right) {
			left=true;
			up=false;
			down=false;
		}
		if( key == KeyEvent.VK_UP && !down) {
			up=true;
			left=false;
			right=false;
		}
		if( key == KeyEvent.VK_DOWN && !up) {
			down=true;
			left=false;
			right=false;
		}
				
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
