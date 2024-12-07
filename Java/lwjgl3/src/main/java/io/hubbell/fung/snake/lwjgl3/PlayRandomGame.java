package io.hubbell.fung.snake.lwjgl3;

public class PlayRandomGame {
    public static void main(String[] args) {
        if (StartupHelper.startNewJvmIfRequired()) return; // This handles macOS support and helps on Windows.
        Lwjgl3Launcher.createRandomMovementGame();
    }
}
