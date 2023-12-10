package io.github.snow.spire.service;

import io.github.snow.spire.beans.StartFlowResult;
import io.github.snow.spire.enums.MainPage;
import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.temp.GameContext;
import lombok.RequiredArgsConstructor;
import org.jline.terminal.Terminal;
import org.springframework.shell.Availability;
import org.springframework.stereotype.Service;

/**
 * @author snow
 * @since 2023/12/6
 */
@Service
@RequiredArgsConstructor
public class CatalogService {
    private final GameContext gameContext;
    private final RunSupport runSupport;
    private final FlowService flowService;
    private final Terminal terminal;

    public String start() {
        if (runSupport.exist()) {
            return "当前有正在进行中的游戏: \n%s".formatted(runSupport.brief());
        }
        // 职业选择
        var select = flowService.startSelect();
        if (select.getLeft().isPresent()) {
            return select.getLeft().get() + "\n";
        }
        StartFlowResult result = select.getRight().get();
        runSupport.startRun(result.role(), result.level());

        // brief
        terminal.writer().println("游戏开始..." + runSupport.brief());
        terminal.flush();
        // 祝福
        flowService.blessSelect(runSupport.genBless());
        runSupport.goHint();
        return runSupport.tips() + "\n";
    }

    public String continuation() {
        if (gameContext.getRunContext().isEmpty()) {
            return "当前没有进行中的游戏";
        }
        gameContext.setMainPage(MainPage.GAMING);
        String brief = "游戏继续...\n" + gameContext.getRunContext().get().brief();
        String tips = gameContext.getRunContext().get().getLastTips();
        return String.format("%s\n%s", brief, tips);
    }

    public String history() {
//        gameContext.setMainPage(MainPage.HISTORY);
        return "历史记录: xxx(该功能暂未完善)";
    }

    public String giveUp() {
        if (!runSupport.exist()) {
            return "当前没有进行中的游戏";
        }
        gameContext.clearRun();
        gameContext.setMainPage(MainPage.CATALOG);
        return "放弃当前游戏...本剧结算如下: (结算功能暂未完善)";
    }

    public Availability availability() {
        return gameContext.getMainPage().availability(MainPage.CATALOG);
    }
}
