 /**
    * @author 
    * Tomer Raitsis  
    * SCE, Ashdod
    */
package animals;
import diet.Carnivore;
import food.EFoodType;
import food.IEdible;
import mobility.Point;
import utilities.MessageUtility;

import java.util.Random;

/**
 *  A class that represents a lion, it extends RoarAnimal 
 *  has 1 attribute: scarCount - an int for how many scars he has.
 * 
 * @version 1.0
 */
public class Lion extends RoarAnimal {
	
	private int scarCount;

/**
 *  A Ctor, uses the super Ctor(Animals), sets a default weight, Carnivore diet and a 0 scar count.
 * 
 * @version 1.0
 * 
 * @param s - String of animals name, p - default point.
 */
	public Lion(String s, Point p)
	{
		super(s,p);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), s);
		this.scarCount = 0;
		this.setWeight(408.2);
		this.setDiet(new Carnivore());
		
	}

/**
 *  Another Ctor, Gets only name. sets the point to the lions default
 * 
 * @version 1.0
 * 
 * @param s - String of animals name
 */
	public Lion(String s)
	{
		this(s,new Point(20,0));
	}

/**
 *  A method to get the lion's type of food (NOTFOOD)
 * 
 *
 * @version 1.0
 * 
 * @param None
 * 
 * @return EFoodType of it's food type
 */
	@Override
	public EFoodType getFoodtype()
	{
		MessageUtility.logGetter(this.getName(), "getFoodtype", EFoodType.NOTFOOD);
		return EFoodType.NOTFOOD;
	}

/**
*  An method that prints the animal's sound.
* 
* @version 1.0
*
* @param None
* 
* @return None (void)
 */
	public void roar()
	{
		MessageUtility.logSound(this.getName(), "Roars, then stretches and shakes its mane");
	}
	

/**
*  A method represent eating, checks if the lion eats the food, if it is, the lion will gain weight after eating, 
*  if it is not eating the given food nothing will happend.
*  also there's a 50/50 percent that the animal will get a scar.
* 
* @version 1.0
* 
* @param E - an IEdible object, it is the food the animal gets
* 
* @return true if the animal eats the food , false if it not
 */
	@Override
	public boolean eat(IEdible E)
	{ 
		boolean isSuccess = super.eat(E);
		if (isSuccess)
		{
			Random r = new Random();
			if (r.nextBoolean())
				this.setScarCount(this.getScarCount() + 1); 
		}
		/*MessageUtility.logBooleanFunction(this.getName(), "eat", E, isSuccess);*/ /*Disabled because it prints it twice*/
		return isSuccess;
	}

/**
 *  A method that returns the scar count 
 * 
 * @version 1.0
 * 
 * @return int of the number of scars
 */
	public int getScarCount() {
		MessageUtility.logGetter(this.getName(), "getScarCount", scarCount);
		return scarCount;
	}

/**
 *  A method to set the number of scars
 * 
 * @version 1.0
 * 
 * @param scarCount - the new number (must be > 0)
 * 
 * @return true if the amount is valid, false if it does'nt ( it will also won't be initialized)
 * 
 * @see
 */
	public boolean setScarCount(int scarCount) {
		boolean isSuccess = scarCount > 0;
		if (isSuccess)
			this.scarCount = scarCount;
		MessageUtility.logSetter(this.getName(), "setScarCount", scarCount, isSuccess);
		return isSuccess;
	}
	
	@Override
	public boolean equals(Object o)
	{
		Lion b = null;
		if (super.equals(o))
		{
			if(o instanceof Lion)
				{
					b = (Lion) o;
					return this.getScarCount() == b.getScarCount();
				}
			else
				return false;
		}
		else 
			return false;
	
	}
}