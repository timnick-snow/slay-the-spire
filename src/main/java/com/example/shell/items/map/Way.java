package com.example.shell.items.map;

import java.util.List;

/**
 * 800:180:30
 *
 * @author snow
 * @since 2023/12/6
 */
interface Way {
    List<Branch> select(int value);

    default Way symmetrical() {
        return new SymmetricalWay(this);
    }
}
