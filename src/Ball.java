import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Ball extends JPanel {
	
	protected void paintComponent(Graphics g) {
		System.out.println("Draw Ball");
        super.paintComponent(g);       
        g.setColor(Color.RED);
        g.drawOval(50, 50, 20, 20);
    } 

	
}
