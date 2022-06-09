package DecoratorAnimalColor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import animals.Animal;
import animals.Lion;
import graphics.IDrawable;

/**
 * This class is for the user interface, the user will choose the color and the animal
 * and its color will be changed to the chosen one in the menu (Natural,Blue,Red)
 * 
 * @version 1.0
 * 
 */

public class ChangeColorGUI extends JFrame {
	public ChangeColorGUI(ArrayList<Animal> Animals) {

		this.setTitle("Color Changing");
		this.setLayout(new GridLayout(3, 1, 0, 20));
		this.setSize(new Dimension(305, 205));
		this.getContentPane().setBackground(Color.DARK_GRAY);
		this.setLocationRelativeTo(getParent());
		try {
			this.setIconImage(ImageIO.read(new File(IDrawable.PICTURE_PATH + "zoo.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setVisible(true);

		Animal[] array = Animals.toArray(new Animal[0]);
		JComboBox cb1 = new JComboBox(array);
		cb1.setFont(new Font("San Francisco", Font.PLAIN, 18));

		String[] Colors = { "Natural", "Blue", "Red" };
		JComboBox cb2 = new JComboBox(Colors);

		JButton bt = new JButton("Submit");
		bt.setBackground(new Color(59, 89, 182));
		bt.setForeground(Color.WHITE);
		bt.setFocusPainted(false);
		bt.setFont(new Font("Tahoma", Font.BOLD, 12));
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String col = Colors[cb2.getSelectedIndex()];
				Animal a = (Animal) Animals.get(cb1.getSelectedIndex());
				
				if (col.equals("Natural"))
					new ChangeColorToNatural(a);
				else if(col.equals("Blue"))
					new ChangeColorToBlue(a);
				else
					new ChangeColorToRed(a);
				a.getPan().repaint();
				dispose();
			}
		});

		this.add(cb1);
		this.add(cb2);
		this.add(bt);

	}
}
