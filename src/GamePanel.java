import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public static final int WIDHT = 500, HEIGHT = 500;

	public GamePanel() {
		setPreferredSize(new Dimension(WIDHT, HEIGHT));
	}

}
