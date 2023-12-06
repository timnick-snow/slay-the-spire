package com.example.shell.map;

import com.example.shell.random.RandomUtil;

import java.util.ArrayList;
import java.util.List;

import static com.example.shell.map.Branch.*;

/**
 * @author snow
 * @since 2023/12/6
 */
class Way3_4 implements Way {
    private static final int[] ODDS = {83, 83, 278, 278, 278};
    private static final List<List<Branch>> BRANCHES;

    static {
        BRANCHES = new ArrayList<>();
        BRANCHES.add(List.of(T, X));
        BRANCHES.add(List.of(X, T));
        BRANCHES.add(List.of(D, S, S));
        BRANCHES.add(List.of(S, D, S));
        BRANCHES.add(List.of(S, S, D));
    }

    @Override
    public List<Branch> select(int value) {
        int idx = RandomUtil.randomIndex(ODDS, value);
        return BRANCHES.get(idx);
    }
}
