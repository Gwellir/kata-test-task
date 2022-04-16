package calculator;

class Symbol {
    public final int value;
    public final String name;
    public final int maxInRow;
    public final int skipAfter;

    public Symbol(String name, int value, int maxInRow, int skipAfter) {
        this.name = name;
        this.value = value;
        this.maxInRow = maxInRow;
        this.skipAfter = skipAfter;
    }
}

public class RomanNumeral {
    public static final Symbol[] baseSymbols = {
            new Symbol("C", 100, 3, 0),
            new Symbol("XC", 90, 1, 2),
            new Symbol("L", 50, 1, 1),
            new Symbol("XL", 40, 1, 1),
            new Symbol("X", 10, 3, 0),
            new Symbol("IX", 9, 1, 2),
            new Symbol("V", 5, 1, 1),
            new Symbol("IV", 4, 1,1),
            new Symbol("I", 1, 3, 0),
    };

    public RomanNumeral() {}

    public static int toArabic(String numAsString) throws CalcException {
        String romanNumeral = numAsString;
        int i = 0;
        int num = 0;
        int repetitions = 0;
        while (romanNumeral.length() > 0 && i < baseSymbols.length) {
            if (romanNumeral.startsWith(baseSymbols[i].name)
                    && repetitions < baseSymbols[i].maxInRow) {
                num += baseSymbols[i].value;
                romanNumeral = romanNumeral.substring(baseSymbols[i].name.length());
                repetitions += 1;
            } else {
                if (repetitions > 0) {
                    i += baseSymbols[i].skipAfter;
                    repetitions = 0;
                }
                i += 1;
            }
        }

        if (romanNumeral.length() > 0)
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
