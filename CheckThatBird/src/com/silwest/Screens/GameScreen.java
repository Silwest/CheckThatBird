package com.silwest.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.silwest.CTBHelpers.InputHandler;
import com.silwest.GameWorld.GameRenderer;
import com.silwest.GameWorld.GameWorld;

/**
 * Created by Silwest on 13.04.14.
 */
public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;
    private float runTime = 0;
    public GameScreen(){
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);

        int midPointY = (int)(gameHeight/2);
        world = new GameWorld(midPointY);
        renderer = new GameRenderer(world, (int)gameHeight, midPointY);

        Gdx.input.setInputProcessor(new InputHandler(world));
    }

    @Override
    public void render(float delta) {
        world.update(delta);
        runTime += delta;
        renderer.render(runTime);

    }

    @Override
    public void resize(int width, int height) {
        System.out.println("Game screen: resizing");
    }

    @Override
    public void show() {
        System.out.println("Game screen: show");
    }

    @Override
    public void hide() {
        System.out.println("Game screen: hide");
    }

    @Override
    public void pause() {
        System.out.println("Game screen: pause");
    }

    @Override
    public void resume() {
        System.out.println("Game screen: resume");
    }

    @Override
    public void dispose() {

    }
}
