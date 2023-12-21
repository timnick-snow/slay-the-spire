package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class QuestionCard extends UncommonRelic {
    @Override
    public String displayName() {
        return "问号牌";
    }

    @Override
    public String description() {
        return "在选奖励牌时，可供选择的牌数增加 1 张。（拾起时同一窗口中的奖励牌不受影响）";
    }
}
