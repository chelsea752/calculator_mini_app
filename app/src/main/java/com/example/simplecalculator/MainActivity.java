package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etFirstNumber, etSecondNumber;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnClear;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // اتصال متغیرها به کامپوننت‌های رابط کاربری
        etFirstNumber = findViewById(R.id.etFirstNumber);
        etSecondNumber = findViewById(R.id.etSecondNumber);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnClear = findViewById(R.id.btnClear);
        tvResult = findViewById(R.id.tvResult);

        // رویداد کلیک برای دکمه جمع
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        // رویداد کلیک برای دکمه تفریق
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        // رویداد کلیک برای دکمه ضرب
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        // رویداد کلیک برای دکمه تقسیم
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });

        // دکمه پاک‌کردن فیلدها و ریست نتیجه
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etFirstNumber.setText("");
                etSecondNumber.setText("");
                tvResult.setText("نتیجه: 0");
                etFirstNumber.requestFocus();
            }
        });
    }

    // متد محاسبه ریاضی با بررسی خطاها
    private void calculate(char operation) {
        String input1 = etFirstNumber.getText().toString().trim();
        String input2 = etSecondNumber.getText().toString().trim();

        // بررسی خالی نبودن ورودی‌ها
        if (input1.isEmpty() || input2.isEmpty()) {
            Toast.makeText(this, "لطفاً هر دو عدد را وارد کنید", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double num1 = Double.parseDouble(input1);
            double num2 = Double.parseDouble(input2);
            double result = 0;

            switch (operation) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        Toast.makeText(this, "خطا: تقسیم بر صفر امکان‌پذیر نیست!", Toast.LENGTH_LONG).show();
                        return;
                    }
                    result = num1 / num2;
                    break;
            }

            // نمایش نتیجه به صورت تمیز (اگر عدد صحیح بود، اعشار اضافی .0 نشان داده نشود)
            if (result == (long) result) {
                tvResult.setText(String.format("نتیجه: %d", (long) result));
            } else {
                tvResult.setText(String.format("نتیجه: %s", result));
            }

        } catch (NumberFormatException e) {
            Toast.makeText(this, "فرمت اعداد نامعتبر است", Toast.LENGTH_SHORT).show();
        }
    }
}
