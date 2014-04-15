package com.silwest.GameWorld;


import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.silwest.CTBHelpers.AssetLoader;
import com.silwest.GameObjects.Bird;
import com.silwest.GameObjects.ScrollHandler;
import com.silwest.Screens.GameScreen;

/**
 * Created by Silwest on 13.04.14.
 */
public class GameWorld {

    private Bird bird;
    private ScrollHandler scroller;
    private Rectangle ground;
    private int score = 0;

    public enum GameState{
        READY, RUNNING, GAMEOVER;

    }

    private GameState currentState;
    private int midPointY;

    public GameWorld(int midPointY){
        bird = new Bird(33, midPointY-5, 17, 12);
        scroller = new ScrollHandler(this, midPointY + 66);
        ground = new Rectangle(0, midPointY +66, 136, 11);
        currentState = GameState.READY;
        this.midPointY = midPointY;
    }

    public void update(float delta) {
        if(delta > .15f)
            delta = .15f;

        bird.update(delta);
        scroller.update(delta);
        if(bird.isAlive() && scroller.collides(bird)){
            scroller.stop();
            AssetLoader.dead.play();
            bird.die();
        }
        if(Intersector.overlaps(bird.getBoundingCircle(), ground)){
            scroller.stop();
            bird.die();
            bird.decelerate();
        }
    }
    public Bird getBird() {
        return bird;
    }
    public ScrollHandler getScroller(){
        return scroller;
    }

    public int getScore(){
        return score;
    }
    public void addScore(int increment){
        score += increment;
    }

    public boolean isReady() {
        return currentState == GameState.READY;
    }
    public void start() {
        currentState = GameState.RUNNING;
    }
    public boolean isGameOver() {
        return currentState == GameState.GAMEOVER;
    }
    public void restart() {
        currentState = GameState.READY;
        score = 0;
        bird.onRestart(midPointY - 5);
        currentState = GameState.READY;
    }

}
