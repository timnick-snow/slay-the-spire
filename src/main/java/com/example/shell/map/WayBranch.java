package com.example.shell.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author snow
 * @since 2023/12/6
 */
public class WayBranch {

    static Way DEAD_WAY = value -> {
        throw new UnsupportedOperationException("dead way");
    };

    static Way[][] WAYS = {
            {DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY},
            {DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY},
            {DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY, new Way2_4(), DEAD_WAY, DEAD_WAY},
            {DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY},
            {DEAD_WAY, DEAD_WAY, new Way2_4().symmetrical(), DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY},
            {DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY},
            {DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY}
    };

    public static List<List<Integer>> strategy(int from, int to, Random random) {
        List<Branch> branches = WAYS[from][to].select(random.nextInt(0, 1000));
        int y = 0;
        List<List<Integer>> res = new ArrayList<>();
        for (Branch branch : branches) {
            switch (branch) {
                case S -> res.add(Collections.singletonList(y++));
                case D -> res.add(List.of(y++, y++));
                case T -> res.add(List.of(y++, y++, y++));
                case X -> {
                    res.add(Collections.singletonList(y));
                    res.add(Collections.singletonList(y));
                    y++;
                }
                case Y -> {
                    res.add(Collections.singletonList(y));
                    res.add(Collections.singletonList(y));
                    res.add(Collections.singletonList(y));
                    y++;
                }
            }
        }
        return res;
    }
}
