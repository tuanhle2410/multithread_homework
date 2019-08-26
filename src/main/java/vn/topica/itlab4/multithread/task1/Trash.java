package vn.topica.itlab4.multithread.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author AnhLT14
 */
public class Trash {
	//create an ArrayList to contain objects Lamp within running process
	List<Lamp> lampTrash = Collections.synchronizedList(new ArrayList<Lamp>());
	
	public void saveToTrash(Lamp lamp) {//add object lamp(s) generated to ArrayList lampTrash
		this.lampTrash.add(lamp);
	}
	
	public void remove(int index) {//remove object lamp(s) out of ArrayList lampTrash
		this.lampTrash.remove(index);
	}
	
	public Lamp get(int index) {//get the object lamp whose index equals to the index input
		return this.lampTrash.get(index);
	}
	
	public int size() {//get the number of elements in ArrayList lampTrash
		return this.lampTrash.size();
	}
}
