package com.example.shell.items.bless;

import com.example.shell.service.FlowService;
import com.example.shell.temp.RunContext;

/**
 * 祝福
 *
 * @author snow
 * @since 2023/12/8
 */
public interface Bless {
    String effect(RunContext ctx, FlowService flowService);

    String displayName(RunContext ctx);
}
