package com.electroweak.game.asset

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.kotcrab.vis.ui.VisUI

object Assets {

    val SPRITE_SHEET: String = "spritesheet.atlas";

    var assetManager: AssetManager = AssetManager();

    /**
     * Texture resource used in game.
     * @param resourceName name of texture, if loadAsTexture is true then file name of texture
     * @param loadAsTexture whether it should be loaded as ordinary texture
     */
    enum class Resource(val resourceName: String, val loadAsTexture: Boolean) {
        SPACE_BACKGROUND("space_background.png", true),
        ALIEN_WEAK("alien_weak", false),
        ALIEN_NORMAL("alien_normal", false),
        ALIEN_STRONG("alien_strong", false),
        ASTEROID_BIG("asteroid_big", false),
        ASTEROID_SMALL1("asteroid_small1", false),
        ASTEROID_SMALL2("asteroid_small2", false),
        ASTEROID_TINY("asteroid_tiny", false),
        PLAYER("player", false),
        CANNON("cannon", false),
        CANNON_DOUBLE("cannon_double", false)
    }

    fun loadAllResources() {
        VisUI.load()

        assetManager.load(SPRITE_SHEET, TextureAtlas::class.java)

        for (resource in Resource.values()) {
            if (resource.loadAsTexture) {
                assetManager.load(resource.resourceName, Texture::class.java)
            }
        }

        assetManager.finishLoading()
    }

    fun getTexture(resource: Resource) : Texture = assetManager.get(resource.resourceName, Texture::class.java)

    fun getRegionFromTexture(resource: Resource) : TextureRegion = TextureRegion(getTexture(resource))

    fun getAtlasRegion(resource: Resource) : TextureAtlas.AtlasRegion = assetManager.get(SPRITE_SHEET, TextureAtlas::class.java)
            .findRegion(resource.resourceName)

    fun dispose() {
        VisUI.dispose()
        assetManager.dispose()
    }

}