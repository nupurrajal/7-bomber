package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
// import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean checkIfLost = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_increment = (Button) findViewById(R.id.btn_increment);
        Button btn_bomb = (Button) findViewById(R.id.btn_bomb);
        Button btn_exit = (Button) findViewById(R.id.btn_exitApp);
        final TextView text_current_num = (TextView) findViewById(R.id.text_currentNumber);
        final TextView game_verdict = (TextView) findViewById(R.id.text_game_verdict);
        final TextView count_down_timer = (TextView) findViewById(R.id.text_countDownTimer);
        char seconds = String.valueOf(count_down_timer.getText()).charAt(0);

        btn_increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int last = Integer.parseInt(String.valueOf(text_current_num.getText()));

                if(!checkIfLost) {
                    if (isBomb(last + 1)) {
                        String lostGame = "You lost.";
                        game_verdict.setText(lostGame);
                        checkIfLost = true;
                        //text_current_num.setText("looser, not a bomb");
                    } else {
                        last += 1;
                        text_current_num.setText(String.valueOf(last));// = game_verdict.getText();
                    }
                }
            }
        });
        btn_bomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int last = Integer.parseInt(String.valueOf(text_current_num.getText()));
                if(!checkIfLost) {
                    if (isBomb(last + 1)) {
                        // wait for next move
                        last += 1;
                        text_current_num.setText(String.valueOf(last));// = game_verdict.getText();
                    } else {
                        String lostGame = "You have lost.";
                        game_verdict.setText(lostGame);
                        checkIfLost = true;
                        //text_current_num.setText("looser, it's a bomb");
                    }
                }
            }
        });

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
        }


    public boolean isBomb(int num) {
        if (num % 7 == 0 || num % 10 == 7) {
            return true;
        }
        return false;
    }

    public void nextMove(){

    }
}
