

public class DoOp {
    public static String operate(String[] args) {
        if (args == null || args.length != 3) {
            return "it depend on the input.";
        }

        int leftOperand = Integer.parseInt(args[0]);
        String operator = args[1];
        int rightOperand = Integer.parseInt(args[2]);

        int result = 0;

        switch (operator) {
            case "+":
                result = leftOperand + rightOperand;
                break;
            case "-":
                result = leftOperand - rightOperand;
                break;
            case "*":
                result = leftOperand * rightOperand;
                break;
            case "/":
                result = leftOperand / rightOperand;
                break;
            default:
                return "Error";
        }
        return String.valueOf(result);
    }
}