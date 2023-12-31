package io.github.snow.spire.items.enemy;

import io.github.snow.spire.enums.EnemyType;

/**
 * @author snow
 * @since 2023/12/14
 */
public abstract class Elite extends BaseEnemy {

    public Elite(String id, int difficulty) {
        super(id, difficulty);
    }

    @Override
    public EnemyType enemyType() {
        return EnemyType.ELITE;
    }
}
