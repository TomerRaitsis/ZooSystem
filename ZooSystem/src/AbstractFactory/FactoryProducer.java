package AbstractFactory;


/**
 * This class is the Factory Producer,it will  create the factory according to the parameter given.
 * 
 * @version 1.0
 * 
 */
public class FactoryProducer {
	public static AbstractFac getFactory(String diet) {
		if (diet.equals("Carnivore"))
			return new CarFactory();
		else if(diet.equals("Herbivore"))
			return new HerFactory();
		else
			return new OmnFactory();
	}
}

