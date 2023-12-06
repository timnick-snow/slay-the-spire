package com.example.shell.map;

import com.example.shell.random.RandomUtil;

import java.util.ArrayList;
import java.util.List;

import static com.example.shell.map.Branch.D;
import static com.example.shell.map.Branch.S;

/**
 * @author snow
 * @since 2023/12/6
 */
class Way2_3 implements Way {
    private static final int[] ODDS = {500, 500};
    private static final List<List<Branch>> BRANCHES;

    static {
        BRANCHES = new ArrayList<>();
        BRANCHES.add(List.of(S, D));
        BRANCHES.add(List.of(D, S));
    }

    @Override
    public List<Branch> select(int value) {
        int idx = RandomUtil.randomIndex(ODDS, value);
        return BRANCHES.get(idx);
    }
}
