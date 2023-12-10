package io.github.snow.spire.items.map;

import io.github.snow.spire.tool.RandomUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author snow
 * @since 2023/12/6
 */
class Way4_5 implements Way {
    private static final int[] ODDS = {187, 187, 187, 187, 42, 42, 42, 21, 21, 21, 21, 21, 21};
    private static final List<List<Branch>> BRANCHES;

    static {
        // 3SD 2DX TSX
        BRANCHES = new ArrayList<>();
        BRANCHES.add(List.of(Branch.S, Branch.S, Branch.S, Branch.D));
        BRANCHES.add(List.of(Branch.S, Branch.S, Branch.D, Branch.S));
        BRANCHES.add(List.of(Branch.S, Branch.D, Branch.S, Branch.S));
        BRANCHES.add(List.of(Branch.D, Branch.S, Branch.S, Branch.S));

        BRANCHES.add(List.of(Branch.D, Branch.D, Branch.X));
        BRANCHES.add(List.of(Branch.D, Branch.X, Branch.D));
        BRANCHES.add(List.of(Branch.X, Branch.D, Branch.D));

        BRANCHES.add(List.of(Branch.T, Branch.S, Branch.X));
        BRANCHES.add(List.of(Branch.T, Branch.X, Branch.S));
        BRANCHES.add(List.of(Branch.X, Branch.T, Branch.S));
        BRANCHES.add(List.of(Branch.X, Branch.S, Branch.T));
        BRANCHES.add(List.of(Branch.S, Branch.X, Branch.T));
        BRANCHES.add(List.of(Branch.S, Branch.T, Branch.X));
    }

    @Override
    public List<Branch> select(int value) {
        int idx = RandomUtil.randomIndex(ODDS, value);
        return BRANCHES.get(idx);
    }
}
