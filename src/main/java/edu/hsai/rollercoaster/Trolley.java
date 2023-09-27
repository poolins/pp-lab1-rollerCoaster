package edu.hsai.rollercoaster;

import java.util.ArrayList;
import java.util.Random;

public class Trolley implements Runnable {
    private final Controller controller;
    private ArrayList<Person> peopleInTrolley;

    Trolley(Controller controller) {
        this.controller = controller;
        peopleInTrolley = new ArrayList<>();
    }

    public void rideTrolley() {
        try {
            System.out.println("All people are in the trolley");
            System.out.println("\n >>>>>>> Trolley is departing with " + peopleInTrolley.size() + " passengers <<<<<<< \n");
            Thread.sleep(1000 + new Random().nextInt(1000));
            System.out.println("\n >>>>>>> Trolley arrived <<<<<<< \n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void freeTrolley() {
        peopleInTrolley.clear();
    }

    public void addPeopleInTrolley() {
        int trolleySize = 10;
        for (int i = 0; i < trolleySize; i++) {
            System.out.println("Trolley is waiting for passenger");
            peopleInTrolley.add(controller.letInCart());
            System.out.println(" -> Next passenger entered the trolley" + "\n" + "Current = " + peopleInTrolley);
        }
    }

    @Override
    public void run() {
        while (true) {
            addPeopleInTrolley();
            rideTrolley();
            freeTrolley();
        }
    }
}
