package com.electroweak.game.input

import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.scenes.scene2d.Stage

class InputHandler : InputProcessor{

    var stage: Stage? = null

    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        stage?.touchUp(screenX, screenY, pointer, button)
        return true
    }

    override fun mouseMoved(screenX: Int, screenY: Int): Boolean {
        stage?.mouseMoved(screenX, screenY)
        return true
    }

    override fun keyTyped(character: Char): Boolean {
        stage?.keyTyped(character)
        return true
    }

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        stage?.touchDown(screenX, screenY, pointer, button)
        return true
    }

    override fun scrolled(amount: Int): Boolean {
        stage?.scrolled(amount)
        return true
    }

    override fun keyUp(keycode: Int): Boolean {
        stage?.keyUp(keycode)
        return true
    }

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
        stage?.touchDragged(screenX, screenY, pointer)
        return true
    }

    override fun keyDown(keycode: Int): Boolean {
        stage?.keyDown(keycode)
        return true
    }

}