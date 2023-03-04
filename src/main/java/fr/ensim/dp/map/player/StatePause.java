package fr.ensim.dp.map.player;

public class StatePause extends AllIllegalState {
    private StatePause() {}

    protected static StatePause PAUSE = new StatePause();
    @Override
    public void play(IPlayer player) {
        player.firechangeState(StatePlay.PLAY);
    }

}
