 /**
    * @author 
    * Tomer Raitsis 316160167
    * SCE, Ashdod
    *    
    */
package graphics;

import java.awt.Graphics;

/**
 *  An interface that represent a drawable object,
 *  has a static variable to the pictures full path
 * 
 * @version 1.0
 * 
 */
public interface IDrawable {
	public final static String PICTURE_PATH = "C:/Users/tomer/OneDrive/שולחן העבודה/עבודה 3 JAVA/תמונות/";
	
	/**
	 *  A method to load the animal's images 
	 * 
	 * @version 1.0
	 * 
	 * @param nm - A string of the pictures color
	 * 
	 * @return None
	 */
	public void loadImages(String nm);

	/**
	 *  A method to draw the object on the screen
	 * 
	 * @version 1.0
	 * 
	 * @param g - Graphics
	 * 
	 * @return None
	 */
	public void drawObject(Graphics g);
	
	/**
	 *  A method to get the animal's color (int a String)
	 * 
	 * @version 1.0
	 * 
	 * @param None
	 * 
	 * @return String of the color
	 */
	public String getColor();
}
