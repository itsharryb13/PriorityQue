package priorityque;
import java.util.*;

/**
 * priority queue
 * 
 * 
 * 
 * Authors:
 * - Harpreet Singh
 * - Ryan Serrano
 * - Luisa Valencia
 */

public class PriorityQue {
    public static void main(String[] args) {
        // Create priority queue to store orders
        PriorityQueue<Order> orderQueue = new PriorityQueue<>();
        
        // Create and add random orders to the queue
        for(int i = 0; i < 10; i++) {
            acceptOrder(orderQueue, getRandomOrder());
        }
        
        // Process orders from the queue
        processOrders(orderQueue);
    }

    // Order class representing an order with orderID, client name, processing time, and priority
    static class Order implements Comparable<Order> {
        int orderId;
        String clientName;
        int processingTime;
        int priority;

        public Order(int orderId, String clientName, int processingTime, int priority) {
            this.orderId = orderId;
            this.clientName = clientName;
            this.processingTime = processingTime;
            this.priority = priority;
        }

        // Compare orders based on priority and order ID
        @Override
        public int compareTo(Order o) {
            if (this.priority == 0 && o.priority == 0) {
                return Integer.compare(this.orderId, o.orderId);
            } else if (this.priority == 0) {
                return 1;
            } else if (o.priority == 0) {
                return -1;
            } else {
                return Integer.compare(this.priority, o.priority);
            }
        }
    }

    // Method to accept an order and add it to the queue
    private static void acceptOrder(PriorityQueue<Order> orderQueue, Order order) {
        orderQueue.offer(order);
    }

    // Method to generate random processing time
    private static int getRandomProcessingTime() {
        return (int) (Math.random() * 2) + 1;
    }

    // Method to process orders from the queue
    private static void processOrders(PriorityQueue<Order> orderQueue) {
        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.poll(); // takes out the next order in the queue
            try {
                Thread.sleep(order.processingTime * 1000); // simulates waiting time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (order.priority == 0) {
                System.out.println("Order " + order.orderId + " processed for " + order.clientName +
                        " with no priority ");
            } else {
                System.out.println("Order " + order.orderId + " processed for " + order.clientName +
                        " with priority " + order.priority);
            }
        }
    }

    // Method to generate random orders
    private static Order getRandomOrder() {
        int orderId = (int) (Math.random() * 100) + 1; // randomizes order ID
        String clientName = "Client" + orderId; // randomizes client ID
        int processingTime = getRandomProcessingTime(); // randomizes processing time
        int priority = (int) (Math.random() * 3); // randomizes priority
        return new Order(orderId, clientName, processingTime, priority);
    }
}
