package io.github.snow.spire.tool;

/**
 * @author snow
 * @since 2023/12/6
 */
public class RandomUtil {

    public static int randomIndex(int[] arr, int value) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > value) {
                return i;
            }
        }
        return 0;
    }
}
