public class ConcatStrategy implements OperationStrategy {
    public int execute(int a, int b) {
        String concat = String.valueOf(a) + String.valueOf(b);
        return Integer.parseInt(concat);
    }
}
