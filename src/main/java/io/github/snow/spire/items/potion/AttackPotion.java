package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class AttackPotion extends CommonPotion {
    public AttackPotion(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "攻击药水";
    }

    @Override
    public String getDescription() {
        return "从 3 张随机攻击牌中选择 1 张加入你的手牌。这张牌在本回合耗能变为 0 。";
    }
}
