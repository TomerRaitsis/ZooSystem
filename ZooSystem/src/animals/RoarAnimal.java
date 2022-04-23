 /**
    * @author 
    * Tomer Raitsis  
    * SCE, Ashdod
    */
package animals;

import mobility.Point;

/**
 *  An abstract class that represents a Roaring animal such as a Lion or a Bear.
 *  Extends Animal
 *
 * @version 1.0
 * 
 */
public abstract class RoarAnimal extends Animal{

/**
	 *  A Ctor, uses Animal ctor
	 * 
	 * @version 1.0
	 * 
	 * @param Strig of the name and a Point for the corrent spot.
 */
	public RoarAnimal(String S, Point P)
	{
		super(S,P);
	}

/**
	 *  A method to make sound, will use the roar method in it.
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return None (void)
 */
	public void makeSound()
	{

		this.roar();
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
	public abstract void roar();
}
