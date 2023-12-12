package io.github.snow.spire.items.map;

import io.github.snow.spire.tool.RandomUtil;

import java.util.ArrayList;
import java.util.List;

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

        // 5S
        BRANCHES.add(List.of(Branch.S, Branch.S, Branch.S, Branch.S, Branch.S));

        // 2SDX
        BRANCHES.add(List.of(Branch.S, Branch.S, Branch.D, Branch.X));
        BRANCHES.add(List.of(Branch.S, Branch.S, Branch.X, Branch.D));
        BRANCHES.add(List.of(Branch.S, Branch.D, Branch.S, Branch.X));
        BRANCHES.add(List.of(Branch.S, Branch.X, Branch.S, Branch.D));
        BRANCHES.add(List.of(Branch.S, Branch.D, Branch.X, Branch.S));
        BRANCHES.add(List.of(Branch.S, Branch.X, Branch.D, Branch.S));
        BRANCHES.add(List.of(Branch.D, Branch.S, Branch.X, Branch.S));
        BRANCHES.add(List.of(Branch.X, Branch.S, Branch.D, Branch.S));
        BRANCHES.add(List.of(Branch.D, Branch.S, Branch.S, Branch.X));
        BRANCHES.add(List.of(Branch.X, Branch.S, Branch.S, Branch.D));
        BRANCHES.add(List.of(Branch.D, Branch.X, Branch.S, Branch.S));
        BRANCHES.add(List.of(Branch.X, Branch.D, Branch.S, Branch.S));

        // STY
        BRANCHES.add(List.of(Branch.S, Branch.T, Branch.Y));
        BRANCHES.add(List.of(Branch.S, Branch.Y, Branch.T));
        BRANCHES.add(List.of(Branch.Y, Branch.T, Branch.S));
        BRANCHES.add(List.of(Branch.Y, Branch.S, Branch.T));
        BRANCHES.add(List.of(Branch.T, Branch.S, Branch.Y));
        BRANCHES.add(List.of(Branch.T, Branch.Y, Branch.S));

        BRANCHES.add(List.of(Branch.D, Branch.D, Branch.Y));
        BRANCHES.add(List.of(Branch.D, Branch.Y, Branch.D));
        BRANCHES.add(List.of(Branch.Y, Branch.D, Branch.D));

        BRANCHES.add(List.of(Branch.X, Branch.X, Branch.T));
        BRANCHES.add(List.of(Branch.X, Branch.T, Branch.X));
        BRANCHES.add(List.of(Branch.T, Branch.X, Branch.X));
    }

    @Override
    public List<Branch> select(int value) {
        int idx = RandomUtil.randomIndex(ODDS, value);
        return BRANCHES.get(idx);
    }
}
