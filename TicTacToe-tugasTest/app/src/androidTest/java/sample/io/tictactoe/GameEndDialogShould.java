package sample.io.tictactoe;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import sample.io.tictactoe.model.Player;
import sample.io.tictactoe.view.GameActivity;

import static com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed;
import static com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotExist;
import static com.schibsted.spain.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton;

public class GameEndDialogShould {

    @Rule
    public ActivityTestRule<GameActivity> activityRule = new ActivityTestRule<>(GameActivity.class);

    @Test
    public void display_winner_when_game_ends() throws Exception {
        givenGameEnded();

        assertDisplayed(R.id.tv_winner);
    }

    @Test
    public void display_begin_dialog_when_done_clicked() throws Exception {
        givenGameEnded();

        clickDialogPositiveButton();

        assertNotExist(R.id.tv_winner);
        assertDisplayed(R.id.et_player1);
    }

    private void givenGameEnded() {
        activityRule.getActivity().onGameWinnerChanged(new Player("daps", "x"));
    }
}