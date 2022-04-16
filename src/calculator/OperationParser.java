package calculator;

public abstract class OperationParser {
    protected Operation operation;

    public OperationParser(String numAsString1, String numAsString2, String opAsString) throws CalcException {
        int num1 = this.parseNum(numAsString1);
        int num2 = this.parseNum(numAsString2);
        Operand operand = this.parseOperand(opAsString);
        this.operation = new Operation(num1, num2, operand);
    }

    public abstract String getResult() throws CalcException;

    protected abstract int parseNum(String numAsString) throws CalcException;

    protected Operand parseOperand(String opString) throws CalcException {
        return switch (opString) {
            case "+" -> Operand.ADD;
            case "-" -> Operand.SUB;
            case "*" -> Operand.MUL;
            case "/" -> Operand.DIV;
            default -> throw new CalcException("Wrong operand!");
        };
    }
}
