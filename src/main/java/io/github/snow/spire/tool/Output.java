package io.github.snow.spire.tool;

import lombok.extern.slf4j.Slf4j;
import org.jline.terminal.Terminal;

/**
 * @author snow
 * @since 2023/12/18
 */
@Slf4j
public class Output {
    private static Terminal terminal;
    /**
     * 1 - 11
     */
    private static final int[] DELAY_TIME = {1000, 900, 800, 700, 600, 500, 400, 300, 200, 100, 0};
    private static int SPEED = 6;


    public static void println(String x) {
        terminal.writer().println(x);
        terminal.flush();
        delay(DELAY_TIME[SPEED]);
    }

    public static void printf(String format, Object... args) {
        terminal.writer().printf(format, args);
        terminal.flush();
        delay(DELAY_TIME[SPEED]);
    }

    public static void delay(long time) {
        if (time <= 0) {
            return;
        }
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            log.error("delay error", e);
        }
    }

    public static void setTerminal(Terminal _terminal) {
        Output.terminal = _terminal;
    }

    public static void setSpeed(int speed) {
        Output.SPEED = speed;
    }
}
