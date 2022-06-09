package plants;

import food.EFoodType;
import food.IEdible;

public class meat implements IEdible {

	// singelton implementation for Cabbage
	private static meat meatOBJ = null;

	public static meat getInstance() {
		if (meatOBJ == null)
			meatOBJ = new meat();
		return meatOBJ;
	}
	private meat() {

	}
	
	/*
	 * A method to set the object to null
	 */
	public void SetNull() {
		meatOBJ = null;
	}
	
	/*
	 * An Override of IEdible interface method
	 */
	@Override
	public EFoodType getFoodtype() {
		return EFoodType.MEAT;
	}
	
	/*
	 * An Override of IEdible interface method
	 */
	@Override
	public IEdible clone()  {
		return meat.getInstance();
	}
	
	/*
	 * An Override of Object class method
	 * to represent this object as string
	 */
	@Override
	public String toString() {
		return "[" + this.getClass().getSimpleName() + "] ";
	}

}
