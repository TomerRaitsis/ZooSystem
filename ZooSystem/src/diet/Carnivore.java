 /**
    * @author 
    * Tomer Raitsis 316160167
    * SCE, Ashdod
    */
package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;
import utilities.MessageUtility;

/**
 *  A class that implements IDiet interface, this class is a type of a diet that eats meat
 * 
 * @version 1.0
 */
public class Carnivore implements IDiet{

/**
 *  A Ctor, not getting any parameters (there are no attributes)
 * 
 * @version 1.0
 * 
 * @param None
 */
	public Carnivore() {}

/**
 *  An boolean method that overides the interface's method 
 *  checks if the food the animal got is meet.
 *
 * 
 * @version 1.0
 * 
 * @param food - an enum (EFoodType)
 * 
 * @return true if the food is meat , false if isn't
 * 
 */
	@Override
	public boolean canEat(EFoodType food) 
	{
		boolean isSuccess = food.equals(EFoodType.MEAT);
		//MessageUtility.logBooleanFunction(this.getClass().getSimpleName(), "canEat", food, isSuccess);
		return isSuccess;
	}

/**
 *  A method that overides the interface's and returns the weight the animal will gain if he can eat the food (0.1 f it's weight) 
 *  0 will be returned if the food type is not meat.
 *  
 * @version 1.0
 * 
 * @param 
 * animal - An naimal object that is supposed to eat the food
 * food - the food that supposed to be eaten by the animal
 * 
 * @return  The weight the animal will gain if he can eat the food, 0 if it can not eat it

 */
	@Override
	public double eat(Animal animal, IEdible food) 
	{
		if (this.canEat(food.getFoodtype()))
			return animal.getWeight() * 0.1;
		else
			return 0;
	}

/**
 *  A method that overides the Object class "toString" method 
 * 
 * @version 1.0
 * 
 * @return a string representation of the object.
 */
	public String toString()
	{
		return "[Carnivore]";
	}

	
}
