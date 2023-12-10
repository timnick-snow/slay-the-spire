package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class BottledLightning extends UncommonRelic {
    @Override
    public String name() {
        return "瓶装闪电";
    }

    @Override
    public String description() {
        return "拾起时，选择一张 【技能牌】 。在每场战斗开始时，这张牌会出现在手牌中。";
    }
}
