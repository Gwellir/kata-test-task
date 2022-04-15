package calculator;

public class OperationParserRoman extends OperationParser {
    public OperationParserRoman(String numAsString1, String numAsString2, String opAsString) throws Exception {
        super(numAsString1, numAsString2, opAsString);
    }

    @Override
    public String compute() throws Exception {
        int result = this.operation.getResult();
        return RomanNumeral.toRoman(result);
    }

    @Override
    protected int parseNum(String numAsString) throws Exception {
        return RomanNumeral.toArabic(numAsString);
    }
}
