package ru.job4j.poly;

public class Bus implements Transport{
    private int passengers;

    @Override
    public void ride() {
        System.out.println("Chuh-chuh");
    }

    @Override
    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public double refuel(double volume) {
        double rate = 51.5;
        return volume * rate;
    }
}
