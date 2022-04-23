 /**
    * @author 
    * Tomer Raitsis  
    * SCE, Ashdod
    */
package privateutil;

import animals.Animal;
import animals.Bear;
import animals.Elephant;
import animals.Giraffe;
import animals.Lion;
import animals.Turtle;

/**
 *  A class of helping methods
 *  
 * @version 1.0
 */
public class StaticMethodsToHelp {

/**
 *  A method to find the actual animal and return an animal reference to it
 * 
 * @version 1.0
 * 
 * @param animal - an object
 * 
 * @return animal reference to the right animal or null
 */
	public static Animal FindAnimalsClass(Object animal)
	{
		if (animal instanceof Lion)
			return ((Lion) animal);
		
		else if (animal instanceof Bear)
			return ((Bear) animal);
		
		else if (animal instanceof Elephant)
			return ((Elephant) animal);
		
		else if (animal instanceof Giraffe)
			return ((Giraffe) animal);
		
		else if (animal instanceof Turtle)
			return ((Turtle) animal);
		else
			return null;
	}
}
