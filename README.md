# کاربرد عملی الگوهای طراحی شی گرا
دانشجویان: سایه جارالهی (۹۸۱۰۱۳۳۹) و یلدا شعبان زاده(۹۸۱۰۱۸۲۲)

در این تمرین هدف استفاده از دو دیزاین پترن برای پیاده سازی یک سیستم انتقال بسته بود. در ابتدا یک پکیج تعریف کردیم که در هر لحظه دارای یک استیت است و همچنین یک ویژگی برای مشخص شدن نوع ارسال دارد. استیت این بسته منظور ارسال شدن یا در ترانزیت بودن است. 

با استفاده از دیزاین پترن state مشخص میکنیم که در هر لحظه بسته از نظر ارسال در چه وضعیتی قرار دارد. 

همانطور که در کد زیر دیده می‌شود،‌یک لایه انتزاع برای استیت داریم که دو کلاس مربوط به دلیور شده و در حال ترانزیت آن راپیاده سازی میکنند. 


```java

public abstract class State {
    public abstract void printState();

}```

```java 
public class DeliveredState extends State{
    @Override
    public void printState() {
        System.out.println("The package is delivered!");
    }
}
```

```java
package code;

public class InTransitState extends State{
    @Override
    public void printState() {
        System.out.println("The package is still in the transit state");
    }
}
```

درواقع برای آنکه وضعیت مشخص شود، در هر لحظه در کلاس پکیج یکی از این دو کلاس یک نمونه دارند. همچنین با استفاده از دیزاین پترن strategy  میتوانیم وضعیت ارسال یک بسته را تغییر دهیم و هر نوع ارسال قیمت متفاوتی دارد که این دیزاین پترن آن را اعمال میکند. 

```java 
package code;

public abstract class Shipping {
    public abstract double getPrice(int weight);

    public abstract void print();
}
```
```java 
public class ExpressShipping extends Shipping{

    @Override
    public double getPrice(int weight) {
        return 3.5 * weight;
    }

    @Override
    public void print() {
        System.out.println("The method is express shipping!");
    }
}

```
```java
package code;

public class StandardShipping extends Shipping{


    @Override
    public double getPrice(int weight) {
        return 2.5* weight;
    }

    @Override
    public void print() {
        System.out.println("The method is Standard Shipping!");
    }
}

```
همانطور که در کدهای بالا دیده میشود، با استفاده از دیزاین پترن استراتژی کاری میکنیم که اگر در هر لحظه نوع ارسال تغییر کرد، نیازی به اعمال تغیر در فیلدها نباشد و تنها با داشتن یک آبجکت از کلاس shipping قیمت محاسبه شود. همچنین متنی که نمایش داده می‌شود نیز در هر کلاسی که از shipping ارث‌بری میکند جداگانه مشحص میشود. 


نکته قابل توجه آن است که در ابتدا بخش مربوط به تستها پیاده سازی شدند و پس از آنکه نوع عملکرد به کمک تست‌ها مشخص شد، به پیاده‌سازی بدنه اصلی کد پرداختیم که این مورد در کامیت ها قابل مشاهده است. 
