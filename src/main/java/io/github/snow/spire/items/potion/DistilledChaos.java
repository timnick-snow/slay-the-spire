package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class DistilledChaos extends UncommonPotion {
    public DistilledChaos(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "精炼混沌";
    }

    @Override
    public String getDescription() {
        return "打出你抽牌堆顶部的 3 张牌。";
    }
}
