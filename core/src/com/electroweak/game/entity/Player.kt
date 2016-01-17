package com.electroweak.game.entity

import com.badlogic.ashley.core.Entity
import com.electroweak.game.asset.Assets
import com.electroweak.game.core.Globals
import com.electroweak.game.entity.component.*
import com.electroweak.game.entity.utils.EntityUtils

class Player : Entity() {

    init {
        val textureComponent = TextureComponent()
        val positionComponent = PositionComponent()
        val sizeComponent = SizeComponent()
        val rotationComponent = RotationComponent()
        val collisionComponent = CollisionComponent()

        textureComponent.textureRegion = Assets.getAtlasRegion(Assets.Resource.PLAYER)

        sizeComponent.width = textureComponent.textureRegion.regionWidth.toFloat()
        sizeComponent.height = textureComponent.textureRegion.regionHeight.toFloat()

        collisionComponent.collisionHandler = object : CollisionHandler {
            override fun collision(owner: Entity, entity: Entity) {

            }
        }

        add(textureComponent)
        add(positionComponent)
        add(sizeComponent)
        add(rotationComponent)
        add(collisionComponent)
    }

}