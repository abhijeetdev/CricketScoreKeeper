package com.example.android.cricketscorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int teamAScore = 0;
    int teamAExtra = 0;
    int teamAWicket = 0;
    int teamAballs = 0;

    int teamBScore = 0;
    int teamBExtra = 0;
    int teamBWicket = 0;
    int teamBballs = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateTeamAScoreBord();
        updateTeamBScoreBord();
    }

    public void updateTeamAScore(View view) {
        Button scoreButton = (Button) view;
        int run = Integer.parseInt(scoreButton.getText().toString());
        teamAScore += run;
        teamAballs += 1;
        updateTeamAScoreBord();
    }

    private void updateTeamAScoreBord() {

        CheckBox wicket_check_box = (CheckBox)findViewById(R.id.team_a_wicket_fall);
        if (wicket_check_box.isChecked()) {
            teamAWicket += 1;

        }
        wicket_check_box.setChecked(false);

        CheckBox no_ball_check_box = (CheckBox)findViewById(R.id.team_a_no_ball);
        if (no_ball_check_box.isChecked()) {
            teamAExtra += 1;
            teamAScore += 1;
            teamAballs -= 1;
        }
        no_ball_check_box.setChecked(false);


        CheckBox wide_ball_check_box = (CheckBox)findViewById(R.id.team_a_wide);
        if (wide_ball_check_box.isChecked()) {
            teamAExtra += 1;
            teamAScore += 1;
            teamAballs -= 1;
        }
        wide_ball_check_box.setChecked(false);

        CheckBox free_hit_check_box = (CheckBox)findViewById(R.id.team_a_no_ball);
        if (free_hit_check_box.isChecked()) {
            teamAballs -= 1;
        }
        free_hit_check_box.setChecked(false);

        TextView score_text_view = (TextView)findViewById(R.id.team_a_score);
        score_text_view.setText(""+teamAScore);

        TextView wicket_text_view = (TextView) findViewById(R.id.team_a_wicket);
        wicket_text_view.setText(""+teamAWicket);

        TextView over_text_view = (TextView) findViewById(R.id.team_a_overs);
        int over = teamAballs/6;
        int ballsInOver = teamAballs%6;
        over_text_view.setText(""+over+"."+ballsInOver);

        TextView extras_text_view = (TextView) findViewById(R.id.team_a_extras);
        extras_text_view.setText(""+teamAExtra);

    }

    public void updateTeamBScore(View view) {
        Button scoreButton = (Button) view;
        int run = Integer.parseInt(scoreButton.getText().toString());
        teamBScore += run;
        teamBballs += 1;
        updateTeamBScoreBord();
    }

    private void updateTeamBScoreBord() {

        CheckBox wicket_check_box = (CheckBox)findViewById(R.id.team_b_wicket_fall);
        if (wicket_check_box.isChecked()) {
            teamBWicket += 1;

        }
        wicket_check_box.setChecked(false);

        CheckBox no_ball_check_box = (CheckBox)findViewById(R.id.team_b_no_ball);
        if (no_ball_check_box.isChecked()) {
            teamBExtra += 1;
            teamBScore += 1;
            teamBballs -= 1;
        }
        no_ball_check_box.setChecked(false);


        CheckBox wide_ball_check_box = (CheckBox)findViewById(R.id.team_b_wide);
        if (wide_ball_check_box.isChecked()) {
            teamBExtra += 1;
            teamBScore += 1;
            teamBballs -= 1;
        }
        wide_ball_check_box.setChecked(false);

        CheckBox free_hit_check_box = (CheckBox)findViewById(R.id.team_b_no_ball);
        if (free_hit_check_box.isChecked()) {
            teamBballs -= 1;
        }
        free_hit_check_box.setChecked(false);

        TextView score_text_view = (TextView)findViewById(R.id.team_b_score);
        score_text_view.setText(""+teamBScore);

        TextView wicket_text_view = (TextView) findViewById(R.id.team_b_wicket);
        wicket_text_view.setText(""+teamBWicket);

        TextView over_text_view = (TextView) findViewById(R.id.team_b_overs);
        int over = teamBballs/6;
        int ballsInOver = teamBballs%6;
        over_text_view.setText(""+over+"."+ballsInOver);

        TextView extras_text_view = (TextView) findViewById(R.id.team_b_extras);
        extras_text_view.setText(""+teamBExtra);

    }

}
