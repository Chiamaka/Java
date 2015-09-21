
import java.util.Scanner;

/**
 *
 * @author chiamaka
 */
public class FigureInWords {

    final private static String[] units = {"Zero", "One", "Two", "Three", "Four",
        "Five", "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
        "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    final private static String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty",
        "Sixty", "Seventy", "Eighty", "Ninety"};

    public static String convert(Integer number) {
        String responseString = "";
        boolean isNegative = false;

        if (number < 0) {
            isNegative = true;
            number = Math.abs(number);
        }

        if (number < 20) {
            responseString = units[number];
        }

        if (number >= 20 && number < 100) {
            if (number % 10 > 0) {
                responseString = tens[number / 10] + " " + convert(number % 10);
            } else {
                responseString = tens[number / 10];
            }
        }

        if (number >= 100 && number < 1000) {
            if (number % 100 > 0) {
                responseString = convert(number / 100) + " Hundred and " + convert(number % 100);
            } else {
                responseString = convert(number / 100) + " Hundred";
            }
        }

        if (number >= 1000 && number < 1000000) {
            if (number % 1000 > 0) {
                responseString = convert(number / 1000) + " Thousand " + convert(number % 1000);
            } else {
                responseString = convert(number / 1000) + " Thousand";
            }
        }
        if (number >= 1000000 && number <= 1000000000) {
            if (number % 1000000 > 0) {
                responseString = convert(number / 1000000) + " Million " + convert(number % 1000000);
            } else {
                responseString = convert(number / 1000000) + " Million";
            }
        }
        if (number > 1000000000) {
            if (number % 1000000000 > 0) {
                responseString = convert(number / 1000000000) + " Billion " + convert(number % 1000000000);
            } else {
                responseString = convert(number / 1000000000) + " Billion";
            }
        }

        if (isNegative) {
            return "Negative " + responseString;
        } else {
            return responseString;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String answer = "";
        int response = 0;
        try {
            do {
                System.out.print("Enter a number to convert to words (or 'done' to quit): ");
                answer = input.nextLine();

                response = Integer.parseInt(answer);

                System.out.println(convert(response));
            } while (answer != "done");

        } catch (NumberFormatException excep) {
            try {
                if (Float.parseFloat(answer) >= 0.0) {
                    System.out.println("You entered a wrong value");
                }
            } catch (NumberFormatException e) {
                System.out.println("Thank you for using our service");
            }
        }

    }
}
