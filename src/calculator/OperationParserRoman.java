package calculator;

public class OperationParserRoman extends OperationParser {
    public OperationParserRoman(String numAsString1, String numAsString2, String opAsString) throws CalcException {
        super(numAsString1, numAsString2, opAsString);
    }

    @Override
    public String getResult() throws CalcException {
        int result = this.operation.compute();
        return RomanNumeral.toRoman(result);
    }

    @Override
    protected int parseNum(String numAsString) throws CalcException {
        return RomanNumeral.toArabic(numAsString);
    }
}
