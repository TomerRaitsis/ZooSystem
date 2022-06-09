package AbstractFactory;

import java.awt.Color;

import animals.Animal;
import animals.Bear;
import graphics.ZooPanel;

/**
 * This class represents a omnivore factory,it will create the animal according to the parameters given.
 * 
 * @version 1.0
 * 
 */
public class OmnFactory implements AbstractFac{
	public OmnFactory() {}
	@Override
	public Animal getAnimal(String type, String s, int size, int horSpeed, int verSpeed, Color col,ZooPanel zp) {
		return new Bear(s,size,horSpeed,verSpeed,col,zp);
	}
}
