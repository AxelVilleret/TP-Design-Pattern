package fr.ensim.dp.map.player;

public class StateBackward extends AllIllegalState {

    private StateBackward() {}

    protected static StateBackward BACKWARD = new StateBackward();

    @Override
    public void stop(IPlayer player) {
        player.firechangeState(StateStop.STOP);
    }

    @Override
    public void forward(IPlayer player) {
        player.firechangeState(StateForward.FORWARD);
    }
}
