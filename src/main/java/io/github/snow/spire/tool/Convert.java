package io.github.snow.spire.tool;

/**
 * @author snow
 * @since 2023/12/8
 */
public class Convert {

    public static int toInt(String s, int defaultValue) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return defaultValue;
        }
    }

}
