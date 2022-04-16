package calculator;

class Symbol {
    public int value;
    public String name;

    public Symbol(int value, String name) {
        this.name = name;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}

public class RomanNumeral {
    public static final Symbol[] baseSymbols = {
            new Symbol(100, "C"),
            new Symbol(90, "XC"),
            new Symbol(50, "L"),
            new Symbol(10, "X"),
            new Symbol(9, "IX"),
            new Symbol(5, "V"),
            new Symbol(4, "IV"),
            new Symbol(1, "I")
    };

    public RomanNumeral() {}

    public static int toArabic(String numAsString) throws CalcException {
        String romanNumeral = numAsString;
        int i = 0;
        int num = 0;
        while (romanNumeral.length() > 0 && i < baseSymbols.length) {
            if (romanNumeral.startsWith(baseSymbols[i].name)) {
                num += baseSymbols[i].value;
                romanNumeral = romanNumeral.substring(baseSymbols[i].name.length());
            } else {
                i++;
            }
        }

        if (num == 0)
            throw new CalcException(
                    String.format("'%s' is not a valid Roman numeral!", numAsString)
            );

        return num;
    }

    public static String toRoman(int num) throws CalcException {
        if (num <= 0)
            throw new CalcException("Cannot display a non-positive result as Roman numeral!");

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (baseSymbols[i].value <= num) {
                sb.append(baseSymbols[i].name);
                num -= baseSymbols[i].value;
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
