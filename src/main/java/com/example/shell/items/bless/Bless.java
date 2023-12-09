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
    /**
     * 生效
     */
    void run(RunContext ctx, FlowService flowService);

    /**
     * 显示信息
     */
    String display(RunContext ctx);
}
