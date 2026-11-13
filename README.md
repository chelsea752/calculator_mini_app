# 📱 Simple Calculator Android App (Java)
یک اپلیکیشن ماشین‌حساب ساده، استاندارد و کاربردی توسعه داده شده با زبان **جاوا (Java)** در محیط **Android Studio** با چهار عمل اصلی ریاضی.

---

## ✨ ویژگی‌ها (Features)
- ➕ **جمع (+)**: محاسبه مجموع دو عدد
- ➖ **تفریق (-)**: کسر عدد دوم از عدد اول
- ✖️ **ضرب (×)**: ضرب دو عدد اعشاری یا صحیح
- ➗ **تقسیم (÷)**: محاسبه حاصل تقسیم با کنترل خطای تقسیم بر صفر
- 🛡️ **اعتبارسنجی ورودی‌ها**: جلوگیری از کرش برنامه هنگام خالی بودن فیلدها یا ورود مقادیر نامعتبر
- 🧹 **دکمه پاک‌کردن (Clear)**: پاک‌سازی سریع فیلدها و بازگشت به حالت اولیه
- 🎨 **رابط کاربری مدرن**: طراحی با متریال دیزاین و سازگار با انواع اندازه‌های صفحه نمایش

---

## 🛠️ مشخصات فنی (Tech Stack)
- **Language:** Java (JDK 8+)
- **Platform:** Android
- **Min SDK:** 21 (Android 5.0 Lollipop)
- **Target SDK:** 34 (Android 14)
- **Architecture:** Android View System (XML + Java Activity)

---

## 📂 ساختار پروژه (Project Structure)
```
SimpleCalculator/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/simplecalculator/
│   │       │   └── MainActivity.java       # منطق اصلی برنامه
│   │       ├── res/
│   │       │   ├── layout/activity_main.xml # رابط کاربری برنامه
│   │       │   └── values/                  # رشته‌ها، رنگ‌ها و استایل‌ها
│   │       └── AndroidManifest.xml
│   └── build.gradle
├── gradle/
├── build.gradle
├── settings.gradle
└── README.md
```

---

## 🚀 نحوه اجرا در Android Studio
1. این مخزن را کلون کنید:
   ```bash
   git clone https://github.com/chelsea752/calculator_mini_app.git
   ```
2. نرم‌افزار **Android Studio** را باز کنید و گزینه **Open** را انتخاب نمایید.
3. پوشه پروژه را انتخاب کنید و منتظر بمانید تا فرایند **Gradle Sync** انجام شود.
4. پروژه را روی یک شبیه‌ساز (Emulator) یا گوشی واقعی با فشردن کلید **Run (Shift + F10)** اجرا کنید.

---

## 📄 مجوز (License)
این پروژه تحت مجوز [MIT](LICENSE) منتشر شده است.
