package com.silwest.CTBHelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Silwest on 13.04.14.
 */
public class AssetLoader {

    public static Texture texture;
    public static TextureRegion bg, grass;

    public static Animation birdAnimation;
    public static TextureRegion bird, birdDown, birdUp;

    public static TextureRegion skullUp, skullDown, bar;
    public static Sound dead, flap, coin;
    public static BitmapFont font, shadow;

    public static void load(){

//        texture = new Texture(Gdx.files.internal("data/texture.png"));
        texture = new Texture(Gdx.files.internal("E:\\Silwest\\Android\\CheckThatBird-android\\assets\\data\\texture.png"));
        texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        bg = new TextureRegion(texture, 0, 0, 136, 43);
        bg.flip(false, true);

        grass = new TextureRegion(texture, 0, 43, 143, 11);
        grass.flip(false, true);

        birdDown = new TextureRegion(texture, 136, 0, 17, 12);
        birdDown.flip(false, true);

        bird = new TextureRegion(texture, 153, 0, 17, 12);
        bird.flip(false, true);

        birdUp = new TextureRegion(texture, 170, 0, 17, 12);
        birdUp.flip(false, true);

        TextureRegion[] birds = {birdDown, bird, birdUp};
        birdAnimation = new Animation(0.06f, birds);
        birdAnimation.setPlayMode(Animation.LOOP_PINGPONG);

        skullUp = new TextureRegion(texture, 192, 0, 24, 14);
        skullDown = new TextureRegion(skullUp);
        skullDown.flip(false, true);

        bar = new TextureRegion(texture, 136, 16, 22, 3);
        bar.flip(false, true);
        dead = Gdx.audio.newSound(Gdx.files.internal("E:\\Silwest\\Android\\CheckThatBird-android\\assets\\data\\dead.wav"));
        flap = Gdx.audio.newSound(Gdx.files.internal("E:\\Silwest\\Android\\CheckThatBird-android\\assets\\data\\flap.wav"));
        coin = Gdx.audio.newSound(Gdx.files.internal("E:\\Silwest\\Android\\CheckThatBird-android\\assets\\data\\coin.wav"));
        font = new BitmapFont(Gdx.files.internal("E:\\Silwest\\Android\\CheckThatBird-android\\assets\\data\\text.fnt"));
        font.setScale(.25f, -.25f);
        shadow = new BitmapFont(Gdx.files.internal("E:\\Silwest\\Android\\CheckThatBird-android\\assets\\data\\shadow.fnt"));
        shadow.setScale(.25f, -.25f);
    }

    public static void dispose(){
        texture.dispose();
        dead.dispose();
        flap.dispose();
        coin.dispose();
        font.dispose();
        shadow.dispose();
    }
}
