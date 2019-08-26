package vn.topica.itlab4.multithread.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author AnhLT14
 */
public class Store {
	//create an ArrayList to contain objects Lamp within running process
	List<Lamp> lampStore = Collections.synchronizedList(new ArrayList<Lamp>());
	
	public void saveToStore(Lamp lamp) {//add object lamp(s) generated to ArrayList lampStore
		this.lampStore.add(lamp);
	}
	
	public void remove(int index) {//remove object lamp(s) out of ArrayList lampStore
		this.lampStore.remove(index);
	}
	
	public Lamp get(int index) {//get the object lamp whose index equals to the index input
		return this.lampStore.get(index);
	}
	
	public int size() {//get the number of elements in ArrayList lampStore
		return this.lampStore.size();
	}
}
