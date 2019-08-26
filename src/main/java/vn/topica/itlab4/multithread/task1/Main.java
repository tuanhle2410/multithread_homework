package vn.topica.itlab4.multithread.task1;

/**
 * 
 * @author AnhLT14
 */
public class Main {
	public static void main(String[] args) throws InterruptedException {
		Store store = new Store();//initiate object Store
		Trash trash = new Trash();//initiate object Trash
		Thread1 t1 = new Thread1(store);//initiate Thread1 and pass parameter store into it
		Thread2 t2 = new Thread2(store, trash);//initiate Thread2 and pass parameter store and trash into it

		t1.start();//run thread 1
		t2.start();//run thread 2
	}
}
