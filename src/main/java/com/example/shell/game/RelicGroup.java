package com.example.shell.game;

import com.example.shell.items.relic.Relic;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author snow
 * @since 2023/12/7
 */
@Getter
public class RelicGroup {

    private final List<Relic> relics = new ArrayList<>();


    public void addRelic(Relic relic) {
        relics.add(relic);
    }

    public String formatCount() {
        return "遗物: %d".formatted(relics.size());
    }

    public String format(boolean verbose) {
        String res = formatCount() + "\n";
        StringBuilder buf = new StringBuilder();
        if (verbose) {
            // 详细的
            for (Relic relic : relics) {
                buf.append(relic.getName())
                        .append(": ")
                        .append(relic.getDescription())
                        .append("\n");
            }
        } else {
            // 简要的
            for (int i = 0; i < relics.size(); i++) {
                buf.append(relics.get(i).getName());
                if (i == relics.size() - 1) {
                    break;
                }
                if (((i + 1) & 3) == 0) {
                    buf.append("\n");
                } else {
                    buf.append("\t\t\t");
                }
            }
        }
        buf.append("\n");
        res += buf;
        return res;
    }
}
