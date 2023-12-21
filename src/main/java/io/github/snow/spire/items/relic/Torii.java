package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class Torii extends RareRelic {
    @Override
    public String displayName() {
        return "鸟居";
    }

    @Override
    public String description() {
        return "每当你受到小于等于 5点的未被格挡 攻击 伤害时，将伤害降低为 1。";
    }
}
