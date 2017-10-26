package my.edu.tarc.lab12mbi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextWeight, editTextHeight;
    private TextView textViewResult;
    private ImageView imageViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateBMI(View view) {

        editTextHeight = (EditText) findViewById(R.id.editTextHeight);
        editTextWeight = (EditText) findViewById(R.id.editTextWeight);
        imageViewResult = (ImageView) findViewById(R.id.imageViewResult);
        textViewResult = (TextView)findViewById(R.id.textViewResult);

        double BMI, weight, height;

        weight = Double.parseDouble(editTextWeight.getText().toString());
        height = Double.parseDouble(editTextHeight.getText().toString());

        BMI = weight / (height * height);

        if (BMI <= 18.5) {
            textViewResult.setText("BMI: " + String.format("%.2f",BMI) + ", you are underweight.");
            imageViewResult.setImageResource(R.drawable.under);
        } else if (BMI > 18.6 || BMI < 25) {
            textViewResult.setText("BMI: " + String.format("%.2f",BMI) + ", you are in normal weight.");
            imageViewResult.setImageResource(R.drawable.normal);
        } else if (BMI >= 25) {
            textViewResult.setText("BMI: " + String.format("%.2f",BMI) + ", you are overweight.");
            imageViewResult.setImageResource(R.drawable.over);
        }
    }
        public void reset(View view) {
            editTextHeight.setText("");
            editTextWeight.setText("");
            imageViewResult.setImageResource(R.drawable.empty);
            textViewResult.setText("");
        }




    }

