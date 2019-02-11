package dar.world;

import dar.darMod.blocks.DARBlocks;
import dar.player.Player;

public class World {
	public static final int HEIGHT = 18;
	public static final int WIDTH = 32;

	private static int[][] world = new int[WIDTH][HEIGHT];
	private static Player player = new Player();

	static {
		for (int x = 0; x < WIDTH; x++) {
			for (int y = 0; y < HEIGHT; y++) {
				world[x][y] = DARBlocks.AIR.getID();
			}
		}

		for (int x = 0; x < WIDTH; x++) {
			world[x][0] = DARBlocks.GRASS.getID();
		}

		/*
		 * for (int y = 3; y < HEIGHT; y++) { world[0][y] = DARBlocks.GRASS.getID();
		 * world[WIDTH - 1][y] = DARBlocks.GRASS.getID(); }
		 */

		world[5][0] = DARBlocks.AIR.getID();

		world[10][1] = DARBlocks.GRASS.getID();
	}

	public static Player getPlayer() {
		return player;
	}

	public static Block get(int x, int y) {
		if (x < 0) {
			x += WIDTH;
		} else if (x >= WIDTH) {
			x -= WIDTH;
		}

		if (y < 0) {
			y += HEIGHT;
		} else if (y >= HEIGHT) {
			y -= HEIGHT;
		}

		return Blocks.get(world[x][y]);
	}

	public static void set(int x, int y, Block block) {
		world[x][y] = block.getID();
	}
}
