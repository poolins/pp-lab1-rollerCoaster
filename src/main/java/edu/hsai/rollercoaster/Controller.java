package edu.hsai.rollercoaster;

import java.util.LinkedList;

public class Controller {
    private LinkedList<Person> peopleInQueue = new LinkedList<>();

    public synchronized void addIntoQueue(Person person) {
        int maxPeopleInQueue = 10;
        while (peopleInQueue.size() == maxPeopleInQueue) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        peopleInQueue.add(person);
        notifyAll();
    }

    synchronized public Person letInCart() {
        Person firstPerson;
        while (peopleInQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        firstPerson = peopleInQueue.removeFirst();
        notifyAll();
        return firstPerson;
    }
}
