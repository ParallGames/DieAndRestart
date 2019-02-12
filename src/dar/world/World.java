package dar.world;

import dar.darMod.blocks.DARBlocks;
import dar.player.Player;

public class World {
	public static final int HEIGHT = 18;
	public static final int WIDTH = 32;

	public static final int UNIT = 1024;

	public static final int UNIT_HEIGHT = HEIGHT * UNIT;
	public static final int UNIT_WIDTH = WIDTH * UNIT;

	private static int[][] world = new int[WIDTH][HEIGHT];
	private static Player player = new Player();

	public static int getUnits(double blocks) {
		return (int) (blocks * UNIT);
	}

	static {
		for (int x = 0; x < WIDTH; x++) {
			for (int y = 0; y < HEIGHT; y++) {
				set(x, y, DARBlocks.AIR);
			}
		}

		for (int x = 0; x < WIDTH; x++) {
			set(x, 0, DARBlocks.GRASS);
		}

		set(5, 0, DARBlocks.AIR);

		set(10, 1, DARBlocks.GRASS);

		set(15, 2, DARBlocks.GRASS);

		set(25, 3, DARBlocks.GRASS);
		set(26, 3, DARBlocks.GRASS);
		set(27, 3, DARBlocks.GRASS);
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

		world[x][y] = block.getID();
	}
}
