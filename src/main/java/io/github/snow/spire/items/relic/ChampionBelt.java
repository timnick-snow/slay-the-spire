package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class ChampionBelt extends RareRelic {
    @Override
    public String name() {
        return "冠军腰带";
    }

    @Override
    public String description() {
        return "每当你给予 【易伤】 时，同时给予 1 层 【虚弱】 。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.IRONCLAD;
    }
}
