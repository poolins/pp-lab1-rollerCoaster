package edu.hsai.rollercoaster;

import java.util.Random;

public class Customer implements Runnable {
    private final Controller controller;
    private final String customerId;
    private int count = 0;
    private final int maxNumberOfPeople;

    public Customer(Controller controller, String id, int maxNumber) {
        this.controller = controller;
        customerId = id;
        maxNumberOfPeople = maxNumber;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < maxNumberOfPeople; i++) {
            try {
                System.out.println("Waiting for customer");
                Thread.sleep(random.nextInt(1000));
                System.out.println("The wait for customer is over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String fullNumber = customerId + "-" + count;
            Person person = new Person(fullNumber);
            count++;
            System.out.println("New customer has arrived");
            controller.addIntoQueue(person);
            System.out.println("New customer entered the queue");
        }
    }
}
