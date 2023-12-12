package io.github.snow.spire.items.card;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Decay extends CurseCard{
    public Decay(String id) {
        super(id);
    }

    @Override
    public String name() {
        return "腐朽";
    }

    @Override
    public String description() {
        return " 【不能被打出】 。 在你的回合结束时，受到2点伤害 。";
    }
}
