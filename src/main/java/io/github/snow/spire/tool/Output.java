package io.github.snow.spire.tool;

import org.jline.terminal.Terminal;

/**
 * @author snow
 * @since 2023/12/18
 */
public class Output {
    private static Terminal terminal;

    public static void println(String x) {
        terminal.writer().println(x);
        terminal.flush();
    }

    public static void printf(String format, Object... args) {
        terminal.writer().printf(format, args);
        terminal.flush();
    }

    public static void setTerminal(Terminal _terminal) {
        Output.terminal = _terminal;
    }
}
