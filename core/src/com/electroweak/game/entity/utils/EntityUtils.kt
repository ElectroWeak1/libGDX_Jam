package com.electroweak.game.entity.utils

import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.math.Vector2
import com.electroweak.game.core.Globals
import com.electroweak.game.entity.system.Mappers

object EntityUtils {

    fun setPositionToCenter(vararg entities: Entity) {
        for (entity in entities) {
            val positionComponent = Mappers.POSITION_MAPPER.get(entity)
            val sizeComponent = Mappers.SIZE_MAPPER.get(entity)

            val x = Globals.WORLD_WIDTH / 2f - sizeComponent.width / 2f
            val y = Globals.WORLD_HEIGHT / 2f - sizeComponent.height / 2f

            positionComponent.position = Vector2(x, y)
        }
    }

}