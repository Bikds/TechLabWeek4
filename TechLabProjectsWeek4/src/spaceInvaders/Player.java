package spaceInvaders;

import apcs.Window;

public class Player {
	
	int x;
	int y;
	int side = 40;
	String color;
	int cooldown;
	int speed;
	
	
	public Player() {
		x = Window.width() / 2;
		y = Window.height() - 50;
		color = "blue";
		cooldown = 5;
		speed = 12;
	}
	
	public void draw() {
		Window.out.color(color);
		Window.out.square(x, y, side);
	}
	public void move() {
		if (Window.key.pressed("left") && x > side / 2) {
			x -= speed;
		}
		else if (Window.key.pressed("right") && x < Window.width() - side / 2) {
			x += speed;
		}
	}
	public boolean shoot() {
		if (Window.key.pressed("space") && cooldown >= 5) {
			cooldown = 0;
		return true;
		}
		cooldown ++;
		return false;
	}

}
