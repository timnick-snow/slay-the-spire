package com.example.shell.map;

import com.example.shell.random.RandomUtil;

import java.util.ArrayList;
import java.util.List;

import static com.example.shell.map.Branch.D;

/**
 * @author snow
 * @since 2023/12/6
 */
class Way1_2 implements Way {
    private static final int[] ODDS = {1000};
    private static final List<List<Branch>> BRANCHES;

    static {
        BRANCHES = new ArrayList<>();
        BRANCHES.add(List.of(D));
    }

    @Override
    public List<Branch> select(int value) {
        int idx = RandomUtil.randomIndex(ODDS, value);
        return BRANCHES.get(idx);
    }
}
