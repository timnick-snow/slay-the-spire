package com.example.shell.game;

import com.example.shell.items.Potion;
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
public class PotionSlot {
    /**
     * 容量
     */
    private int cap;
    private List<Potion> potions;

    public PotionSlot(int cap) {
        this.cap = cap;
        this.potions = new ArrayList<>();
    }

    public PotionSlot() {
        this.cap = 3;
        this.potions = new ArrayList<>();
    }

    public void addPotion(Potion p) {
        this.potions.add(p);
    }

    public String formatCount() {
        return "potions: %d/%d".formatted(potions.size(), cap);
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
