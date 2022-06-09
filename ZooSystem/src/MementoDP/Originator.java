package MementoDP;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import animals.Animal;
import food.IEdible;
import graphics.Controller;

/**
 * This class represents the originator of the Memento DP, it has a inner class for 
 * a Memento(Saved state).
 * 
 * In this system state have:
 * 1. Animals ArrayList (deep copy using clone)
 * 2. Food (deep copy using clone)
 * 3. Thread Pool (deep copy using clone)
 * 4. BackGround
 * 5. A flag if the animals are asleep
 * 
 */
public class Originator {
	public ArrayList<Animal> Animals = new ArrayList<Animal>();
	public IEdible Food;
	public ExecutorService threadPoolExecutor = (ExecutorService) Executors.newFixedThreadPool(10);

	public class Memento {
		private ArrayList<Animal> Animals1;
		private IEdible Food1;
		private ExecutorService threadPoolExecutor1 = (ExecutorService) Executors.newFixedThreadPool(10);
		private int BG;
		private boolean isSleep = false;

		public Memento(ArrayList<Animal> A, IEdible F, int bg1, Controller cr1) {
			Animals1 = new ArrayList<Animal>();
			for (int i = 0; i < A.size(); i++) {
				Animal pre = A.get(i);
				Animal a = (Animal) pre.clone();
				a.getob().addObserver(cr1);
				threadPoolExecutor1.execute(a);
				a.setSuspended();

				Animals1.add(a);
			}
			if (A.size() > 0)
				isSleep = A.get(0).isTreadSuspended();

			if (F != null)
				Food1 = F.clone();
			else
				Food1 = null;
			BG = bg1;

		}

		public ArrayList<Animal> getList() {
			return Animals1;
		}

		public IEdible getFood() {
			return Food1;
		}

		public ExecutorService getTPool() {
			return threadPoolExecutor1;
		}

		public int getBg() {
			return BG;
		}

		public boolean getisSleep() {
			return isSleep;
		}

		@Override
		public String toString() {
			return "%d ".formatted(Animals1.size()) + "Animals, Food is " + "%s".formatted(Food1);
		}

	}

	public Originator() {
	}

	public Memento save(int bg, Controller cr) {
		return new Memento(Animals, Food, bg, cr);
	}

	public void restore(Memento m) {

		for (int i = 0; i < Animals.size(); i++) {
			Animals.get(i).shut();
		}
		threadPoolExecutor.shutdown();
		Animals.clear();

		Animals = new ArrayList<Animal>();
		ArrayList<Animal> AnimalsTemp = m.getList();
		for (int i = 0; i < AnimalsTemp.size(); i++) {
			Animals.add(AnimalsTemp.get(i));
		}
		if (!m.getisSleep()) {
			for (Animal a : Animals) {
				a.setResumed();
			}
		}
		Food = m.getFood();
		threadPoolExecutor = m.getTPool();
	}
}
