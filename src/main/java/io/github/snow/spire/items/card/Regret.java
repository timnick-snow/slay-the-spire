package io.github.snow.spire.items.card;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Regret extends CurseCard{
    public Regret(String id) {
        super(id);
    }

    @Override
    public String baseName() {
        return "悔恨";
    }

    @Override
    public String description() {
        return " 【不能被打出】 。你的回合结束时，每有一张手牌就失去1点生命。";
    }
}
