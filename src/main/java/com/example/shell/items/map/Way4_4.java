package com.example.shell.items.map;

import com.example.shell.tool.RandomUtil;

import java.util.ArrayList;
import java.util.List;

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
        BRANCHES.add(List.of(Branch.S, Branch.S, Branch.S, Branch.S));
        BRANCHES.add(List.of(Branch.S, Branch.D, Branch.X));
        BRANCHES.add(List.of(Branch.S, Branch.X, Branch.D));
        BRANCHES.add(List.of(Branch.X, Branch.S, Branch.D));
        BRANCHES.add(List.of(Branch.X, Branch.D, Branch.S));
        BRANCHES.add(List.of(Branch.D, Branch.X, Branch.S));
        BRANCHES.add(List.of(Branch.D, Branch.S, Branch.X));
        BRANCHES.add(List.of(Branch.Y, Branch.T));
        BRANCHES.add(List.of(Branch.T, Branch.Y));
    }

    @Override
    public List<Branch> select(int value) {
        int idx = RandomUtil.randomIndex(ODDS, value);
        return BRANCHES.get(idx);
    }
}
