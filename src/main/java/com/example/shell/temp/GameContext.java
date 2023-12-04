package com.example.shell.temp;

import com.example.shell.beans.RandomManage;
import com.example.shell.beans.SaveLoadHandler;
import com.example.shell.enums.Characters;
import com.example.shell.enums.MainPage;
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

    private MainPage mainPage;
    private Optional<GameRunContext> runContext;
    private final Terminal terminal;
    private final SaveLoadHandler saveLoadHandler;

    public GameContext(Terminal terminal, SaveLoadHandler saveLoadHandler) {
        this.terminal = terminal;
        this.saveLoadHandler = saveLoadHandler;
        this.mainPage = MainPage.CATALOG;
        this.runContext = Optional.empty();
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
    public void genRun() {
        String seed = RandomManage.genSeed();
        this.runContext = Optional.of(new GameRunContext(seed, Characters.IRONCLAD, 20));
    }

    public void clearRun() {
        this.runContext = Optional.empty();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.terminal.writer().println("""
                欢迎来到杀戮尖塔：
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
