package com.example.shell.map;

import com.example.shell.random.RandomUtil;

import java.util.ArrayList;
import java.util.List;

import static com.example.shell.map.Branch.*;

/**
 * @author snow
 * @since 2023/12/6
 */
class Way5_5 implements Way {
    private static final int[] ODDS = {372, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35,
            12, 12, 12, 12, 12, 12, 23, 23, 23, 23, 23, 23};
    private static final List<List<Branch>> BRANCHES;

    static {
        // 5S 2SDX STY 2DY 2XT
        BRANCHES = new ArrayList<>();
        BRANCHES.add(List.of(S, S, S, S, S));

        BRANCHES.add(List.of(S, S, D, X));
        BRANCHES.add(List.of(S, S, X, D));
        BRANCHES.add(List.of(S, D, S, X));
        BRANCHES.add(List.of(S, X, S, D));
        BRANCHES.add(List.of(S, D, X, S));
        BRANCHES.add(List.of(S, X, D, S));
        BRANCHES.add(List.of(D, S, X, S));
        BRANCHES.add(List.of(X, S, D, S));
        BRANCHES.add(List.of(D, S, S, X));
        BRANCHES.add(List.of(X, S, S, D));
        BRANCHES.add(List.of(D, X, S, S));
        BRANCHES.add(List.of(X, D, S, S));

        BRANCHES.add(List.of(S, T, Y));
        BRANCHES.add(List.of(S, Y, T));
        BRANCHES.add(List.of(Y, T, S));
        BRANCHES.add(List.of(Y, S, T));
        BRANCHES.add(List.of(T, S, T));
        BRANCHES.add(List.of(T, Y, S));

        BRANCHES.add(List.of(D, D, Y));
        BRANCHES.add(List.of(D, Y, D));
        BRANCHES.add(List.of(Y, D, D));

        BRANCHES.add(List.of(X, X, T));
        BRANCHES.add(List.of(X, T, X));
        BRANCHES.add(List.of(T, X, X));
    }

    @Override
    public List<Branch> select(int value) {
        int idx = RandomUtil.randomIndex(ODDS, value);
        return BRANCHES.get(idx);
    }
}
