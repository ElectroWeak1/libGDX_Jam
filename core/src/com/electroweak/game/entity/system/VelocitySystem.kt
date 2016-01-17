package com.electroweak.game.entity.system

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.EntitySystem
import com.badlogic.ashley.core.Family
import com.badlogic.ashley.utils.ImmutableArray
import com.electroweak.game.entity.component.PositionComponent
import com.electroweak.game.entity.component.VelocityComponent

class VelocitySystem : EntitySystem() {

    lateinit var entities: ImmutableArray<Entity>

    override fun addedToEngine(engine: Engine) {
        entities = engine.getEntitiesFor(Family.all(PositionComponent::class.java, VelocityComponent::class.java).get())
    }

    override fun update(deltaTime: Float) {
        for (entity in entities) {
            var positionComponent = Mappers.POSITION_MAPPER.get(entity)
            var velocityComponent = Mappers.VELOCITY_MAPPER.get(entity)

            positionComponent.position!!.add(velocityComponent.velocity)
        }
    }

}