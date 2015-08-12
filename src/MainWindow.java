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
import javax.swing.JButton;
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
	private static Graphics g;
	private static BufferedImage img;
	private static JLabel background;
	private static JLabel pitch;
	
	MainWindow() {

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
		loadBackgroundImage();
		BorderLayout gl = new BorderLayout();
		jp.setLayout(gl);
		jp.add(background, BorderLayout.CENTER);
		
		JButton start = new JButton("Start");
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadPitchImage();
				jp.add(pitch, BorderLayout.CENTER);
				jp.revalidate();
				jp.paintImmediately(0, 0, 600, 600);
				System.out.println("Start game");
			}	
		});
		
		JButton swing = new JButton("Swing");
		swing.setSize(100, 50);
		swing.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Swing!");
			}
		});
		
		jp.add(swing, BorderLayout.SOUTH);
		jp.add(start, BorderLayout.NORTH);
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
	
	public static void loadBackgroundImage() {
		try {
			img = ImageIO.read(new File("src/Field.jpg"));
			background = new JLabel(new ImageIcon(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadPitchImage() {
		try {
			img = ImageIO.read(new File("src/Pitch.jpg"));
			pitch = new JLabel(new ImageIcon(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
	}

	
	
	
	
	public static void main(String[] args) {
		makeFrame();
	}


}
