package com.example.shell.map;

import com.example.shell.random.RandomUtil;

import java.util.ArrayList;
import java.util.List;

import static com.example.shell.map.Branch.*;

/**
 * @author snow
 * @since 2023/12/6
 */
class Way4_6 implements Way {
    private static final int[] ODDS = {100, 100, 100, 100, 100, 100, 33, 33, 33, 33, 34, 34, 50, 50, 50, 50};
    private static final List<List<Branch>> BRANCHES;

    static {
        // 2D2S DTX 3ST
        BRANCHES = new ArrayList<>();
        BRANCHES.add(List.of(S, S, D, D));
        BRANCHES.add(List.of(S, D, S, D));
        BRANCHES.add(List.of(S, D, D, S));
        BRANCHES.add(List.of(D, S, D, S));
        BRANCHES.add(List.of(D, S, S, D));
        BRANCHES.add(List.of(D, D, S, S));

        BRANCHES.add(List.of(D, T, X));
        BRANCHES.add(List.of(D, X, T));
        BRANCHES.add(List.of(X, D, T));
        BRANCHES.add(List.of(X, T, D));
        BRANCHES.add(List.of(D, T, X));
        BRANCHES.add(List.of(D, X, T));

        BRANCHES.add(List.of(S, S, S, T));
        BRANCHES.add(List.of(S, S, T, S));
        BRANCHES.add(List.of(S, T, S, S));
        BRANCHES.add(List.of(T, S, S, S));
    }

    @Override
    public List<Branch> select(int value) {
        int idx = RandomUtil.randomIndex(ODDS, value);
        return BRANCHES.get(idx);
    }
}
