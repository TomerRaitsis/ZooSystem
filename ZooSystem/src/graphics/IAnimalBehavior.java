 /**
    * @author 
    * Tomer Raitsis 316160167
    * SCE, Ashdod
    *    
    */
package graphics;

/**
 * An interface that represent the animal behavior
 * 
 * @version 1.0
 * 
 */
public interface IAnimalBehavior {
	/**
	 * A method to returns the animal's name
	 * 
	 * @version 1.0
	 * 
	 * @return AnimalName (String)
	 */

	public String getAnimalName();

	/**
	 * A method to returns the animal's size
	 * 
	 * @version 1.0
	 * 
	 * @return Size (int)
	 */
	public int getSize();

	/**
	 * A method to increase the eatcount by 1
	 * 
	 * @version 1.0
	 * 
	 */
	public void eatInc();

	/**
	 * A method to return the EatCount
	 * 
	 * @version 1.0
	 * 
	 * @return EatCount (int)
	 */
	public int getEatCount();

	/**
	 * A method to return the changes
	 * 
	 * @version 1.0
	 * 
	 * @return Changes (boolean)
	 */
	public boolean getChanges();

	/**
	 * A method to set the changes
	 * 
	 * @version 1.0
	 * 
	 * @param state - boolean that will be set
	 * 
	 * @return None
	 * 
	 */
	public void setChanges(boolean state);
}
