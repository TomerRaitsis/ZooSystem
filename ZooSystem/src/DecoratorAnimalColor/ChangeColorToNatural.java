package DecoratorAnimalColor;


import animals.Animal;

/**
 * This class  will change the animals color to Natural
 * 
 * @version 1.0
 * 
 */

public class ChangeColorToNatural extends AnimalColorChange {

	public ChangeColorToNatural(Animal animalToColor) {
		super(animalToColor);
		this.changeColor();
	}

	@Override
	public void changeColor() {
		synchronized (AnimalToColor) {
			AnimalToColor.setCol(null);
			AnimalToColor.loadImages(AnimalToColor.getColor());
		}
	}

}
