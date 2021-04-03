package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button One, Zero, Two, Three, Four, Five, Six, Seven, Eight, Nine;
    Button Divide, Multiple, Minus, Plus, Point, Equals, Delete;
    EditText mEditText;
    static float result = 0;
    static ArrayList<Float> operand = new ArrayList();
    static ArrayList<Character> operation = new ArrayList();
    static String mInputTxt = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        mEditText = findViewById(R.id.Edit_text);

        Zero = findViewById(R.id.button_zero);
        One = findViewById(R.id.button_one);
        Two = findViewById(R.id.button_two);
        Three = findViewById(R.id.button_three);
        Four = findViewById(R.id.button_four);
        Five = findViewById(R.id.button_five);
        Six = findViewById(R.id.button_six);
        Seven = findViewById(R.id.button_seven);
        Eight = findViewById(R.id.button_eight);
        Nine = findViewById(R.id.button_nine);

        Divide = findViewById(R.id.button_divide);
        Multiple = findViewById(R.id.button_multiple);
        Minus = findViewById(R.id.button_minus);
        Plus = findViewById(R.id.button_plus);
        Point = findViewById(R.id.button_point);
        Equals = findViewById(R.id.button_equals);
        Delete = findViewById(R.id.button_delete);

        mEditText.setInputType(InputType.TYPE_NULL);//This code hide soft keyboard
        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        Zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditText.setText(mEditText.getText() + getString(R.string.n_0));
                mInputTxt = mInputTxt.concat("0");
                Toast.makeText(MainActivity.this,"0",Toast.LENGTH_SHORT).show();
            }
        });

        One.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditText.setText(String.format("%s%s", mEditText.getText(), getString(R.string.n_1)));
                mInputTxt = mInputTxt.concat("1");
                Toast.makeText(MainActivity.this,"1",Toast.LENGTH_SHORT).show();
            }
        });

        Two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditText.setText(mEditText.getText() + getString(R.string.n_2));
                mInputTxt = mInputTxt.concat("2");
                Toast.makeText(MainActivity.this,"2",Toast.LENGTH_SHORT).show();
            }
        });
        Three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditText.setText(mEditText.getText() + getString(R.string.n_3));
                mInputTxt = mInputTxt.concat("3");
                Toast.makeText(MainActivity.this,"3",Toast.LENGTH_SHORT).show();
            }
        });
        Four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditText.setText(mEditText.getText() + getString(R.string.n_4));
                mInputTxt = mInputTxt.concat("4");
                Toast.makeText(MainActivity.this,"4",Toast.LENGTH_SHORT).show();
            }
        });
        Five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditText.setText(mEditText.getText() + getString(R.string.n_5));
                mInputTxt = mInputTxt.concat("5");
                Toast.makeText(MainActivity.this,"5",Toast.LENGTH_SHORT).show();
            }
        });
        Six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditText.setText(mEditText.getText() + getString(R.string.n_6));
                mInputTxt = mInputTxt.concat("6");
                Toast.makeText(MainActivity.this,"6",Toast.LENGTH_SHORT).show();
            }
        });
        Seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditText.setText(mEditText.getText().append(getString(R.string.n_7)));
                mInputTxt = mInputTxt.concat("7");
                Toast.makeText(MainActivity.this,"7",Toast.LENGTH_SHORT).show();
            }
        });
        Eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditText.setText(mEditText.getText().append(getString(R.string.n_8)));
                mInputTxt = mInputTxt.concat("8");
                Toast.makeText(MainActivity.this,"8",Toast.LENGTH_SHORT).show();
            }
        });
        Nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditText.setText(mEditText.getText().append(getString(R.string.n_9)));
                mInputTxt = mInputTxt.concat("9");
                Toast.makeText(MainActivity.this,"9",Toast.LENGTH_SHORT).show();
            }
        });
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Delete",Toast.LENGTH_SHORT).show();
                mEditText.setText("");
                mInputTxt = "";
                result = 0;
                operation.clear();
                operand.clear();
            }
        });

        Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"+",Toast.LENGTH_SHORT).show();
                if(mInputTxt.isEmpty())
                    return;
                char temp=mEditText.getText().toString().charAt(mEditText.length()-1);
                if(temp=='/' || temp == '+' || temp == '-' || temp == '*' || temp=='.') {
                    return;
                }
                operand.add(Float.parseFloat(mInputTxt));
                operation.add('+');
                mEditText.setText(mEditText.getText().append("+"));
                mInputTxt = "";
            }
        });
        Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"-",Toast.LENGTH_SHORT).show();
                if(mInputTxt.isEmpty())
                    return;
                char temp=mEditText.getText().toString().charAt(mEditText.length()-1);
                if(temp=='/' || temp == '+' || temp == '-' || temp == '*' || temp=='.') {
                    return;
                }
                operand.add(Float.parseFloat(mInputTxt));
                operation.add('-');
                mEditText.setText(mEditText.getText().append("-"));
                mInputTxt = "";
            }
        });
        Multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"*",Toast.LENGTH_SHORT).show();
                if(mInputTxt.isEmpty())
                    return;
                char temp=mEditText.getText().toString().charAt(mEditText.length()-1);
                if(temp=='/' || temp == '+' || temp == '-' || temp == '*' || temp=='.') {
                    return;
                }
                operand.add(Float.parseFloat(mInputTxt));
                operation.add('*');
                mEditText.setText(mEditText.getText().append("*"));
                mInputTxt = "";
            }
        });
        Divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"/",Toast.LENGTH_SHORT).show();
                if(mInputTxt.isEmpty())
                    return;
                char temp=mEditText.getText().toString().charAt(mEditText.length()-1);
                if(temp=='/' || temp == '+' || temp == '-' || temp == '*' || temp=='.') {
                    return;
                }
                operand.add(Float.parseFloat(mInputTxt));
                operation.add('/');
                mEditText.setText(mEditText.getText().append("/"));
                mInputTxt = "";
            }
        });
        Equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"=",Toast.LENGTH_SHORT).show();
                if(mInputTxt.isEmpty())
                    return;
                operand.add(Float.parseFloat(mInputTxt));
                result=operand.remove(0);
                for (int i = 0; i < operation.size(); i += 1) {
                    Calculator(operand.get(i), operation.get(i));
                }
                DecimalFormat df = new DecimalFormat("0.###");
                mEditText.setText(df.format(result));
                mInputTxt = df.format(result);
                result = 0;
                operation.clear();
                operand.clear();
            }
        });
        Point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,".",Toast.LENGTH_SHORT).show();
                if(mInputTxt.isEmpty())
                    return;
                char temp=mEditText.getText().toString().charAt(mEditText.length()-1);
                if(mInputTxt.contains(".") || temp=='/' || temp == '+' || temp == '-' || temp == '*') {
                    return;
                }
                mEditText.setText(mEditText.getText().append("."));
                mInputTxt +=".";
            }
        });
    }

    private static void Calculator(float operand1, char operation) {
        switch (operation) {
            case '+':
                result += operand1;
                break;
            case '-':
                result -= operand1;
                break;
            case '*':
                result *= operand1;
                break;
            case '/':
                result /= operand1;
                break;
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
