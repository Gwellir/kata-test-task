package calculator;

public abstract class OperationParser {
    protected NumberType numType;
    protected Operation operation;

    public OperationParser(String numAsString1, String numAsString2, String opAsString) throws Exception {
        int num1 = this.parseNum(numAsString1);
        int num2 = this.parseNum(numAsString2);
        Operand operand = this.parseOperand(opAsString);
        this.operation = new Operation(num1, num2, operand);
    }

    public abstract String compute() throws Exception;

    protected abstract int parseNum(String numAsString) throws Exception;

    protected Operand parseOperand(String opString) throws Exception {
        return switch (opString) {
            case "+" -> Operand.ADD;
            case "-" -> Operand.SUB;
            case "*" -> Operand.MUL;
            case "/" -> Operand.DIV;
            default -> throw new Exception("Wrong Op");
        };
    }
}
