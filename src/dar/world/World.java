package dar.world;

import dar.player.Player;

public class World {
	public static final int HEIGHT = 18;
	public static final int WIDTH = 32;

	private static int[][] world = new int[WIDTH][HEIGHT];
	private static Player player = new Player();

	static {
		for (int x = 0; x < WIDTH; x++) {
			for (int y = 0; y < HEIGHT; y++) {
				world[x][y] = Blocks.get("dar:air").getID();
			}
		}

		for (int x = 0; x < WIDTH; x++) {
			world[x][0] = Blocks.get("dar:grass").getID();
		}

		for (int y = 0; y < HEIGHT; y++) {
			world[0][y] = Blocks.get("dar:grass").getID();
			world[WIDTH - 1][y] = Blocks.get("dar:grass").getID();
		}
	}

	public static Player getPlayer() {
		return player;
	}

	public static Block get(int x, int y) {
		return Blocks.get(world[x][y]);
	}

	public static void set(int x, int y, Block block) {
		world[x][y] = block.getID();
	}
}
