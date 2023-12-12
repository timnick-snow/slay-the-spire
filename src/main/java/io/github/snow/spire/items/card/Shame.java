package io.github.snow.spire.items.card;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Shame extends CurseCard{
    public Shame(String id) {
        super(id);
    }

    @Override
    public String name() {
        return "羞耻";
    }

    @Override
    public String description() {
        return " 【不能被打出】 。在你的回合结束时，获得1层 【脆弱】 。";
    }
}
