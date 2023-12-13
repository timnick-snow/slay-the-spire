package io.github.snow.spire.items.card;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Pain extends CurseCard{
    public Pain(String id) {
        super(id);
    }

    @Override
    public String baseName() {
        return "疼痛";
    }

    @Override
    public String description() {
        return " 【不能被打出】 。在手牌中时， 每打出一张其他牌，失去1生命。";
    }
}
