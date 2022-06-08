 /**
    * @author 
    * Tomer Raitsis 316160167
    * SCE, Ashdod
    *    
    */
package animals;
import mobility.Mobile;
import mobility.Point;
import utilities.MessageUtility;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import diet.IDiet;
import diet.Omnivore;
import food.IEdible;
import graphics.IAnimalBehavior;
import graphics.IDrawable;
import graphics.ZooPanel;

/**
 *  An abstract class that represent an animal, has different behaviore such as: eat, move and make sound. 
 *  This class extends Mobile and implements IEdible
 * 
 * @version 1.0

 */
public abstract class Animal extends Mobile implements IEdible, IDrawable, IAnimalBehavior{
	private String name;
	private double weight;
	private IDiet diet;
	
	private final int EAT_DISTANCE = 10;
	private int size;
	private Color col;
	private int horSpeed;
	private int verSpeed;
	private boolean coordChanged;
	private int x_dir = 1;
	private int y_dir = 1;
	private int eatCount;
	private ZooPanel pan;
	private BufferedImage img1, img2;
	
	
	/**
	 *  A Ctor, also calls the super Ctor (Mobility Ctor)
	 * 
	 * @version 1.0
	 * 
	 * @param 
	 * S - String of the animal's name.
	 * P - Point object for the animals default location. 

	 */
	public Animal(String S, Point P)
	{
		super(P);
		MessageUtility.logConstractor("Animal", S);
		this.setName(S);
	}
	

	/**
	 *  A method that returns the animal's name.
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return String of the animal's name
	 * 
	 */
	public String getName() 
	{
		MessageUtility.logGetter(this.name, "getName", this.name);
		return this.name;
	}

	/**
	 *  A method to change the animal's name, if the String is null the name will be "Anonymous"
	 * 
	 * @version 1.0
	 * 
	 * @param String of the name
	 * 
	 * @return true if the parameter is not null and the were set, false if the parameter is null
	 * 
	 * @see
	 */
	public boolean setName(String name) 
	{
		boolean isSuccess = name != null;
		if (isSuccess)
			this.name = name;
		else
			this.name = new String("Anonymous");
		MessageUtility.logSetter(this.getName(), "setName", name, isSuccess);
		return isSuccess;
	}

	/**
	 *  A method that returns the animals Weight
	 * 
	 *
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return double of the animal's weight
	 * 
	 * @see
	 */
	public double getWeight() 
	{
		MessageUtility.logGetter(this.getName(), "getWeight", weight);
		return weight;
	}

	/**
	 *  A method that sets the animals Weight, the Weight must be > 0;
	 * 
	 * @version 1.0
	 * 
	 * @param weight - the new weight of the animal
	 * 
	 * @return true if the weight is > 0 , false if it isn't

	 */
	public boolean setWeight(double weight) 
	{
		boolean isSuccess = weight > 0;
		if (isSuccess)
			this.weight = weight;
		MessageUtility.logSetter(this.getName(), "setWeight", weight, isSuccess);
		return isSuccess;
	}

	/**
	 *  A method that return the animals diet
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return IDiet object that represent some diet (Carnivore and so on)

	 */
	public IDiet getDiet() 
	{
		MessageUtility.logGetter(this.getName(), "getDiet", diet);
		return diet;
	}

	/**
	 *  A method that sets a diet to the animal object, if the paremeter is null, omnivore will be set
	 * 
	 * @version 1.0
	 * 
	 * @param diet - IDiet that represent some diet, must not be null
	 * 
	 * @return true if was assigned and parameter is not null, false if null.
	 * 
	 * @see
	 */
	public boolean setDiet(IDiet diet) 
	{
		boolean isSuccess = diet != null;
		if (isSuccess)
			this.diet = diet;
		else
			this.diet = new Omnivore();
		MessageUtility.logSetter(this.getName(), "setDiet", diet, isSuccess);
		return isSuccess;
	
		
	}
	
