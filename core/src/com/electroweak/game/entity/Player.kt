package com.electroweak.game.entity

import com.badlogic.ashley.core.Entity
import com.electroweak.game.asset.Assets
import com.electroweak.game.core.Globals
import com.electroweak.game.entity.component.PositionComponent
import com.electroweak.game.entity.component.RotationComponent
import com.electroweak.game.entity.component.SizeComponent
import com.electroweak.game.entity.component.TextureComponent
import com.electroweak.game.entity.utils.EntityUtils

class Player : Entity() {

    init {
        val textureComponent = TextureComponent()
        val positionComponent = PositionComponent()
        val sizeComponent = SizeComponent()
        val rotationComponent = RotationComponent()

        textureComponent.textureRegion = Assets.getAtlasRegion(Assets.Resource.PLAYER)

        sizeComponent.width = textureComponent.textureRegion.regionWidth.toFloat()
        sizeComponent.height = textureComponent.textureRegion.regionHeight.toFloat()

        add(textureComponent)
        add(positionComponent)
        add(sizeComponent)
        add(rotationComponent)
    }

}