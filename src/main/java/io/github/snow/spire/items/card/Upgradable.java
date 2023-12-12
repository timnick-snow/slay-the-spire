package io.github.snow.spire.items.card;

/**
 * 可升级的
 *
 * @author snow
 * @since 2023/12/12
 */
public interface Upgradable {
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
    default boolean upgrade() {
        return level() < 1;
    }

    String upgradeDescription();
}
