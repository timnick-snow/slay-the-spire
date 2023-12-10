package io.github.snow.spire.game;

import io.github.snow.spire.items.potion.Potion;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author snow
 * @since 2023/12/7
 */
@Getter
@Setter
public class PotionGroup {
    /**
     * 容量
     */
    private int cap;
    private List<Potion> potions;

    public PotionGroup(int cap) {
        this.cap = cap;
        this.potions = new ArrayList<>();
    }

    public PotionGroup() {
        this.cap = 3;
        this.potions = new ArrayList<>();
    }

    public boolean addPotion(Potion p) {
        if (this.potions.size() < cap) {
            this.potions.add(p);
            return true;
        }
        return false;
    }

    public String formatCount() {
        return "药水: %d/%d".formatted(potions.size(), cap);
    }

    public String format() {
        String res = formatCount() + "\n";
        if (potions.isEmpty()) {
            res += "There are currently no potions";
        } else {
            StringBuilder buf = new StringBuilder();
            for (Potion p : potions) {
                buf.append(p.getId()).append("\t\t").append(p.getName())
                        .append(": ").append(p.getDescription());
            }
            res += buf.toString();
        }
        return res;
    }
}
