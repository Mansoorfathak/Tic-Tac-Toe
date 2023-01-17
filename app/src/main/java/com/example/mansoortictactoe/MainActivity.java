package com.example.mansoortictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //0:0 ,1:1
     int playerActive = 0;
     int gameState[] = {2,2,2,2,2,2,2,2,2};

     public  static int count = 0;

     boolean gameActive = true;

     int[][] winningPosition ={ {0,1,2},
                                {3,4,5},
                                {6,7,8},
                {0,3,6},{1,4,7},{2,5,8},
                 {0,4,8},{2,4,6} };

    public void OnImageTap(View view){
        ImageView imageView =(ImageView) view;
        imageView.setTranslationY(-1000);

        int imageTapped = Integer.parseInt(imageView.getTag().toString());

        if (gameState[imageTapped] == 2 && gameActive) {
            count++;

            if (count == 9){
                gameActive = false;
            }
            gameState[imageTapped] = playerActive;
            if (playerActive == 0) {
                imageView.setImageResource(R.drawable.o);
                playerActive = 1;
                TextView status = findViewById(R.id.textView2);
                status.setText("X's turn");
            } else {
                imageView.setImageResource(R.drawable.x);
                playerActive = 0;
                TextView status = findViewById(R.id.textView2);
                status.setText("0's turn");
            }
            imageView.animate().translationYBy(1000).setDuration(200);

            int draw = 1;
            for(int [] winningPosition:winningPosition){
                if (gameState[winningPosition[0]]== gameState[winningPosition[1]]
                    && gameState[winningPosition[1]] == gameState[winningPosition[2]]
                        && gameState[winningPosition[0]] != 2){
                    draw = 0; // Not a draw
                    String winner;
                    if (gameState[winningPosition[0]] == 0){
                        winner = "0 has won ";
                    }else{
                        winner = "X has won";
                    }

                    TextView status = findViewById(R.id.textView2);
                    status.setText(winner);

                    Button playAgainButton = findViewById(R.id.button);
                    playAgainButton.setVisibility(View.VISIBLE);
            }
        }
            //Draw Condition
            if (count ==9 && draw == 1){
                TextView status = findViewById(R.id.textView2);
                status.setText("Match draw ");


                Button playAgainButton = findViewById(R.id.button);
                playAgainButton.setVisibility(View.VISIBLE);
            }
     }
    }

    public void playAgain(View view){
        Button playAgainButton = findViewById(R.id.button);
        playAgainButton.setVisibility(View.INVISIBLE);

        TextView status = findViewById(R.id.textView2);
        status.setText("0's turn ");

        gameActive = true;
        playerActive = 0;
        count = 0;

        for (int i = 0;i<gameState.length;i++){
            gameState[i] = 2;

        }

        ((ImageView)findViewById(R.id.imageView0)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView1)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView2)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView3)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView4)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView5)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView6)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView7)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView8)).setImageDrawable(null);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playAgainButton = findViewById(R.id.button);
        playAgainButton.setVisibility(View.INVISIBLE);
    }
}