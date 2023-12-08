package com.example.shell.items.map;

import com.example.shell.tool.RandomUtil;

import java.util.ArrayList;
import java.util.List;

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
        BRANCHES.add(List.of(Branch.D, Branch.S, Branch.S, Branch.S, Branch.S));
        BRANCHES.add(List.of(Branch.S, Branch.D, Branch.S, Branch.S, Branch.S));
        BRANCHES.add(List.of(Branch.S, Branch.S, Branch.D, Branch.S, Branch.S));
        BRANCHES.add(List.of(Branch.S, Branch.S, Branch.S, Branch.D, Branch.S));
        BRANCHES.add(List.of(Branch.S, Branch.S, Branch.S, Branch.S, Branch.D));

        // DTY
        BRANCHES.add(List.of(Branch.D, Branch.T, Branch.Y));
        BRANCHES.add(List.of(Branch.D, Branch.Y, Branch.T));
        BRANCHES.add(List.of(Branch.Y, Branch.D, Branch.T));
        BRANCHES.add(List.of(Branch.Y, Branch.T, Branch.D));
        BRANCHES.add(List.of(Branch.D, Branch.T, Branch.Y));
        BRANCHES.add(List.of(Branch.D, Branch.Y, Branch.T));

        // 2DXS
        BRANCHES.add(List.of(Branch.D, Branch.D, Branch.X, Branch.S));
        BRANCHES.add(List.of(Branch.D, Branch.D, Branch.S, Branch.X));
        BRANCHES.add(List.of(Branch.D, Branch.X, Branch.D, Branch.S));
        BRANCHES.add(List.of(Branch.D, Branch.S, Branch.D, Branch.X));
        BRANCHES.add(List.of(Branch.D, Branch.X, Branch.S, Branch.D));
        BRANCHES.add(List.of(Branch.D, Branch.S, Branch.X, Branch.D));
        BRANCHES.add(List.of(Branch.X, Branch.D, Branch.D, Branch.S));
        BRANCHES.add(List.of(Branch.S, Branch.D, Branch.D, Branch.X));
        BRANCHES.add(List.of(Branch.X, Branch.D, Branch.S, Branch.D));
        BRANCHES.add(List.of(Branch.S, Branch.D, Branch.X, Branch.D));
        BRANCHES.add(List.of(Branch.X, Branch.S, Branch.D, Branch.D));
        BRANCHES.add(List.of(Branch.S, Branch.X, Branch.D, Branch.D));

        // 2STX
        BRANCHES.add(List.of(Branch.S, Branch.S, Branch.T, Branch.X));
        BRANCHES.add(List.of(Branch.S, Branch.S, Branch.X, Branch.T));
        BRANCHES.add(List.of(Branch.S, Branch.T, Branch.S, Branch.X));
        BRANCHES.add(List.of(Branch.S, Branch.X, Branch.S, Branch.T));
        BRANCHES.add(List.of(Branch.S, Branch.T, Branch.X, Branch.S));
        BRANCHES.add(List.of(Branch.S, Branch.X, Branch.T, Branch.S));
        BRANCHES.add(List.of(Branch.T, Branch.S, Branch.X, Branch.S));
        BRANCHES.add(List.of(Branch.X, Branch.S, Branch.T, Branch.S));
        BRANCHES.add(List.of(Branch.T, Branch.S, Branch.S, Branch.X));
        BRANCHES.add(List.of(Branch.X, Branch.S, Branch.S, Branch.T));
        BRANCHES.add(List.of(Branch.T, Branch.X, Branch.S, Branch.S));
        BRANCHES.add(List.of(Branch.X, Branch.T, Branch.S, Branch.S));
    }

    @Override
    public List<Branch> select(int value) {
        int idx = RandomUtil.randomIndex(ODDS, value);
        return BRANCHES.get(idx);
    }
}
