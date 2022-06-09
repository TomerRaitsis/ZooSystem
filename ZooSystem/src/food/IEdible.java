 /**
    * @author 
    * Tomer Raitsis
    * SCE, Ashdod
    */
package food;

/**
 *  An interface that represent edible objects,
 *  extends Cloneable- used to deep copy objects from this class
 * 
 * @version 1.0
 * 
 */
public interface IEdible extends Cloneable {

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
	
	/*
	 * A method to set the object to null 
	 */
	public void SetNull();

	/*
	 * A method to clone an object
	 */
	public IEdible clone();
	
	
}
