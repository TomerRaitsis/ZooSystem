 /**
    * @author 
    * Tomer Raitsis  
    * SCE, Ashdod
    */
package mobility;
import java.lang.Math;

/**
 *  An abstract class that represent an object that can move, implements ILocatable
 *  Has two attributes:
 *  location - The current location of the object.
 *  totalDistance - The distance the object moved.
 *  
 * @version 1.0
 * 
 */
public abstract class Mobile implements ILocatable {
	private Point location;
	private double totalDistance;

/**
 *  The Ctor of this class 
 * 
 * @version 1.0
 * 
 * @param Point object that sets the location of this object
 * 
 */
	public Mobile(Point P)
	{
		this.location = P;
		this.totalDistance = 0;
	}
	

/**
 *  A method that that adds a given value to the total distance 
 * 
 * @version 1.0
 * 
 * @param D - The value that need to be added to the corrent distance
 * 
 * @return Nothing. (A void method)
 * 
 */
	public void addTotalDistance(double D)
	{
		this.setTotalDistance(this.getTotalDistance() + D);
	}

/**
 *  A method that calcs the distance from a current location to a given point
 *  by formula: sqrt((x1-x2)^2  -  (y1-y2)^2) 
 *  
 * @version 1.0
 * 
 * @param P - A given point
 * 
 * @return The value of the distance (double)
 * 
 */
	public double calcDistance(Point P)
	{
		int x = P.GetX() - this.location.GetX();
		int y = P.GetY() - this.location.GetY();
		return Math.sqrt((x*x) + (y*y));
		
	}

/**
 *  A method that moves (changes current lcation) to a given point
 * 
 * @version 1.0
 * 
 * @param P - Point object that represent the new location
 * 
 * @return The distance between the current point and P (double)
 * 
 */
	public double move(Point P)
	{
		if (Point.cheackBounderies(P))
		{
			double newD = this.calcDistance(P);
			
			this.addTotalDistance(newD);
			this.setLocation(P);
			
			return newD;
		}
		return 0;
		
	}

/**
 *  A method that return The current location
 *  
 * @version 1.0
 * 
 * @param None
 * 
 * @return Point object of the current location
 * 
 */
	public Point getLocation()
	{
		return this.location;
	}

/**
 *  A method that that sets a new given location a the current one (if its between the bounderis)
 * 
 * @version 1.0
 * 
 * @param P - Point object of the new point
 * 
 * @return true or false, depends if the new value was legal (and initialized) or not
 * 
 */
	public boolean setLocation(Point P)
	{
		if (Point.cheackBounderies(P))
		{
			this.location = new Point(P.GetX(),P.GetY());
			return true;
		}
		return false;
	}

/**
 *  A method that returns the total distance.
 * 
 * @version 1.0
 * 
 * @param None
 * 
 * @return The total distance (double)
 * 
 * @see
 */
	public double getTotalDistance() {return this.totalDistance;}

/**
 *  A method that that sets the total distance to a given number (if its > 0)
 * 
 * @version 1.0
 * 
 * @param d- The new distance
 * 
 * @return true or false, depends on if the given value is legal or not
 * 
 */
	public boolean setTotalDistance(double d) 
	{
		if (d > 0)
		{
			this.totalDistance = d;
			return true;
		}
		else 
			return false;
	}
	
	
}

