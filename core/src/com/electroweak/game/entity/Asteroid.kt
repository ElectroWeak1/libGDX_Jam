package com.electroweak.game.entity

import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.math.Vector2
import com.electroweak.game.asset.Assets
import com.electroweak.game.core.Globals
import com.electroweak.game.entity.component.*
import com.electroweak.game.entity.system.Mappers

class Asteroid(val asteroidType: AsteroidType) : Entity() {

    enum class AsteroidType(val resource: Assets.Resource) {
        BIG(Assets.Resource.ASTEROID_BIG),
        SMALL2(Assets.Resource.ASTEROID_SMALL1),
        SMALL1(Assets.Resource.ASTEROID_SMALL2),
        TINY(Assets.Resource.ASTEROID_TINY)
    }

    init {
        val textureComponent = TextureComponent()
        val positionComponent = PositionComponent()
        val sizeComponent = SizeComponent()
        val rotationComponent = RotationComponent()
        val velocityComponent = VelocityComponent()

        textureComponent.textureRegion = Assets.getAtlasRegion(asteroidType.resource)

        sizeComponent.width = textureComponent.textureRegion.regionWidth.toFloat()
        sizeComponent.height = textureComponent.textureRegion.regionHeight.toFloat()

        add(textureComponent)
        add(positionComponent)
        add(sizeComponent)
        add(rotationComponent)
        add(velocityComponent)
    }

    fun setPosition(position: Vector2?) {
        Mappers.POSITION_MAPPER.get(this).position = position
        Mappers.VELOCITY_MAPPER.get(this).velocity = Globals.SCREEN_CENTER.cpy().sub(position).nor()
    }

}