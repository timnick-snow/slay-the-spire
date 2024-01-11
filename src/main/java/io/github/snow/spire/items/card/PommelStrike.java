package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;
import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.RoughEffect;
import io.github.snow.spire.items.effect.rough.CardDraw;
import io.github.snow.spire.items.effect.rough.DamageGroup;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/12
 */
public class PommelStrike extends RedCard implements StrikeAware {
    private static final String DESC = "造成9点伤害。抽1张牌。";
    private static final String DESC1 = "造成10点伤害。抽2张牌。";
    private int damage = 9;
    private int draw = 1;

    public PommelStrike(String id, int level) {
        super(id, level);
    }

    @Override
    public void upgrade() {
        super.upgrade();
        this.damage = 10;
        this.draw = 2;
    }

    @Override
    public Card copy(String id) {
        PommelStrike copy = (PommelStrike) super.copy(id);
        copy.damage = this.damage;
        copy.draw = this.draw;
        return copy;
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        // 伤害
        SourceChain source = new SourceChain().setFighter(fighter).setProducer(this);
        DamageGroup damageGroup = new DamageGroup(EffectTarget.SINGLE_OPPONENT, source, damage, 1);
        // draw
        CardDraw cardDraw = new CardDraw(source.copy(), draw);
        return List.of(damageGroup, cardDraw);
    }

    @Override
    public String baseName() {
        return "剑柄打击";
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
