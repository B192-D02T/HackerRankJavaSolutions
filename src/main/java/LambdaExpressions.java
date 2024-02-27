import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
////Solved By Betül Kuyucu  https://github.com/Betulk96
/*

Bu Java 8 meydan okuması, Lambda ifadeleri konusundaki bilginizi test ediyor!

Belirli bir eylemi gerçekleştiren bir lambda ifadesi döndüren aşağıdaki yöntemleri yazın:

PerformOperation isOdd(): Lambda ifadesi, bir sayı tek ise 1'i, çift ise 0'ı döndürmelidir.
PerformOperation isPrime(): Lambda ifadesi, bir sayı asal ise 1'i, değilse 0'ı döndürmelidir.
PerformOperation isPalindrome(): Lambda ifadesi, bir sayı palindrom ise 1'i, değilse 0'ı döndürmelidir.
 */
/*
    isOdd(), isPrime() veya isPalindrome() metotlarının döndürdüğü lambda ifadelerini alarak,
     belirli bir sayının teklik, asallık veya palindrom olup olmadığını kontrol eder.
     */
interface PerformOperation {// check methodu ekledik
    boolean check(int a);
}

class MyMath {

    public static boolean checker(PerformOperation p, int num) {
        // bir tamsayı alır ve bu tamsayının belirli bir koşulu sağlayıp sağlamadığını kontrol eder.
        return p.check(num);
    }

    public static PerformOperation isOdd() {//tek mi
        return n -> n % 2 == 1;
    }

    public static PerformOperation isPrime() {//asal
        return n -> {
            boolean result = true;
            //eğer 2'den küçükse asal değildir direk false dön
            if (n < 2) return false;
            for (int i = 2; i < n; i++) {
                //eğer i değerine bölünürse asal olmaz ,false dönsün
                if (n % i == 0) result = false;
                break;

            }

            return result;
        };
    }

    public static PerformOperation isPalindrome() {//123321
        return n -> {
            int remainder;
            int reversedNum = 0;
            int originalNum = n;
            while (n != 0) {
                remainder = n % 10;
                reversedNum = reversedNum * 10 + remainder;
                n /= 10;
            }

            if (originalNum == reversedNum) {
                return true;
            } else {
                return false;
            }
        };
    }
}

public class LambdaExpressions {

    public static void main(String[] args) throws IOException {


        MyMath math = new MyMath();
        /*
        standart giriş akışından gelen verileri okumak için bir BufferedReader oluşturur ve bu giriş akışından bir satır okur. Daha sonra, okunan satırı bir tamsayıya (int) dönüştürür.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//sanner gibi kullancıdan değer almak için
        int T = Integer.parseInt(br.readLine());//bir satır okur ve bu satırı bir String olarak döndürür.buffer rea

        PerformOperation op;
        boolean ret = false;
        String ans = null;

        while (T-- > 0) {

            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);

            int ch = Integer.parseInt(st.nextToken());//giriş dizesindeki sıradaki parçayı verir.
            int num = Integer.parseInt(st.nextToken());

            if (ch == 1) {//ilk değer
                op = math.isOdd();
                ret = math.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {//ikinci değer
                op = math.isPrime();
                ret = math.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {//3.değer
                op = math.isPalindrome();
                ret = math.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}

/*

BufferedReader ve Scanner ikisi de kullanıcıdan girdi almak için Java'da kullanılan sınıflardır, ancak aralarında bazı farklar vardır:

Performans:

BufferedReader, InputStreamReader üzerine bir tampon ekleyerek verimli bir şekilde karakter tabanlı giriş akışını işler. Bu nedenle, büyük miktarlarda veri okurken daha hızlı olabilir.
Scanner ise daha yavaş olabilir çünkü karmaşık bir yapıya sahiptir ve girdiyi analiz etmek için daha fazla işlem yapar.
Giriş Biçimi:

BufferedReader, karakter tabanlı giriş akışlarını okumak için kullanılır ve readLine() metodu aracılığıyla bir satır okur. Bu nedenle, genellikle metin tabanlı verilerle çalışmak için tercih edilir.
Scanner, hem karakter tabanlı hem de belirli veri türlerini doğrudan okumak için kullanılabilir. Örneğin, nextInt(), nextDouble() gibi metotlar aracılığıyla tamsayılar, ondalık sayılar vb. okunabilir.
Kullanım Kolaylığı:

Scanner, genellikle kullanımı daha basit olduğu için tercih edilir. Özellikle farklı veri türlerini kolayca okumak için kullanışlıdır.
BufferedReader, readLine() metoduyla gelen satırı işlemek biraz daha karmaşıktır, çünkü bu metot bir dize döndürür ve gerekirse dönüşümler yapmanız gerekir.
Hata İşleme:

BufferedReader, genellikle IOException gibi istisnaları yakalamak için try-catch bloklarıyla kullanılır.
Scanner, girdi beklerken hata oluşursa genellikle InputMismatchException gibi belirli istisnaları fırlatır.
 */
