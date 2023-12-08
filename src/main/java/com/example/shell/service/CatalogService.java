package com.example.shell.service;

import com.example.shell.enums.Characters;
import com.example.shell.enums.MainPage;
import com.example.shell.game.RunSupport;
import com.example.shell.temp.GameContext;
import com.example.shell.tool.Convert;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.component.flow.ComponentFlow;
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
    private final ComponentFlow.Builder componentFlowBuilder;

    public String start() {
        if (runSupport.exist()) {
            return "当前有正在进行中的游戏: \n%s".formatted(runSupport.brief());
        }
        ComponentFlow flow = componentFlowBuilder.clone().reset()
                .withSingleItemSelector("character")
                .name("职业")
                .selectItem("战士", "IRONCLAD")
                .and()
                .withStringInput("level")
                .name("难度(0-20)")
                .defaultValue("0")
                .and()
                .build();
        ComponentFlow.ComponentFlowResult result = flow.run();
        String role = result.getContext().get("character");
        int level = Convert.toInt(result.getContext().get("level"), -1);
        if (level < 0 || level > 20) {
            return "难度(0-20)，输入错误\n";
        }
        runSupport.startRun(Characters.valueOf(role), level);

        return String.format("游戏开始...\n%s\n%s", runSupport.brief(), runSupport.tips());
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
