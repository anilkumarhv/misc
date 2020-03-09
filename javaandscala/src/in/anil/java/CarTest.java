package in.anil.java;

public class CarTest {
    public static void main(String[] args) {
        Engine engine = new Engine();
        Transmission transmission = new Transmission();
//        Car car = new Car(engine, transmission);
        Car car = new Car("Ferrari", engine, transmission);
        Car car1 = new Car("Ferrari", engine, transmission);
        car.setGear(5);
        car.setRpm(10000);

        System.out.println(car.hashCode());
        System.out.println(car1.hashCode());

        System.out.println(car);
    }
}
