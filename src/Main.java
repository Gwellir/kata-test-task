import calculator.CalcException;
import calculator.OperationParser;
import calculator.OperationParserArabic;
import calculator.OperationParserRoman;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String result;
        boolean inputIsValid;
        do {
            System.out.println("Input a new operation: ");
            String opLine = input.nextLine();
            try {
                result = calc(opLine.toUpperCase());
                inputIsValid = true;
                System.out.println("Operation output: ");
                System.out.println(result);
            } catch (CalcException e) {
                e.printStackTrace();
                inputIsValid = false;
            }
        } while (inputIsValid);
    }

    public static String calc(String input) throws CalcException {
        String[] segments = input.trim().split("\\s+");

        if (segments.length != 3) {
            throw new CalcException("Need exactly 3 arguments!");
        }

        OperationParser parser;

        if (Character.isDigit(input.charAt(0)))
            parser = new OperationParserArabic(segments[0], segments[2], segments[1]);
        else if ("IXV".indexOf(input.charAt(0)) >= 0)
            parser = new OperationParserRoman(segments[0], segments[2], segments[1]);
        else throw new CalcException("Numbers are neither Arabic nor Roman!");

        return parser.getResult();
    }

}
