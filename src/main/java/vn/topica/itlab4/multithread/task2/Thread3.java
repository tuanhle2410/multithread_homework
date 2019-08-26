package vn.topica.itlab4.multithread.task2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import vn.topica.itlab4.multithread.task2.Lamp.Status;

public class Thread3 extends Thread {
	Store store;// initiate a Store
	Trash trash;//initiate a Trash
	
	/**
	 * constructor with parameter store 
	 * to get the store whenever create Thread1 
	 * to manipulate store's information
	 */
	public Thread3(Store store, Trash trash) {
		this.store = store;
		this.trash = trash;
	}
	Random r = new Random();
	int random;
	@Override
	public void run() {
		System.out.println("Thread 3 is running");//show that thread 2 is running
		while (true) {//internal loop
			/**
			 * for loop to 
			 * 1. Find out the lamps with status REPAIR (REPAIR lamps) in Trash
			 * 	  - add them back to Store
			 *    - then remove them out of Trash
			 * 2. Find out the lamps with status OFF (OFF lamps) in Trash
			 * 	  - random a number 0 or 1
			 *    - if random number is 0: remove the lamp out of Trash
			 *    - if random number is 1:
			 * 	  		+ change their status to REPAIR
			 *    		+ then add them back to Store
			 */
			for (int i = 0; i < trash.size(); i++) {
				if (trash.get(i).status.equals(Status.REPAIR)) {//check if this lamp in Trash has status REPAIR
					store.saveToStore(trash.get(i));//add REPAIR lamp back to Store
					System.out.println("Thread 3 add REPAIR lamp back to Store: "+trash.get(i).toString());//show information of REPAIR lamp
					trash.remove(i);//remove REPAIR lamp from Trash
				}else if(trash.get(i).status.equals(Status.OFF)) {//check if this lamp in Trash has status OFF
					 random = r.nextInt(2);//create a random number (0 or 1)
					 if(random==0) {//check if the random number is 0
						 trash.remove(i);//remove the lamp out of Trash
					 }else {//check if the random number is 1
						 trash.get(i).status = Status.REPAIR;//change status of the lamp to REPAIR
						 store.saveToStore(trash.get(i));//add the lamp back to Store
						 //show the information of the OFF lamp whose status have been changed to REPAIR
						 System.out.println("Thread 3 add OFF lamp back to Store: "+trash.get(i).toString());
					 }
				}
			}
			try {
				Thread.sleep(200);//get Thread 3 sleep 200ms
			} catch (InterruptedException ex) {//catch the exception
				Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);//log out the exception
			}
		}
	}
}
