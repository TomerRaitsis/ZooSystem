 /**
    * @author 
    * Tomer Raitsis
    * SCE, Ashdod
    *    
    */
package animals;
import mobility.Mobile;
import mobility.Point;
import utilities.MessageUtility;
import diet.IDiet;
import diet.Omnivore;
import food.IEdible;

/**
 *  An abstract class that represent an animal, has different behaviore such as: eat, move and make sound. 
 *  This class extends Mobile and implements IEdible
 * 
 * @version 1.0

 */
public abstract class Animal extends Mobile implements IEdible{
	private String name;
	private double weight;
	private IDiet diet;
	
	/**
	 *  A Ctor, also calls the super Ctor (Mobility Ctor)
	 * 
	 * @version 1.0
	 * 
	 * @param 
	 * S - String of the animal's name.
	 * P - Point object for the animals default location. 

	 */
	public Animal(String S, Point P)
	{
		super(P);
		MessageUtility.logConstractor("Animal", S);
		this.setName(S);
	}
	

	/**
	 *  A method that returns the animal's name.
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return String of the animal's name
	 * 
	 */
	public String getName() 
	{
		MessageUtility.logGetter(this.name, "getName", this.name);
		return this.name;
	}

	/**
	 *  A method to change the animal's name, if the String is null the name will be "Anonymous"
	 * 
	 * @version 1.0
	 * 
	 * @param String of the name
	 * 
	 * @return true if the parameter is not null and the were set, false if the parameter is null
	 * 
	 * @see
	 */
	public boolean setName(String name) 
	{
		boolean isSuccess = name != null;
		if (isSuccess)
			this.name = name;
		else
			this.name = new String("Anonymous");
		MessageUtility.logSetter(this.getName(), "setName", name, isSuccess);
		return isSuccess;
	}

	/**
	 *  A method that returns the animals Weight
	 * 
	 *
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return double of the animal's weight
	 * 
	 * @see
	 */
	public double getWeight() 
	{
		MessageUtility.logGetter(this.getName(), "getWeight", weight);
		return weight;
	}

	/**
	 *  A method that sets the animals Weight, the Weight must be > 0;
	 * 
	 * @version 1.0
	 * 
	 * @param weight - the new weight of the animal
	 * 
	 * @return true if the weight is > 0 , false if it isn't

	 */
	public boolean setWeight(double weight) 
	{
		boolean isSuccess = weight > 0;
		if (isSuccess)
			this.weight = weight;
		MessageUtility.logSetter(this.getName(), "setWeight", weight, isSuccess);
		return isSuccess;
	}

	/**
	 *  A method that return the animals diet
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return IDiet object that represent some diet (Carnivore and so on)

	 */
	public IDiet getDiet() 
	{
		MessageUtility.logGetter(this.getName(), "getDiet", diet);
		return diet;
	}

	/**
	 *  A method that sets a diet to the animal object, if the paremeter is null, omnivore will be set
	 * 
	 * @version 1.0
	 * 
	 * @param diet - IDiet that represent some diet, must not be null
	 * 
	 * @return true if was assigned and parameter is not null, false if null.
	 * 
	 * @see
	 */
	public boolean setDiet(IDiet diet) 
	{
		boolean isSuccess = diet != null;
		if (isSuccess)
			this.diet = diet;
		else
			this.diet = new Omnivore();
		MessageUtility.logSetter(this.getName(), "setDiet", diet, isSuccess);
		return isSuccess;
	
		
	}
	
	/**
	 *  A method represent eating, checks if the animal eats the food, if it is the animal will gain weight after eating, 
	 *  if it is not eating the given food nothing will happend
	 * 
	 * @version 1.0
	 * 
	 * @param E - an IEdible object, it is the food the animal gets
	 * 
	 * @return true if the animal eats the food , false if it not
	 * 
	 */
	public boolean eat(IEdible E)
	{
		double d = this.diet.eat(this,E); 
		boolean isSuccess = d != 0;
		if (isSuccess)
			{
				this.setWeight(this.getWeight() + d);
				this.makeSound();
			}
		MessageUtility.logBooleanFunction(this.getName(), "eat", E, isSuccess);
		return isSuccess;
		
	}
	
	/**
	 *  A method that overrides object toString, to print the animal in a defferend way.
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return String object that will be printed.
	 * 
	 * @see
	 */
	public String toString()
	{
		return "[" + this.getClass().getSimpleName() + "]: " + this.getName();
	}
	
	/**
	 *  A method that overrides Mobility's move, gets a poing and move the animal there, if the animal moves it will lose weight.
	 * 
	 * @version 1.0
	 * 
	 * @param P - Point object that represent the new point
	 * 
	 * @return double that represent the distance of the new point from the current one, 0 if it the same one or the point is not in the bounderies.
	 */
	
	@Override
	public double move(Point P)
	{
		double newD = super.move(P);
		if (newD != 0) 
		{
			double w = this.getWeight();
			this.setWeight(w - (newD*w*0.00025));
		}
		return newD;
	}
	
	/**
	 *  An abstract method, that will print the animal's sound
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return None (void)
	 */
	public abstract void makeSound();
	
	@Override
	public boolean equals(Object o)
	{
		 if (o == this) 
		 {
	        return true;
	     }
		 
		 if (!(o instanceof Animal))
			 return false;
		 Animal A = (Animal) o;
		 
		 return this.getName() == A.getName() && this.getWeight() == A.getWeight() && this.getDiet().getClass().getSimpleName() == A.getDiet().getClass().getSimpleName();
	}
}
