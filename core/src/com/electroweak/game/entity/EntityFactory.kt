package com.electroweak.game.entity

import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Vector2
import com.electroweak.game.entity.component.PositionComponent
import com.electroweak.game.entity.component.RotationComponent
import com.electroweak.game.entity.component.SizeComponent
import com.electroweak.game.entity.component.TextureComponent

object EntityFactory {

    fun createEntity(textureRegion: TextureRegion) : Entity = createEntity(textureRegion, Vector2())

    fun createEntity(textureRegion: TextureRegion, position: Vector2) : Entity =
            createEntity(textureRegion, position, textureRegion.regionWidth.toFloat(),
                    textureRegion.regionHeight.toFloat())

    fun createEntity(textureRegion: TextureRegion, width: Float, height: Float) : Entity =
            createEntity(textureRegion, Vector2(), width, height)

    fun createEntity(textureRegion: TextureRegion, position: Vector2, width: Float, height: Float) : Entity =
            createEntity(textureRegion, position, width, height, 0f)

    fun createEntity(textureRegion: TextureRegion, position: Vector2, width: Float, height: Float,
                     rotation: Float): Entity = createEntity(textureRegion, position, width, height, rotation, true)

    fun createEntity(textureRegion: TextureRegion, position: Vector2, width: Float, height: Float,
                     rotation: Float, clockwise: Boolean) : Entity {
        val entity = Entity()

        val textureComponent = TextureComponent()
        val positionComponent = PositionComponent()
        val sizeComponent = SizeComponent()
        val rotationComponent = RotationComponent()

        textureComponent.textureRegion = textureRegion

        positionComponent.position = position

        sizeComponent.width = width
        sizeComponent.height = height

        rotationComponent.rotation = rotation
        rotationComponent.clockwise = clockwise

        entity.add(textureComponent)
        entity.add(positionComponent)
        entity.add(sizeComponent)
        entity.add(rotationComponent)

        return entity
    }

}