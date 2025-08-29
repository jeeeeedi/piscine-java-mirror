public class MaxStrategy implements OperationStrategy {
    public int execute(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
        }
}
