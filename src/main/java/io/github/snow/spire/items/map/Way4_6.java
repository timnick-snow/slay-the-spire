package io.github.snow.spire.items.map;

import io.github.snow.spire.tool.RandomUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author snow
 * @since 2023/12/6
 */
class Way4_6 implements Way {
    private static final int[] ODDS = {100, 100, 100, 100, 100, 100, 33, 33, 33, 33, 34, 34, 50, 50, 50, 50};
    private static final List<List<Branch>> BRANCHES;

    static {
        // 2D2S DTX 3ST
        BRANCHES = new ArrayList<>();
        BRANCHES.add(List.of(Branch.S, Branch.S, Branch.D, Branch.D));
        BRANCHES.add(List.of(Branch.S, Branch.D, Branch.S, Branch.D));
        BRANCHES.add(List.of(Branch.S, Branch.D, Branch.D, Branch.S));
        BRANCHES.add(List.of(Branch.D, Branch.S, Branch.D, Branch.S));
        BRANCHES.add(List.of(Branch.D, Branch.S, Branch.S, Branch.D));
        BRANCHES.add(List.of(Branch.D, Branch.D, Branch.S, Branch.S));

        BRANCHES.add(List.of(Branch.D, Branch.T, Branch.X));
        BRANCHES.add(List.of(Branch.D, Branch.X, Branch.T));
        BRANCHES.add(List.of(Branch.X, Branch.D, Branch.T));
        BRANCHES.add(List.of(Branch.X, Branch.T, Branch.D));
        BRANCHES.add(List.of(Branch.D, Branch.T, Branch.X));
        BRANCHES.add(List.of(Branch.D, Branch.X, Branch.T));

        BRANCHES.add(List.of(Branch.S, Branch.S, Branch.S, Branch.T));
        BRANCHES.add(List.of(Branch.S, Branch.S, Branch.T, Branch.S));
        BRANCHES.add(List.of(Branch.S, Branch.T, Branch.S, Branch.S));
        BRANCHES.add(List.of(Branch.T, Branch.S, Branch.S, Branch.S));
    }

    @Override
    public List<Branch> select(int value) {
        int idx = RandomUtil.randomIndex(ODDS, value);
        return BRANCHES.get(idx);
    }
}
