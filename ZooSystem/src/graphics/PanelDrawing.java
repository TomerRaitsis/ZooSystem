 /**
    * @author 
    * Tomer Raitsis 316160167
    * SCE, Ashdod
    *    
    */
package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import animals.Animal;
import animals.Lion;
import food.IEdible;
import mobility.Point;
import plants.Cabbage;
import plants.Lettuce;

/**
 *  A panel that used to draw animals, food or the background on it
 * 
 * @version 1.0
 */
public class PanelDrawing extends JPanel {

	private BufferedImage imgSce = null;
	private ArrayList<Animal> Animals = null;
	private IEdible food;

	/**
	 *  A Ctor that doesnt get anything
	 * 
	 * @version 1.0
	 * 
	 */
	public PanelDrawing() {
		super();
	}

	/**
	 *  A Ctor that gets an animals (ArrayList) and a food (IEdible)
	 * 
	 * @version 1.0
	 * 
	 * @param a - ArrayList, food - IEdible
	 */
	public PanelDrawing(ArrayList<Animal> a, IEdible food) {
		super();
		Animals = a;
	}

	/**
	 *  An override to paintComponent, used to paint all the objects and background uses 
	 * paintAnimal method 
	 * 
	 * @version 1.0
	 * 
	 * @param g - Graphics 

	 * @see paintAnimal
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D gr = (Graphics2D) g;
		gr.drawImage(imgSce, 0, 0, this.getWidth(), this.getHeight(), null);
		paintAnimal(gr, food);
	}

	/**
	 *  A method to draw food and animals on the screen, used in paintComponent
	 * 
	 * @version 1.0
	 * 
	 * @param g - Graphics , f - IEdible
	 * 
	 * @see paintComponent
	 */
	public void paintAnimal(Graphics g, IEdible f) {
		if (Animals != null) {
			for (int i = 0; i < Animals.size(); i++) {
				Animals.get(i).loadImages(Animals.get(i).getColor());
				Animals.get(i).drawObject(g);
			}
		}

		this.food = f;
		if (food != null) {
			if (food instanceof Lettuce) {
				((Lettuce) food).setLocation(new Point(this.getWidth() / 2, this.getHeight() / 2));
				((Lettuce) food).drawObject(g);
			} else if (food instanceof Cabbage) {
				((Cabbage) food).setLocation(new Point(this.getWidth() / 2, this.getHeight() / 2));
				((Cabbage) food).drawObject(g);
			} else {
				try {
					g.drawImage(
							ImageIO.read(new File(IDrawable.PICTURE_PATH + "meat.gif")),
							((int) this.getWidth() / 2) - 20 / 2 , ((int) this.getHeight() / 2) - 20 / 2 , 20, 20, this);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 *  A method that sets the image fo the background
	 * 
	 * @version 1.0
	 * 
	 * @param i - BufferedImage
	 * 
	 */
	public void setImage(BufferedImage i) {
		imgSce = i;
	}

}
