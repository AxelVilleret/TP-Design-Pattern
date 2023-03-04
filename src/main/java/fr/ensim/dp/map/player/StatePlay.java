package fr.ensim.dp.map.player;

public class StatePlay extends AllIllegalState {

    private StatePlay() {}

    protected static StatePlay PLAY = new StatePlay();

    @Override
    public void stop(IPlayer player) {
        player.firechangeState(StateStop.STOP);
    }

    @Override
    public void pause(IPlayer player) {
        player.firechangeState(StatePause.PAUSE);
    }

    @Override
    public void forward(IPlayer player) {
        player.firechangeState(StateForward.FORWARD);
    }

    @Override
    public void backward(IPlayer player) {
        player.firechangeState(StateBackward.BACKWARD);
    }
}
