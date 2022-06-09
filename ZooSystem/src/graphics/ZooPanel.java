/**
   * @author 
   * Tomer Raitsis
   * SCE, Ashdod
   *    
   */
package graphics;

import java.awt.BorderLayout;
import plants.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import DecoratorAnimalColor.ChangeColorGUI;
import MementoDP.MementoGUI;
import MementoDP.Originator;
import MementoDP.Originator.Memento;
import animals.Animal;
import food.IEdible;
import mobility.Point;

/**
 * A panel that is devided to 2 different panels that work together: 1. buttons
 * 2. screen to show the animals and background
 * 
 */
public class ZooPanel extends JPanel {

	private Originator originator = new Originator();
	private ArrayList<Memento> memList = new ArrayList<Memento>();

	// IEdible Food;
	PanelDrawing p = new PanelDrawing(getOriginator().Animals, getOriginator().Food);

	// private controller;
	private Controller cr = new Controller();

	// singelton implementation for ZooPanel
	private static ZooPanel ZooPanelOBJ = null;

	public static ZooPanel getInstance() {
		if (ZooPanelOBJ == null)
			ZooPanelOBJ = new ZooPanel();
		return ZooPanelOBJ;
	}


	public ArrayList<Animal> getAnimals() {
		return getOriginator().Animals;
	}

