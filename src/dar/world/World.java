package dar.world;

import dar.player.Player;

public class World {
	public static final int HEIGHT = 9 * 2;
	public static final int WIDTH = 16 * 2;

	private static BlockID world[][] = new BlockID[WIDTH][HEIGHT];
	private static Player player = new Player();

	static {
		for (int x = 0; x < WIDTH; x++) {
			for (int y = 0; y < HEIGHT; y++) {
				world[x][y] = BlockID.AIR;
			}
		}
	}

	public static Player getPlayer() {
		return player;
	}

	public static BlockID get(int x, int y) {
		return world[x][y];
	}

	public static void set(int x, int y, BlockID block) {
		world[x][y] = block;
	}
}
