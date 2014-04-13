package com.silwest.GameWorld;


import com.silwest.GameObjects.Bird;
import com.silwest.GameObjects.ScrollHandler;

/**
 * Created by Silwest on 13.04.14.
 */
public class GameWorld {

    private Bird bird;
    private ScrollHandler scroller;

    public GameWorld(int midPointY){
        bird = new Bird(33, midPointY-5, 17, 12);
        scroller = new ScrollHandler(midPointY + 66);
    }
    public void update(float delta) {
        bird.update(delta);
        scroller.update(delta);
    }

    public Bird getBird() {
        return bird;
    }
    public ScrollHandler getScroller(){
        return scroller;
    }
}
