package com.electroweak.game.entity.component

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.math.Vector2

class VelocityComponent : Component {

    var velocity: Vector2 = Vector2.Zero.cpy()

}