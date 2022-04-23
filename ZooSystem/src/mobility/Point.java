 /**
    * @author 
    * Tomer Raitsis  
    * SCE, Ashdod
    */
package mobility;

/**
 *  A class that represent a point.
 *  Has 5 attributes:
 *  x- X cordinate
 *  y- Y cordinate
 *  MaxX- A static and final value represent the maximum cordinate of X
 * 	MaxY- A static and final value represent the maximum cordinate of Y
 * 	Min- A static and final value represent the minimum cordinate of both X and Y.
 * @version 1.0
 * 
 */
public class Point {
	private int x;
	private int y;
	public static final int MaxX = 800;
	public static final int MaxY = 600;
	public static final int Min = 0;

/**
 *  A Ctor of this class
 * 
 *
 * @version 1.0
 * 
 * @param x, y cordinates
 * 
 * @return None
 * 
 */
	public Point (int x,int y)
	{
		this.x = x;
		this.y = y;
	}

/**
 *  A method that returns the value of x
 * 
 * @version 1.0
 * 
 * @param None
 * 
 * @return value of x
 * 
 */
	public int GetX() {return this.x;}

/**
 *  A method that returns the value of y
 * 
 * @version 1.0
 * 
 * @param None
 * 
 * @return value of y
 * 
 * @see
 */
	public int GetY() {return this.y;}

/**
 *  A static method that checks if a given point is between the limits
 * 
 *
 * @version 1.0
 * 
 * @param newLocation - Point object
 * 
 * @return true r false, depends on if the point is in the limits
 * 
 */
	public static boolean cheackBounderies(Point newLocation)
	{
		return (newLocation.GetX() < Point.MaxX) && (newLocation.GetX() >= Point.Min) && (newLocation.GetY() < Point.MaxY) && (newLocation.GetY() >= Point.Min);
	}
}
