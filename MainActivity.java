package padapocnemoradit.tictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    Button a1,a2,a3,b1,b2,b3,c1,c2,c3, bNewGame;
    Button[] buttonArray;

    boolean turnMark = false;

    int markCounter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a1 = (Button) findViewById(R.id.A1);
        a2 = (Button) findViewById(R.id.A2);
        a3 = (Button) findViewById(R.id.A3);
        b1 = (Button) findViewById(R.id.B1);
        b2 = (Button) findViewById(R.id.B2);
        b3 = (Button) findViewById(R.id.B3);
        c1 = (Button) findViewById(R.id.C1);
        c2 = (Button) findViewById(R.id.C2);
        c3 = (Button) findViewById(R.id.C3);
        bNewGame = (Button) findViewById(R.id.NewGame);

        buttonArray = new Button[]{a1,a2,a3,b1,b2,b3,c1,c2,c3};

        for(Button b : buttonArray){
            b.setOnClickListener(this);
        }

        bNewGame.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                turnMark = true;
                markCounter = 0;
                enableDisableAllButtons(true);
            }
        });


    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;

        buttonClicked(b);
    }

    public void buttonClicked(Button b){
        if(turnMark){
            b.setText("X");
        } else{
            b.setText("O");
        }
        b.setClickable(false);
        b.setBackgroundColor(Color.GREEN);
        turnMark = !turnMark;

        checkForWinner();
    }

    public void checkForWinner(){
        boolean thereIsAWinner = false;


        if(a1.getText()==a2.getText()&&a2.getText()==a3.getText() && !a1.isClickable()){
            thereIsAWinner = true;
        } else if(b1.getText()==b2.getText()&&b2.getText()==b3.getText()  && !b1.isClickable()){
            thereIsAWinner = true;
        } else if(c1.getText()==c2.getText()&&c2.getText()==c3.getText()  && !c1.isClickable()){
            thereIsAWinner = true;
        } else if(a1.getText()==b2.getText()&&b2.getText()==c3.getText()  && !a1.isClickable()){
            thereIsAWinner = true;
        }else if(a1.getText()==b2.getText()&&b2.getText()==c3.getText()  && !a1.isClickable()){
            thereIsAWinner = true;
        }else if(a3.getText()==b2.getText()&&b2.getText()==c1.getText()  && !a3.isClickable()){
            thereIsAWinner = true;
        }else if(a2.getText()==b2.getText()&&b2.getText()==c2.getText()  && !a2.isClickable()){
            thereIsAWinner = true;
        }else if(a1.getText()==b1.getText()&&b1.getText()==c1.getText()  && !a1.isClickable()){
            thereIsAWinner = true;
        }else if(a3.getText()==b3.getText()&&b3.getText()==c3.getText()  && !a3.isClickable()){
            thereIsAWinner = true;
        }


        if(thereIsAWinner){
            if(!turnMark){
                toast("X je pobijedio");

            } else if(markCounter==9){
                toast("Izjednaceno je");
            }else{
                toast("Kruzic je pobijedio");
            }

            enableDisableAllButtons(false);
        }
    }

    public void enableDisableAllButtons(boolean enable){
        for(Button b:buttonArray){
            b.setClickable(enable);
            if(enable){
                b.setBackgroundColor(Color.BLACK);
                b.setText("");
            } else{
                b.setBackgroundColor(Color.GREEN);
            }
        }
    }

    public void toast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
