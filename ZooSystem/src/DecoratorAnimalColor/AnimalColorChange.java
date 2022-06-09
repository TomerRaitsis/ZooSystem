package DecoratorAnimalColor;

import animals.Animal;


/**
 * This abstract class represents all the classes that will be uesd to change the animals color.
 * 
 * @version 1.0
 * 
 */
public abstract class AnimalColorChange implements ColorChange{
	protected Animal AnimalToColor;
	
	public AnimalColorChange(Animal animalToColor) {
		AnimalToColor = animalToColor;
	}
	
}
