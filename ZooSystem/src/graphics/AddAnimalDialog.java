 /**
    * @author 
    * Tomer Raitsis 316160167
    * SCE, Ashdod
    *    
    */
package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.lang.Object;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import animals.Animal;
import animals.Bear;
import animals.Elephant;
import animals.Giraffe;
import animals.Lion;
import animals.Turtle;

/**
 * A dialog for creating a new animal, the user will pick a type, name (or
 * default will be used) ,size (pixels), vertical speed, horizontal speed and a
 * color. there are restrictions to follow and an "Enter" must be used to sumbit
 * a field, only at the end the submit will be available
 * 
 * @version 1.0
 */
public class AddAnimalDialog extends JDialog {
	Animal a;

	/**
	 * A ctor, gets the animals ArrayList and the zoo-panel itself, builds the
	 * dialog window and showing it.
	 * 
	 * @version 1.0
	 * 
	 * @param Animals - ArrayList<Animal>, zp - ZooPanel
	 */
	public AddAnimalDialog(ArrayList<Animal> Animals, ZooPanel zp) {
		super();
		this.setTitle("Add Animal Dialog");
		this.setLayout(new GridLayout(8, 1, 0, 20));
		this.setSize(new Dimension(500, 400));
		this.getContentPane().setBackground(Color.DARK_GRAY);
		this.setLocationRelativeTo(zp);
		try {
			this.setIconImage(ImageIO.read(new File(IDrawable.PICTURE_PATH + "zoo.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setVisible(true);

		String animalNames[] = { "Please choose an animal", "Lion", "Bear", "Elephant", "Giraffe", "Turtle" };
		JComboBox cb1 = new JComboBox(animalNames);
		cb1.setFont(new Font("San Francisco", Font.PLAIN, 18));
		cb1.setBounds(0, 0, 100, 100);

		JTextField tf = new JTextField("Please choose an animal size (in pixels), must be between 50-300.");
		tf.setFont(new Font("San Francisco", Font.PLAIN, 18));

		JTextField tf2 = new JTextField("Please choose a name (or a default one will be asigned)");
		tf2.setFont(new Font("San Francisco", Font.PLAIN, 18));

		showMessageDialog Err = new showMessageDialog();
		Err.setTitle("Error");
		JButton but = new JButton("OK");
		but.setBounds(150, 110, 100, 30);
		but.setBackground(new Color(59, 89, 182));
		but.setForeground(Color.WHITE);
		but.setFocusPainted(false);
		but.setFont(new Font("Tahoma", Font.BOLD, 12));
		but.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Err.setVisible(false);
			}
		});
		JLabel lab1 = new JLabel();
		lab1.setOpaque(false);
		lab1.setForeground(Color.white);
		lab1.setBounds(105, 40, 300, 20);
		lab1.setFont(new Font("San Francisco", Font.PLAIN, 18));
		Err.add(lab1);
		Err.add(but);

		JButton but1 = new JButton("Submit");
		but1.setEnabled(false);
		but1.setBackground(new Color(59, 89, 182));
		but1.setForeground(Color.WHITE);
		but1.setFocusPainted(false);
		but1.setFont(new Font("Tahoma", Font.BOLD, 12));

		tf2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (tf2.getText().equals("")) {
					tf2.setForeground(Color.black);
					tf2.setBackground(Color.RED);
				} else {
					tf2.setForeground(Color.green);
					tf2.setBackground(Color.WHITE);
				}
			}
		});

		cb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!((String) cb1.getSelectedItem()).equals("Please choose an animal")) {
					tf.setForeground(Color.black);
					tf.setBackground(Color.RED);
					tf.setText("Insert " + cb1.getSelectedItem() + "'s size (in pixels)" + ",Press enter when done!");
				} else
					tf.setText((String) cb1.getSelectedItem());
			}
		});
		tf.setOpaque(true);
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int i = Integer.parseInt(tf.getText());
					if (i <= 300 && i >= 50) {
						tf.setForeground(Color.green);
						tf.setBackground(Color.WHITE);
						but1.setEnabled(true);
					} else {
						lab1.setText("Your choice must be between 50-300!!");
						tf.setForeground(Color.black);
						tf.setBackground(Color.RED);
						but1.setEnabled(false);
						Err.setVisible(true);
					}
				} catch (NumberFormatException ex) {
					lab1.setText("Your choice must be an 'int' number!!");
					tf.setForeground(Color.black);
					tf.setBackground(Color.RED);
					but1.setEnabled(false);
					Err.setVisible(true);
				}

			}
		});

		String HorizontalSpeed[] = { "Please choose an Horizontal Speed", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10" };
		JComboBox cb2 = new JComboBox(HorizontalSpeed);

		cb2.setFont(new Font("San Francisco", Font.PLAIN, 18));
		cb2.setBounds(0, 0, 100, 100);

		String VerticalSpeed[] = { "Please choose an Vertical Speed", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10" };
		JComboBox cb3 = new JComboBox(VerticalSpeed);

		cb3.setFont(new Font("San Francisco", Font.PLAIN, 18));
		cb3.setBounds(0, 0, 100, 100);

		String animalcolors[] = { "Please choose an Animal color", "Natural", "Red", "Blue" };
		JComboBox cb4 = new JComboBox(animalcolors);

		cb4.setFont(new Font("San Francisco", Font.PLAIN, 18));
		cb3.setBounds(0, 0, 100, 100);

		JLabel lab = new JLabel("Please Fill The Next Sections:");
		lab.setFont(new Font("San Francisco", Font.PLAIN, 18));
		lab.setForeground(Color.white);
		lab.setBackground(Color.DARK_GRAY);
		lab.setOpaque(true);
		lab.setHorizontalAlignment(SwingConstants.CENTER);

		but1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!(((String) cb1.getSelectedItem()).equals("Please choose an animal")
						|| ((String) cb2.getSelectedItem()).equals("Please choose an Horizontal Speed")
						|| ((String) cb3.getSelectedItem()).equals("Please choose an Vertical Speed")
						|| ((String) cb4.getSelectedItem()).equals("Please choose an Animal color"))) {
					if (!tf2.getText().equals("")) {
						Color c = null;
						String colors = cb4.getSelectedItem().toString();
						switch (colors) {
						case "Natural":
							c = null;
							break;
						case "Blue":
							c = Color.blue;
							break;
						case "Red":
							c = Color.red;
							break;
						}
						boolean check = (tf2.getText().equals("Please choose a name (or a default one will be asigned)")
								|| tf2.getText().equals(""));
						String name;
						String s = cb1.getSelectedItem().toString();
						setVisible(false);
						switch (s) {
						case "Lion":
							if (check)
								name = "Lion";
							else
								name = tf2.getText();
							a = new Lion(name, Integer.parseInt(tf.getText()),
									Integer.parseInt(cb2.getSelectedItem().toString()),
									Integer.parseInt(cb3.getSelectedItem().toString()), c,zp);
							break;
						case "Bear":
							if (check)
								name = "Bear";
							else
								name = tf2.getText();
							a = new Bear(name, Integer.parseInt(tf.getText()),
									Integer.parseInt(cb2.getSelectedItem().toString()),
									Integer.parseInt(cb3.getSelectedItem().toString()), c,zp);
							break;
						case "Elephant":
							if (check)
								name = "Elephant";
							else
								name = tf2.getText();
							a = new Elephant(name, Integer.parseInt(tf.getText()),
									Integer.parseInt(cb2.getSelectedItem().toString()),
									Integer.parseInt(cb3.getSelectedItem().toString()), c,zp);
							break;
						case "Giraffe":
							if (check)
								name = "Giraffe";
							else
								name = tf2.getText();
							a = new Giraffe(name, Integer.parseInt(tf.getText()),
									Integer.parseInt(cb2.getSelectedItem().toString()),
									Integer.parseInt(cb3.getSelectedItem().toString()), c,zp);
							break;
						case "Turtle":
							if (check)
								name = "Turtle";
							else
								name = tf2.getText();
							a = new Turtle(name, Integer.parseInt(tf.getText()),
									Integer.parseInt(cb2.getSelectedItem().toString()),
									Integer.parseInt(cb3.getSelectedItem().toString()), c,zp);
							break;
							
						}

						JFrame f = new JFrame();
						f.setLayout(new BorderLayout());
						try {
							f.setIconImage(ImageIO.read(new File(IDrawable.PICTURE_PATH + "zoo.png")));
						} catch (IOException e1) {

							e1.printStackTrace();
						}
						PanelDrawing pd = new PanelDrawing();
						a.loadImages(a.getColor());
						pd.setImage(a.getImg1());
						JButton bt = new JButton("OK");
						bt.setBackground(new Color(59, 89, 182));
						bt.setForeground(Color.WHITE);
						bt.setFocusPainted(false);
						bt.setFont(new Font("Tahoma", Font.BOLD, 12));
						bt.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								
								a.setChanges(true);
								//a.setPan(zp);
								Animals.add(a);
								zp.repaint();
								if (zp.CheckIfSuspended())
									a.setSuspended();
								a.setThread(new Thread(a));
								a.getThread().start();
								
								
								f.dispose();
								dispose();
							}
						});
						f.add(new JLabel("Please press OK to approve your choice...", JLabel.CENTER),
								BorderLayout.NORTH);
						f.add(pd, BorderLayout.CENTER);
						f.add(bt, BorderLayout.SOUTH);
						f.setPreferredSize(new Dimension(300, 300));
						f.setLocationRelativeTo(zp);
						f.pack();
						f.setVisible(true);

					}
				}
			}
		});

		this.add(lab);
		this.add(cb1);
		this.add(tf2);
		this.add(tf);
		this.add(cb2);
		this.add(cb3);
		this.add(cb4);
		this.add(but1);

	}
}
