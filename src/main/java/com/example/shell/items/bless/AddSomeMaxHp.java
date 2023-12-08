package com.example.shell.items.bless;

import com.example.shell.temp.RunContext;

/**
 * 增加最大生命
 *
 * @author snow
 * @since 2023/12/8
 */
public class AddSomeMaxHp extends AddMaxHp {

    @Override
    protected int getAddValue(RunContext ctx) {
        return switch (ctx.getCharacter()) {
            case IRONCLAD -> 8;
            case SILENT -> 6;
            case DEFECT, WATCHER -> 7;
        };
    }
}
