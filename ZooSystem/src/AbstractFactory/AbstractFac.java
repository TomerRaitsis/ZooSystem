package AbstractFactory;

import java.awt.Color;

import animals.Animal;
import graphics.ZooPanel;

/**
 * This interface represent an abstract factory, it will generate a factory (carnivore,omnivore or herbivore) 
 * and will  create the animal according to the parameters given.
 * 
 * @version 1.0
 * 
 */
public interface AbstractFac{
	public Animal getAnimal(String type, String s, int size, int horSpeed, int verSpeed, Color col,ZooPanel zp); 
}