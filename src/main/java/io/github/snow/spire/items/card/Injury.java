package io.github.snow.spire.items.card;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Injury extends CurseCard{
    public Injury(String id) {
        super(id);
    }

    @Override
    public String baseName() {
        return "受伤";
    }

    @Override
    public String description() {
        return " 【不能被打出】 。";
    }
}
