package graphics;

import java.util.Observable;
import java.util.Observer;

import animals.Animal;


/**
 * This class is used to connect between animals,
 * checks if they can eat each other or the food on the screen
 * if an animal can not eat another animal of food it will keep moving 
 * same as before. 
 * 
 * @version 1.0
 */
public class Controller implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		ZooPanel zp = (ZooPanel) arg;
		if (!zp.CheckIfSuspended()) {
			boolean c = false;

			if (zp.isChange()) {
				zp.repaint();

			}

			for (int i = 0; i < zp.getOriginator().Animals.size(); i++) {
				Animal a = zp.getOriginator().Animals.get(i);

				for (int j = 0; j < zp.getOriginator().Animals.size(); j++) {
					Animal b = zp.getOriginator().Animals.get(j);

					if (a != b) {
						if (a.getWeight() > (2 * b.getWeight())) {
							if (a.calcDistance(b.getLocation()) < b.getSize()) {
								if (a.eat(b)) {
									a.eatInc();
									b.shut();
									zp.getOriginator().Animals.remove(b);
									c = true;
									break;
								}
							}
						}
					}
				}
				if (c)
					break;

			}

			if (zp.getOriginator().Food != null) {
				for (int i = 0; i < zp.getOriginator().Animals.size(); i++) {
					Animal a = zp.getOriginator().Animals.get(i);

					if (zp.getOriginator().Food != null && a.getDiet().canEat(zp.getOriginator().Food.getFoodtype())) {
						a.setToCenter();
						if (Math.abs(a.getLocation().GetX() - (400)) <= a.getEAT_DISTANCE()
								&& Math.abs(a.getLocation().GetY() - (300)) <= a.getEAT_DISTANCE()) {

							if (a.eat(zp.getOriginator().Food)) {
								a.eatInc();

								a.setbackX();
								a.setY_dir(1);

								for (int j = 0; j < zp.getOriginator().Animals.size(); j++) {
									Animal d = zp.getOriginator().Animals.get(j);
									if (zp.getOriginator().Food != null && i != j
											&& d.getDiet().canEat(zp.getOriginator().Food.getFoodtype())) {
										d.setbackX();
										d.setY_dir(-1);
									}
								}
								if (zp.getOriginator().Food != null) {
									zp.getOriginator().Food.SetNull();
									zp.getOriginator().Food = null;
									break;
								}
								

							}
						}
					} else {
						if (!a.getFlag().get()) {
							a.setFlag(true);
							a.setY_dir(1);
						}
					}

				}
			}

		}
	}

}
