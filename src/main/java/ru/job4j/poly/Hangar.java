package ru.job4j.poly;

public class Hangar {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle airplane = new Airplane();
        Vehicle[] hangar = {bus, train, airplane};
        for (Vehicle vehicle: hangar) {
            vehicle.move();
        }
    }
}
