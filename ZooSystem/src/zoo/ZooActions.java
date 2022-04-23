   /**
    * @author 
    * Tomer Raitsis  
    * SCE, Ashdod
    */

package zoo;

import food.IEdible;
import mobility.Point;
import privateutil.StaticMethodsToHelp;
import animals.Animal;
import animals.Bear;
import animals.Elephant;
import animals.Giraffe;
import animals.Lion;
import animals.Turtle;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;


/**
 *  A class that has two static methods and the main
 * 
 * @version 1.0
 */
public class ZooActions {
	
	/**
	 *  A method the gets an object and a food, gets the real animal in the object (if exists) and letting it eat the food (if possible)
	 * 
	 *
	 * @version 1.0
	 * 
	 * @param animal - the object (an animal), food - An IEdible object
	 * 
	 * @return true if there is an actual animal and if it was able to eat the food, false if is'nt.

	 */
	public static boolean eat(Object animal, IEdible food)
	{
		Animal A = StaticMethodsToHelp.FindAnimalsClass(animal);
		if (A != null && !(A == food))
		{
			return A.eat(food);
		}
		else
		{
			System.out.println("\n" + A + " Can't eat itself\n");
			return false;
		}		
		 
		
	}

/**
	/**
	 *  A method the gets an object and a food, gets the real animal in the object (if exists) and moving the animal if the point is valid. 
	 * 
	 * @version 1.0
	 * 
	 * @param animal - the object (an animal), point - An Point object
	 * 
	 * @return true if the point is valid , false if is'nt.
	 */
	public static boolean move(Object animal, Point point)
	{
		Animal A = StaticMethodsToHelp.FindAnimalsClass(animal);
		if (Point.cheackBounderies(point))
		{
			A.move(point);
			return true;
		}
		else
			return false;
		
	}
	

/**
 *  The main, crates an array of animals, tries to move them and then to randomly eat.
 * 
 * @version 1.0
 */
	public static void main(String[] args)
	{
		Scanner sc = new Scanner (System.in);
		System.out.print("Enter the size of the array (minimum 3): ");
		int choice = sc.nextInt();
		sc.nextLine();
		
		if (choice < 3)
			choice = 3;
		
		//Animal Array[] = new Animal[choice];
		ArrayList<Animal> Array = new ArrayList<Animal>();
		
		for (int i = 0; i< choice; i++)
		{
			boolean Check = true;
			
			while (Check)
			{
				System.out.print("\nChoose an animal (Write it's name):\n1. Lion\n2. Bear\n3. Elephant\n4. Giraffe\n5. Turtle\n");
				String name = null;
				String S = sc.nextLine();
				if (S.equals("Lion"))
				{
					System.out.print("Choose Your lion's name: ");
					name = sc.nextLine();
					//Array[i] = new Lion(name);
					Array.add(new Lion(name));
					Check = false;
				}
				else if (S.equals("Bear"))
				{
					System.out.print("Choose Your Bear's name: ");
					name = sc.nextLine();
					//Array[i] = new Bear(name);
					Array.add(new Bear(name));
					Check = false;
				}
				else if (S.equals("Elephant"))
				{
					System.out.print("Choose Your Elephant's name: ");
					name = sc.nextLine();
					//Array[i] = new Elephant(name);
					Array.add(new Elephant(name));
					Check = false;
				}
				else if (S.equals("Giraffe"))
				{
					System.out.print("Choose Your Giraffe's name: ");
					name = sc.nextLine();
					//Array[i] = new Giraffe(name);
					Array.add(new Giraffe(name));
					Check = false;
				}
				else if (S.equals("Turtle"))
				{
					System.out.print("Choose Your Turtle's name: ");
					name = sc.nextLine();
					//Array[i] = new Turtle(name);
					Array.add(new Turtle(name));
					Check = false;
				}
				else
					System.out.print("Invalid option, Try again.\n");
			}
			
			
			
		}
		

		Point P = null;
		int x;
		int y;
		System.out.println();
		for (int j = 0; j < choice; j++)
		{
			System.out.println("\nChoose the coordinates to move animal number " + (j+1) + " :\nX: ");
			x =  sc.nextInt();
			System.out.println("Y: ");
			y =  sc.nextInt();
			P = new Point(x,y);
			while(!Point.cheackBounderies(P))
			{
				System.out.println("Out of the bounderies , try again!\nX:");
				x =  sc.nextInt();
				System.out.println("Y: ");
				y =  sc.nextInt();
				P = new Point(x,y);
			}
			//ZooActions.move(Array[j], P);
			ZooActions.move(Array.get(j), P);
		}
		
		
		for (int k = 0; k < (choice / 2); k++)
		{
			Random r =new Random();        
			//ZooActions.eat(Array[r.nextInt(Array.length)], Array[r.nextInt(Array.length)]);
			int a = r.nextInt(Array.size());
			int b = r.nextInt(Array.size());
			if(ZooActions.eat(Array.get(a),Array.get(b)))
				Array.remove(b);

		}
		
		sc.close();
	}
}
