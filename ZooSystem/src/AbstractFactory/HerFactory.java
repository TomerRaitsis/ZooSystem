package AbstractFactory;

import java.awt.Color;

import animals.Animal;
import animals.Elephant;
import animals.Giraffe;
import animals.Turtle;
import graphics.ZooPanel;


/**
 * This class represents an herbivore factory,it will  create the animal according to the parameters given.
 * 
 * @version 1.0
 * 
 */
public class HerFactory implements AbstractFac {
	public HerFactory() {
	}

	@Override
	public Animal getAnimal(String type, String s, int size, int horSpeed, int verSpeed, Color col, ZooPanel zp) {
		if (type.equals("Giraffe"))
			return new Giraffe(s, size, horSpeed, verSpeed, col, zp);
		else if (type.equals("Elephant"))
			return new Elephant(s, size, horSpeed, verSpeed, col, zp);
		else
			return new Turtle(s, size, horSpeed, verSpeed, col, zp);
	}
}
