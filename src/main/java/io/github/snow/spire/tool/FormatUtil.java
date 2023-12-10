package io.github.snow.spire.tool;

/**
 * @author snow
 * @since 2023/12/8
 */
public class FormatUtil {

    /**
     * 居中对齐
     *
     * @param text  文本
     * @param width 宽度
     * @return 具有指定宽度的文本
     */
    public static String center(String text, int width) {
        if (text.length() >= width) {
            return text;
        }
        int space = width - text.length();
        return " ".repeat(space / 2) + text + " ".repeat((space + 1) / 2);
    }
}
