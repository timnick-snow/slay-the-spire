package com.example.shell.items.potion;

import java.io.Serializable;

/**
 * @author snow
 * @since 2023/12/7
 */
public interface Potion extends Serializable {
    /**
     * 标识
     */
    String getId();

    /**
     * 名称
     */
    String getName();

    /**
     * 介绍
     */
    String getDescription();
}
