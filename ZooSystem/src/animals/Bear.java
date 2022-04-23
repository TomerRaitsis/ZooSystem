 /**
    * @author 
    * Tomer Raitsis  
    * SCE, Ashdod
    *    
    */
package animals;
import diet.Omnivore;
import food.EFoodType;
import mobility.Point;
import utilities.MessageUtility;

/**
 *  A class that represents a Bear, it extends RoarAnimal 
 *  has 1 attribute: furColor - a String for a fur color.
 * 
 * @version 1.0
 */
public class Bear extends RoarAnimal {

	private String furColor;
	
	/**
	 *  A Ctor, uses the super Ctor(Animals), sets a default weight, Omnivore diet and a gray fur color.
 * 
 * @version 1.0
 * 
 * @param s - String of animals name, p - default point.
	 */
	public Bear(String s, Point p)
	{
		super(s,p);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), s);
		this.setWeight(308.2);
		this.setFurColor("GRAY");
		this.setDiet(new Omnivore());
		
	}
	
	/**
	 *  Another Ctor, Gets only name. sets the point to the Bears default
	 * 
	 * @version 1.0
	 * 
	 * @param s - String of animals name
	 */
	public Bear(String s)
	{
		this(s,new Point(100,5));
	}
	
	
	/**
	 *  Another Ctor, Gets a name and fur color. sets the point to the Bears default and the fur color to the parameter
	 * 
	 * @version 1.0
	 * 
	 * @param s - String of animals name, string - fur color

	 */
	public Bear(String s, String string) 
	{
		super(s,new Point(100,5));
		MessageUtility.logConstractor(this.getClass().getSimpleName(), s);
		this.setWeight(308.2);
		this.setFurColor(string);
		this.setDiet(new Omnivore());
	}

	/**
	 *  A method to get the bear's type of food (MEAT)
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return EFoodType of it's food type
	 */
	@Override
	public EFoodType getFoodtype() {
		MessageUtility.logGetter(this.getName(), "getFoodtype", EFoodType.MEAT);
		return EFoodType.MEAT;
	}

	/**
	 *  A method to get the fur color
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 */
	public String getFurColor() 
	{
		MessageUtility.logGetter(this.getName(), "getFurColor", furColor);
		return furColor;
	}

	/**
	 *  A method to set the fur color
	 * 
	 * @version 1.0
	 * 
	 * @param furColor - fur color, must be black/white/gray
	 * 
	 * @return true if the color is valid, false if it does'nt (gray would be initialized instead)
	 */
	public boolean setFurColor(String furColor) {
		boolean isSuccess = furColor.equals("BLACK") || furColor.equals("WHITE") || furColor.equals("GRAY");
		if (isSuccess)
		{	
			this.furColor = furColor;
			MessageUtility.logSetter(this.getName(), "setFurColor", furColor, isSuccess);
		}
		else
		{
			MessageUtility.logSetter(this.getName(), "setFurColor", furColor, isSuccess);
			this.setFurColor("GRAY");
		}
		return isSuccess;
	}

	/**
	*  An method that prints the bear's sound.
	* 
	* @version 1.0
	*
	* @param None
	* 
	* @return None (void)
	 */
	public void roar()
	{
		MessageUtility.logSound(this.getName(), "Stands on its hind legs, roars and scratches its belly");
	}
	
	@Override
	public boolean equals(Object o)
	{
		Bear b = null;
		if (super.equals(o))
		{
			if(o instanceof Bear)
				{
					b = (Bear) o;
					return this.getFurColor() == b.getFurColor();
				}
			else
				return false;
		}
		else 
			return false;
	
	}
}

