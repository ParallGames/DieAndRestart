package dar.util;

public class Random {
	public static int randInt(int max) {
		return (int) (Math.random() * max);
	}

	public static int randInt(int min, int max) {
		return (int) (Math.random() * (max - min)) + min;
	}
}
