
    import java.util.Scanner;

    public class SafeInput {
        Scanner pipe = new Scanner(System.in);

        /**
         * Prompts the user until a non-zero length string is entered.
         *
         * @param pipe   a Scanner opened to read from System.in
         * @param prompt the prompt message for the user
         * @return a non-zero length String response
         */
        public static int getRangedInt(Scanner pipe, String prompt, int lo, int hi) {
            int result = 0;
            boolean done = false;
            String trash = "";
            do {
                // Code and control logic to loop until validated
                System.out.print(prompt + "[" + lo + " - " + hi + "]: ");
                if (pipe.hasNextInt()) {
                    result = pipe.nextInt();
                    pipe.nextLine(); // clear input buffer
                    if (result >= lo && result <= hi) {
                        done = true;
                    } else {
                        System.out.println("You must enter a value in range [" + lo + " - " + hi + "]: " + result);
                    }
                } else {
                    trash = pipe.nextLine();
                    System.out.println("You must enter an int [" + lo + " - " + hi + "]: " + trash);
                }

            } while (!done);

            return result;
        }


        public static String getNonZeroLenString(Scanner pipe, String prompt) {
            String retString = "";  // Initialize to zero length


            do {
                System.out.print("\n" + prompt + ": "); // Show prompt with space
                retString = pipe.nextLine();
            } while (retString.length() == 0);

            return retString;
        }

        public static int getInt(Scanner pipe, String prompt) {
            int retValue = 0;
            String trash = "";
            boolean done = false;

            do {
                System.out.print("\n" + prompt + ": ");
                if (pipe.hasNextInt()) {
                    retValue = pipe.nextInt();
                    pipe.nextLine(); // clear key buffer
                    done = true;
                } else {
                    trash = pipe.nextLine();
                    System.out.println("You must enter a valid number not: " + trash);
                }
            } while (!done);

            return retValue;
        }

        public static double getDouble(Scanner pipe, String prompt) {
            double retValue = 0;
            String trash = "";
            boolean done = false;

            do {
                System.out.print("\n" + prompt + ": ");
                if (pipe.hasNextDouble()) {
                    retValue = pipe.nextDouble();
                    pipe.nextLine(); // clear key buffer
                    done = true;
                } else {
                    trash = pipe.nextLine();
                    System.out.println("You must enter a valid number not: " + trash);
                }
            } while (!done);

            return retValue;
        }

        public static double getRangedDouble(Scanner pipe, String prompt, double lo, double hi) {
            double result = 0;
            boolean done = false;
            String trash = "";
            do {
                // Code and control logic to loop until validated
                System.out.print(prompt + "[" + lo + " - " + hi + "]: ");
                if (pipe.hasNextDouble()) {
                    result = pipe.nextDouble();
                    pipe.nextLine(); // clear input buffer
                    if (result >= lo && result <= hi) {
                        done = true;
                    } else {
                        System.out.println("You must enter a value in range [" + lo + " - " + hi + "]: " + result);
                    }
                } else {
                    trash = pipe.nextLine();
                    System.out.println("You must enter an int [" + lo + " - " + hi + "]: " + trash);
                }

            } while (!done);

            return result;
        }

        public static boolean getYNConfirm(Scanner pipe, String prompt) {
            boolean done = false;
            boolean result = false;

            do {
                System.out.print(prompt);
                String input = pipe.nextLine().trim();

                if (input.equalsIgnoreCase("Y")) {
                    result = true;
                    done = true;
                } else if (input.equalsIgnoreCase("N")) {
                    result = false;
                    done = true;
                } else {
                    System.out.println("You must enter either Y or N, not " + input);
                }

            } while (!done);

            return result;
        }


        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String SSN = "";

            SSN = getRegExString(in, "Enter your SSN", "\\d{3}-\\d{2}-\\d{4}");
        }

        public static String getRegExString(Scanner pipe, String prompt, String regExPattern) {
            String value = "";
            boolean gotAValue = false;

            do {
                // show the prompt
                System.out.print(prompt + ": ");
                // input the data
                value = pipe.nextLine();
                // test to see if it is correct
                if (value.matches(regExPattern)) {
                    // We have a match this String passes!
                    gotAValue = true;
                } else {
                    System.out.println("\nInvalid input: " + value);
                }

            } while (!gotAValue);

            return value;
        }
        public static void prettyHeader(String msg) {
            // Print the top border
            for (int i = 0; i < 60; i++) {
                System.out.print("*");
            }
            System.out.println();

            // Calculate spaces needed to center the message
            int totalWidth = 60;
            int messageLength = msg.length();
            int padding = (totalWidth - messageLength - 6) / 2;

            // Print the middle line with centered message
            System.out.print("***");
            for (int i = 0; i < padding; i++) {
                System.out.print(" ");
            }
            System.out.print(msg);
            for (int i = 0; i < padding; i++) {
                System.out.print(" ");
            }
            if ((messageLength + 6) % 2 != 0) {  // Adjust if odd number of spaces
                System.out.print(" ");
            }
            System.out.println("***");

            // Print the bottom border
            for (int i = 0; i < 60; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

