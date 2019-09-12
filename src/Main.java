import javax.swing.JFrame;

public class Main {
	
	public Main() {
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Snake");
		GamePanel gamePanel = new GamePanel();
		
		frame.add(gamePanel);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
	}
	
	public static void main(String [] args) {
		new Main();
	}

}
