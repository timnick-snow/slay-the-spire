package com.example.shell.map;

import com.example.shell.random.RandomUtil;

import java.util.ArrayList;
import java.util.List;

import static com.example.shell.map.Branch.*;

/**
 * @author snow
 * @since 2023/12/6
 */
class Way5_6 implements Way {
    private static final int[] ODDS = {110, 110, 110, 110, 110, 15, 15, 15, 15, 15, 15,
            22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22,
            8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8};
    private static final List<List<Branch>> BRANCHES;

    static {
        // 4SD DTY 2DXS 2STX
        BRANCHES = new ArrayList<>();
        BRANCHES.add(List.of(D, S, S, S, S));
        BRANCHES.add(List.of(S, D, S, S, S));
        BRANCHES.add(List.of(S, S, D, S, S));
        BRANCHES.add(List.of(S, S, S, D, S));
        BRANCHES.add(List.of(S, S, S, S, D));

        // DTY
        BRANCHES.add(List.of(D, T, Y));
        BRANCHES.add(List.of(D, Y, T));
        BRANCHES.add(List.of(Y, D, T));
        BRANCHES.add(List.of(Y, T, D));
        BRANCHES.add(List.of(D, T, Y));
        BRANCHES.add(List.of(D, Y, T));

        // 2DXS
        BRANCHES.add(List.of(D, D, X, S));
        BRANCHES.add(List.of(D, D, S, X));
        BRANCHES.add(List.of(D, X, D, S));
        BRANCHES.add(List.of(D, S, D, X));
        BRANCHES.add(List.of(D, X, S, D));
        BRANCHES.add(List.of(D, S, X, D));
        BRANCHES.add(List.of(X, D, D, S));
        BRANCHES.add(List.of(S, D, D, X));
        BRANCHES.add(List.of(X, D, S, D));
        BRANCHES.add(List.of(S, D, X, D));
        BRANCHES.add(List.of(X, S, D, D));
        BRANCHES.add(List.of(S, X, D, D));

        // 2STX
        BRANCHES.add(List.of(S, S, T, X));
        BRANCHES.add(List.of(S, S, X, T));
        BRANCHES.add(List.of(S, T, S, X));
        BRANCHES.add(List.of(S, X, S, T));
        BRANCHES.add(List.of(S, T, X, S));
        BRANCHES.add(List.of(S, X, T, S));
        BRANCHES.add(List.of(T, S, X, S));
        BRANCHES.add(List.of(X, S, T, S));
        BRANCHES.add(List.of(T, S, S, X));
        BRANCHES.add(List.of(X, S, S, T));
        BRANCHES.add(List.of(T, X, S, S));
        BRANCHES.add(List.of(X, T, S, S));
    }

    @Override
    public List<Branch> select(int value) {
        int idx = RandomUtil.randomIndex(ODDS, value);
        return BRANCHES.get(idx);
    }
}
