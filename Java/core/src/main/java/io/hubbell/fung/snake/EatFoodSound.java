package io.hubbell.fung.snake;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.Gdx;

public class EatFoodSound implements AudioPlayable {
    Sound sound = Gdx.audio.newSound(Gdx.files.internal("eat.mp3"));

    @Override
    public void play() {
        sound.play();
    }
}
