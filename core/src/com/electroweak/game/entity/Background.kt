package com.electroweak.game.entity

import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.math.Vector2
import com.electroweak.game.asset.Assets
import com.electroweak.game.core.Globals
import com.electroweak.game.entity.component.PositionComponent
import com.electroweak.game.entity.component.RotationComponent
import com.electroweak.game.entity.component.SizeComponent
import com.electroweak.game.entity.component.TextureComponent

class Background : Entity() {

    init {
        val textureComponent = TextureComponent()
        val positionComponent = PositionComponent()
        val sizeComponent = SizeComponent()
        val rotationComponent = RotationComponent()

        textureComponent.textureRegion = Assets.getRegionFromTexture(Assets.Resource.SPACE_BACKGROUND)

        positionComponent.position = Vector2.Zero.cpy()

        sizeComponent.width = Globals.WORLD_WIDTH
        sizeComponent.height = Globals.WORLD_HEIGHT

        add(textureComponent)
        add(positionComponent)
        add(sizeComponent)
        add(rotationComponent)
    }

}