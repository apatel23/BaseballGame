import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.border.Border;


public class MainWindow implements ActionListener {
	
	private static JFrame jf;
	private static JPanel jp;
	private static JMenuBar jb;
	private static FileReader fr;
	private static ArrayList<Integer> points;
	private static Graphics g;
	private static BufferedImage img;
	private static JLabel background;
	
	MainWindow() {
		points = new ArrayList<Integer>();
	}
	
	
	public static JFrame makeFrame() {
		jf = new JFrame();
		createMenuBar();
		makeTopContainerPanel();
		jf.setContentPane(jp);
		jf.setSize(600, 600);
		jf.setTitle("Let's Play Ball!");
		jf.setVisible(true);
		return jf;
	}
	
	public static JPanel makeTopContainerPanel() {
		jp = new JPanel();
		loadImage();
		BorderLayout gl = new BorderLayout();
		jp.setLayout(gl);
		jp.add(background);
		jp.setVisible(true);
		return jp;
	}
	
	public static void createMenuBar() {
		jb = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem close = new JMenuItem("Close");
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(open);
		menu.add(close);
		jb.add(menu);
		jf.setJMenuBar(jb);
	}
	
	public static void loadImage() {
		try {
			img = ImageIO.read(new File("src/Field.jpg"));
			background = new JLabel(new ImageIcon(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void drawPoints(ArrayList<Integer> points) {
		points = fr.getPoints();
		int j = 10;
		for(Integer i : points) {
			System.out.println(" : " + i);
			//g.drawOval(j, i, 5, 5);
		}
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	public static void main(String[] args) {
		fr = new FileReader("points.txt");
		drawPoints(points);
		makeFrame();
	}


}
