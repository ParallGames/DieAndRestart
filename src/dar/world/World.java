package dar.world;

import dar.player.Player;

public class World {
	public static final int HEIGHT = 18;
	public static final int WIDTH = 32;

	private static BlockID[][] world = new BlockID[WIDTH][HEIGHT];
	private static Player player = new Player();

	static {
		for (int x = 0; x < WIDTH; x++) {
			for (int y = 0; y < HEIGHT; y++) {
				world[x][y] = BlockID.AIR;
			}
		}

		for (int x = 0; x < WIDTH; x++) {
			world[x][0] = BlockID.GRASS;
		}

		for (int y = 0; y < HEIGHT; y++) {
			world[0][y] = BlockID.GRASS;
			world[WIDTH - 1][y] = BlockID.GRASS;
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
