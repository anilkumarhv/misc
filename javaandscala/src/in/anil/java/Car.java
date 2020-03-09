package in.anil.java;

import java.util.Objects;

public class Car {
    private String name;
    private Engine engine;
    private Transmission transmission;

    Car(String name, Engine engine, Transmission transmission) {
        this.name = name;
        this.engine = Objects.requireNonNull(engine, "Engine can not be null");
        this.transmission = Objects.requireNonNull(transmission, "Transmission can not be null");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRpm(int rpm) {
        engine.setRpm(rpm);
    }

    public void setGear(int gear) {
        transmission.setGear(gear);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return name.equals(car.name) &&
                engine.equals(car.engine) &&
                transmission.equals(car.transmission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, engine, transmission);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", engine=" + engine +
                ", transmission=" + transmission +
                '}';
    }
}
