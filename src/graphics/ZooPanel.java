/**
   * @author 
   * Tomer Raitsis 316160167
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
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import animals.Animal;
import animals.Bear;
import animals.Lion;
import animals.Turtle;
import food.EFoodType;
import food.IEdible;
import mobility.Point;
import plants.Plant;

/**
 * A panel that is devided to 2 different panels that work together: 1. buttons
 * 2. screen to show the animals and background
 * 
 */
public class ZooPanel extends JPanel implements Runnable {

	private ArrayList<Animal> Animals = new ArrayList<Animal>();

	JTable table = new JTable();
	IEdible Food;
	PanelDrawing p = new PanelDrawing(Animals, Food);
	private Thread controller;

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
	public ZooPanel() {
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
		JButton but1 = new JButton("Add Animal");
		but1.setBackground(new Color(59, 89, 182));
		but1.setForeground(Color.WHITE);
		but1.setFocusPainted(false);
		but1.setFont(new Font("Tahoma", Font.BOLD, 12));
		but1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Animals.size() < 10) {
					int size = Animals.size();
					new AddAnimalDialog(Animals, getPan());
				} else {
					lab1.setText("You cannot add more than 10 animals");
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
				for (int i = 0; i < Animals.size(); i++) {
					Animals.get(i).setSuspended();
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
				for (int i = 0; i < Animals.size(); i++) {
					Animals.get(i).setResumed();

				}

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
				for (int i = 0; i < Animals.size(); i++) {
					Animals.get(i).shut();
				}
				Animals.clear();
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
				Food = new Lettuce();
				((Lettuce) Food).setLocation(new Point(p.getWidth() / 2, p.getHeight() / 2));
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
				Food = new Cabbage();
				((Cabbage) Food).setLocation(new Point(p.getWidth() / 2, p.getHeight() / 2));
				FoodDialog.dispose();
				;
				repaint();
				// manageZoo();
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
				IEdible meat = new IEdible() {
					public EFoodType getFoodtype() {
						return EFoodType.MEAT;
					}
				};
				Food = meat;
				FoodDialog.dispose();
				;
				repaint();
				// manageZoo();
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
				InfoTable window = new InfoTable(Animals);
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
				for (int i = 0; i < Animals.size(); i++) {
					Animals.get(i).shut();
				}
				System.exit(0);
			}
		});

		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(new GridLayout(1, 7, 10, 5));
		panel.add(but1);
		panel.add(but2);
		panel.add(but7);
		panel.add(but3);
		panel.add(but4);
		panel.add(but5);
		panel.add(but6);
		this.add(panel, BorderLayout.SOUTH);
		p = new PanelDrawing(Animals, Food);
		p.setLayout(null);
		this.add(p, BorderLayout.CENTER);

		this.controller = new Thread(this);
		this.controller.start();
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

	/**
	 * A method that checks if there's been a change in any animal
	 * 
	 * @version 1.0
	 * 
	 * @return True if changed, false if isn't
	 */
	public boolean isChange() {
		for (int i = 0; i < Animals.size(); i++) {
			if (Animals.get(i).getChanges()) {
				Animals.get(i).setChanges(false);
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
		p.paintAnimal(g, Food);
	}

	/**
	 * A method that checks is the animal are suspended or not
	 * 
	 * @version 1.0
	 * 
	 * @return true if suspended, false if not
	 */
	public synchronized boolean CheckIfSuspended() {
		for (int i = 0; i < Animals.size(); i++) {
			if (Animals.get(i).isTreadSuspended())
				return true;
		}
		return false;
	}

	/**
	 * A run method, for the controller, this thread starts to run at the end of the Ctor
	 * 
	 * Checks if there are any animals that can eat each other, or if an animal eats the
	 * food at the center (if not the animal will keep moving) and it will move to it until 
	 * it is close enough to eat it or another animal ate ot first 
	 * 
	 * @version 1.0
	 * 
	 */
	@Override
	public void run() {
		while (true) {
			if (!CheckIfSuspended()) {
				boolean c = false;

				if (isChange())
						this.repaint();
				
				for (int i = 0; i < Animals.size(); i++) {
					Animal a = Animals.get(i);

					for (int j = 0; j < Animals.size(); j++) {
						Animal b = Animals.get(j);

						if (a != b) {
							if (a.getWeight() > (2 * b.getWeight())) {
								if (a.calcDistance(b.getLocation()) < b.getSize()) {
											if (a.eat(b)) {
												a.eatInc();
												b.shut();
												Animals.remove(b);
												c = true;
												break;
											}
								}
							}
						}
					}
					if (c)
						break;

				}
				
				if (Food != null) {
					
					for (int i = 0; i < Animals.size(); i++) {
						Animal a = Animals.get(i);
						
							if (a.getDiet().canEat(Food.getFoodtype())) {
								a.setToCenter();
								if (Math.abs(a.getLocation().GetX() - (400)) <= a.getEAT_DISTANCE()
										&& Math.abs(a.getLocation().GetY() - (300)) <= a.getEAT_DISTANCE()) {

									if (a.eat(Food)) {
										a.eatInc();

										a.setbackX();
										a.setY_dir(1);

										
										for (int j = 0; j < Animals.size(); j++) {
											Animal d = Animals.get(j);
											if (i != j && d.getDiet().canEat(Food.getFoodtype())) {
												d.setbackX();
												d.setY_dir(-1);
											} 
										}
										Food = null;
										break;
									}
								}
							} else {
								if (!a.getFlag().get()) {
									a.setFlag(true);
									a.setY_dir(1);
								}
							}
						
					}
				}
				
			}
		}
	}
}
