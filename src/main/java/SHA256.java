import java.io.*;
import java.util.*;
import java.security.*;
import java.nio.charset.*;

//Solved By Muhammet Ali Yılmaz
public class SHA256 {
    public static void main(String[] args) {


      /*
      verilen bir metnin SHA-256 hash değerini hesaplamayı ve sonucu adım adım açıklamayı istiyor.
      İlk olarak, verilen metni SHA-256 algoritması kullanarak hashlememiz gerekecek.

       1- Metni SHA-256 Algoritmasıyla Hashleme:
            Verilen metni SHA-256 algoritması kullanarak hashlememiz gerekiyor. Bu işlem, belirli bir algoritmaya göre metnin özetini oluşturur.
       2- Hash Değerini Biçimlendirme:

        SHA-256 algoritması bir hexadecimal değer üretir. Bu değeri uygun bir formata dönüştürmemiz gerekiyor. Örneğin, 32 karakterlik bir hexadecimal sayıdır.
       3-Sonucu Gösterme:

        Elde edilen hash değerini belirtilen formatta yazdırmamız gerekiyor.
         */


        Scanner sc = new Scanner(System.in);
        String originalString = sc.nextLine();

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(
                    originalString.getBytes(StandardCharsets.UTF_8));
            System.out.println(bytesToHex(encodedhash));
        }
        catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}