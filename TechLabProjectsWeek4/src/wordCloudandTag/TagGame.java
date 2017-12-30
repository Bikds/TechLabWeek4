package wordCloudandTag;

import java.util.HashMap;

import apcs.Window;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class TagGame {
	
	static Firebase server = new Firebase("https://techlabtag.firebaseio.com/");

	public static void main(String[] args) {
		
		Window.size(1000, 700);
		Window.setFrameRate(30);
		Player p = new Player("Javale McGee");
		
		//final ArrayList<Player> players = new ArrayList<Player>();
		final HashMap<String, Player> players = new HashMap<String, Player>();
		
		server.child("online").child("Javale McGee").setValue(true);
		server.child("online").child("Javale McGee").onDisconnect().setValue(true);
		
		server.child("online").addChildEventListener(new ChildEventListener(){

			@Override
			public void onCancelled(FirebaseError arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onChildAdded(DataSnapshot arg0, String arg1) {
				// TODO Auto-generated method stub
				String name = arg0.getKey();
				if (!name.equals("Javale McGee")) {
					players.put(name, new Player(name));
				}
				
			}

			@Override
			public void onChildChanged(DataSnapshot arg0, String arg1) {
				// TODO Auto-generated method stub
				String name = arg0.getKey();
				if ((Boolean) arg0.getValue()) {
					System.out.println(name + " is online");
					
				}
				else {
					System.out.println(name + " is not online");
					server.child(name).removeValue();
					players.remove(name);
				}
				
			}

			@Override
			public void onChildMoved(DataSnapshot arg0, String arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onChildRemoved(DataSnapshot arg0) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
		
		
		while (true) {
			Window.out.background("white");
			p.draw();
			p.move();
			for (String s : players.keySet()) {
				players.get(s).draw();
				
				if (p.checkCollision(players.get(s)) && players.get(s).it) {
					p.it = true;
				}
			}
			p.setValue();
			
			Window.frame();
		}
		
	}

}
