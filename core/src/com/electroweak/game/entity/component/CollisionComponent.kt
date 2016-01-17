package com.electroweak.game.entity.component

import com.badlogic.ashley.core.Component
import com.electroweak.game.entity.CollisionHandler

class CollisionComponent : Component {

    lateinit var collisionHandler: CollisionHandler

}