package io.github.snow.spire.items.map;

import java.util.ArrayList;
import java.util.List;

/**
 * @author snow
 * @since 2023/12/6
 */
class SymmetricalWay implements Way {

    private final Way way;

    SymmetricalWay(Way way) {
        this.way = way;
    }

    @Override
    public List<Branch> select(int value) {
        List<Branch> list = way.select(value);
        List<Branch> res = new ArrayList<>();
        for (Branch branch : list) {
            Branch b = switch (branch) {
                case S -> Branch.S;
                case D -> Branch.X;
                case T -> Branch.Y;
                case X -> Branch.D;
                case Y -> Branch.T;
            };
            res.add(b);
        }
        return res;
    }
}
