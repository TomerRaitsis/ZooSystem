/**
   * @author 
   * Tomer Raitsis 316160167
   * SCE, Ashdod
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
 * A class that represents an Turtle, it extends ChewAnimal has 1 attribute: Age
 * - a int for a age.
 * 
 * @version 1.0
 */
public class Turtle extends ChewAnimal {

	private int Age;

	/**
	 * A Ctor, uses the super Ctor(Animals), sets a default weight, Herbivore diet
	 * and a age = 1.5 .
	 * 
	 * @version 1.0
	 * 
	 * @param s - String of animals name, p - default point.
	 */
	public Turtle(String s, Point p) {
		super(s, p);
		//MessageUtility.logConstractor(this.getClass().getSimpleName(), s);
		this.setWeight(1);
		this.setAge(1);
		this.setDiet(new Herbivore());
	}

	public Turtle(String s, int size, int horSpeed, int verSpeed, Color col,ZooPanel zp) {
		this(s, new Point(80, 0));
		this.setSize(size);
		this.setHorSpeed(horSpeed);
		this.setVerSpeed(verSpeed);
		this.setCol(col);
		this.setWeight(size * 0.5);
		this.setPan(zp);
	}

	/**
	 * Another Ctor, Gets only name. sets the point to the Turtle default
	 * 
	 * @version 1.0
	 * 
	 * @param s - String of animals name
	 */
	public Turtle(String s) {
		this(s, new Point(80, 0));
	}

	/**
	 * Another Ctor, Gets a name and age. sets the point to the Elephants default
	 * and the age to the parameter
	 * 
	 * @version 1.0
	 * 
	 * @param s - String of animals name, i - int for age
	 */
	public Turtle(String s, int i) {
		super(s, new Point(80, 0));
		//MessageUtility.logConstractor(this.getClass().getSimpleName(), s);
		this.setWeight(1);
		this.setAge(i);
		this.setDiet(new Herbivore());
	}

	/**
	 * A method to get the Turtle's type of food (MEAT)
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
	 * A method to get the age
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return double for the age
	 */
	public double getAge() {
		//MessageUtility.logGetter(this.getName(), "getAge", Age);
		return Age;
	}

	/**
	 * A method to set the age
	 * 
	 *
	 * @version 1.0
	 * 
	 * @param Age - the new age to be set ( must be: > 0 and < 500)
	 * 
	 * @return true if valid, false if not( and 1 would be initialized)
	 * 
	 * @see
	 */
	public boolean setAge(int Age) {
		boolean isSuccess = Age > 0 && Age < 500;
		if (isSuccess)
			this.Age = Age;
		else
			this.Age = 1;
		//MessageUtility.logSetter(this.getName(), "setAge", Age, isSuccess);
		return isSuccess;
	}

	/**
	 * An method that prints the Turtle's sound.
	 * 
	 * @version 1.0
	 *
	 * @param None
	 * 
	 * @return None (void)
	 */
	public void chew() {
		//MessageUtility.logSound(this.getName(), "Retracts its head in then eats quietly");
	}

	@Override
	public boolean equals(Object o) {
		Turtle b = null;
		if (super.equals(o)) {
			if (o instanceof Turtle) {
				b = (Turtle) o;
				return this.getAge() == b.getAge();
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
				this.setImg1(ImageIO.read(new File(IDrawable.PICTURE_PATH + "trt_n_1.png")));
				this.setImg2(ImageIO.read(new File(IDrawable.PICTURE_PATH + "trt_n_2.png")));
				break;
			case "Blue":
				this.setImg1(ImageIO.read(new File(IDrawable.PICTURE_PATH + "trt_b_1.png")));
				this.setImg2(ImageIO.read(new File(IDrawable.PICTURE_PATH + "trt_b_2.png")));
				break;
			case "Red":
				this.setImg1(ImageIO.read(new File(IDrawable.PICTURE_PATH + "trt_r_1.png")));
				this.setImg2(ImageIO.read(new File(IDrawable.PICTURE_PATH + "trt_r_2.png")));
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
