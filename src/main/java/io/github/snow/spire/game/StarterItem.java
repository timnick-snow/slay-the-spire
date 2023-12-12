package io.github.snow.spire.game;

import io.github.snow.spire.items.card.*;
import io.github.snow.spire.items.relic.BurningBlood;
import io.github.snow.spire.items.relic.Relic;

import java.util.ArrayList;
import java.util.List;

/**
 * 初始物品
 *
 * @author snow
 * @since 2023/12/7
 */
public interface StarterItem {
    int hp();

    int maxHp();

    Relic relic();

    List<Card> deck();

    int gold();

    static StarterItem redStarter() {
        return new StarterItem() {

            @Override
            public int hp() {
                return 80;
            }

            @Override
            public int maxHp() {
                return 80;
            }

            @Override
            public Relic relic() {
                return new BurningBlood();
            }

            @Override
            public List<Card> deck() {
                List<Card> cards = new ArrayList<>();
                int id = 0;
                for (int i = 0; i < 5; i++) {
                    cards.add(new RedStrike("c%02d".formatted(++id), 0));
                }
                for (int i = 0; i < 4; i++) {
                    cards.add(new RedDefend("c%02d".formatted(++id), 0));
                }
                cards.add(new Bash("c%02d".formatted(++id), 0));
                return cards;
            }

            @Override
            public int gold() {
                return 99;
            }
        };
    }

}
