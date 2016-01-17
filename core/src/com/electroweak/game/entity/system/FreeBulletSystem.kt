package com.electroweak.game.entity.system

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.EntitySystem
import com.badlogic.ashley.core.Family
import com.badlogic.ashley.utils.ImmutableArray
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Rectangle
import com.electroweak.game.entity.component.BulletComponent
import com.electroweak.game.entity.component.PositionComponent
import com.electroweak.game.entity.component.SizeComponent
import com.electroweak.game.entity.component.TextureComponent

class FreeBulletSystem() : EntitySystem() {

    lateinit var entities: ImmutableArray<Entity>

    override fun addedToEngine(engine: Engine) {
        entities = engine.getEntitiesFor(Family.all(BulletComponent::class.java, PositionComponent::class.java,
                SizeComponent::class.java).get())
    }

    override fun update(deltaTime: Float) {
        for (entity in entities) {
            val positionComponent = Mappers.POSITION_MAPPER.get(entity)
            val sizeComponent = Mappers.SIZE_MAPPER.get(entity)
            val bulletComponent = Mappers.BULLET_MAPPER.get(entity)

            val bulletBox = Rectangle(positionComponent.position!!.x, positionComponent.position!!.y,
                    sizeComponent.width, sizeComponent.height)

            val screenBox = Rectangle(0f, 0f, Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat())

            if (!screenBox.contains(bulletBox)) {
                bulletComponent.timeOffScreen += deltaTime
                if (bulletComponent.timeOffScreen >= 3f) {
                    engine.removeEntity(entity)
                }
            }
        }
    }

}