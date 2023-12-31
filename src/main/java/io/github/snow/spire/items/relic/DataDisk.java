package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class DataDisk extends CommonRelic {
    @Override
    public String displayName() {
        return "数据磁盘";
    }

    @Override
    public String description() {
        return "在每场战斗开始时，获得 1 点 【集中】。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.DEFECT;
    }
}
