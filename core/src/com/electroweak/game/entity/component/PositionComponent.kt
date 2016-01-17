package com.electroweak.game.entity.component

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.math.Vector2

class PositionComponent : Component {

    var position: Vector2? = Vector2.Zero.cpy()

}
