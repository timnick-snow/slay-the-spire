package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class Ambrosia extends RarePotion {
    public Ambrosia(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "仙馔密酒";
    }

    @Override
    public String getDescription() {
        return "进入 神格 姿态 。";
    }
}
