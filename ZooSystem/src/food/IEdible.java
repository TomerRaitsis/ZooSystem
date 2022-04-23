 /**
    * @author 
    * Tomer Raitsis  
    * SCE, Ashdod
    */
package food;

/**
 *  An interface that represent edible objects
 * 
 * @version 1.0
 * 
 */
public interface IEdible {

/**
 *  A method that returns the food type of an object that implements this interface
 * 
 * @version 1.0
 * 
 * @param None
 * 
 * @return A food type as an EFoodType object
 * 
 */
	public EFoodType getFoodtype();
}
