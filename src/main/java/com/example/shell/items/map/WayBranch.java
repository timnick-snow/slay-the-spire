package com.example.shell.items.map;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author snow
 * @since 2023/12/6
 */
@Slf4j
public class WayBranch {

    static Way DEAD_WAY = value -> {
        throw new UnsupportedOperationException("dead way");
    };

    static Way[][] WAYS = {
            {DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY},
            {DEAD_WAY, new Way1_1(), new Way1_2(), new Way1_3(), DEAD_WAY, DEAD_WAY, DEAD_WAY},
            {DEAD_WAY, DEAD_WAY, new Way2_2(), new Way2_3(), new Way2_4(), new Way2_5(), new Way2_6()},
            {DEAD_WAY, DEAD_WAY, DEAD_WAY, new Way3_3(), new Way3_4(), new Way3_5(), new Way3_6()},
            {DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY, new Way4_4(), new Way4_5(), new Way4_6()},
            {DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY, new Way5_5(), new Way5_6()},
            {DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY, DEAD_WAY, new Way6_6()}
    };

    public static List<List<Integer>> strategy(int from, int to, Random random) {
        Way way = from <= to ? WAYS[from][to] : WAYS[to][from].symmetrical();
        List<Branch> branches = way.select(random.nextInt(0, 1000));
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
