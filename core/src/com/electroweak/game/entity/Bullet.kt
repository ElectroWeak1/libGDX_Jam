package com.electroweak.game.entity

import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.math.Vector2
import com.electroweak.game.asset.Assets
import com.electroweak.game.core.Globals
import com.electroweak.game.entity.component.*
import com.electroweak.game.entity.system.Mappers

class Bullet(val bulletDamage: BulletDamage) : Entity() {

    enum class BulletDamage(val damage: Float) {
        WEAK(10f),
        NORMAL(20f),
        STRONG(30f)
    }

    init {
        val textureComponent = TextureComponent()
        val positionComponent = PositionComponent()
        val sizeComponent = SizeComponent()
        val rotationComponent = RotationComponent()
        val bulletComponent = BulletComponent()
        val velocityComponent = VelocityComponent()

        textureComponent.textureRegion = Assets.getAtlasRegion(Assets.Resource.BULLET)

        positionComponent.position = Globals.SCREEN_CENTER.cpy()

        sizeComponent.width = textureComponent.textureRegion.regionWidth.toFloat()
        sizeComponent.height = textureComponent.textureRegion.regionHeight.toFloat()

        bulletComponent.damage = bulletDamage.damage

        add(textureComponent)
        add(positionComponent)
        add(sizeComponent)
        add(rotationComponent)
        add(bulletComponent)
        add(velocityComponent)
    }

    fun setPosition(position: Vector2) {
        val positionComponent = Mappers.POSITION_MAPPER.get(this)
        positionComponent.position = position
    }

    fun setScale(scale: Float) {
        val sizeComponent = Mappers.SIZE_MAPPER.get(this)
        sizeComponent.scaleX = scale
        sizeComponent.scaleY = scale
    }

    fun setVelocity(velocity: Vector2) {
        Mappers.VELOCITY_MAPPER.get(this).velocity = velocity
    }

    fun setRotation(rotation: Float) {
        Mappers.ROTATION_MAPPER.get(this).rotation = rotation
    }

    fun getPosition() : Vector2 = Mappers.POSITION_MAPPER.get(this).position.cpy()

    fun getWidth() : Float = Mappers.SIZE_MAPPER.get(this).width

    fun getHeight() : Float = Mappers.SIZE_MAPPER.get(this).height

}