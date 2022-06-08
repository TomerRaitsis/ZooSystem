 /**
    * @author 
    * Tomer Raitsis 316160167
    * SCE, Ashdod
    */
package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;

/**
 *  An interface that represent an eating behaviour of an animal object
 * 
 * @version 1.0
 */
public interface IDiet{

/**
 *  A boolean method that checks if the given food can be eaten (according to a certain diet)
 * 
 *
 * @version 1.0
 * 
 * @param food - EFoodType Enum
 * 
 * @return true if it can be eaten, false if its not.
 * 
 */
	public boolean canEat(EFoodType food);

/**
 *  A method that returns the weight the animal will gain if he can eat the food (according to his diet type), if he can not 0 will be returned
 * 
 * @version 1.0
 * 
 * @param 
 * animal - An naimal object that is supposed to eat the food
 * food - the food that supposed to be eaten by the animal
 * 
 * @return  The weight the animal will gain if he can eat the food, 0 if it can not eat it
 * 
 */
	public double eat(Animal animal, IEdible food);
}
