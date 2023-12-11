package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class LiquidMemories extends UncommonPotion {
    public LiquidMemories(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "液态记忆";
    }

    @Override
    public String getDescription() {
        return "选择弃牌堆中的一张牌放入你的手牌。这张牌在本回合的耗能变为 0 。";
    }
}
