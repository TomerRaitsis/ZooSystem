/**
   * @author 
   * Tomer Raitsis
   * SCE, Ashdod
   *    
   */
package animals;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import diet.Omnivore;
import food.EFoodType;
import food.IEdible;
import graphics.IDrawable;
import graphics.ZooPanel;
import mobility.Point;


/**
 * A class that represents a Bear, it extends RoarAnimal has 1 attribute:
 * furColor - a String for a fur color.
 * 
 * @version 1.0
 */
public class Bear extends RoarAnimal {

	private String furColor;

	/**
	 * A Ctor, uses the super Ctor(Animals), sets a default weight, Omnivore diet
	 * and a gray fur color.
	 * 
	 * @version 1.0
	 * 
	 * @param s - String of animals name, p - default point.
	 */
	public Bear(String s, Point p) {
		super(s, p);
		this.setWeight(308.2);
		this.setFurColor("GRAY");
		this.setDiet(new Omnivore());
	}

	@Override
	public synchronized IEdible clone()  {
		Animal temp = new Bear(this.getName(),this.getSize(),this.getHorSpeed(),this.getVerSpeed(),this.getCol(),this.getPan());
		temp.setWeight(getWeight());
		temp.setLocation(getLocation());
		temp.setEatCount(getEatCount());
		temp.setX_dir(getX_dir());
		temp.setY_dir(getY_dir());
		return temp;
	}

	public Bear(String s, int size, int horSpeed, int verSpeed, Color col, ZooPanel zp) {
		this(s, new Point(100, 5));
		this.setSize(size);
		this.setHorSpeed(horSpeed);
		this.setVerSpeed(verSpeed);
		this.setCol(col);
		this.setWeight(size * 1.5);
		this.setPan(zp);
		this.loadImages(getColor());
	}

	/**
	 * Another Ctor, Gets only name. sets the point to the Bears default
	 * 
	 * @version 1.0
	 * 
	 * @param s - String of animals name
	 */
	public Bear(String s) {
		this(s, new Point(100, 5));
	}

	/**
	 * Another Ctor, Gets a name and fur color. sets the point to the Bears default
	 * and the fur color to the parameter
	 * 
	 * @version 1.0
	 * 
	 * @param s - String of animals name, string - fur color
	 * 
	 */
	public Bear(String s, String string) {
		super(s, new Point(100, 5));
		this.setWeight(308.2);
		this.setFurColor(string);
		this.setDiet(new Omnivore());
	}

	/**
	 * A method to get the bear's type of food (MEAT)
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return EFoodType of it's food type
	 */
	@Override
	public EFoodType getFoodtype() {
		return EFoodType.MEAT;
	}

	/**
	 * A method to get the fur color
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 */
	public String getFurColor() {
		return furColor;
	}

	/**
	 * A method to set the fur color
	 * 
	 * @version 1.0
	 * 
	 * @param furColor - fur color, must be black/white/gray
	 * 
	 * @return true if the color is valid, false if it does'nt (gray would be
	 *         initialized instead)
	 */
	public boolean setFurColor(String furColor) {
		boolean isSuccess = furColor.equals("BLACK") || furColor.equals("WHITE") || furColor.equals("GRAY");
		if (isSuccess) {
			this.furColor = furColor;
		} else {
			this.setFurColor("GRAY");
		}
		return isSuccess;
	}

	/**
	 * An method that prints the bear's sound.
	 * 
	 * @version 1.0
	 *
	 * @param None
	 * 
	 * @return None (void)
	 */
	public void roar() {
	}

	@Override
	public boolean equals(Object o) {
		Bear b = null;
		if (super.equals(o)) {
			if (o instanceof Bear) {
				b = (Bear) o;
				return this.getFurColor() == b.getFurColor();
			} else
				return false;
		} else
			return false;

	}

	@Override
	public void loadImages(String nm) {
		String c = nm;
		try {
			switch (c) {
			case "Natural":
				this.setImg1(ImageIO.read(new File(IDrawable.PICTURE_PATH + "bea_n_1.png")));
				this.setImg2(ImageIO.read(new File(IDrawable.PICTURE_PATH + "bea_n_2.png")));
				break;
			case "Blue":
				this.setImg1(ImageIO.read(new File(IDrawable.PICTURE_PATH + "bea_b_1.png")));
				this.setImg2(ImageIO.read(new File(IDrawable.PICTURE_PATH + "bea_b_2.png")));
				break;
			case "Red":
				this.setImg1(ImageIO.read(new File(IDrawable.PICTURE_PATH + "bea_r_1.png")));
				this.setImg2(ImageIO.read(new File(IDrawable.PICTURE_PATH + "bea_r_2.png")));
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getAnimalName() {
		return this.getClass().getSimpleName();
	}

}
