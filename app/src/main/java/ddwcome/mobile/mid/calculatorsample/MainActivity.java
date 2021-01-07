/* 과제명: 모바일소프트웨어 중간평가 과제
 * 분반: 2분반
 * 학번: 20180970, 성명: 박승연
 * 제출일: 2020년 5월 29일 */

package ddwcome.mobile.mid.calculatorsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText myEdit;
    Button btn_equal;
    Button btn_clear;
    Button btn_plus;
    Button btn_subtraction;
    Button btn_multiply;
    Button btn_divide;

    Button btn_root;
    Button btn_power;
    Button btn_sin;

    double num1;
    double num2;
    boolean first = true;

    double result = 0.0;
    String operator = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myEdit = findViewById(R.id.etDisplay);

        //clear
        btn_clear = findViewById(R.id.btn_clear);
        btn_clear.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String clear = "";
                myEdit.setHint("");
                myEdit.setText(clear);

                first = true;
                num1 = 0.0;
                num2 = 0.0;
                result = 0.0;
            }
        });

        //+
        btn_plus = findViewById(R.id.btn_plus);
        btn_plus.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = "plus";
                myEdit.setHint("+");

                if(!first){
                    num1 = result;
                    num2 = Double.parseDouble(myEdit.getText() + "");
                    calc(operator,num1,num2);
                }else {
                    result = Double.parseDouble(myEdit.getText() + "");
                    first = false;
                }
                myEdit.setText("");
                operator = "plus";
                //  Log.d("###", "onClick: "+operator);
            }
        });

        //-
        btn_subtraction = findViewById(R.id.btn_subtraction);
        btn_subtraction.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(myEdit.getText() + "");
                operator = "sub";
                myEdit.setHint("-");

                if (!first) {
                    num1 = result;
                    num2 = Double.parseDouble(myEdit.getText() + "");
                    calc(operator,num1,num2);
                }else {
                    result = Double.parseDouble(myEdit.getText() + "");
                    first = false;
                }
                myEdit.setText("");
                operator = "sub";
                //  Log.d("###", "onClick: "+operator);

            }
        });

        //*
        btn_multiply = findViewById(R.id.btn_multiply);
        btn_multiply.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(myEdit.getText() + "");
                operator = "multiply";
                myEdit.setHint("*");

                if (!first) {
                    num1 = result;
                    num2 = Double.parseDouble(myEdit.getText() + "");
                    calc(operator,num1,num2);
                }else {
                    result = Double.parseDouble(myEdit.getText() + "");
                    first = false;
                }
                myEdit.setText("");
                operator = "multiply";
                //    Log.d("###", "onClick: "+operator);
            }
        });

        //%
        btn_divide = findViewById(R.id.btn_divide);
        btn_divide.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(myEdit.getText() + "");
                operator = "divide";
                myEdit.setHint("/");

                if (!first) {
                    num1 = result;
                    num2 = Double.parseDouble(myEdit.getText() + "");
                    calc(operator,num1,num2);
                }else {
                    result = Double.parseDouble(myEdit.getText() + "");
                    first = false;
                }
                myEdit.setText("");
                operator = "divide";
                //    Log.d("###", "onClick: "+operator);
            }
        });

        //power
        btn_power = findViewById(R.id.btn_power);
        btn_power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(myEdit.getText() + "");
                operator = "power";
                myEdit.setHint("power");
                myEdit.setText(null);
            }
        });

        //root
        btn_root = findViewById(R.id.btn_root);
        btn_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(myEdit.getText() + "");
                operator = "root";
                myEdit.setHint("root");
                myEdit.setText(null);
            }
        });


        //sin
        btn_sin = findViewById(R.id.btn_sinx);
        btn_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(myEdit.getText() + "");
                operator = "sin";
                myEdit.setHint("sin");
                myEdit.setText(null);
            }
        });

        //=
        btn_equal = findViewById(R.id.btn_equal);
        btn_equal.setOnClickListener(myClickListener);


        //가산점 항목_1.화면 디자인 개선
        myEdit.setBackgroundColor(Color.GRAY);
        btn_plus.setBackgroundColor(Color.LTGRAY);
        btn_subtraction.setBackgroundColor(Color.LTGRAY);
        btn_multiply.setBackgroundColor(Color.LTGRAY);
        btn_divide.setBackgroundColor(Color.LTGRAY);
        btn_equal.setBackgroundColor(Color.LTGRAY);
    }

    public void onClick(View v) {
        String num = myEdit.getText().toString();

        switch (v.getId()) {
            case R.id.btn_0:
                myEdit.setText(num + "0");
                break;
            case R.id.btn_1:
                myEdit.setText(num + "1");
                break;
            case R.id.btn_2:
                myEdit.setText(num + "2");
                break;
            case R.id.btn_3:
                myEdit.setText(num + "3");
                break;
            case R.id.btn_4:
                myEdit.setText(num + "4");
                break;
            case R.id.btn_5:
                myEdit.setText(num + "5");
                break;
            case R.id.btn_6:
                myEdit.setText(num + "6");
                break;
            case R.id.btn_7:
                myEdit.setText(num + "7");
                break;
            case R.id.btn_8:
                myEdit.setText(num + "8");
                break;
            case R.id.btn_9:
                myEdit.setText(num + "9");
                break;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.general:
                btn_power.setVisibility(View.INVISIBLE);
                btn_root.setVisibility(View.INVISIBLE);
                btn_sin.setVisibility(View.INVISIBLE);
                myEdit.setHint("");
                myEdit.setText(null);

                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                break;
            case R.id.engineering:
                btn_power.setVisibility(View.VISIBLE);
                btn_root.setVisibility(View.VISIBLE);
                btn_sin.setVisibility(View.VISIBLE);
                myEdit.setHint("");
                myEdit.setText(null);

                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                break;
        }
        return true;
    }

    //=
    View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(!myEdit.getText().toString().equals("")) {
                //  Log.d("###", "onClick: "+operator);
                if(!first) {
                    num1 = result;
                    num2 = Double.parseDouble(myEdit.getText().toString());
                }
                calc(operator, num1, num2);
            }
        }
    };

    public void calc(String operator, double num1, double num2) {
        // 계산해서 결과 result에 넣어줌
        // 텍스트 창 초기화해줌
        if(operator.equals("")){
            return;
        }
        switch (operator){
            case "plus":
                    result = num1 + num2;
                    myEdit.setText(result + "");
                break;
            case "sub":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                //가산점 항목_2.오류처리_연산오류
                if (num2 == 0) {
                    Toast.makeText(MainActivity.this, "연산 오류", Toast.LENGTH_SHORT).show();
                    myEdit.setHint("");
                    myEdit.setText("");
                } else {
                    result = num1 / num2;
                }
                break;
            case "power":
                result = Math.pow(num1, num2);
                break;
            case "root":
                result = Math.sqrt(num1);
            case "sin":
                result = Math.sin(num1 * Math.PI / 180);
                break;
            default:
                //가산점 항목_2.오류처리_연산순서오류
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "연산 순서 오류", Toast.LENGTH_SHORT).show();
                    }
                });
        }
        this.operator = "";

    }

}