package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023/12/7
 */
public class StrengthPotion implements Potion {
    private final String id;

    public StrengthPotion(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return "力量药水";
    }

    @Override
    public String getDescription() {
        return "获得 2 点力量。";
    }
}
