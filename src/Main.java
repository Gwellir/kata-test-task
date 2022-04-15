import calculator.Operation;
import calculator.OperationParser;
import calculator.OperationParserArabic;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String result = "";
        while (true) {
            System.out.println("Введите новую операцию: ");
            String opLine = input.nextLine();
            try {
                result = calc(opLine);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
            System.out.println(result);
        }
    }

    public static String calc(String input) throws Exception {
        String[] segments = input.trim().split("\\s+");
        if (segments.length != 3) {
            System.out.println("Wrong input");
            return "ERROR";
        }

        OperationParser parser;

        if ("0123456789".indexOf(input.charAt(0)) >= 0)
            parser = new OperationParserArabic(segments[0],  segments[2], segments[1]);
//        else if ("IXV".indexOf(input.charAt(0)) >= 0) {}
        else
            throw new Exception("Wrong number format");

        return parser.compute();
    }

}
