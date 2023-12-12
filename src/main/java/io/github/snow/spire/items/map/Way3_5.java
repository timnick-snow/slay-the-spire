package io.github.snow.spire.items.map;

import io.github.snow.spire.tool.RandomUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author snow
 * @since 2023/12/6
 */
class Way3_5 implements Way {
    private static final int[] ODDS = {111, 111, 111, 222, 222, 223};
    private static final List<List<Branch>> BRANCHES;

    static {
        BRANCHES = new ArrayList<>();

        // 2ST
        BRANCHES.add(List.of(Branch.T, Branch.S, Branch.S));
        BRANCHES.add(List.of(Branch.S, Branch.T, Branch.S));
        BRANCHES.add(List.of(Branch.S, Branch.S, Branch.T));

        // 2DS
        BRANCHES.add(List.of(Branch.S, Branch.D, Branch.D));
        BRANCHES.add(List.of(Branch.D, Branch.S, Branch.D));
        BRANCHES.add(List.of(Branch.D, Branch.D, Branch.S));
    }

    @Override
    public List<Branch> select(int value) {
        int idx = RandomUtil.randomIndex(ODDS, value);
        return BRANCHES.get(idx);
    }
}
