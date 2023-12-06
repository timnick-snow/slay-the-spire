package com.example.shell.map;

import com.example.shell.random.RandomUtil;

import java.util.ArrayList;
import java.util.List;

import static com.example.shell.map.Branch.*;

/**
 * @author snow
 * @since 2023/12/6
 */
class Way4_5 implements Way {
    private static final int[] ODDS = {187, 187, 187, 187, 42, 42, 42, 21, 21, 21, 21, 21, 21};
    private static final List<List<Branch>> BRANCHES;

    static {
        // 3SD 2DX TSX
        BRANCHES = new ArrayList<>();
        BRANCHES.add(List.of(S, S, S, D));
        BRANCHES.add(List.of(S, S, D, S));
        BRANCHES.add(List.of(S, D, S, S));
        BRANCHES.add(List.of(D, S, S, S));

        BRANCHES.add(List.of(D, D, X));
        BRANCHES.add(List.of(D, X, D));
        BRANCHES.add(List.of(X, D, D));

        BRANCHES.add(List.of(T, S, Y));
        BRANCHES.add(List.of(T, Y, S));
        BRANCHES.add(List.of(Y, T, S));
        BRANCHES.add(List.of(Y, S, T));
        BRANCHES.add(List.of(S, Y, T));
        BRANCHES.add(List.of(S, T, Y));
    }

    @Override
    public List<Branch> select(int value) {
        int idx = RandomUtil.randomIndex(ODDS, value);
        return BRANCHES.get(idx);
    }
}
