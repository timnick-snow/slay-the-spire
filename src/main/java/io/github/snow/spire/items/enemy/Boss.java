package io.github.snow.spire.items.enemy;

import io.github.snow.spire.enums.EnemyType;

/**
 * @author snow
 * @since 2023/12/14
 */
public abstract class Boss extends BaseEnemy {

    public Boss(String id) {
        super(id);
    }

    @Override
    public EnemyType enemyType() {
        return EnemyType.BOSS;
    }
}
