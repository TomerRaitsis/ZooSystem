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
 *   A class that implements IDiet interface, this class is a type of a diet that eats vegetable and meat.
 *   has two attributes: Carnivore and Herbivore. Because an Omnivore eats both meat and vegetable.
 * 
 * @version 1.0
 */
public class Omnivore implements IDiet {
	
	private Carnivore C;
	private Herbivore H;

/**
*   A Ctor, not getting any parameters (but creates Carnivore and Herbivore objects for it's attributes)
 * 
 * @version 1.0
 * 
 * @param None
 */
	public Omnivore() 
	{
		this.C = new Carnivore();
		this.H = new Herbivore();
	}

/**
 *   An boolean method that overides the interface's method 
 *  checks if the food the animal got is vegetable or meat.
 *
 * @version 1.0
 * 
 * @param food - an enum (EFoodType)
 * 
 * @return true if the food is vegetable or meat, false if isn't
 * 
 */
	@Override
	public boolean canEat(EFoodType food) {
		boolean isSuccess = C.canEat(food) || H.canEat(food);
		//MessageUtility.logBooleanFunction(this.getClass().getSimpleName(), "canEat", food, isSuccess);
		return isSuccess;
	}

/**
 * A method that overides the interface's and returns the weight the animal will gain if he can eat the food (0.1 f it's weight) 
 *  0 will be returned if the food type is not vegetable.
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
	public double eat(Animal animal, IEdible food) {
		if (this.canEat(food.getFoodtype()))
		{
			if (C.canEat(food.getFoodtype()))
				return animal.getWeight() * 0.1;
			else if (H.canEat(food.getFoodtype()))
				return animal.getWeight() * 0.07;
			else 
				return 0;
		}
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
		return "[Omnivore]";
	}
}
