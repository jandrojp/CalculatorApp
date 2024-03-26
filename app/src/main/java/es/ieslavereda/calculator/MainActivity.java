package es.ieslavereda.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private Button buttonClear;
    private Button buttonEqual;
    private Button buttonSum;
    private Button buttonLess;
    private Button buttonMultiply;
    private Button buttonSplit;
    private Button buttonPoint;
    private CheckBox checkBoxSettings;
    private Operacion operacion;
    private Double operando;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        buttonClear = findViewById(R.id.buttonReset);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonSum = findViewById(R.id.buttonSum);
        buttonLess = findViewById(R.id.buttonLess);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonSplit = findViewById(R.id.buttonSplit);
        buttonPoint = findViewById(R.id.buttonPoint);
        checkBoxSettings = findViewById(R.id.checkBoxSettings);
        radioGroup = findViewById(R.id.radioGroup);

        buttonClear.setOnClickListener(v -> textView.setText("0"));

        buttonSum.setOnClickListener(v -> {
            operando = Double.parseDouble(textView.getText().toString());
            operacion = Operacion.SUMA;
            textView.setText("0");
        });

        buttonLess.setOnClickListener(v -> {
            operando = Double.parseDouble(textView.getText().toString());
            operacion = Operacion.RESTA;
            textView.setText("0");
        });

        buttonMultiply.setOnClickListener(v -> {
            operando = Double.parseDouble(textView.getText().toString());
            operacion = Operacion.MULTIPLICACION;
            textView.setText("0");
        });

        buttonSplit.setOnClickListener(v -> {
            operando = Double.parseDouble(textView.getText().toString());
            operacion = Operacion.DIVISION;
            textView.setText("0");
        });

        buttonPoint.setOnClickListener(v -> {
            textView.setText(textView.getText() + ".");
        });

        buttonEqual.setOnClickListener(v -> {
            if (operacion == Operacion.SUMA) {
                textView.setText(String.valueOf(operando + Double.parseDouble(textView.getText().toString())));
            } else if (operacion == Operacion.RESTA) {
                textView.setText(String.valueOf(operando - Double.parseDouble(textView.getText().toString())));
            } else if (operacion == Operacion.MULTIPLICACION) {
                textView.setText(String.valueOf(operando * Double.parseDouble(textView.getText().toString())));
            } else if (operacion == Operacion.DIVISION) {
                textView.setText(String.valueOf(operando / Double.parseDouble(textView.getText().toString())));
            }
        });


        checkBoxSettings.setOnClickListener(v -> {
            if (checkBoxSettings.isChecked()) {
                radioGroup.setVisibility(View.VISIBLE);
                checkBoxSettings.setText("Deshabilitar opciones");

            } else {
                checkBoxSettings.setText("Habilitar opciones");
                radioGroup.setVisibility(View.GONE);

                radioGroup.clearCheck();

                buttonSum.setVisibility(View.VISIBLE);
                buttonLess.setVisibility(View.VISIBLE);
                buttonMultiply.setVisibility(View.VISIBLE);
                buttonSplit.setVisibility(View.VISIBLE);
            }
        });

        radioGroup.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == R.id.radioButtonSum) {
                buttonSum.setVisibility(View.GONE);
                buttonLess.setVisibility(View.VISIBLE);
                buttonMultiply.setVisibility(View.VISIBLE);
                buttonSplit.setVisibility(View.VISIBLE);

            } else if (i == R.id.radioButtonLess) {
                buttonLess.setVisibility(View.GONE);
                buttonSum.setVisibility(View.VISIBLE);
                buttonMultiply.setVisibility(View.VISIBLE);
                buttonSplit.setVisibility(View.VISIBLE);

            } else if (i == R.id.radioButtonMultiply) {
                buttonMultiply.setVisibility(View.GONE);
                buttonSum.setVisibility(View.VISIBLE);
                buttonLess.setVisibility(View.VISIBLE);
                buttonSplit.setVisibility(View.VISIBLE);

            } else if (i == R.id.radioButtonSplit) {
                buttonSplit.setVisibility(View.GONE);
                buttonSum.setVisibility(View.VISIBLE);
                buttonLess.setVisibility(View.VISIBLE);
                buttonMultiply.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onClick(View view) {

        if (textView.getText().equals("0")) {
            textView.setText(((Button) view).getText());
        } else {
            textView.setText(textView.getText() + ((Button) view).getText().toString());
        }

    }


}