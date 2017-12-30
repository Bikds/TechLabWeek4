package spaceInvaders;

import java.util.ArrayList;

import apcs.Window;


public class SpaceInvaders {

	public static void main(String args[]) {

		Window.size(800, 600);

		Player p = new Player();
		ArrayList<Star> stars = new ArrayList<Star>();

		for (int i = 0; i < 200; i++) {
			stars.add(new Star());
		}

		ArrayList<Bullet> bullets = new ArrayList<Bullet>();

		ArrayList<Enemy> e = new ArrayList<Enemy>();

		for (int i = 0; i < 50; i++) {
			e.add(new Enemy());

		}

		while (true) {

			for (int i = 0; i < stars.size(); i++) {
				stars.get(i).draw();
			}

			p.draw();
			p.move();

			if (p.shoot()) {
				bullets.add(new Bullet(p.x, p.y, true));
			}
			for (int i = 0; i < e.size(); i++) {
				e.get(i).draw();
				e.get(i).move();

				if (e.get(i).shoot()) {
					bullets.add(new Bullet(e.get(i).x, e.get(i).y, false));
				}
			}

			for (int i = 0; i < bullets.size(); i++) {
				bullets.get(i).draw();
				bullets.get(i).move();

				if (bullets.get(i).checkBoundaries()) {
					bullets.remove(i);
					i--;
				}
			}

			for (int i = 0; i < bullets.size(); i++) {
				for (int j = 0; j < e.size(); j++) {
					if (bullets.get(i).player && bullets.get(i).checkEnemy(e.get(j))) {
						bullets.remove(i);
						e.remove(j);                       
						i--;
						break;
					}
				}


			}

			for (int i = 0; i < bullets.size(); i++) {
				if (bullets.get(i).checkPlayer(p) && bullets.get(i).player == false) {
					Window.out.color("white");
					Window.out.print("Game over", 150, 150);
					Window.frame(1000);
					System.exit(0);
				}
			}

			for (int i = 0; i < bullets.size(); i++) {
				for (int j = 0; j < bullets.size(); j++) {
					if(i != j&& bullets.get(i).checkBullet(bullets.get(j))) {
						bullets.remove(i);
						j--;
						bullets.remove(j);
						i--;
						break;
					}
				}
			}


			Window.frame();
		}
	}

}
