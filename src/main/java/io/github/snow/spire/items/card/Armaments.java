package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;
import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.RoughEffect;
import io.github.snow.spire.items.effect.rough.BlockChanger;
import io.github.snow.spire.items.effect.rough.CardUpgrade;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Armaments extends RedCard {
    private static final String DESC = "获得5点 【格挡】 。在本场战斗中 【升级】 手牌中的一张牌。";
    private static final String DESC1 = "获得5点 【格挡】 。在本场战斗中 【升级】 手牌中的所有牌。";

    public Armaments(String id, int level) {
        super(id, level);
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        // 格挡
        int block = 5;
        SourceChain source = new SourceChain().setFighter(fighter).setProducer(this);
        BlockChanger blockAdd = new BlockChanger(block, source);
        // 升级手牌
        EffectTarget effectTarget = level == 0 ? EffectTarget.SINGLE_HAND_CARD : EffectTarget.ALL_HAND_CARD;
        CardUpgrade cardUpgrade = new CardUpgrade(effectTarget, source.copy());
        return List.of(blockAdd, cardUpgrade);
    }

    @Override
    public String baseName() {
        return "武装";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.COMMON;
    }

    @Override
    public int cost() {
        return 1;
    }

    @Override
    public String description() {
        return level == 0 ? DESC : DESC1;
    }

    @Override
    public String upgradeDescription() {
        return DESC1;
    }
}
