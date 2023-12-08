package com.example.shell.items.map;

import com.example.shell.tool.RandomUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author snow
 * @since 2023/12/6
 */
class Way3_3 implements Way {
    private static final int[] ODDS = {202, 202, 596};
    private static final List<List<Branch>> BRANCHES;

    static {
        BRANCHES = new ArrayList<>();
        BRANCHES.add(List.of(Branch.D, Branch.X));
        BRANCHES.add(List.of(Branch.X, Branch.D));
        BRANCHES.add(List.of(Branch.S, Branch.S, Branch.S));
    }

    @Override
    public List<Branch> select(int value) {
        int idx = RandomUtil.randomIndex(ODDS, value);
        return BRANCHES.get(idx);
    }
}
