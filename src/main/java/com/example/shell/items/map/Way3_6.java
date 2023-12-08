package com.example.shell.items.map;

import com.example.shell.tool.RandomUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author snow
 * @since 2023/12/6
 */
class Way3_6 implements Way {
    private static final int[] ODDS = {670, 55, 55, 55, 55, 55, 55};
    private static final List<List<Branch>> BRANCHES;

    static {
        BRANCHES = new ArrayList<>();
        BRANCHES.add(List.of(Branch.D, Branch.D, Branch.D));

        BRANCHES.add(List.of(Branch.S, Branch.D, Branch.T));
        BRANCHES.add(List.of(Branch.S, Branch.T, Branch.D));
        BRANCHES.add(List.of(Branch.D, Branch.S, Branch.T));
        BRANCHES.add(List.of(Branch.D, Branch.T, Branch.S));
        BRANCHES.add(List.of(Branch.T, Branch.S, Branch.D));
        BRANCHES.add(List.of(Branch.T, Branch.D, Branch.S));
    }

    @Override
    public List<Branch> select(int value) {
        int idx = RandomUtil.randomIndex(ODDS, value);
        return BRANCHES.get(idx);
    }
}
