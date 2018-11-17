package edu.calvin.cs262.jww23.home_work1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import edu.calvin.cs262.jww23.home_work1.R;

/**
 * The MainActivity class implements methodes which allow the user to make calculations
 * they can add, subtract, multiple and divide any two integers
 * @author  Josh Wilson
 * @version 1.0
 * @since   11-16-2018
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // button1 = add
    // button2 = Subtract
    // button3 = Multiply
    // button4 = Divide
    TextView result;
    EditText Value1, Value2;
    Button button1, button2, button3,button4;

    float res_num;
    int val1, val2;

    
    //Allows the collection of inputed data to be read
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView)findViewById(R.id.result);

        Value1 = (EditText)findViewById(R.id.Value1);
        Value2 = (EditText)findViewById(R.id.Value2);
        
        // Creates an instance for the application to recognize which calculation is being done
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);

     





    }

    @Override
    public void onClick(View v) {

        // Creates the addition function
        button1.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                val1 = Integer.parseInt(Value1.getText().toString());
                val2 = Integer.parseInt(Value2.getText().toString());
                res_num = val1 + val2;
                result.setText(String.valueOf(res_num));


            }
        });
        // Creates the subtraction function
        button2.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                val1 = Integer.parseInt(Value1.getText().toString());
                val2 = Integer.parseInt(Value2.getText().toString());
                res_num = val1 - val2;
                result.setText(String.valueOf(res_num));


            }
        });

        // Creates the multiplication function
        button3.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                val1 = Integer.parseInt(Value1.getText().toString());
                val2 = Integer.parseInt(Value2.getText().toString());
                res_num = val1 * val2;
                result.setText(String.valueOf(res_num));


            }
        });

        // Creates the division function
        button4.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1 = Integer.parseInt(Value1.getText().toString());
                val2 = Integer.parseInt(Value2.getText().toString());
                res_num = val1 / val2;
                result.setText(String.valueOf(res_num));
            }
         });
     }

}
