package com.electroweak.game.entity

import com.badlogic.ashley.core.Entity
import com.electroweak.game.core.Globals
import com.electroweak.game.entity.system.Mappers

object EntityUtils {

    /**
     * Will set the entity position to the center of the screen.
     * Entity must have PositionComponent and SizeComponent.
     */
    fun placeEntityToCenter(entity: Entity) {
        val positionComponent = Mappers.POSITION_MAPPER.get(entity)
        val sizeComponent = Mappers.SIZE_MAPPER.get(entity)

        positionComponent.position.x = Globals.WORLD_WIDTH / 2f - sizeComponent.width / 2f
        positionComponent.position.y = Globals.WORLD_HEIGHT / 2f - sizeComponent.height / 2f
    }

    fun setEntityRotation(entity: Entity, rotation: Float) {
        val rotationComponent = Mappers.ROTATION_MAPPER.get(entity)
        rotationComponent.rotation = rotation
    }

    fun setEntityScale(entity: Entity, scaleX: Float, scaleY: Float) {
        var sizeComponent = Mappers.SIZE_MAPPER.get(entity)
        sizeComponent.scaleX = scaleX
        sizeComponent.scaleY = scaleY
    }

}