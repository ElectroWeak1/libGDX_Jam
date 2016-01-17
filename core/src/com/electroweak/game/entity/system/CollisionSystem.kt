package com.electroweak.game.entity.system

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.EntitySystem
import com.badlogic.ashley.core.Family
import com.badlogic.ashley.utils.ImmutableArray
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Rectangle
import com.electroweak.game.entity.component.CollisionComponent
import com.electroweak.game.entity.component.PositionComponent
import com.electroweak.game.entity.component.SizeComponent
import com.electroweak.game.entity.component.TextureComponent

class CollisionSystem : EntitySystem() {

    lateinit var entities: ImmutableArray<Entity>

    override fun addedToEngine(engine: Engine) {
        entities = engine.getEntitiesFor(Family.all(CollisionComponent::class.java, PositionComponent::class.java,
                SizeComponent::class.java).get())
    }

    override fun update(deltaTime: Float) {
        for (entity in entities) {
            var collisionComponent1 = Mappers.COLLISION_MAPPER.get(entity)
            var positionComponent = Mappers.POSITION_MAPPER.get(entity)
            var sizeComponent = Mappers.SIZE_MAPPER.get(entity)

            val boundingBox = Rectangle(positionComponent.position!!.x, positionComponent.position!!.y,
                    sizeComponent.width, sizeComponent.height)

            for (i in 0..entities.size() - 1) {
                val secondEntity = entities.get(i)
                if (secondEntity == entity) continue

                var collisionComponent2 = Mappers.COLLISION_MAPPER.get(secondEntity)
                var positionComponent = Mappers.POSITION_MAPPER.get(secondEntity)
                var sizeComponent = Mappers.SIZE_MAPPER.get(secondEntity)

                val secondBox = Rectangle(positionComponent.position!!.x, positionComponent.position!!.y,
                        sizeComponent.width, sizeComponent.height)

                if (boundingBox.overlaps(secondBox)) {
                    collisionComponent1.collisionHandler.collision(entity, secondEntity)
                    collisionComponent2.collisionHandler.collision(secondEntity, entity)
                }
            }
        }
    }

}