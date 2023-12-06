package com.example.shell.map;

import com.example.shell.random.RandomUtil;

import java.util.ArrayList;
import java.util.List;

import static com.example.shell.map.Branch.*;

/**
 * @author snow
 * @since 2023/12/6
 */
class Way4_4 implements Way {
    private static final int[] ODDS = {482, 73, 73, 73, 73, 73, 73, 40, 40};
    private static final List<List<Branch>> BRANCHES;

    static {
        // 4S SDX TY 482 73 40
        BRANCHES = new ArrayList<>();
        BRANCHES.add(List.of(S, S, S, S));
        BRANCHES.add(List.of(S, D, X));
        BRANCHES.add(List.of(S, X, D));
        BRANCHES.add(List.of(X, S, D));
        BRANCHES.add(List.of(X, D, S));
        BRANCHES.add(List.of(D, X, S));
        BRANCHES.add(List.of(D, S, X));
        BRANCHES.add(List.of(Y, T));
        BRANCHES.add(List.of(T, Y));
    }

    @Override
    public List<Branch> select(int value) {
        int idx = RandomUtil.randomIndex(ODDS, value);
        return BRANCHES.get(idx);
    }
}
