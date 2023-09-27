package edu.hsai.rollercoaster;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RollerCoaster {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Trolley trolley = new Trolley(controller);
        Customer customer = new Customer(controller, "i", 20);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(customer);
        executorService.submit(trolley);
    }
}