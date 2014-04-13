package com.silwest.CheckThatBird;

import com.badlogic.gdx.Game;
import com.silwest.CTBHelpers.AssetLoader;
import com.silwest.Screens.GameScreen;

public class CTBGame extends Game{

    @Override
    public void create() {
        AssetLoader.load();
        setScreen(new GameScreen());
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
