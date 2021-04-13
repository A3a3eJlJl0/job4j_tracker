package ru.job4j.poly;

public interface Transport {
    void ride();

    void setPassengers(int passengers);

    double refuel(double volume);
}
