package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvExpression, tvDisplay;
    private StringBuilder currentNumber = new StringBuilder();
    private Double firstNumber = null;
    private String currentOperator = null;
    private boolean isResultDisplayed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvExpression = findViewById(R.id.tvExpression);
        tvDisplay = findViewById(R.id.tvDisplay);

        // ثبت شنونده رویداد کلیک برای دکمه‌های عددی 0 تا 9
        findViewById(R.id.btn0).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);

        // ثبت شنونده رویداد کلیک برای عملگرهای اصلی
        findViewById(R.id.btnAdd).setOnClickListener(this);
        findViewById(R.id.btnSubtract).setOnClickListener(this);
        findViewById(R.id.btnMultiply).setOnClickListener(this);
        findViewById(R.id.btnDivide).setOnClickListener(this);

        // ثبت شنونده کلیک برای دکمه‌های کنترلی
        findViewById(R.id.btnEquals).setOnClickListener(this);
        findViewById(R.id.btnC).setOnClickListener(this);
        findViewById(R.id.btnDelete).setOnClickListener(this);
        findViewById(R.id.btnDot).setOnClickListener(this);
        findViewById(R.id.btnPercent).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        // بررسی کلیک روی دکمه‌های عددی ۰ تا ۹
        if (id == R.id.btn0 || id == R.id.btn1 || id == R.id.btn2 ||
            id == R.id.btn3 || id == R.id.btn4 || id == R.id.btn5 ||
            id == R.id.btn6 || id == R.id.btn7 || id == R.id.btn8 || id == R.id.btn9) {
            
            Button b = (Button) v;
            onDigitClick(b.getText().toString());
            return;
        }

        // نقطه اعشار
        if (id == R.id.btnDot) {
            onDotClick();
            return;
        }

        // چهار عمل اصلی
        if (id == R.id.btnAdd) {
            onOperatorClick("+");
        } else if (id == R.id.btnSubtract) {
            onOperatorClick("-");
        } else if (id == R.id.btnMultiply) {
            onOperatorClick("×");
        } else if (id == R.id.btnDivide) {
            onOperatorClick("÷");
        } 
        // دکمه مساوی
        else if (id == R.id.btnEquals) {
            onEqualsClick();
        } 
        // دکمه ریست کامل (C)
        else if (id == R.id.btnC) {
            onClearClick();
        } 
        // دکمه پاک کردن آخرین رقم (Backspace)
        else if (id == R.id.btnDelete) {
            onDeleteClick();
        } 
        // دکمه درصد (%)
        else if (id == R.id.btnPercent) {
            onPercentClick();
        }
    }

    // افزودن رقم به عدد فعلی
    private void onDigitClick(String digit) {
        if (isResultDisplayed) {
            currentNumber.setLength(0);
            isResultDisplayed = false;
        }

        // جلوگیری از تایپ چند صفر پشت سر هم در ابتدای عدد
        if (currentNumber.toString().equals("0")) {
            currentNumber.setLength(0);
        }

        currentNumber.append(digit);
        tvDisplay.setText(currentNumber.toString());
    }

    // افزودن ممیز اعشار
    private void onDotClick() {
        if (isResultDisplayed) {
            currentNumber.setLength(0);
            currentNumber.append("0");
            isResultDisplayed = false;
        }

        if (currentNumber.length() == 0) {
            currentNumber.append("0.");
        } else if (!currentNumber.toString().contains(".")) {
            currentNumber.append(".");
        }
        tvDisplay.setText(currentNumber.toString());
    }

    // انتخاب یکی از ۴ عمل اصلی
    private void onOperatorClick(String op) {
        if (currentNumber.length() > 0) {
            if (firstNumber != null && currentOperator != null) {
                // اگر کاربر بدون زدن مساوی عملگر بعدی را زد، محاسبه قبلی انجام شود
                calculateIntermediate();
            } else {
                firstNumber = Double.parseDouble(currentNumber.toString());
            }
            currentOperator = op;
            tvExpression.setText(formatResult(firstNumber) + " " + currentOperator);
            currentNumber.setLength(0);
        } else if (firstNumber != null) {
            // تغییر عملگر در صورتی که عددی تایپ نشده باشد
            currentOperator = op;
            tvExpression.setText(formatResult(firstNumber) + " " + currentOperator);
        }
    }

    // محاسبه نتیجه نهایی با دکمه مساوی
    private void onEqualsClick() {
        if (firstNumber == null || currentOperator == null || currentNumber.length() == 0) {
            return;
        }

        double secondNumber = Double.parseDouble(currentNumber.toString());
        double result = 0;

        switch (currentOperator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "×":
                result = firstNumber * secondNumber;
                break;
            case "÷":
                if (secondNumber == 0) {
                    Toast.makeText(this, "خطا: تقسیم بر صفر امکان‌پذیر نیست!", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = firstNumber / secondNumber;
                break;
        }

        tvExpression.setText(formatResult(firstNumber) + " " + currentOperator + " " + formatResult(secondNumber) + " =");
        tvDisplay.setText(formatResult(result));

        // ذخیره نتیجه به عنوان عدد اول برای محاسبات بعدی
        firstNumber = result;
        currentNumber.setLength(0);
        currentNumber.append(formatResult(result));
        currentOperator = null;
        isResultDisplayed = true;
    }

    // محاسبه میانی هنگام زدن متوالی عملگرها
    private void calculateIntermediate() {
        double secondNumber = Double.parseDouble(currentNumber.toString());
        switch (currentOperator) {
            case "+": firstNumber = firstNumber + secondNumber; break;
            case "-": firstNumber = firstNumber - secondNumber; break;
            case "×": firstNumber = firstNumber * secondNumber; break;
            case "÷":
                if (secondNumber != 0) {
                    firstNumber = firstNumber / secondNumber;
                }
                break;
        }
    }

    // پاک‌کردن یک کاراکتر (⌫)
    private void onDeleteClick() {
        if (currentNumber.length() > 0) {
            currentNumber.deleteCharAt(currentNumber.length() - 1);
            if (currentNumber.length() == 0) {
                tvDisplay.setText("0");
            } else {
                tvDisplay.setText(currentNumber.toString());
            }
        }
    }

    // محاسبه درصد (%)
    private void onPercentClick() {
        if (currentNumber.length() > 0) {
            double val = Double.parseDouble(currentNumber.toString()) / 100.0;
            currentNumber.setLength(0);
            currentNumber.append(formatResult(val));
            tvDisplay.setText(currentNumber.toString());
        }
    }

    // ریست کامل ماشین‌حساب (C)
    private void onClearClick() {
        currentNumber.setLength(0);
        firstNumber = null;
        currentOperator = null;
        isResultDisplayed = false;
        tvExpression.setText("");
        tvDisplay.setText("0");
    }

    // فرمت‌بندی نتیجه (حذف .0 در اعداد صحیح)
    private String formatResult(double value) {
        if (value == (long) value) {
            return String.format("%d", (long) value);
        } else {
            return String.valueOf(value);
        }
    }
}
