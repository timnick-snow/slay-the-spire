package com.example.shell.map;

import com.example.shell.random.RandomUtil;

import java.util.ArrayList;
import java.util.List;

import static com.example.shell.map.Branch.*;

/**
 * @author snow
 * @since 2023/12/6
 */
class Way3_5 implements Way {
    private static final int[] ODDS = {111, 111, 111, 222, 222, 223};
    private static final List<List<Branch>> BRANCHES;

    static {
        BRANCHES = new ArrayList<>();
        BRANCHES.add(List.of(T, S, S));
        BRANCHES.add(List.of(S, T, S));
        BRANCHES.add(List.of(S, S, T));

        BRANCHES.add(List.of(S, D, D));
        BRANCHES.add(List.of(D, S, D));
        BRANCHES.add(List.of(D, D, S));
    }

    @Override
    public List<Branch> select(int value) {
        int idx = RandomUtil.randomIndex(ODDS, value);
        return BRANCHES.get(idx);
    }
}
