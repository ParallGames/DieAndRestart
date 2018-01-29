package dar.player;

import dar.gui.Key;
import dar.world.Blocks;
import dar.world.World;

public class Player {
	private static int height = 1800;
	private static int width = 800;

	private static int x = 0;
	private static int y = 0;

	private static int speedX = 0;
	private static int speedY = 0;

	private static boolean direction = false;
	
	private static boolean canJump = false;

	public static int getX() {
		return x;
	}

	public static int getY() {
		return y;
	}

	public static int getHeight() {
		return height;
	}

	public static int getWidth() {
		return width;
	}

	public static void accelX(int x) {
		speedX += x;
	}

	public static void accelY(int y) {
		speedY += y;
	}

	public static void jump() {
		if (canJump) {
			speedY += 170;
		}
		canJump = false;
	}

	public static void moveX(int moveX) {
		if (moveX > 0) {
			while (moveX != 0) {
				if (x >= World.WIDTH * 1000 - Player.getWidth()) {
					speedX = 0;
					return;
				}
				for (int x = 0; x < World.WIDTH; x++) {
					for (int y = 0; y < World.HEIGHT; y++) {
						if (!Blocks.get(World.get(x, y)).isAir()) {
							if ((Player.height + 1000) / 2 > Math
									.abs((Player.y + Player.height / 2) - (y * 1000 + 500))) {
								if (Player.width + Player.x == x * 1000) {
									speedX = 0;
									return;
								}
							}
						}
					}
				}
				x++;
				moveX--;
			}
		} else if (moveX < 0) {
			while (moveX != 0) {
				if (x <= 0) {
					speedX = 0;
					return;
				}
				for (int x = 0; x < World.WIDTH; x++) {
					for (int y = 0; y < World.HEIGHT; y++) {
						if (!Blocks.get(World.get(x, y)).isAir()) {
							if ((Player.height + 1000) / 2 > Math
									.abs((Player.y + Player.height / 2) - (y * 1000 + 500))) {
								if (x * 1000 + 1000 == Player.x) {
									speedX = 0;
									return;
								}
							}
						}
					}
				}
				x--;
				moveX++;
			}
		}
	}

	public static void moveY(int moveY) {
		if (moveY > 0) {
			while (moveY != 0) {
				if (y >= World.HEIGHT * 1000 - Player.getHeight()) {
					speedY = 0;
					break;
				}
				for (int x = 0; x < World.WIDTH; x++) {
					for (int y = 0; y < World.HEIGHT; y++) {
						if (!Blocks.get(World.get(x, y)).isAir()) {
							if ((Player.width + 1000) / 2 > Math
									.abs((Player.x + Player.width / 2) - (x * 1000 + 500))) {
								if (Player.height + Player.y == y * 1000) {
									speedY = 0;
									return;
								}
							}
						}
					}
				}
				y++;
				moveY--;
			}
		} else if (moveY < 0) {
			while (moveY != 0) {
				if (y <= 0) {
					speedY = 0;
					canJump = true;
					break;
				}
				for (int x = 0; x < World.WIDTH; x++) {
					for (int y = 0; y < World.HEIGHT; y++) {
						if (!Blocks.get(World.get(x, y)).isAir()) {
							if ((Player.width + 1000) / 2 > Math
									.abs((Player.x + Player.width / 2) - (x * 1000 + 500))) {
								if (y * 1000 + 1000 == Player.y) {
									speedY = 0;
									canJump = true;
									return;
								}
							}
						}
					}
				}
				y--;
				moveY++;
			}
		}
	}

	public static void tick() {
		int speed = 10;
		if (Key.isShiftDown()) {
			speed = 5;
		} else if (Key.isCtrlDown()) {
			speed = 20;
		}
		if (Key.isADown()) {
			accelX(-speed);
			direction = true;
		}
		if (Key.isDDown()) {
			accelX(speed);
			direction = false;
		}
		if (Key.isWDown()) {
			jump();
		}
		speedY -= 10;

		moveX(speedX);

		moveY(speedY);

		speedX -= speedX / 10;
		speedY -= speedY / 100;

		if (speedX > 0) {
			speedX--;
		} else if (speedX < 0) {
			speedX++;
		}
		if (speedY > 0) {
			speedY--;
		} else if (speedY < 0) {
			speedY++;
		}
	}
	
	public static boolean getDirection() {
		return direction;
	}
}
