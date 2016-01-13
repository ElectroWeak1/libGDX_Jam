package com.electroweak.game.entity.system

import com.badlogic.ashley.core.ComponentMapper
import com.electroweak.game.entity.component.PositionComponent
import com.electroweak.game.entity.component.RotationComponent
import com.electroweak.game.entity.component.SizeComponent
import com.electroweak.game.entity.component.TextureComponent

object Mappers {

    var TEXTURE_MAPPER: ComponentMapper<TextureComponent> = ComponentMapper.getFor(TextureComponent::class.java)
    var POSITION_MAPPER: ComponentMapper<PositionComponent> = ComponentMapper.getFor(PositionComponent::class.java)
    var SIZE_MAPPER: ComponentMapper<SizeComponent> = ComponentMapper.getFor(SizeComponent::class.java)
    var ROTATION_MAPPER: ComponentMapper<RotationComponent> = ComponentMapper.getFor(RotationComponent::class.java)

}