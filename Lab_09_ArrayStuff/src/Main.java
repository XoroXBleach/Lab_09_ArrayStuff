import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner scanner = new Scanner(System.in);

        // Create and populate the dataPoints array with random values
        int[] dataPoints = new int[100];
        Random random = new Random();

        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = random.nextInt(100) + 1;
        }

        // Display the dataPoints values separated by " | "
        for (int i = 0; i < dataPoints.length; i++) {
            if (i > 0) {
                System.out.print(" | ");
            }
            System.out.print(dataPoints[i]);
        }
        System.out.println(); // Move to the next line after printing all values

        // Calculate the sum and average
        int sum = 0;
        for (int i = 0; i < dataPoints.length; i++) {
            sum += dataPoints[i];
        }
        double average = (double) sum / dataPoints.length;

        // Display the sum and average
        System.out.printf("The sum of the values in dataPoints is: %d%n", sum);
        System.out.printf("The average of the values in dataPoints is: %.2f%n", average);

        // Prompt user for an integer value between 1 and 100
        int userValue = SafeInput.getRangedInt(scanner, "Enter an integer between 1 and 100", 1, 100);
        System.out.println("You entered: " + userValue);

        // Count how many times the user's value appears in the array
        int count = 0;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userValue) {
                count++;
            }
        }
        System.out.printf("The value %d appears %d times in the dataPoints array.%n", userValue, count);

        // Prompt user for another integer value between 1 and 100
        int searchValue = SafeInput.getRangedInt(scanner, "Enter another integer between 1 and 100 to search for", 1, 100);
        boolean found = false;
        int position = -1;

        // Search for the new value and display its position
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == searchValue) {
                position = i;
                found = true;
                break; // Exit the loop as soon as the value is found
            }
        }

        if (found) {
            System.out.printf("The value %d was found at array index %d.%n", searchValue, position);
        } else {
            System.out.printf("The value %d was not found in the dataPoints array.%n", searchValue);
        }

        // Find the minimum and maximum values in the dataPoints array
        int min = dataPoints[0];
        int max = dataPoints[0];

        for (int i = 1; i < dataPoints.length; i++) {
            if (dataPoints[i] < min) {
                min = dataPoints[i];
            }
            if (dataPoints[i] > max) {
                max = dataPoints[i];
            }
        }

        // Display the minimum and maximum values
        System.out.printf("The minimum value in the dataPoints array is: %d%n", min);
        System.out.printf("The maximum value in the dataPoints array is: %d%n", max);

        // Calculate and display the average using getAverage method
        System.out.printf("Average of dataPoints is: %.2f%n", getAverage(dataPoints));
    }

    // Static method to calculate the average of an array of double values
    public static double getAverage(int[] values) {
        if (values.length == 0) {
            return 0.0; // To handle the case where the array might be empty
        }

        double sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum / values.length;
    }
}
