package fr.ensim.dp.map.player;

public class StateForward extends AllIllegalState {

    private StateForward() {}

    protected static StateForward FORWARD = new StateForward();

    @Override
    public void stop(IPlayer player) {
        player.firechangeState(StateStop.STOP);
    }

    @Override
    public void backward(IPlayer player) {
        player.firechangeState(StateBackward.BACKWARD);
    }
}
