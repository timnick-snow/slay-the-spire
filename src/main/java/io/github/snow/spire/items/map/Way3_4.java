package io.github.snow.spire.items.map;

import io.github.snow.spire.tool.RandomUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author snow
 * @since 2023/12/6
 */
class Way3_4 implements Way {
    private static final int[] ODDS = {83, 83, 278, 278, 278};
    private static final List<List<Branch>> BRANCHES;

    static {
        BRANCHES = new ArrayList<>();

        // TX
        BRANCHES.add(List.of(Branch.T, Branch.X));
        BRANCHES.add(List.of(Branch.X, Branch.T));

        // 2SD
        BRANCHES.add(List.of(Branch.D, Branch.S, Branch.S));
        BRANCHES.add(List.of(Branch.S, Branch.D, Branch.S));
        BRANCHES.add(List.of(Branch.S, Branch.S, Branch.D));
    }

    @Override
    public List<Branch> select(int value) {
        int idx = RandomUtil.randomIndex(ODDS, value);
        return BRANCHES.get(idx);
    }
}
