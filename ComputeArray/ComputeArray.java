public class ComputeArray {
    public static int[] computeArray(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            switch (array[i] % 3) {
                case 0:
                    result[i] = array[i] * 5;
                    break;
                case 1:
                    result[i] = array[i] + 7;
                    break;
                case 2:
                    result[i] = array[i];
                    break;
            }
        }
        return result;
    }
}