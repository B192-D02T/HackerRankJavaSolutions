import java.util.*;
import java.math.BigInteger; //büyük tamsayılar ve matematiksel işlemler için
import java.security.MessageDigest; //md5 algoritması için kullandık
import java.security.NoSuchAlgorithmException; //Algoritma bulunumazsa hata mesajı için
//Solved BY İbrahim Sağlam https://github.com/ibrahim354270
public class MD5 { // Solution adında bir sınıf tanımlanır

    public static void main(String[] args) {

        // Scanner sınıfı kullanılarak kullanıcıdan bir girdi dizesi alınır.
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        // String türünde bir output değişkeni tanımlanır. Bu değişken, sonuç olarak hesaplanan MD5 özetini içerecektir.
        String output = "";

        // try-catch bloğu kullanılarak istisnalar ele alınır. Bu durumda, NoSuchAlgorithmException ele alınır,
        // çünkü belirtilen algoritma mevcut değilse bir istisna oluşturulur.
        try{

            //  MessageDigest sınıfından bir örnek oluşturulur ve belirli bir özetleme algoritmasıyla başlatılır.
            //  Burada MD5 kullanılır.
            MessageDigest md = MessageDigest.getInstance("MD5");

            //  input dizesinin bayt olarak özetini hesaplamak için MessageDigest sınıfının digest yöntemi kullanılır.
            byte[] digest = md.digest(input.getBytes());

            //  BigInteger sınıfından bir örnek oluşturulur ve bu örnek, bir işaret biti ve baytlar dizisi
            //  kullanılarak başlatılır.
            BigInteger bigInteger = new BigInteger(1,digest);

            //bigInteger nesnesinin toString yöntemi kullanılarak özet dizesi elde edilir.
            // Bu dize 16'lık tabanda olacaktır.
            String hash = bigInteger.toString(16);

            //  Eğer elde edilen özet dizesi 32 karakterden kısa ise, başına sıfır eklenerek
            //  dize 32 karaktere tamamlanır.
            while(hash.length() < 32){
                hash = "0" + hash;
            }

            //- hash dizesi output değişkenine atanır.
            output = hash;

            //hesaplanan MD5 özetini konsola yazdırılır.
            System.out.println(output);
        }
        //Algoritmanın bulunamaması durumunda hata mesajı fırlatılır
        catch(NoSuchAlgorithmException ex){
            System.out.println(ex.getMessage());
        }
    }
}

/*
MD5 (Message-Digest algoritması 5), 128 bit karma değerine sahip, yaygın olarak kullanılan bir kriptografik karma işlevidir.
MD5'in bazı yaygın kullanımları şunlardır:
• Bir parolanın tek yönlü karmasını saklamak için.
• Aktarılan dosyanın sağlam bir şekilde ulaştığına dair bir miktar güvence sağlamak. MD5, MIT'den Profesör Ronald Rivest tarafından tasarlanan bir dizi mesaj özeti algoritmasından biridir (Rivest, 1994); ancak MD5'in güvenliği, en çok 2012'deki Flame kötü amaçlı yazılımı tarafından ciddi şekilde tehlikeye atıldı. CMU Yazılım Mühendisliği Enstitüsü, MD5'in "kriptografik olarak bozuk ve daha fazla kullanıma uygun olmadığını" düşünüyor. Bir parolayı ifade eden alfasayısal bir dize (s) verildiğinde, bunun MD5 şifreleme değerini hesaplayın ve yazdırın. Giriş Formatı s'yi ifade eden tek bir alfasayısal dize. Kısıtlamalar 6<= s <=20 • String s yalnızca İngilizce alfabetik harflerden (örn. [a – zA – Z] ve/veya ondalık rakamlardan (örn. 0'dan 9'a kadar) oluşur. • Çıkış biçimi • s'nin MD5 şifreleme değerini yeni bir satıra yazdırın. Örnek Giriş 0 Selam Dünya Örnek Çıkışı 0 68e109f0f40ca72a15e05cc22786f8e6
Örnek Giriş 1 Javarmi123 Örnek Çıkış 1 2da2d1e0ce7b4951a858ed2d547ef485

-Bu kod, kullanıcıdan bir girdi dizesi alır ve bu dizenin MD5 özetini hesaplar. Sonra bu özeti ekrana yazdırır."

 */