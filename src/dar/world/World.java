package dar.world;

import dar.player.Player;

public class World {
	public static final int HEIGHT = 9 * 2;
	public static final int WIDTH = 16 * 2;

	private static int world[][] = new int[WIDTH][HEIGHT];
	private static Player player = new Player();

	public static Player getPlayer() {
		return player;
	}

	public static int get(int x, int y) {
		return world[x][y];
	}

	public static void set(int x, int y, int block) {
		world[x][y] = block;
	}
}
