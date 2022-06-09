package MementoDP;

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
import MementoDP.Originator.Memento;
import graphics.IDrawable;
import graphics.ZooPanel;


/**
 * This class is the GUI that the user will interact
 *  with to try to restore a previous state
 * 
 */
public class MementoGUI extends JFrame {
	public MementoGUI(ArrayList<Memento> memList,Originator org, ZooPanel zp) {

		this.setTitle("Restore");
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

		Memento[] array = memList.toArray(new Memento[0]);   
		JComboBox cb1 = new JComboBox(array);
		cb1.setFont(new Font("San Francisco", Font.PLAIN, 18));

		JButton bt = new JButton("Submit");
		bt.setBackground(new Color(59, 89, 182));
		bt.setForeground(Color.WHITE);
		bt.setFocusPainted(false);
		bt.setFont(new Font("Tahoma", Font.BOLD, 12));
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int x = cb1.getSelectedIndex();
				Memento m = memList.get(x);
				memList.remove(x);
				org.restore(m);
				zp.setPanelDrawing(org.Animals, org.Food);
				if (m.getBg() == 1)
					zp.ChangeBackgroudToImage();
				else if (m.getBg() == 2)
					zp.ChangeBackgroudToGreen();
				zp.repaint();
				dispose();
			}
		});

		this.add(cb1);
		this.add(bt);

	}
}
