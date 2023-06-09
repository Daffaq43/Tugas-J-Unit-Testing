package sample.io.tictactoe;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import sample.io.tictactoe.model.Player;
import sample.io.tictactoe.view.GameActivity;

import static com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed;
import static com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn;
import static com.schibsted.spain.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton;
import static com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo;


public class GameActivityShould {

    @Rule
    public ActivityTestRule<GameActivity> activityRule = new ActivityTestRule<>(GameActivity.class);

    private Player player1 = new Player("daps", "x");
    private Player player2 = new Player("yasir", "o");

    @Test
    public void end_game_when_one_player_wins() {
        writeTo(R.id.et_player1, player1.name);
        writeTo(R.id.et_player2, player2.name);
        clickDialogPositiveButton();

        clickOn(R.id.cell_00);
        clickOn(R.id.cell_10);
        clickOn(R.id.cell_01);
        clickOn(R.id.cell_11);
        clickOn(R.id.cell_02);

        assertDisplayed(R.id.tv_winner);
        assertDisplayed(player1.name);
    }
}
