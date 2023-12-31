package io.github.snow.spire.temp;

import io.github.snow.spire.enums.Characters;
import io.github.snow.spire.enums.MainPage;
import io.github.snow.spire.tool.Output;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.jline.terminal.Terminal;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 游戏上下文信息
 *
 * @author snow
 * @since 2023/12/1
 */
@Component
@Getter
@Setter
@Slf4j
public class GameContext implements InitializingBean {

    private MainPage mainPage = MainPage.CATALOG;
    @Getter
    private Optional<RunContext> runContext = Optional.empty();
    private final Terminal terminal;
    private final SaveLoadHandler saveLoadHandler;

    public GameContext(Terminal terminal, SaveLoadHandler saveLoadHandler) {
        this.terminal = terminal;
        this.saveLoadHandler = saveLoadHandler;
    }

    /**
     * 游戏轮回中
     */
    public boolean isRunning() {
        return runContext.isPresent();
    }

    /**
     * 生成一个轮回
     */
    public RunContext genRun(Characters role, int level) {
        String seed = RandomManage.genSeed();
        this.runContext = Optional.of(new RunContext(seed, role, level));
        return runContext.get();
    }

    public void clearRun() {
        this.runContext = Optional.empty();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Output.setTerminal(terminal);
        this.terminal.writer().println("""
                欢迎来到杀戮尖塔 0.0.1-alpha
                    game start -> 开始游戏
                    game continue -> 继续游戏
                    game give up -> 放弃当前游戏
                    game history -> 历史记录
                """);
        this.terminal.writer().flush();
        // 从文件中读取之前的轮回
        this.runContext = saveLoadHandler.tryLoadRun();
    }
}