	/**
	 * A ctor, builds the two inner panels and sets the buttons
	 * 
	 * @version 1.0
	 * 
	 * @param
	 * 
	 * @return
	 * 
	 * @see
	 */
	private ZooPanel() {
		super();
		this.setLayout(new BorderLayout());

		showMessageDialog dial = new showMessageDialog();
		JButton b = new JButton("OK");
		b.setBounds(150, 100, 100, 20);
		b.setBackground(new Color(59, 89, 182));
		b.setForeground(Color.WHITE);
		JLabel lab1 = new JLabel();
		lab1.setForeground(Color.white);
		lab1.setBounds(120, 30, 220, 20);
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dial.setVisible(false);
			}
		});
		dial.add(b);
		dial.add(lab1);

		JPanel panel = new JPanel();
		JButton but1 = new JButton("Add");
		but1.setBackground(new Color(59, 89, 182));
		but1.setForeground(Color.WHITE);
		but1.setFocusPainted(false);
		but1.setFont(new Font("Tahoma", Font.BOLD, 12));
		but1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (getOriginator().Animals.size() < 15) {
					new AddAnimalDialog(getOriginator().Animals, getPan(), getOriginator().threadPoolExecutor, cr);
				} else {
					lab1.setText("You cannot add more animals");
					dial.setVisible(true);
				}

			}
		});

		JButton but2 = new JButton("Sleep");
		but2.setBackground(new Color(59, 89, 182));
		but2.setForeground(Color.WHITE);
		but2.setFocusPainted(false);
		but2.setFont(new Font("Tahoma", Font.BOLD, 12));
		but2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < getOriginator().Animals.size(); i++) {
					getOriginator().Animals.get(i).setSuspended();
				}
			}
		});

		JButton but7 = new JButton("Wake up");
		but7.setBackground(new Color(59, 89, 182));
		but7.setForeground(Color.WHITE);
		but7.setFocusPainted(false);
		but7.setFont(new Font("Tahoma", Font.BOLD, 12));
		but7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < getOriginator().Animals.size(); i++) {
					getOriginator().Animals.get(i).setResumed();

				}

			}
		});

		JButton but8 = new JButton("Change Color");
		but8.setBackground(new Color(59, 89, 182));
		but8.setForeground(Color.WHITE);
		but8.setFocusPainted(false);
		but8.setFont(new Font("Tahoma", Font.BOLD, 12));
		but8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (getOriginator().Animals.size() == 0)
					JOptionPane.showMessageDialog(null, "There are no Animals!", "Warning",
							JOptionPane.WARNING_MESSAGE);
				else {
					synchronized (this) {
						new ChangeColorGUI(getOriginator().Animals);
					}
				}
			}
		});

		JButton but9 = new JButton("Save");
		but9.setBackground(new Color(59, 89, 182));
		but9.setForeground(Color.WHITE);
		but9.setFocusPainted(false);
		but9.setFont(new Font("Tahoma", Font.BOLD, 12));
		but9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (memList.size() == 3)
					memList.remove(0);
				int bg = -1;
				if (p.getImage() != null)
					bg = 1;
				else if (p.getBackground() == Color.green)
					bg = 2;
				memList.add(getOriginator().save(bg, cr));
			}
		});

		JButton but10 = new JButton("Load");
		but10.setBackground(new Color(59, 89, 182));
		but10.setForeground(Color.WHITE);
		but10.setFocusPainted(false);
		but10.setFont(new Font("Tahoma", Font.BOLD, 12));
		but10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (memList.size() == 0)
					JOptionPane.showMessageDialog(null, "There are no saved states!", "Warning",
							JOptionPane.WARNING_MESSAGE);
				else
					new MementoGUI(memList, getOriginator(), getPan());

			}
		});

		JButton but3 = new JButton("Clear");
		but3.setBackground(new Color(59, 89, 182));
		but3.setForeground(Color.WHITE);
		but3.setFocusPainted(false);
		but3.setFont(new Font("Tahoma", Font.BOLD, 12));
		but3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < getOriginator().Animals.size(); i++) {
					getOriginator().Animals.get(i).shut();
				}
				getOriginator().threadPoolExecutor.shutdown();
				getOriginator().threadPoolExecutor = (ExecutorService) Executors.newFixedThreadPool(10);
				getOriginator().Animals.clear();
				repaint();

			}
		});

		JButton but4 = new JButton("Food");
		but4.setBackground(new Color(59, 89, 182));
		but4.setForeground(Color.WHITE);
		but4.setFocusPainted(false);
		but4.setFont(new Font("Tahoma", Font.BOLD, 12));

		JDialog FoodDialog = new JDialog();
		FoodDialog.setTitle("Food For Animal");
		FoodDialog.setLayout(new BorderLayout());
		FoodDialog.setSize(new Dimension(300, 170));
		FoodDialog.setLocationRelativeTo(null);
		FoodDialog.setResizable(false);
		try {
			FoodDialog.setIconImage(ImageIO.read(new File(IDrawable.PICTURE_PATH + "zoo.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FoodDialog.getContentPane().setBackground(Color.DARK_GRAY);
		JLabel Txt = new JLabel("Please choose food", SwingConstants.CENTER);
		Txt.setFont(new Font("San Francisco", Font.PLAIN, 16));
		Txt.setForeground(Color.white);
		Txt.setBackground(Color.DARK_GRAY);
		JPanel foods = new JPanel();
		foods.setLayout(new FlowLayout(FlowLayout.CENTER));
		foods.setBackground(Color.DARK_GRAY);
		JButton b1 = new JButton("Lettuce");
		b1.setFont(new Font("Tahoma", Font.BOLD, 12));
		b1.setBackground(new Color(59, 89, 182));
		b1.setForeground(Color.WHITE);
		b1.setFocusPainted(false);
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getOriginator().Food = Lettuce.getInstance();
				((Lettuce) getOriginator().Food).setLocation(new Point(p.getWidth() / 2, p.getHeight() / 2));
				FoodDialog.dispose();
				repaint();
				// manageZoo();
			}
		});
		JButton b2 = new JButton("Cabbage");
		b2.setFont(new Font("Tahoma", Font.BOLD, 12));
		b2.setBackground(new Color(59, 89, 182));
		b2.setForeground(Color.WHITE);
		b2.setFocusPainted(false);
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getOriginator().Food = Cabbage.getInstance();
				((Cabbage) getOriginator().Food).setLocation(new Point(p.getWidth() / 2, p.getHeight() / 2));
				FoodDialog.dispose();
				repaint();
			}
		});
		JButton b3 = new JButton("Meat");
		b3.setFont(new Font("Tahoma", Font.BOLD, 12));
		b3.setBackground(new Color(59, 89, 182));
		b3.setForeground(Color.WHITE);
		b3.setFocusPainted(false);
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				getOriginator().Food = meat.getInstance();
				FoodDialog.dispose();
				repaint();
			}
		});
		foods.add(b1);
		foods.add(b2);
		foods.add(b3);
		FoodDialog.add(foods, BorderLayout.SOUTH);
		FoodDialog.add(Txt, BorderLayout.CENTER);

		but4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FoodDialog.setVisible(true);
			}
		});

		JButton but5 = new JButton("Info");
		but5.setBackground(new Color(59, 89, 182));
		but5.setForeground(Color.WHITE);
		but5.setFocusPainted(false);
		but5.setFont(new Font("Tahoma", Font.BOLD, 12));
		but5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InfoTable window = new InfoTable(getOriginator().Animals);
				window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});

		JButton but6 = new JButton("Exit");
		but6.setBackground(new Color(59, 89, 182));
		but6.setForeground(Color.WHITE);
		but6.setFocusPainted(false);
		but6.setFont(new Font("Tahoma", Font.BOLD, 12));
		but6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < getOriginator().Animals.size(); i++) {
					getOriginator().Animals.get(i).shut();
				}
				getOriginator().threadPoolExecutor.shutdown();
				System.exit(0);
			}
		});

		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(new FlowLayout());// GridLayout(1, 8, 5, 5));
		panel.add(but1);
		panel.add(but8);
		panel.add(but3);
		panel.add(but2);
		panel.add(but7);
		panel.add(but4);
		panel.add(but9);
		panel.add(but10);
		panel.add(but5);
		panel.add(but6);
		this.add(panel, BorderLayout.SOUTH);
		p = new PanelDrawing(getOriginator().Animals, getOriginator().Food);
		p.setLayout(null);
		this.add(p, BorderLayout.CENTER);

	}

	/**
	 * A method to change the backround to green
	 * 
	 * @version 1.0
	 * 
	 */
	public void ChangeBackgroudToGreen() {
		p.setImage(null);
		this.p.setBackground(Color.green);

	}

	/**
	 * A method to change the backround to nothing
	 * 
	 * @version 1.0
	 * 
	 */
	public void ChangeBackgroudToNone() {
		p.setImage(null);
		this.p.setBackground(null);
	}

	/**
	 * A method to change the backround to an image (savvana in this case)
	 * 
	 * @version 1.0
	 */
	public void ChangeBackgroudToImage() {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(IDrawable.PICTURE_PATH + "savanna.png"));
		} catch (IOException e1) {
			System.out.println("Cannot load image");
		}
		this.p.setImage(img);
		this.p.setBackground(null);
	}

	/**
	 * A method to set this panel to it
	 * 
	 * @version 1.0
	 * 
	 * @param A - Animal
	 */
	public void setPan(Animal A) {
		A.setPan(this);
	}

	/**
	 * A method that returns this zoo panel
	 * 
	 * @version 1.0
	 * 
	 * @return ZooPanel
	 */
	public ZooPanel getPan() {
		return this;
	}

	public void setPanelDrawing(ArrayList<Animal> a, IEdible f) {

		this.remove(p);
		this.p = new PanelDrawing(a, f);
		p.setLayout(null);
		p.setBounds(0, 0, this.getWidth(), this.getHeight() - 35);
		this.add(p, BorderLayout.CENTER);

	}

	/**
	 * A method that checks if there's been a change in any animal
	 * 
	 * @version 1.0
	 * 
	 * @return True if changed, false if isn't
	 */
	public boolean isChange() {
		for (int i = 0; i < getOriginator().Animals.size(); i++) {
			if (getOriginator().Animals.get(i).getChanges()) {
				getOriginator().Animals.get(i).setChanges(false);
				return true;
			}
		}
		return false;
	}

	/**
	 * An override to paintComponent, shows the background, animals and food on the
	 * screen that shows the animals and background
	 * 
	 * @version 1.0
	 * 
	 * @param g - Graphics
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		p.repaint();
		p.paintAnimal(g, getOriginator().Food);
	}

	/**
	 * A method that checks is the animal are suspended or not
	 * 
	 * @version 1.0
	 * 
	 * @return true if suspended, false if not
	 */
	public synchronized boolean CheckIfSuspended() {
		for (int i = 0; i < getOriginator().Animals.size(); i++) {
			if (getOriginator().Animals.get(i).isTreadSuspended())
				return true;
		}
		return false;
	}


	/**
	 * A method that returns the originator.
	 * 
	 * @version 1.0
	 * 
	 * @return Originator object of this class
	 */
	public Originator getOriginator() {
		return originator;
	}


}
