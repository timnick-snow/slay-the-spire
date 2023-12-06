package com.example.shell.map;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/6
 */
interface Way {
    List<Branch> select(int value);

    default Way symmetrical() {
        return new SymmetricalWay(this);
    }
}
