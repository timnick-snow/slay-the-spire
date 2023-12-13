package io.github.snow.spire.items.card;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Writhe extends CurseCard {
    public Writhe(String id) {
        super(id);
    }

    @Override
    public String baseName() {
        return "苦恼";
    }

    @Override
    public String description() {
        return " 【不能被打出】 。 【固有】 。";
    }
}
