 /**
    * @author 
    * Tomer Raitsis 316160167
    * SCE, Ashdod
    *    
    */
package graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *  The main frame, this class holds the main method.
 *  extends JFrame and implements ActionListener.
 * 
 */
public class ZooFrame extends JFrame implements ActionListener {
	private JMenuBar mb;
	private JMenu File;
	private JMenuItem Exit;
	private JMenu Background;
	private JMenuItem Image;
	private JMenuItem Green;
	private JMenuItem None;
	private showMessageDialog dial;
	private JMenu Help;
	private JMenuItem help;
	private JButton b;
	private JLabel lab1;
	
	private ZooPanel panel;

	/**
	 *  A Ctor that makes the frame with all it's features and presents it.
	 * 
	 * @version 1.0
	 * 
	 */
	public ZooFrame() {
		super("Zoo");
		try {
			this.setIconImage(ImageIO.read(new File(IDrawable.PICTURE_PATH + "zoo.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		mb = new JMenuBar();
		mb.setBackground(new Color(59, 89, 182));

		File = new JMenu("File");
		Exit = new JMenuItem("Exit");
		Exit.addActionListener(this);

		File.add(Exit);

		
		Background = new JMenu("Background");
		Image = new JMenuItem("Image");
		Image.addActionListener(this);

		Green = new JMenuItem("Green");
		Green.addActionListener(this);

		None = new JMenuItem("None");
		None.addActionListener(this);

		Background.add(Image);
		Background.add(Green);
		Background.add(None);

		
		dial = new showMessageDialog();
		b = new JButton("OK");
		b.setBounds(150, 100, 100, 20);
		b.setBackground(new Color(59, 89, 182));
		b.setForeground(Color.WHITE);
		b.addActionListener(this);
		
		lab1 = new JLabel();
		lab1.setBounds(140, 20, 120, 20);
		lab1.setText("Home Work 2 - GUI");
		lab1.setOpaque(false);
		lab1.setForeground(Color.white);
		lab1.setHorizontalTextPosition(JLabel.RIGHT);

		dial.add(b);
		dial.add(lab1);
		
		
		Help = new JMenu("Help");
		help = new JMenuItem("Help");
		help.addActionListener(this);

		Help.add(help);


		mb.add(File);
		mb.add(Background);
		mb.add(Help);

		this.setJMenuBar(mb);
		panel = new ZooPanel();
		this.add(panel);
		
		this.setSize(800, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	/**
	 *  A override to actionperformed to add actions to buttons 
	 * 
	 * @version 1.0
	 * 
	 * @param 
	 * 
	 * @return 
	 * 
	 * @see
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Exit) // Exit program
			System.exit(0);
		
		if (e.getSource() == Image) // Change backgroud to the savvana image
			panel.ChangeBackgroudToImage();
		
		if (e.getSource() == Green) // Change backgroud color to green
			panel.ChangeBackgroudToGreen();
		
		if (e.getSource() == None) // Change backgroud color to none (no color)
			panel.ChangeBackgroudToNone();
		
		if (e.getSource() == help) // show help window
			dial.setVisible(true);
		
		if (e.getSource() == b) // hide help window
			dial.setVisible(false);
	}
	

	/**
	 *  Main method, builds a zoo frame
	 * 
	 * @version 1.0
	 */
	public static void main(String[] args) {
		new ZooFrame();
	}

}
