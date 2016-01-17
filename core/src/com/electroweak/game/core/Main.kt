package com.electroweak.game.core

import com.badlogic.ashley.core.Engine
import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.utils.viewport.FitViewport
import com.electroweak.game.asset.Assets
import com.electroweak.game.entity.system.CollisionSystem
import com.electroweak.game.entity.system.FreeBulletSystem
import com.electroweak.game.entity.system.TextureRenderSystem
import com.electroweak.game.entity.system.VelocitySystem
import com.electroweak.game.input.InputHandler
import com.electroweak.game.screens.GameplayScreen
import com.electroweak.game.screens.MainMenuScreen

class Main : Game() {

    lateinit var viewport: FitViewport
    lateinit var inputHandler: InputHandler

    lateinit var engine: Engine
    lateinit var textureRenderSystem: TextureRenderSystem
    lateinit var velocitySystem: VelocitySystem
    lateinit var freeBulletSystem: FreeBulletSystem
    lateinit var collisionSystem: CollisionSystem

    lateinit var gameplayScreen: GameplayScreen
    lateinit var mainMenuScreen: MainMenuScreen

    override fun create() {
        Assets.loadAllResources()

        viewport = FitViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT, OrthographicCamera())

        engine = Engine()
        textureRenderSystem = TextureRenderSystem()
        velocitySystem = VelocitySystem()
        freeBulletSystem = FreeBulletSystem()
        collisionSystem = CollisionSystem()

        engine.addSystem(textureRenderSystem)
        engine.addSystem(velocitySystem)
        engine.addSystem(freeBulletSystem)
        engine.addSystem(collisionSystem)

        inputHandler = InputHandler()
        Gdx.input.inputProcessor = inputHandler

        mainMenuScreen = MainMenuScreen(this)
        gameplayScreen = GameplayScreen(this)

        setScreen(mainMenuScreen)
    }

    override fun render() {
        viewport.camera.update()
        textureRenderSystem.batch.projectionMatrix = viewport.camera.combined

        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        engine.update(Gdx.graphics.deltaTime)

        super.render()
    }

    override fun resize(width: Int, height: Int) {
        super.resize(width, height)
        viewport.update(width, height, true)
    }

    override fun dispose() {
        super.dispose()
        Assets.dispose()
    }

}