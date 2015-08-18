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
	private static JDialog jd;
	private static JMenuBar jb;
	private static BufferedImage img;
	private static JLabel background;
	private static JLabel pitch;
	
	private static Boolean pitched = false;
	
	
	
	MainWindow() {
		splashScreen();
	}
	
	
	public static void splashScreen() {
		jd = new JDialog();
		jd.setSize(200, 100);
		jd.setTitle("New Game");
		jd.setLocationRelativeTo(null);
		
		JButton start = new JButton("Start");
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NewGame();
				System.out.println("Start game");
			}	
		});
		
		JButton close = new JButton("Exit");
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JPanel jdp = new JPanel();
		BorderLayout bl = new BorderLayout();
		jdp.setLayout(bl);
		jd.add(start, BorderLayout.NORTH);
		jd.add(close, BorderLayout.SOUTH);
		jd.setVisible(true);
	}
	
	public static JFrame NewGame() {
		
		// Close Dialog
		jd.dispose();
		
		JPanel jp = new JPanel();
		loadPitchImage();
		BorderLayout gl = new BorderLayout();
		
		jp.setLayout(gl);
		jp.add(pitch, BorderLayout.CENTER);
		jp.setVisible(true);
		
		jf = new JFrame();
		createMenuBar();
		jf.setContentPane(jp);
		jf.setSize(600, 600);
		jf.setTitle("Let's Play Ball!");
		jf.setLocationRelativeTo(null);
		
		JButton throwPitch = new JButton("Throw Pitch");
		throwPitch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Throw pitch
				System.out.println("Throw Pitch");
				Ball pitchBall = new Ball();
				jp.add(pitchBall);
			}
		});
		
		JButton swing = new JButton("Swing");
		if(!pitched) {
			swing.setEnabled(false);
		}
		swing.setSize(100, 50);
		swing.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Swing!");
			}
		});
		
		jp.add(throwPitch, BorderLayout.NORTH);
		jp.add(swing, BorderLayout.SOUTH);
		
		jf.setVisible(true);
		return jf;
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
		MainWindow mw = new MainWindow();
	}


}
