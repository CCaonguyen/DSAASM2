/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package MessageQueueSystem;

import java.util.Scanner;

public class MessageQueueSystem {
    public static void main(String[] args) {
        Queue messageQueue = new Queue();
        Stack messageStack = new Stack();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading the integer input.

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
        if (message.length() <= 250) {
            messageQueue.enqueue(message);
            System.out.println("Message added to the Queue.");
        } else {
            System.out.println("Message length exceeds 250 characters. Please try again.");
        }
    }

    public static void sendMessage(Queue messageQueue, Stack messageStack) {
        if (!messageQueue.is_empty()) {
            while (!messageQueue.is_empty()) {
                String message = messageQueue.dequeue();
                messageStack.push(message);
            }
            System.out.println("Messages sent and moved from Queue to Stack.");
        } else {
            System.out.println("Queue is empty. No messages to send.");
        }
    }

    public static void viewMessage(Stack messageStack) {
        if (!messageStack.is_empty()) {
            System.out.println("Messages currently in the Stack:");
            while (!messageStack.is_empty()) {
                String message = messageStack.pop();
                System.out.println(message);
            }
        } else {
            System.out.println("Stack is empty. No messages received.");
        }
    }
}
