package kieraGeneral;

import java.util.Random;

public class UsefulMethods {
	/**
	 * Random number generator within range
	 * pulled from https://www.mkyong.com/java/java-generate-random-integers-in-a-range/
	 * @param min
	 * @param max
	 * @return
	 */
	private static int RandomInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

}
