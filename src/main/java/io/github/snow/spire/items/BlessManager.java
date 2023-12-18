package io.github.snow.spire.items;

import io.github.snow.spire.beans.context.GameStartEvent;
import io.github.snow.spire.enums.BlessLevel;
import io.github.snow.spire.items.bless.*;
import io.github.snow.spire.temp.RunContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author snow
 * @since 2023/12/11
 */
@Component
@Slf4j
public class BlessManager {
    private final Map<BlessLevel, List<Bless>> blessMap = new HashMap<>();
    private Random blessRandom;


    /**
     * 随机一个祝福
     */
    public Bless randomBless(BlessLevel blessLevel) {
        int randomValue = blessRandom.nextInt(0, 1000);
        List<Bless> list = blessMap.get(blessLevel);
        return list.get(randomValue % list.size());
    }


    /**
     * 根据随机数生成一个复合祝福
     */
    public ComplexBless complexBless() {
        int a = blessRandom.nextInt(0, 1000);
        int b = blessRandom.nextInt(0, 1000);
        int c = blessRandom.nextInt(0, 1000);

        List<Bless> negativeList = blessMap.get(BlessLevel.DISADVANTAGE);
        List<Bless> positiveList = blessMap.get(BlessLevel.BETTER_REWARD);
        Bless negative = negativeList.get(a % negativeList.size());
        Bless positive;
        int i = 0;
        while (true) {
            int size = positiveList.size();
            int random = b + c * i + i + size;
            int idx = random % size;
            log.info("random: {}, idx: {}", random, idx);
            positive = positiveList.get(idx);
            i++;
            if (negative instanceof LossMaxHp && positive instanceof AddMaxHp) {
                continue;
            }
            if (negative instanceof LossGold && positive instanceof GetGold) {
                continue;
            }
            if (negative instanceof RandomCurse && positive instanceof RemoveTwoCard) {
                continue;
            }
            break;
        }
        return new ComplexBless(negative, positive);
    }


    @EventListener(GameStartEvent.class)
    public void onGameStart(GameStartEvent event) {
        RunContext source = (RunContext) event.getSource();
        this.blessRandom = source.getRandomManage().getOtherRandom();
        this.blessMap.clear();

        register(new AddMoreMaxHp());
        register(new AddSomeMaxHp());
        register(new ChooseClassCard());
        register(new ChooseRareCard());
        register(new ChooseRareColorlessCard());
        register(new ChooseUncommonColorlessCard());
        register(new ExchangeBossRelic());
        register(new GetGold100());
        register(new GetGold250());
        register(new GetNeowsBlessing());
        register(new GetPotion());
        register(new LossGold());
        register(new LossHp());
        register(new LossMaxHp());
        register(new RandomCommonRelic());
        register(new RandomCurse());
        register(new RandomRareCard());
        register(new RandomRareRelic());
        register(new RemoveOneCard());
        register(new RemoveTwoCard());
        register(new TransformOneCard());
        register(new TransformTwoCard());
        register(new UpgradeCard());
    }

    private void register(Bless bless) {
        List<Bless> list = blessMap.getOrDefault(bless.level(), new ArrayList<>());
        list.add(bless);
        blessMap.put(bless.level(), list);
    }

}
