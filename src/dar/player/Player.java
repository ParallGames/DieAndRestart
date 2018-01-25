package dar.player;

import dar.gui.Key;
import dar.world.World;

public class Player {
	private static int height = 1800;
	private static int width = 800;

	private static int x = 0;
	private static int y = 0;

	private static int speedX = 0;
	private static int speedY = 0;

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
			speedY += 200;
		}
		canJump = false;
	}

	public static void tick() {
		if (Key.isADown()) {
			accelX(-10);
		} else if (Key.isDDown()) {
			accelX(10);
		}
		if (Key.isWDown()) {
			jump();
		}
		speedY -= 10;

		int moveX = speedX;
		if (moveX > 0) {
			while (moveX != 0) {
				if (x >= World.WIDTH * 1000 - Player.getWidth()) {
					speedX = 0;
					break;
				}
				x++;
				moveX--;
			}
		} else if (moveX < 0) {
			while (moveX != 0) {
				if (x <= 0) {
					speedX = 0;
					break;
				}
				x--;
				moveX++;
			}
		}

		int moveY = speedY;
		if (moveY > 0) {
			while (moveY != 0) {
				if (y >= World.HEIGHT * 1000 - Player.getHeight()) {
					speedY = 0;
					break;
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
				y--;
				moveY++;
			}
		}

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
}
