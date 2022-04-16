package calculator;

public class OperationParserArabic extends OperationParser {
    public OperationParserArabic(String numAsString1, String numAsString2, String opAsString) throws CalcException {
        super(numAsString1, numAsString2, opAsString);
    }

    @Override
    public String getResult() throws CalcException {
        int result = this.operation.compute();
        return String.valueOf(result);
    }

    @Override
    protected int parseNum(String numAsString) throws CalcException {
        try {
            return Integer.parseInt(numAsString);
        } catch (NumberFormatException e) {
            throw new CalcException(String.format("%s is not an Arabic numeral", numAsString));
        }
    }
}