	/**
	 *  A method represent eating, checks if the animal eats the food, if it is the animal will gain weight after eating, 
	 *  if it is not eating the given food nothing will happend
	 * 
	 * @version 1.0
	 * 
	 * @param E - an IEdible object, it is the food the animal gets
	 * 
	 * @return true if the animal eats the food , false if it not
	 * 
	 */
	public boolean eat(IEdible E)
	{
		double d = this.diet.eat(this,E); 
		boolean isSuccess = d != 0;
		if (isSuccess)
			{
				this.setWeight(this.getWeight() + d);
				this.makeSound();
			}
		MessageUtility.logBooleanFunction(this.getName(), "eat", E, isSuccess);
		return isSuccess;
		
	}
	
	/**
	 *  A method that overrides object toString, to print the animal in a defferend way.
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return String object that will be printed.
	 * 
	 * @see
	 */
	public String toString()
	{
		return "[" + this.getClass().getSimpleName() + "]: " + this.getName();
	}
	
	/**
	 *  A method that overrides Mobility's move, gets a poing and move the animal there, if the animal moves it will lose weight.
	 * 
	 * @version 1.0
	 * 
	 * @param P - Point object that represent the new point
	 * 
	 * @return double that represent the distance of the new point from the current one, 0 if it the same one or the point is not in the bounderies.
	 */
	
	@Override
	public double move(Point P)
	{
		double newD = super.move(P);
		if (newD != 0) 
		{
			double w = this.getWeight();
			this.setWeight(w - (newD*w*0.00025));
		}
		return newD;
	}
	
	/**
	 *  An abstract method, that will print the animal's sound
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return None (void)
	 */
	public abstract void makeSound();
	
	@Override
	public boolean equals(Object o)
	{
		 if (o == this) 
		 {
	        return true;
	     }
		 
		 if (!(o instanceof Animal))
			 return false;
		 Animal A = (Animal) o;
		 
		 return this.getName() == A.getName() && this.getWeight() == A.getWeight() && this.getDiet().getClass().getSimpleName() == A.getDiet().getClass().getSimpleName();
	}

	/**
	 *  A method to get the eat distance of the animal
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return EAT_DISTANCE (an int)
	 * 
	 */
	public int getEAT_DISTANCE() {
		return EAT_DISTANCE;
	}

	/**
	 *  A method to get the size f the animal
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return size (an int)
	 * 
	 */
	public int getSize() {
		return size;
	}

	/**
	 * A method to set the size of the animal
	 *  
	 * 
	 * @version 1.0
	 * 
	 * @param The size
	 * 
	 * @return None
	 * 
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 *  A method to get the color of the animal's picture
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return the Color (a Color object)
	 * 
	 * @see
	 */
	public Color getCol() {
		return col;
	}

	/**
	 *  A method to set the color of the animal's picture
	 * 
	 * @version 1.0
	 * 
	 * @param The new color
	 * 
	 * @return None
	 * 
	 */
	public void setCol(Color col) {
		this.col = col;
	}

	/**
	 *  A method to get the horizontal speed
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return the horizontal speed (an int)
	 */
	public int getHorSpeed() {
		return horSpeed;
	}

	/**
	 *  A method to set the horizontal speed
	 * 
	 * @version 1.0
	 * 
	 * @param The new speed
	 * 
	 * @return None
	 */
	public void setHorSpeed(int horSpeed) {
		this.horSpeed = horSpeed;
	}

	/**
	 *  A method to get the vertical speed
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return the vertical speed (an int)
	 */
	public int getVerSpeed() {
		return verSpeed;
	}

	/**
	 *  A method to set the vertical speed
	 * 
	 * @version 1.0
	 * 
	 * @param The new speed
	 * 
	 * @return None
	 */
	public void setVerSpeed(int verSpeed) {
		this.verSpeed = verSpeed;
	}

	/**
	 *  A method to get the x direction
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return X direction (an int0
	 * 
	 */
	public int getX_dir() {
		return x_dir;
	}

	/**
	 *  A method to set the x direction
	 * 
	 * @version 1.0
	 * 
	 * @param new direction (int)
	 * 
	 * @return None
	 * 
	 */
	public void setX_dir(int x_dir) {
		this.x_dir = x_dir;
	}

