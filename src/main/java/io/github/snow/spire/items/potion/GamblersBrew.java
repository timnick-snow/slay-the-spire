package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class GamblersBrew extends UncommonPotion {
    public GamblersBrew(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "赌徒特酿";
    }

    @Override
    public String getDescription() {
        return "丢弃任意张牌，然后抽相同数量的牌。";
    }
}
