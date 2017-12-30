package spaceInvaders;

import apcs.Window;

public class Enemy {
	String color;
	int x;
	int y;
	int side;
	int speed;
	int cooldown;

	public Enemy() {
		side = 40;
		x = Window.rollDice((Window.width() - side) + side / 2);
		y = Window.rollDice(100) + 50;
		color = "green";
		speed = 5;
		cooldown = 121;
	}

	public void draw() {
		Window.out.color(color);
		Window.out.square(x, y, side);
	}
	public void move() {
		x += speed;
		
		//enemy touches right
		if (x > Window.width() - side / 2) {
			speed = -speed;
			y += side;
		}
		
		//enemy touches left
		if (x < side / 2) {
			speed = - speed;
			y += side;
			
		}
	}
	
	public boolean shoot() {
		if (Window.rollDice(cooldown) == 1) {
			return true;
		}
		return false;
	}

}
