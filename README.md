# 📱 Modern Keypad Calculator Android App (Java)
یک اپلیکیشن ماشین‌حساب مدرن و کامل توسعه داده شده با زبان **جاوا (Java)** در محیط **Android Studio**، طراحی‌شده بر اساس استانداردهای روز رابط کاربری (Material Design) و چیدمان صفحه کلید کامل عددی ۰ تا ۹.

---

## ✨ امکانات و قابلیت‌ها (Features)
- 🔢 **صفحه کلید کامل عددی (Keypad 0-9)**: چیدمان حرفه‌ای ماتریسی ارقام ۰ تا ۹ با ممیز اعشار (`.`)
- ➕ ➖ ✖️ ➗ **چهار عمل اصلی ریاضی**: انجام جمع، تفریق، ضرب و تقسیم
- 🧮 **محاسبات پیوسته (Chained Operations)**: امکان ادامه محاسبات متوالی بدون نیاز به زدن مساوی در هر مرحله
- 📊 **محاسبه درصد (%)**: محاسبه سریع درصد مقادیر
- ⌫ **کلید حذف رقم آخر (Backspace)**: اصلاح سریع ورودی بدون پاک شدن کل عبارت
- 🧹 **ریست کامل (Clear - C)**: پاک‌سازی تمام ورودی‌ها و بازنشانی متغیرها
- 🛡️ **جلوگیری از خطای تقسیم بر صفر**: مدیریت هوشمند خطای ریاضی با پیام Toast
- 🎨 **رابط کاربری تیره مدرن (Dark UI)**: طراحی جذاب و ارگونومیک سازگار با تمامی اندازه‌های صفحه
- 📖 **[پوشه مستندات و آنالیز کدهای پروژه (انالیز)](./انالیز/README.md)**: تحلیل خط‌به‌خط فنی، ماشین وضعیت و معماری برنامه

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
calculator_mini_app/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/simplecalculator/
│   │       │   └── MainActivity.java       # منطق اصلی، رویدادها و ماشین وضعیت
│   │       ├── res/
│   │       │   ├── layout/activity_main.xml # رابط کاربری کی‌پد و نمایشگر
│   │       │   └── values/                  # استایل‌ها، رنگ‌ها و رشته‌ها
│   │       └── AndroidManifest.xml
│   └── build.gradle
├── انالیز/
│   └── README.md                            # مستندات و آنالیز کامل فنی و خط‌به‌خط
├── gradle/
├── build.gradle
├── settings.gradle
├── README.md
└── LICENSE
```

---

## 🚀 نحوه کلون و اجرا در Android Studio
1. ریپازیتوری را کلون کنید:
   ```bash
   git clone https://github.com/chelsea752/calculator_mini_app.git
   ```
2. نرم‌افزار **Android Studio** را باز کنید و گزینه **Open** را انتخاب نمایید.
3. پوشه پروژه را انتخاب کنید تا بیلد و دانلود نیازمندی‌های **Gradle** انجام شود.
4. پروژه را روی یک شبیه‌ساز (Emulator) یا گوشی واقعی با فشردن کلید **Run (Shift + F10)** اجرا نمایید.

---

## 📄 مجوز (License)
این پروژه تحت مجوز [MIT](LICENSE) منتشر شده است.
