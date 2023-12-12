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
        String name = name();
        int idx = name.lastIndexOf('+');
        if (idx == -1) {
            return name + "+";
        } else {
            return name.substring(0, idx + 1) + (level() + 1);
        }
    }

    String upgradeDescription();

    default int upgradeCost() {
        return cost();
    }
}
