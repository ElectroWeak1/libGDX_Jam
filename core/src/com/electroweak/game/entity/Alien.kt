package com.electroweak.game.entity

import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.TimeUtils
import com.electroweak.game.asset.Assets
import com.electroweak.game.core.Globals
import com.electroweak.game.core.Main
import com.electroweak.game.entity.component.*
import com.electroweak.game.entity.system.Mappers

class Alien(val main: Main, val alienType: AlienType) : Entity() {

    var lastTime: Long = 0

    enum class AlienType(val resource: Assets.Resource) {
        WEAK(Assets.Resource.ALIEN_WEAK),
        NORMAL(Assets.Resource.ALIEN_NORMAL),
        STRONG(Assets.Resource.ALIEN_STRONG)
    }

    init {
        val textureComponent = TextureComponent()
        val positionComponent = PositionComponent()
        val sizeComponent = SizeComponent()
        val rotationComponent = RotationComponent()
        val velocityComponent = VelocityComponent()
        val collisionComponent = CollisionComponent()

        textureComponent.textureRegion = Assets.getAtlasRegion(alienType.resource)

        sizeComponent.width = textureComponent.textureRegion.regionWidth.toFloat()
        sizeComponent.height = textureComponent.textureRegion.regionHeight.toFloat()

        collisionComponent.collisionHandler = object : CollisionHandler {
            override fun collision(owner: Entity, entity: Entity) {
                if (owner is Alien && entity is Bullet) {
                    main.engine.removeEntity(owner)
                    main.engine.removeEntity(entity)

                    if (TimeUtils.timeSinceMillis(lastTime) >= 100) {
                        lastTime = TimeUtils.millis()
                        main.gameplayScreen.score++
                        main.gameplayScreen.scoreLabel.setText("Score: " + main.gameplayScreen.score)
                    }
                }

                if (owner is Alien && entity is Player) {
                    main.engine.removeEntity(owner)
                    main.engine.removeEntity(entity)
                    main.engine.removeEntity(main.gameplayScreen.cannon)

                    main.gameplayScreen.gameOver()
                }
            }
        }

        add(textureComponent)
        add(positionComponent)
        add(sizeComponent)
        add(rotationComponent)
        add(velocityComponent)
        add(collisionComponent)
    }

    fun setPosition(position: Vector2?) {
        Mappers.POSITION_MAPPER.get(this).position = position
        Mappers.VELOCITY_MAPPER.get(this).velocity = Globals.SCREEN_CENTER.cpy().sub(position).nor()
    }

    fun setRotation(rotation: Float) {
        Mappers.ROTATION_MAPPER.get(this).rotation = rotation
    }

    fun getPosition() : Vector2 = Mappers.POSITION_MAPPER.get(this).position!!.cpy()

}