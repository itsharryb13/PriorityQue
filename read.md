This Java program demonstrates the use of a priority queue to manage and process orders. Let's break down the code:

 **Main Method:**
    - Creates a `PriorityQueue` named `orderQueue` to store orders.
    - Generates 10 random orders using the `getRandomOrder()` method and adds them to the queue using the `acceptOrder` method.
    - Calls the `processOrders` method to simulate processing the orders from the queue.

 **Order Class:**
    - A nested static class `Order` is defined to represent an order.
    - An order has an order ID, client name, processing time, and priority.
    - The class implements the `Comparable` interface to allow comparison of orders based on their priority and order ID.
    - The `compareTo` method is overridden to define the comparison logic.

**acceptOrder Method:**
    - A private method that accepts an order and adds it to the priority queue using the `offer` method.

 **getRandomProcessingTime Method:**
    - A private method that generates and returns a random processing time between 1 and 2 seconds.

 **processOrders Method:**
    - A private method that processes orders from the priority queue.
    - It uses a `while` loop to continuously process orders until the queue is empty.
    - For each order, it simulates processing time using `Thread.sleep`, and then prints a message indicating that the order has been processed, along with its details.

 **getRandomOrder Method:**
    - A private method that generates and returns a random order.
    - It randomizes the order ID, client name, processing time, and priority for each order.
