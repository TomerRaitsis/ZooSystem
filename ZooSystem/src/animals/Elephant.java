/**
   * @author 
   * Tomer Raitsis 316160167
   * SCE, Ashdod
   *    
   */
package animals;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import diet.Herbivore;
import food.EFoodType;
import graphics.IDrawable;
import mobility.Point;
import utilities.MessageUtility;

/**
 * A class that represents an Elephant, it extends ChewAnimal has 1 attribute:
 * trunkLength - a int for a trunk length.
 * 
 * @version 1.0
 */
public class Elephant extends ChewAnimal {

	private double trunkLength;

	/**
	 * A Ctor, uses the super Ctor(Animals), sets a default weight, Herbivore diet
	 * and a trunk length = 1.
	 * 
	 * @version 1.0
	 * 
	 * @param s - String of animals name, p - default point.
	 */
	public Elephant(String s, Point p) {
		super(s, p);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), s);
		this.setWeight(500);
		this.settrunkLength(1);
		this.setDiet(new Herbivore());
	}

	public Elephant(String s, int size, int horSpeed, int verSpeed, Color col) {
		this(s, new Point(50, 90));
		this.setSize(size);
		this.setHorSpeed(horSpeed);
		this.setVerSpeed(verSpeed);
		this.setCol(col);
		this.setWeight(size * 10);
	}

	/**
	 * Another Ctor, Gets only name. sets the point to the Elephants default
	 * 
	 * @version 1.0
	 * 
	 * @param s - String of animals name
	 */
	public Elephant(String s) {
		this(s, new Point(50, 90));
	}

	/**
	 * Another Ctor, Gets a name and trunk lengh. sets the point to the Elephants
	 * default and the trunk lengh to the parameter
	 * 
	 * @version 1.0
	 * 
	 * @param s - String of animals name, i - int trunck lengh
	 */
	public Elephant(String s, int i) {
		super(s, new Point(50, 90));
		MessageUtility.logConstractor(this.getClass().getSimpleName(), s);
		this.setWeight(500);
		this.settrunkLength(i);
		this.setDiet(new Herbivore());
	}

	/**
	 * A method to get the Elephant's type of food (MEAT)
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return EFoodType of it's food type
	 */
	@Override
	public EFoodType getFoodtype() {
		MessageUtility.logGetter(this.getName(), "getFoodtype", EFoodType.MEAT);
		return EFoodType.MEAT;
	}

	/**
	 * A method to get the trunk lengh
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return double of the trunk lengh
	 * 
	 * @see
	 */
	public double getTrunkLength() {
		MessageUtility.logGetter(this.getName(), "getTrunkLength", trunkLength);
		return trunkLength;
	}

	/**
	 * A method to set the trunk lengh
	 * 
	 * @version 1.0
	 * 
	 * @param trunkLength - the new lengh ( must be: < 3 and > 0.5 )
	 * 
	 * @return true it the parameter is valid, false if not (1 would be initialized)
	 */
	public boolean settrunkLength(double trunkLength) {
		boolean isSuccess = trunkLength > 0.5 && trunkLength < 3;
		if (isSuccess)
			this.trunkLength = trunkLength;
		else
			this.trunkLength = 1;
		MessageUtility.logSetter(this.getName(), "setTrunkLength", trunkLength, isSuccess);
		return isSuccess;
	}

	/**
	 * An method that prints the Elephant's sound.
	 * 
	 * @version 1.0
	 *
	 * @param None
	 * 
	 * @return None (void)
	 */
	public void chew() {
		MessageUtility.logSound(this.getName(), "Trumpets with joy while flapping its ears, then chews");
	}

	@Override
	public boolean equals(Object o) {
		Elephant b = null;
		if (super.equals(o)) {
			if (o instanceof Elephant) {
				b = (Elephant) o;
				return this.getTrunkLength() == b.getTrunkLength();
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
				this.setImg1(ImageIO.read(new File(IDrawable.PICTURE_PATH + "elf_n_1.png")));
				this.setImg2(ImageIO.read(new File(IDrawable.PICTURE_PATH + "elf_n_2.png")));
				break;
			case "Blue":
				this.setImg1(ImageIO.read(new File(IDrawable.PICTURE_PATH + "elf_b_1.png")));
				this.setImg2(ImageIO.read(new File(IDrawable.PICTURE_PATH + "elf_b_2.png")));
				break;
			case "Red":
				this.setImg1(ImageIO.read(new File(IDrawable.PICTURE_PATH + "elf_r_1.png")));
				this.setImg2(ImageIO.read(new File(IDrawable.PICTURE_PATH + "elf_r_2.png")));
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
