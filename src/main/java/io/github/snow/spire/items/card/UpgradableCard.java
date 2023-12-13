package io.github.snow.spire.items.card;

/**
 * 可升级的
 *
 * @author snow
 * @since 2023/12/12
 */
public interface UpgradableCard extends Card {
    /**
     * 当前等级
     * 0 - 未升级
     * 1 - 升级+1
     * ...
     */
    int level();

    /**
     * 能否继续升级
     */
    default boolean isUpgradable() {
        return level() < 1;
    }

    default String upgradeName() {
        String name = baseName();
        if (level() == 0) {
            return "%s+".formatted(name);
        }
        return "%s+%d".formatted(name, level() + 1);
    }

    String upgradeDescription();

    default int upgradeCost() {
        return cost();
    }
}
