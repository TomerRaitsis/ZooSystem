package AbstractFactory;

import java.awt.Color;

import animals.Animal;
import animals.Lion;
import graphics.ZooPanel;


/**
 * This class represents a carnivore factory,it will  create the animal according to the parameters given.
 * 
 * @version 1.0
 * 
 */
public class CarFactory implements AbstractFac{
	public CarFactory() {}

	@Override
	public Animal getAnimal(String type, String s, int size, int horSpeed, int verSpeed, Color col,ZooPanel zp) {
		return new Lion(s,size,horSpeed,verSpeed,col,zp);
	}
}
