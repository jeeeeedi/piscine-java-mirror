public class ComputeArray {
    public static int[] computeArray(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int mod = array[i] % 3;
            if (mod == 0) {
                result[i] = array[i] * 5;
            } else if (mod == 1) {
                result[i] = array[i] + 7;
            } else {
                result[i] = array[i];
            }
        }
        return result;
    }
}