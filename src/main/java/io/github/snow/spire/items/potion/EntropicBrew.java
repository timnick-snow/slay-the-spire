package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class EntropicBrew extends RarePotion {
    public EntropicBrew(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "混沌药水";
    }

    @Override
    public String getDescription() {
        return "在所有空药水栏位中获得随机药水。";
    }
}
