 /**
    * @author 
    * Tomer Raitsis
    * SCE, Ashdod
    */
package mobility;

/**
 * An interface that represent object that can be moved
 *
 * @version 1.0
 * 
 */
public interface ILocatable {

/**
 *  A method that return a Point object of the current location 
 * 
 * @version 1.0
 * 
 * @param None
 * 
 * @return Point object of the current location 
 * 
 */
	public Point getLocation();

/**
 *  A method that sets the location of the object implementing this interface 
 * 
 * @version 1.0
 * 
 * @param Point object, represent the new point
 * 
 * @return true or false, if this method succeded
 * 
 * @see
 */
	public boolean setLocation(Point P);
}
