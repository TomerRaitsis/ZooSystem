package DecoratorAnimalColor;

import java.awt.Color;

import animals.Animal;


/**
 * This class  will change the animals color to blue
 * 
 * @version 1.0
 * 
 */
public class ChangeColorToBlue extends AnimalColorChange {

	public ChangeColorToBlue(Animal animalToColor) {
		super(animalToColor);
		this.changeColor();
	}

	@Override
	public void changeColor() {
		synchronized (AnimalToColor) {
			AnimalToColor.setCol(Color.blue);
			AnimalToColor.loadImages(AnimalToColor.getColor());
		}

	}
}
