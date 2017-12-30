package spaceInvaders;

import apcs.Window;

public class Star {
	
	int x;
	int y;
	String color;
	
	public Star() {
		x = Window.rollDice(Window.width());
		y = Window.rollDice(Window.height());
		color = "white";
	}
	
	public void draw() {
		Window.out.color(color);
		Window.out.circle(x, y, Window.rollDice(3));
	}

}
