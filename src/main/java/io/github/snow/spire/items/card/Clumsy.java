package io.github.snow.spire.items.card;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Clumsy extends CurseCard{
    public Clumsy(String id) {
        super(id);
    }

    @Override
    public String name() {
        return "笨拙";
    }

    @Override
    public String description() {
        return " 【不能被打出】 。 【虚无】 。";
    }
}
