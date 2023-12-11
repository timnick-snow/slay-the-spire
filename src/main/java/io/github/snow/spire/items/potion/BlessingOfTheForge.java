package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class BlessingOfTheForge extends CommonPotion {
    public BlessingOfTheForge(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "熔炉的祝福";
    }

    @Override
    public String getDescription() {
        return "在本场战斗中升级手牌中的所有牌。";
    }
}
