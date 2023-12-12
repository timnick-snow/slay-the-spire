package io.github.snow.spire.items.card;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Parasite extends CurseCard{
    public Parasite(String id) {
        super(id);
    }

    @Override
    public String name() {
        return "寄生";
    }

    @Override
    public String description() {
        return " 【不能被打出】 。如果这张牌在你的牌组中被转化或移除，你失去3点最大生命。";
    }
}
