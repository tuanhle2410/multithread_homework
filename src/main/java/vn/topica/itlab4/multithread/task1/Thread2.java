package vn.topica.itlab4.multithread.task1;

import java.util.logging.Level;
import java.util.logging.Logger;

import vn.topica.itlab4.multithread.task1.Lamp.Status;

/**
 * 
 * @author AnhLT14
 */
public class Thread2 extends Thread {
	Store store;// initiate a Store
	Trash trash;//initiate a Trash
	
	/**
	 * constructor with parameter store 
	 * to get the store whenever create Thread1 
	 * to manipulate store's information
	 */
	public Thread2(Store store, Trash trash) {
		this.store = store;
		this.trash = trash;
	}

	@Override
	public void run() {
		System.out.println("Thread 2 is running");//show that thread 2 is running
		while (true) {//internal loop
			/**
			 * for loop to find out the lamps with status OFF (OFF lamps)
			 * add them to Trash
			 * then remove them out of Store
			 */
			for (int i = 0; i < store.size(); i++) {
				if (store.get(i).status.equals(Status.OFF)) {//check if this lamp in Store has status OFF
					trash.saveToTrash(store.get(i));//add OFF lamp to Trash
					System.out.println("Thread 2 remove lamp to trash: "+store.get(i).toString());//show information of OFF lamp
					store.remove(i);//remove OFF lamp from Store
				}
				try {
					Thread.sleep(200);//get Thread 2 sleep 200ms
				} catch (InterruptedException ex) {//catch the exception
					Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);//log out the exception
				}
			}
		}
	}
}
