package com.example.shell.items.bless;

import com.example.shell.temp.RunContext;

/**
 * 增加最大生命
 *
 * @author snow
 * @since 2023/12/8
 */
public class AddMoreMaxHp extends AddMaxHp {

    @Override
    protected int getAddValue(RunContext ctx) {
        return switch (ctx.getCharacter()) {
            case IRONCLAD -> 16;
            case SILENT -> 12;
            case DEFECT, WATCHER -> 14;
        };
    }
}
