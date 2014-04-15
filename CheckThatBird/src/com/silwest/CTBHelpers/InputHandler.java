package com.silwest.CTBHelpers;

import com.badlogic.gdx.InputProcessor;
import com.silwest.GameObjects.Bird;
import com.silwest.GameWorld.GameWorld;

/**
 * Created by Silwest on 13.04.14.
 */
public class InputHandler implements InputProcessor{

    private final GameWorld myWorld;
    private Bird myBird;

    public InputHandler(GameWorld myWorld){
        this.myBird = myWorld.getBird();
        this.myWorld = myWorld;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(myWorld.isReady()){
            myWorld.start();
        }

        myBird.onClick();
        if(myWorld.isGameOver()){
            myWorld.restart();
        }
        return true; // zwracamy true, czyli ze obsluzylismy akcje
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