	/**
	 *  A method to get the y direction
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return X direction (an int0
	 * 
	 */
	public int getY_dir() {
		return y_dir;
	}

	/**
	 *  A method to set the y direction
	 * 
	 * @version 1.0
	 * 
	 * @param new direction (int)
	 * 
	 * @return None
	 * 
	 */
	public void setY_dir(int y_dir) {
		this.y_dir = y_dir;
	}

	/**
	 *  A method to get the eat count
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return eatCount (an int)
	 * 
	 */
	public int getEatCount() {
		return eatCount;
	}

	/**
	 *  A method to set the eat count
	 * 
	 * @version 1.0
	 * 
	 * @param new number (an int)
	 * 
	 * @return none
	 * 
	 */
	public void setEatCount(int eatCount) {
		this.eatCount = eatCount;
	}

	/**
	 *  A method to get the animal's panel
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return The panel (ZooPanel) 
	 * 
	 */
	public ZooPanel getPan() {
		return pan;
	}

	/**
	 *  A method to set the animal's panel
	 * 
	 * @version 1.0
	 * 
	 * @param a panel (ZooPanel)
	 * 
	 * @return None
	 * 
	 */
	public void setPan(ZooPanel pan) {
		this.pan = pan;
	}

	/**
	 *  A methd to get the animal img1
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return img1 (BufferedImage)
	 * 
	 */
	public BufferedImage getImg1() {
		return img1;
	}

	/**
	 *  A methd to set the animal img1
	 * 
	 * @version 1.0
	 * 
	 * @param an image (BufferedImage)
	 * 
	 * @return None
	 * 
	 */
	public void setImg1(BufferedImage img1) {
		this.img1 = img1;
	}

	/**
	 *  A methd to get the animal img2
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return img1 (BufferedImage)
	 * 
	 */
	public BufferedImage getImg2() {
		return img2;
	}

	/**
	 *  A methd to set the animal img2
	 * 
	 * @version 1.0
	 * 
	 * @param an image (BufferedImage)
	 * 
	 * @return None
	 * 
	 */
	public void setImg2(BufferedImage img2) {
		this.img2 = img2;
	}
	/**
	 *  A method to get the animal's picture color (String)
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return the color (String)
	 * 
	 */
	@Override
	public String getColor() {
		Color r = this.getCol();
		if (r == null)
			return "Natural";
		if (r == Color.blue)
			return "Blue";
		else
			return "Red";		
	}

	/**
	 *  A method to add 1 to the EatCount
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return None
	 * 
	 */
	@Override
	public void eatInc() {
		this.setEatCount(this.getEatCount() + 1);

	}

	/**
	 *  A method that returns true if there's been any changes in the animal
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return true if there's been any changes, false if not
	 * 
	 */
	@Override
	public boolean getChanges() {
		return this.coordChanged;
	}
	/**
	 *  A method that sets the "coordChanged" to the given state
	 * 
	 * @version 1.0
	 * 
	 * @param state (boolean)
	 * 
	 * @return None
	 * 
	 */
	@Override
	public void setChanges(boolean state) {
		this.coordChanged = state;

	}
	
	/**
	 *  A method to draw the animal on the screen
	 * 
	 * @version 1.0
	 * 
	 * @param g (Graphics)
	 * 
	 * @return None
	 * 
	 */
	@Override
	public void drawObject(Graphics g) {
		Graphics2D gr = (Graphics2D) g;
		gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (this.getX_dir() == 1)
			g.drawImage(this.getImg1(), this.getLocation().GetX() - this.getSize() / 2,
					this.getLocation().GetY() - this.getSize() / 2, this.getSize() / 2, this.getSize(), this.getPan());
		else
			g.drawImage(this.getImg2(), this.getLocation().GetX() - this.getSize() / 2,
					this.getLocation().GetY() - this.getSize() / 2, this.getSize() / 2, this.getSize(), this.getPan());

	}
}
