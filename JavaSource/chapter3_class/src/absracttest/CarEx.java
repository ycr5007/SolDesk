package absracttest;

public class CarEx {
	public static void main(String[] args) {
//		Car car = new Car(); // Cannot instantiate the type Car
		Car car1 = new SportsCar();
		Car car2 = new Truck();
		
		car1.startCar();
		car1.drive();
		car1.stop();
		car1.turnOff();
		System.out.println();
		car2.startCar();
		car2.drive();
		car2.stop();
		car2.turnOff();
	}
	
}
