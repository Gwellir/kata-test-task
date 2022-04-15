package calculator;

public class OperationParserArabic extends OperationParser {
    public OperationParserArabic(String numAsString1, String numAsString2, String opAsString) throws Exception {
        super(numAsString1, numAsString2, opAsString);
    }

    @Override
    public String compute() {
        int result = this.operation.getResult();
        return String.valueOf(result);
    }

    @Override
    protected int parseNum(String numAsString) {
        return Integer.parseInt(numAsString);
    }
}
