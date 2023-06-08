package adamasmaca;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AdamAsmacaOyunu {
    /*
        Kelime Tahmin Oyunu
        Kullanıcının bir kelimeyi harf harf tahmin ederek doğru kelimeyi bulmasını sağlayan bir oyun geliştirin.
        Oyun şu adımları içermelidir:

        - Bir kelime listesi tanımlayın. Bu listede en az 5 farklı kelime bulunsun.
        - Oyuncu, listeden rastgele seçilen bir kelimeyi tahmin etmeye çalışmalıdır.
        - Oyuncuya, seçilen kelimenin uzunluğu kadar alt tire "_" işaretinden  oluşan bir dizi gösterilmelidir.
          Örneğin, seçilen kelime "elma" ise "____" şeklinde bir gösterim yapılmalıdır.
        - Oyuncu, her tahmininde bir harf girmelidir.
            - Girdiği harf, seçilen kelimede bulunuyorsa, doğru tahmin olduğu belirtilmeli ve
              ilgili harf yerine konulmalıdır. ve oyuncuya kelimeyi tahmin etmek isteyip istemediği
              sorulmalıdır.
            - Oyuncu, yanlış tahminlerde bulunduğunda, kalan hakkı azalmalıdır. ve oyuncuya bir ipucu verilmelidir.
              Başlangıçta oyuncunun 5 hakka sahip olduğu varsayılmalıdır.
        - Oyuncunun doğru kelimeyi bulması durumunda, tebrik mesajı gösterilmeli ve oyun sonlandırılmalıdır.
        - Oyuncunun kalan hakları sıfır olduğunda, olumsuz bir mesaj ve doğru kelime gösterilmelidir.
        */

    static int can=5;

    public static String rastgeleSec () {
        List<String> fruits = List.of("elma","armut","kiraz","mango","karpuz","kavun","vişne","erik");
        Random rastgele = new Random();
        int rastgeleIndex = rastgele.nextInt(fruits.size());
        String rastgeleEleman = fruits.get(rastgeleIndex);
        return rastgeleEleman;
    }


    public static void adamAsmaca ( ) {

        ArrayList<String> bos = new ArrayList<>();
        for (int i = 0; i <rastgeleSec().length(); i++) {
            bos.add("_");
        }
        System.out.println(bos);

        System.out.println("Lütfen bir harf tahmin ediniz:)");
        Scanner scan = new Scanner(System.in);
        do {

            String tahmin = scan.next().toLowerCase().substring(0,1);

            if (rastgeleSec().contains(tahmin)){
                System.out.println("Doğru tahmin!");
                bos.set(rastgeleSec().indexOf(tahmin),tahmin);
                System.out.println(bos);
                String sonuc= String.join("",bos);
                if (sonuc.equals(rastgeleSec())){
                    System.out.println("Tebrikler!!! Oyunu kazandınız!");
                    break;
                }
            } else {
                can--;
                System.out.println("Yanlış tahmin! " + can + " hakkınız kaldı.");
            }

        }while (can>0);

        if (can==0) {
            System.out.println("Oyunu kaybettiniz! Üzgünüz :( Cevap = "+ rastgeleSec());

        }

    }



}
