package vn.topica.itlab4.multithread.task2;

import java.util.Random;
/**
 * 
 * @author AnhLT14
 */
public class Lamp {
	public enum Status {//define an enum type Status
		ON, OFF, REPAIR
	}

	public Status status;//define field status
	int index;//define field index
	
	/**
	 * method constructor with parameter index
	 * index will be automatically increased when we create a new object Lamp by using AtomicInteger (in Thread1)
	 * field "status" is generated randomly using switch-case 
	 */
	public Lamp(int index){
		this.index = index;
		
		//randomly generate status
		switch(new Random().nextInt(3)) {
		case 0:
			this.status = Status.ON;
			break;
		case 1:
			this.status = Status.OFF;
			break;
		case 2:
			this.status = Status.REPAIR;
			break;
		}
	}
	
	//override method toString() to print out the fields of object Lamp
	@Override
	public String toString() {
		return String.format("%s  %d",this.status,this.index);
	}
}