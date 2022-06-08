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
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;

/**
 * A class that represents an Giraffe, it extends ChewAnimal has 1 attribute:
 * neckLength - a int for a neck length.
 * 
 * @version 1.0
 */
public class Giraffe extends ChewAnimal {

	private double neckLength;

	/**
	 * A Ctor, uses the super Ctor(Animals), sets a default weight, Herbivore diet
	 * and a neck length = 1.5 .
	 * 
	 * @version 1.0
	 * 
	 * @param s - String of animals name, p - default point.
	 */
	public Giraffe(String s, Point p) {
		super(s, p);
		//MessageUtility.logConstractor(this.getClass().getSimpleName(), s);
		this.setWeight(450);
		this.setNeckLength(1.5);
		this.setDiet(new Herbivore());
	}

	public Giraffe(String s, int size, int horSpeed, int verSpeed, Color col,ZooPanel zp) {
		this(s, new Point(50, 0));
		this.setSize(size);
		this.setHorSpeed(horSpeed);
		this.setVerSpeed(verSpeed);
		this.setCol(col);
		this.setWeight(size * 2.2);
		this.setPan(zp);
	}

	/**
	 * Another Ctor, Gets only name. sets the point to the Giraffe default
	 * 
	 * @version 1.0
	 * 
	 * @param s - String of animals name
	 */
	public Giraffe(String s) {
		this(s, new Point(50, 0));
	}

	/**
	 * Another Ctor, Gets a name and neck lengh. sets the point to the Elephants
	 * default and the neck lengh to the parameter
	 * 
	 * @version 1.0
	 * 
	 * @param s - String of animals name, i - int for neck lengh
	 */
	public Giraffe(String s, int i) {
		super(s, new Point(50, 0));
		//MessageUtility.logConstractor(this.getClass().getSimpleName(), s);
		this.setWeight(450);
		this.setNeckLength(i);
		this.setDiet(new Herbivore());
	}

	/**
	 * A method to get the Giraffe's type of food (MEAT)
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return EFoodType of it's food type
	 */
	@Override
	public EFoodType getFoodtype() {
		//MessageUtility.logGetter(this.getName(), "getFoodtype", EFoodType.MEAT);
		return EFoodType.MEAT;
	}

	/**
	 * A method to get the neck lengh
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return double for the neck lengh
	 * 
	 */
	public double getneckLength() {
		//MessageUtility.logGetter(this.getName(), "getneckLength", neckLength);
		return neckLength;
	}

	/**
	 * A method to set the neck lengh
	 * 
	 * @version 1.0
	 * 
	 * @param neckLength - the new neck lengh must be: > 1 and < 2.5 .
	 * 
	 * @return true if it's valid, false is it's not (1.5 would be initialized)
	 * 
	 */
	public boolean setNeckLength(double neckLength) {
		boolean isSuccess = neckLength > 1 && neckLength < 2.5;
		if (isSuccess)
			this.neckLength = neckLength;
		else
			this.neckLength = 1.5;
		//MessageUtility.logSetter(this.getName(), "setneckLength", neckLength, isSuccess);
		return isSuccess;
	}

	/**
	 * An method that prints the Giraffe's sound.
	 * 
	 * @version 1.0
	 *
	 * @param None
	 * 
	 * @return None (void)
	 */
	public void chew() {
		//MessageUtility.logSound(this.getName(), "Bleats and Stomps its legs, then chews");
	}

	@Override
	public boolean equals(Object o) {
		Giraffe b = null;
		if (super.equals(o)) {
			if (o instanceof Giraffe) {
				b = (Giraffe) o;
				return this.getneckLength() == b.getneckLength();
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
				this.setImg1(ImageIO.read(new File(IDrawable.PICTURE_PATH + "grf_n_1.png")));
				this.setImg2(ImageIO.read(new File(IDrawable.PICTURE_PATH + "grf_n_2.png")));
				break;
			case "Blue":
				this.setImg1(ImageIO.read(new File(IDrawable.PICTURE_PATH + "grf_b_1.png")));
				this.setImg2(ImageIO.read(new File(IDrawable.PICTURE_PATH + "grf_b_2.png")));
				break;
			case "Red":
				this.setImg1(ImageIO.read(new File(IDrawable.PICTURE_PATH + "grf_r_1.png")));
				this.setImg2(ImageIO.read(new File(IDrawable.PICTURE_PATH + "grf_r_2.png")));
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
