/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MessageQueueSystem;

import java.util.Scanner;

public class MessageQueueSystemtry {
    public static void main(String[] args) {
        Queue messageQueue = new Queue();
        Stack messageStack = new Stack();

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            displayMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Enter the message (max 250 characters):");
                        String message = scanner.nextLine();
                        inputMessage(message, messageQueue);
                        break;
                    case 2:
                        sendMessage(messageQueue, messageStack);
                        break;
                    case 3:
                        viewMessage(messageStack);
                        break;
                    case 4:
                        System.out.println("Exiting the program. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Input Message");
        System.out.println("2. Send Message");
        System.out.println("3. View Message");
        System.out.println("4. Exit");
        System.out.println("Enter your choice (1-4):");
    }

    public static void inputMessage(String message, Queue messageQueue) {
        try {
            if (message.trim().isEmpty()) {
                throw new IllegalArgumentException("The message cannot be blank.");
            } else if (message.length() > 250) {
                throw new IllegalArgumentException("Message length exceeds 250 characters.");
            } else {
                messageQueue.enqueue(message);
                System.out.println("Message added to the Queue.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void sendMessage(Queue messageQueue, Stack messageStack) {
        try {
            if (!messageQueue.is_empty()) {
                while (!messageQueue.is_empty()) {
                    String message = messageQueue.dequeue();
                    messageStack.push(message);
                }
                System.out.println("Messages sent and moved from Queue to Stack.");
            } else {
                throw new IllegalStateException("Queue is empty. No messages to send.");
            }
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void viewMessage(Stack messageStack) {
        try {
            if (!messageStack.is_empty()) {
                System.out.println("Messages currently in the Stack:");
                while (!messageStack.is_empty()) {
                    String message = messageStack.pop();
                    System.out.println(message);
                }
            } else {
                throw new IllegalStateException("Stack is empty. No messages received.");
            }
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
