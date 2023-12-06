package com.example.shell.map;

import com.example.shell.random.RandomUtil;

import java.util.ArrayList;
import java.util.List;

import static com.example.shell.map.Branch.*;

/**
 * @author snow
 * @since 2023/12/6
 */
class Way6_6 implements Way {
    private static final int[] ODDS = {308,
            22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22,
            7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
            7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
            7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
    };
    private static final List<List<Branch>> BRANCHES;

    static {
        // 6S 3SDX 2STY 2DSY 2XST
        BRANCHES = new ArrayList<>();
        BRANCHES.add(List.of(S, S, S, S, S, S));

        // 3SDX
        BRANCHES.add(List.of(S, S, S, D, X));
        BRANCHES.add(List.of(S, S, S, X, D));
        BRANCHES.add(List.of(S, S, D, S, X));
        BRANCHES.add(List.of(S, S, X, S, D));
        BRANCHES.add(List.of(S, S, D, X, S));
        BRANCHES.add(List.of(S, S, X, D, S));
        BRANCHES.add(List.of(S, D, S, S, X));
        BRANCHES.add(List.of(S, X, S, S, D));
        BRANCHES.add(List.of(S, D, S, X, S));
        BRANCHES.add(List.of(S, X, S, D, S));
        BRANCHES.add(List.of(S, D, X, S, S));
        BRANCHES.add(List.of(S, X, D, S, S));
        BRANCHES.add(List.of(D, S, S, S, X));
        BRANCHES.add(List.of(X, S, S, S, D));
        BRANCHES.add(List.of(D, S, S, X, S));
        BRANCHES.add(List.of(X, S, S, X, D));
        BRANCHES.add(List.of(D, S, X, S, S));
        BRANCHES.add(List.of(X, S, D, S, S));
        BRANCHES.add(List.of(D, X, S, S, S));
        BRANCHES.add(List.of(X, D, S, S, S));

        // 2STY
        BRANCHES.add(List.of(S, S, T, Y));
        BRANCHES.add(List.of(S, S, Y, T));
        BRANCHES.add(List.of(S, T, S, Y));
        BRANCHES.add(List.of(S, Y, S, T));
        BRANCHES.add(List.of(S, T, Y, S));
        BRANCHES.add(List.of(S, Y, T, S));
        BRANCHES.add(List.of(T, S, Y, S));
        BRANCHES.add(List.of(Y, S, T, S));
        BRANCHES.add(List.of(T, S, S, Y));
        BRANCHES.add(List.of(Y, S, S, T));
        BRANCHES.add(List.of(T, Y, S, S));
        BRANCHES.add(List.of(Y, T, S, S));

        // 2DSY
        BRANCHES.add(List.of(D, D, Y, S));
        BRANCHES.add(List.of(D, D, S, Y));
        BRANCHES.add(List.of(D, Y, D, S));
        BRANCHES.add(List.of(D, S, D, Y));
        BRANCHES.add(List.of(D, Y, S, D));
        BRANCHES.add(List.of(D, S, Y, D));
        BRANCHES.add(List.of(Y, D, D, S));
        BRANCHES.add(List.of(S, D, D, Y));
        BRANCHES.add(List.of(Y, D, S, D));
        BRANCHES.add(List.of(S, D, Y, D));
        BRANCHES.add(List.of(Y, S, D, D));
        BRANCHES.add(List.of(S, Y, D, D));

        // 2XST
        BRANCHES.add(List.of(X, X, T, S));
        BRANCHES.add(List.of(X, X, S, T));
        BRANCHES.add(List.of(X, T, X, S));
        BRANCHES.add(List.of(X, S, X, T));
        BRANCHES.add(List.of(X, T, S, X));
        BRANCHES.add(List.of(X, S, T, X));
        BRANCHES.add(List.of(T, X, S, X));
        BRANCHES.add(List.of(S, X, T, X));
        BRANCHES.add(List.of(T, X, X, S));
        BRANCHES.add(List.of(S, X, X, T));
        BRANCHES.add(List.of(T, S, X, X));
        BRANCHES.add(List.of(S, T, X, X));
    }

    @Override
    public List<Branch> select(int value) {
        int idx = RandomUtil.randomIndex(ODDS, value);
        return BRANCHES.get(idx);
    }
}
