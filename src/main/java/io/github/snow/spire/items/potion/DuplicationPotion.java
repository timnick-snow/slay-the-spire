package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class DuplicationPotion extends UncommonPotion {
    public DuplicationPotion(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "复制药水";
    }

    @Override
    public String getDescription() {
        return "本回合你的下一张牌将被打出两次。";
    }
}
