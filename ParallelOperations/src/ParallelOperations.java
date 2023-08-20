import java.util.Scanner;

public class ParallelOperations {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the first positive integer: ");
		int num1 = scanner.nextInt();

		System.out.print("Enter the second positive integer: ");
		int num2 = scanner.nextInt();

		scanner.close();

		if (num1 < 0 || num2 < 0) {
			System.out.println("Both numbers should be positive integers.");
			return;
		}

		// Create threads for each operation
		Thread addThread = new Thread(() -> System.out.println("Addition: " + (num1 + num2)));
		Thread subtractThread = new Thread(() -> System.out.println("Subtraction: " + (num1 - num2)));
		Thread multiplyThread = new Thread(() -> System.out.println("Multiplication: " + (num1 * num2)));
		Thread divideThread = new Thread(() -> {
			if (num2 != 0) {
				System.out.println("Division: " + ((double) num1 / num2));
			} else {
				System.out.println("Cannot divide by zero.");
			}
		});

		// Start threads
		addThread.start();
		subtractThread.start();
		multiplyThread.start();
		divideThread.start();

		// Wait for all threads to finish
		try {
			addThread.join();
			subtractThread.join();
			multiplyThread.join();
			divideThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
