package DecoratorAnimalColor;

import java.awt.Color;

import animals.Animal;

/**
 * This class  will change the animals color to red
 * 
 * @version 1.0
 * 
 */
public class ChangeColorToRed extends AnimalColorChange {

	public ChangeColorToRed(Animal animalToColor) {
		super(animalToColor);
		this.changeColor();
	}

	@Override
	public void changeColor() {
		synchronized (AnimalToColor) {
			AnimalToColor.setCol(Color.red);
			AnimalToColor.loadImages(AnimalToColor.getColor());
		}
	}

}
