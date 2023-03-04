package fr.ensim.dp.map.player;

public class StateStop extends AllIllegalState {

    private StateStop() {}

    protected static StateStop STOP = new StateStop();
    @Override
    public void play(IPlayer player) {
        player.firechangeState(StatePlay.PLAY);
    }
}
