 /**
    * @author 
    * Tomer Raitsis 316160167
    * SCE, Ashdod
    *    
    */
package animals;

import mobility.Point;

/**
 *  An abstract class that represents a chewing animal such as an Elephant or a Girrafe.
 *  Extends Animal
 * 
 * @version 1.0
 * 
 */
public abstract class ChewAnimal extends Animal{
	
	/**
	 *  A Ctor, uses Animal ctor
	 * 
	 * @version 1.0
	 * 
	 * @param Strig of the name and a Point for the corrent spot.
	 */
	public ChewAnimal(String S, Point P)
	{
		super(S,P);
	}
	
	/**
	 *  A method to make sound, will use the chew method in it.
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return None (void)
	 */
	public void makeSound()
	{

		this.chew();
	}
	
	/**
	 *  An abstract method that print the animal's sound.
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return None (void)
	 */
	public abstract void chew();
	
}
