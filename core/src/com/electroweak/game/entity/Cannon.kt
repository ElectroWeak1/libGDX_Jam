package com.electroweak.game.entity

import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Vector2
import com.electroweak.game.asset.Assets
import com.electroweak.game.core.Globals
import com.electroweak.game.entity.component.PositionComponent
import com.electroweak.game.entity.component.RotationComponent
import com.electroweak.game.entity.component.SizeComponent
import com.electroweak.game.entity.component.TextureComponent
import com.electroweak.game.entity.system.Mappers
import com.electroweak.game.entity.utils.EntityUtils

class Cannon(val cannonType: CannonType) : Entity() {

    enum class CannonType(val texture: Assets.Resource) {
        SINGLE(Assets.Resource.CANNON),
        DOUBLE(Assets.Resource.CANNON_DOUBLE)
    }
    enum class Barrel() {
        LEFT, RIGHT, CENTER
    }

    init {
        val textureComponent = TextureComponent()
        val positionComponent = PositionComponent()
        val sizeComponent = SizeComponent()
        val rotationComponent = RotationComponent()

        textureComponent.textureRegion = Assets.getAtlasRegion(cannonType.texture)

        sizeComponent.width = textureComponent.textureRegion.regionWidth.toFloat()
        sizeComponent.height = textureComponent.textureRegion.regionHeight.toFloat()

        add(textureComponent)
        add(positionComponent)
        add(sizeComponent)
        add(rotationComponent)
    }

    fun setRotation(rotation: Float) {
        Mappers.ROTATION_MAPPER.get(this).rotation = rotation
    }

    fun getBulletForBarrel(barrel: Barrel) : Bullet {
        val bullet = Bullet(Bullet.BulletDamage.NORMAL)
        bullet.setScale(0.9f)

        val bulletDirection = getDirection()
        var barrelDirection: Vector2? = null

        val x = Globals.WORLD_WIDTH / 2f - bullet.getWidth() / 2f
        val y = Globals.WORLD_HEIGHT / 2f - bullet.getHeight() / 2f
        val bulletPosition = Vector2(x, y)

        when (barrel) {
            Barrel.LEFT -> {
                barrelDirection = bulletDirection.cpy().rotate90(0)
            }

            Barrel.RIGHT -> {
                barrelDirection = bulletDirection.cpy().rotate90(-1)

            }

            Barrel.CENTER -> {
                bullet.setPosition(bulletPosition.add(bulletDirection?.scl(70f)))
                bullet.setRotation(bulletDirection.angle())
                return bullet
            }
        }

        bulletPosition.add(barrelDirection?.scl(10f))

        bullet.setPosition(bulletPosition.add(bulletDirection?.scl(70f)))
        bullet.setRotation(bulletDirection.angle())

        return bullet
    }

    fun getDirection() : Vector2 {
        var mousePosition = Vector2(Gdx.input.x.toFloat(), Gdx.graphics.height - Gdx.input.y.toFloat())
        return mousePosition.sub(Globals.SCREEN_CENTER.cpy()).nor()
    }

    fun getPosition() : Vector2 = Mappers.POSITION_MAPPER.get(this).position!!.cpy()

}