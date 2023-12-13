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
        int len = 0;
        for (char c : text.toCharArray()) {
            if (isChinese(c)) {
                len += 2;
            } else {
                len++;
            }
        }
        if (len >= width) {
            return text;
        }
        int space = width - len;
        return " ".repeat(space / 2) + text + " ".repeat((space + 1) / 2);
    }

    // 判断字符是否为中文
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        return ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }
}
