package in.anil.java;

import java.util.Objects;

public class Transmission {
    private int gear;

    public Transmission() {
    }

    public Transmission(int gear) {
        this.gear = gear;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transmission that = (Transmission) o;
        return gear == that.gear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gear);
    }

    @Override
    public String toString() {
        return "Transmission{" +
                "gear=" + gear +
                '}';
    }
}
