package com.electroweak.game.entity.system

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.EntitySystem
import com.badlogic.ashley.core.Family
import com.badlogic.ashley.utils.ImmutableArray
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.ParticleEffect
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.TimeUtils
import com.electroweak.game.entity.component.PositionComponent
import com.electroweak.game.entity.component.SizeComponent
import com.electroweak.game.entity.component.TextureComponent

class TextureRenderSystem : EntitySystem() {

    val batch: SpriteBatch = SpriteBatch()
    lateinit var entities: ImmutableArray<Entity>

    override fun addedToEngine(engine: Engine) {
        entities = engine.getEntitiesFor(Family.all(TextureComponent::class.java, PositionComponent::class.java,
                SizeComponent::class.java).get())
    }

    override fun update(deltaTime: Float) {
        batch.begin()
        for (entity in entities) {
            var textureComponent = Mappers.TEXTURE_MAPPER.get(entity)
            var positionComponent = Mappers.POSITION_MAPPER.get(entity)
            var sizeComponent = Mappers.SIZE_MAPPER.get(entity)
            var rotationComponent = Mappers.ROTATION_MAPPER.get(entity)

            batch.draw(textureComponent.textureRegion, positionComponent.position!!.x, positionComponent.position!!.y,
                    sizeComponent.width / 2f, sizeComponent.height / 2f, sizeComponent.width, sizeComponent.height
                    , sizeComponent.scaleX, sizeComponent.scaleY, rotationComponent.rotation, rotationComponent.clockwise)
        }
        batch.end()
    }

}