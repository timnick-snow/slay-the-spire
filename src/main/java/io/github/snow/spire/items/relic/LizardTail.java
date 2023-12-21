package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class LizardTail extends RareRelic {
    @Override
    public String displayName() {
        return "蜥蜴尾巴";
    }

    @Override
    public String description() {
        return "当你要被杀死时，免死并回复到最大生命值的 50% （仅能起效一次）。";
    }
}
