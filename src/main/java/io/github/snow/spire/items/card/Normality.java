package io.github.snow.spire.items.card;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Normality extends CurseCard{
    public Normality(String id) {
        super(id);
    }

    @Override
    public String baseName() {
        return "凡庸";
    }

    @Override
    public String description() {
        return " 【不能被打出】 。在手牌中时，你在此回合无法打出3张以上牌。";
    }
}
