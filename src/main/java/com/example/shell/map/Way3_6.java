package com.example.shell.map;

import com.example.shell.random.RandomUtil;

import java.util.ArrayList;
import java.util.List;

import static com.example.shell.map.Branch.*;

/**
 * @author snow
 * @since 2023/12/6
 */
class Way3_6 implements Way {
    private static final int[] ODDS = {670, 55, 55, 55, 55, 55, 55};
    private static final List<List<Branch>> BRANCHES;

    static {
        BRANCHES = new ArrayList<>();
        BRANCHES.add(List.of(D, D, D));

        BRANCHES.add(List.of(S, D, T));
        BRANCHES.add(List.of(S, T, D));
        BRANCHES.add(List.of(D, S, T));
        BRANCHES.add(List.of(D, T, S));
        BRANCHES.add(List.of(T, S, D));
        BRANCHES.add(List.of(T, D, S));
    }

    @Override
    public List<Branch> select(int value) {
        int idx = RandomUtil.randomIndex(ODDS, value);
        return BRANCHES.get(idx);
    }
}
