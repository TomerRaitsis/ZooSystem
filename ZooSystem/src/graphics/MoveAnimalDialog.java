 /**
    * @author 
    * Tomer Raitsis 316160167
    * SCE, Ashdod
    *    
    */
package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import mobility.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import animals.Animal;
import animals.Bear;
import animals.Lion;
import animals.Turtle;

/**
 * A dialog to move an animal accros the screen, an "Enter" needs to be pressed
 * after every input before the submit button.
 * 
 * The animal will be chosen by it's name and the picture will be displayed next
 * to it.
 * 
 * @version 1.0
 * 
 */
public class MoveAnimalDialog extends JDialog {

	boolean validX = false;
	boolean validY = false;

	/**
	 * A ctor, gets the animals ArrayList and the zoo-panel itself, builds the
	 * dialog window and showing it.
	 * 
	 * @version 1.0
	 * 
	 * @param Animals - ArrayList<Animal>, zp - ZooPanel
	 * 
	 */
	public MoveAnimalDialog(ArrayList<Animal> a, ZooPanel zp) {
		super();
		this.setTitle("Move Animal Dialog");
		this.setLayout(new GridLayout(6, 1, 0, 20));
		this.setSize(new Dimension(400, 500));
		this.getContentPane().setBackground(Color.DARK_GRAY);
		this.setLocationRelativeTo(getParent());
		try {
			this.setIconImage(ImageIO.read(new File(IDrawable.PICTURE_PATH + "zoo.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setVisible(true);

		PanelDrawing pd = new PanelDrawing();
		pd.setPreferredSize(new Dimension(200,200));

		Animal[] array2 = a.toArray(new Animal[0]);
		JComboBox cb1 = new JComboBox(array2);
		cb1.setFont(new Font("San Francisco", Font.PLAIN, 18));
		cb1.setBounds(0, 0, 200, 100);
		cb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				a.get(cb1.getSelectedIndex()).loadImages(a.get(cb1.getSelectedIndex()).getColor());
				pd.setImage(a.get(cb1.getSelectedIndex()).getImg1());
				pd.repaint();
			}

		});
		JTextField tf = new JTextField("Please choose the animal's X cordinate");
		tf.setFont(new Font("San Francisco", Font.PLAIN, 15));
		tf.setSize(new Dimension(100, 100));
		JTextField sf = new JTextField(tf.getText());
		sf.setFont(new Font("San Francisco", Font.PLAIN, 15));
		sf.setEnabled(false);
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 1, 5, 0));
		p.add(tf);
		p.add(sf);

		JTextField tf2 = new JTextField("Please choose the animal's Y cordinate");
		tf2.setFont(new Font("San Francisco", Font.PLAIN, 15));
		JTextField sf2 = new JTextField(tf2.getText());
		sf2.setFont(new Font("San Francisco", Font.PLAIN, 15));
		sf2.setEnabled(false);
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(2, 1, 5, 0));
		p2.add(tf2);
		p2.add(sf2);

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
		lab1.setForeground(Color.white);
		lab1.setBounds(120, 30, 300, 20);
		lab1.setFont(new Font("San Francisco", Font.PLAIN, 16));
		Err.add(lab1);
		Err.add(but);

		JButton but1 = new JButton("Submit");
		but1.setEnabled(false);
		but1.setBackground(new Color(59, 89, 182));
		but1.setForeground(Color.WHITE);
		but1.setFocusPainted(false);
		but1.setFont(new Font("Tahoma", Font.BOLD, 12));

		tf.setOpaque(true);
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sf.setText("You Chose: " + tf.getText());
				try {
					int i = Integer.parseInt(tf.getText());
					if (i <= 800 && i >= 0) {
						sf.setForeground(Color.white);
						sf.setBackground(Color.blue);
						validX = true;
						if (validY)
							but1.setEnabled(true);
					} else {
						lab1.setText("Your choice must be between 0-800!!");
						sf.setForeground(Color.white);
						sf.setBackground(Color.RED);
						validX = false;
						but1.setEnabled(false);
						Err.setVisible(true);
					}
				} catch (NumberFormatException ex) {
					lab1.setText("Your choice must be an 'int' number!!");
					sf.setForeground(Color.white);
					sf.setBackground(Color.RED);
					validX = false;
					but1.setEnabled(false);
					Err.setVisible(true);
				}

			}
		});

		tf2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sf2.setText("You Chose: " + tf2.getText());
				try {
					int i = Integer.parseInt(tf2.getText());
					if (i <= 600 && i >= 0) {
						sf2.setForeground(Color.black);
						sf2.setBackground(Color.blue);
						validY = true;
						if (validX)
							but1.setEnabled(true);
					} else {
						lab1.setText("Your choice must be between 0-600!!");
						sf2.setForeground(Color.black);
						sf2.setBackground(Color.RED);
						validY = false;
						but1.setEnabled(false);
						Err.setVisible(true);
					}
				} catch (NumberFormatException ex) {
					lab1.setText("Your choice must be an 'int' number!!");
					sf2.setForeground(Color.black);
					sf2.setBackground(Color.RED);
					validY = false;
					but1.setEnabled(false);
					Err.setVisible(true);
				}

			}
		});

		JLabel lab = new JLabel("Please Fill The Next Sections:");
		lab.setFont(new Font("San Francisco", Font.PLAIN, 18));
		lab.setForeground(Color.white);
		lab.setBackground(Color.DARK_GRAY);
		lab.setOpaque(true);
		lab.setHorizontalAlignment(SwingConstants.CENTER);

		but1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				a.get(cb1.getSelectedIndex())
						.move(new Point(Integer.parseInt(tf.getText()), Integer.parseInt(tf2.getText())));
				a.get(cb1.getSelectedIndex()).setChanges(true);
				zp.manageZoo();
				setVisible(false);
			}
		});
		JPanel pl = new JPanel();
		pl.setLayout(null);
		a.get(cb1.getSelectedIndex()).loadImages(a.get(cb1.getSelectedIndex()).getColor());
		pd.setImage(a.get(cb1.getSelectedIndex()).getImg1());
		cb1.setBounds(0,0,200,60);
		pd.setBounds(250, 0, 100, 60);
		pl.add(cb1);
		pl.add(pd);

		this.add(lab);
		this.add(pl);
		this.add(p);
		this.add(p2);
		this.add(but1);
	}
}
