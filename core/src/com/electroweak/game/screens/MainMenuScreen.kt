package com.electroweak.game.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import com.badlogic.gdx.utils.Align
import com.electroweak.game.asset.Assets
import com.electroweak.game.core.Main
import com.kotcrab.vis.ui.widget.VisLabel
import com.kotcrab.vis.ui.widget.VisTable
import com.kotcrab.vis.ui.widget.VisTextButton

class MainMenuScreen(val main: Main) : Screen {

    lateinit var stage: Stage
    lateinit var rootTable: VisTable
    lateinit var titleLabel: VisLabel
    lateinit var playButton: VisTextButton
    lateinit var exitButton: VisTextButton

    fun addTable() {
        rootTable = VisTable()
        rootTable.setFillParent(true)

        stage.addActor(rootTable)
    }

    fun addTitleLabel() {
        titleLabel = VisLabel("Alien Invasion", Label.LabelStyle(Assets.getBigFont(), Color.CORAL))
        rootTable.add(titleLabel).align(Align.top).padTop(30f)
    }

    fun addPlayButton() {
        playButton = VisTextButton("Play")
        rootTable.row()
        rootTable.add(playButton).expandY().align(Align.bottom).padBottom(20f).width(250f)

        playButton.addListener(object : ChangeListener() {
            override fun changed(event: ChangeEvent?, actor: Actor?) {
                main.screen = main.gameplayScreen
            }
        })
    }

    fun addExitButton() {
        exitButton = VisTextButton("Exit")
        rootTable.row()
        rootTable.add(exitButton).expandY().align(Align.top).padTop(20f).width(250f)

        exitButton.addListener(object : ChangeListener() {
            override fun changed(event: ChangeEvent?, actor: Actor?) {
                Gdx.app.exit()
            }
        })
    }

    override fun show() {
        stage = Stage(main.viewport)
        main.inputHandler.stage = stage

        addTable()
        addTitleLabel()
        addPlayButton()
        addExitButton()
    }

    override fun pause() {
    }

    override fun resize(width: Int, height: Int) {
        main.viewport.update(width, height)
    }

    override fun hide() {
        rootTable.clear()
        stage.clear()
    }

    override fun render(delta: Float) {
        stage.act()
        stage.draw()
    }

    override fun resume() {
    }

    override fun dispose() {
        stage.dispose()
    }

}