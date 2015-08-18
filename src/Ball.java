import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Ball extends JPanel {
	
	private int xPosition;
	private int yPosition;
	private static int radius = 20;
	
	Ball() {
		super();
		xPosition = 50;
		yPosition = 50;
	}
	
	public void paintComponent(Graphics g) {
		System.out.println("Draw Ball");
        super.paintComponent(g);       
        g.drawString("This is my custom Panel!",10,20);
        g.setColor(Color.RED);
        g.drawOval(xPosition, yPosition, radius, radius);
    } 

	
}
