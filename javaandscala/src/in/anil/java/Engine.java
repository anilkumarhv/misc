package in.anil.java;

import java.util.Objects;

public class Engine {
    private int rpm;

    public Engine() {
    }

    public Engine(int rpm) {
        this.rpm = rpm;
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return rpm == engine.rpm;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rpm);
    }

    @Override
    public String toString() {
        return "Engine{" +
                "rpm=" + rpm +
                '}';
    }
}
