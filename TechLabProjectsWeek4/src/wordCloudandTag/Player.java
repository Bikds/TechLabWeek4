package wordCloudandTag;

/*
 * @author BikDS
 * July 7, 2017
 * This class is the player
 */


import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import apcs.Window;

public class Player {
	int x;
	int y;
	int r, g, b;
	String name;
	int radius = 20;
	boolean it = false;

	public Player(String name) {
		x  = Window.rollDice(Window.width() - radius) + radius / 2;
		y  = Window.rollDice(Window.height() - radius) + radius / 2;

		this.name = name;
		r = Window.rollDice(255);
		g = Window.rollDice(255);
		b = Window.rollDice(255);
		addListeners();
		setValue();
		
	}
	public boolean checkCollision(Player p) {
		int a = x - p.x;
		int b = y - p.y;
		int c = radius + p.radius;
		
		if ( a * a + b * b < c * c) {
			return true;
		}
		
		return false;
		
	}
	
	public void setValue() {
		//TagGame.server.child(name).setValue(name);
		TagGame.server.child(name).child("x").setValue(x);
		TagGame.server.child(name).child("y").setValue(y);
		TagGame.server.child(name).child("it").setValue(it);
		
	}
	
	public void addListeners() {
		TagGame.server.child(name).child("it").addValueEventListener(new ValueEventListener() {

			@Override
			public void onCancelled(FirebaseError arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onDataChange(DataSnapshot arg0) {
				// TODO Auto-generated method stub
				if (arg0.getValue() != null) {
					it = (Boolean) arg0.getValue();
				}
				
			}
			
			
		});
			TagGame.server.child(name).child("x").addValueEventListener(new ValueEventListener() {

			@Override
			public void onCancelled(FirebaseError arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onDataChange(DataSnapshot data) {
				if (data.getValue() != null){
					long x2 = (Long) data.getValue();
					x = (int) x2;
				}
			}
			
		});
		
		TagGame.server.child(name).child("y").addValueEventListener(new ValueEventListener() {

			@Override
			public void onCancelled(FirebaseError arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onDataChange(DataSnapshot data) {
				if (data.getValue() != null){
					long y2 = (Long) data.getValue();
					y = (int) y2;
				}
			}
			
		});


	}

	public void draw() {
		if (it) {
			Window.out.randomColor();
		}
		else {
			Window.out.color(r, g, b);
		}
		Window.out.circle(x, y, radius);
		Window.out.color("black");
		Window.out.print(name, x, y);
	}

	public void move() {
		if (Window.key.pressed("up")) {
			y -= 7;
		}
		if (Window.key.pressed("down")) {
			y += 7;
		}
		if (Window.key.pressed("left")) {
			x -= 7;
		}
		if (Window.key.pressed("right")) {
			x += 7;
		} 
		if (x < radius) {
			x = radius;
		}
		if (y < radius) {
			y = radius;
		}
		if (x > Window.width() - radius) {
			x = Window.width() - radius;
		}
		if (y > Window.height() - radius) {
			y = Window.height() - radius;
		}
	}
}
