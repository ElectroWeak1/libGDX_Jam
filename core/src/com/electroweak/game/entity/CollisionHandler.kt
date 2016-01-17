package com.electroweak.game.entity

import com.badlogic.ashley.core.Entity

interface CollisionHandler {

    fun collision(owner: Entity, entity: Entity)

}