package io.github.snow.spire.items.enemy;

import io.github.snow.spire.enums.EnemyType;

/**
 * 小怪
 *
 * @author snow
 * @since 2023/12/14
 */
public abstract class Monster extends BaseEnemy {

    protected Monster(String id, int difficulty) {
        super(id, difficulty);
    }

    @Override
    public EnemyType enemyType() {
        return EnemyType.MONSTER;
    }
}
