/**
   * @author 
   * Tomer Raitsis 
   * SCE, Ashdod
   */
package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;

/**
 * A class that implements IDiet interface, this class is a type of a diet that
 * eats vegetable
 * 
 * @version 1.0
 */
public class Herbivore implements IDiet {

	/**
	 * A Ctor, not getting any parameters (there are no attributes)
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 */
	public Herbivore() {
	}

	/**
	 * An boolean method that overides the interface's method checks if the food the
	 * animal got is vegetable.
	 *
	 * 
	 * @version 1.0
	 * 
	 * @param food - an enum (EFoodType)
	 * 
	 * @return true if the food is vegetable , false if isn't
	 * 
	 */
	@Override
	public boolean canEat(EFoodType food) {
		boolean isSuccess = food.equals(EFoodType.VEGETABLE);
		// MessageUtility.logBooleanFunction(this.getClass().getSimpleName(), "canEat",
		// food, isSuccess);
		return isSuccess;
	}

	/**
	 * A method that overides the interface's and returns the weight the animal will
	 * gain if he can eat the food (0.07 of it's weight) 0 will be returned if the
	 * food type is not vegetable.
	 * 
	 * @version 1.0
	 * 
	 * @param animal - An naimal object that is supposed to eat the food food - the
	 *               food that supposed to be eaten by the animal
	 * 
	 * @return The weight the animal will gain if he can eat the food, 0 if it can
	 *         not eat it
	 * 
	 */
	@Override
	public double eat(Animal animal, IEdible food) {
		if (this.canEat(food.getFoodtype()))
			return animal.getWeight() * 0.07;
		else
			return 0;
	}

	/**
	 * A method that overides the Object class "toString" method
	 * 
	 * @version 1.0
	 * 
	 * @return a string representation of the object.
	 */
	public String toString() {
		return "[Herbivore]";
	}

}
