package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;
import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.RoughEffect;
import io.github.snow.spire.items.effect.rough.BlockChanger;
import io.github.snow.spire.items.effect.rough.DamageGroup;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/12
 */
public class IronWave extends RedCard {
    private static final String DESC = "获得5点 【格挡】 。造成5点伤害。";
    private static final String DESC1 = "获得7点 【格挡】 。造成7点伤害。";

    private int damage = 5;
    private int block = 5;


    public IronWave(String id, int level) {
        super(id, level);
    }

    @Override
    public void upgrade() {
        super.upgrade();
        this.damage = 7;
        this.block = 7;
    }

    @Override
    public Card copy(String id) {
        IronWave copy = (IronWave) super.copy(id);
        copy.damage = this.damage;
        copy.block = this.block;
        return copy;
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        // 伤害
        SourceChain source = new SourceChain().setFighter(fighter).setProducer(this);
        DamageGroup damageGroup = new DamageGroup(EffectTarget.SINGLE_OPPONENT, source, damage, 1);
        // 格挡
        BlockChanger blockChanger = new BlockChanger(block, source.copy());
        return List.of(damageGroup, blockChanger);
    }

    @Override
    public String baseName() {
        return "铁斩波";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
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
