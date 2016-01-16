package com.electroweak.game.entity.system

import com.badlogic.ashley.core.ComponentMapper
import com.electroweak.game.entity.component.*

object Mappers {

    var TEXTURE_MAPPER: ComponentMapper<TextureComponent> = ComponentMapper.getFor(TextureComponent::class.java)
    var POSITION_MAPPER: ComponentMapper<PositionComponent> = ComponentMapper.getFor(PositionComponent::class.java)
    var SIZE_MAPPER: ComponentMapper<SizeComponent> = ComponentMapper.getFor(SizeComponent::class.java)
    var ROTATION_MAPPER: ComponentMapper<RotationComponent> = ComponentMapper.getFor(RotationComponent::class.java)
    var VELOCITY_MAPPER: ComponentMapper<VelocityComponent> = ComponentMapper.getFor(VelocityComponent::class.java)
    var BULLET_MAPPER: ComponentMapper<BulletComponent> = ComponentMapper.getFor(BulletComponent::class.java)

}