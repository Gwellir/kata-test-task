package calculator;

public class Operation {
    private final int num1;
    private final int num2;
    private final Operand operand;
    private int result;

    private int minValue = 0;
    private int maxValue = 10;

    public Operation(int num1, int num2, Operand operand) throws CalcException {
        checkValue(num1);
        checkValue(num2);

        this.num1 = num1;
        this.num2 = num2;

        this.operand = operand;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    private void checkValue(int num) throws CalcException {
        if (num < this.minValue || num > this.maxValue)
            throw new CalcException("An argument is out of range!");
    }

    public int compute() throws CalcException {
        switch (this.operand) {
            case ADD -> result = num1 + num2;
            case SUB -> result = num1 - num2;
            case MUL -> result = num1 * num2;
            case DIV -> {
                    if (num2 == 0)
                        throw new CalcException("Trying to divide by zero");
                    result = num1 / num2;
            }

        }
        return this.result;
    }
}
