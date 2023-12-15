package io.github.snow.spire.items.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 攻击结果
 *
 * @author snow
 * @since 2023/12/14
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttackResult {
    /**
     * 总伤害
     */
    private int totalDamage;
    /**
     * 格挡伤害
     */
    private int blockDamage;
    /**
     * 是否致死
     */
    private boolean die;

    /**
     * 真实hp伤害
     */
    private int getRealDamage() {
        return totalDamage - blockDamage;
    }
}
