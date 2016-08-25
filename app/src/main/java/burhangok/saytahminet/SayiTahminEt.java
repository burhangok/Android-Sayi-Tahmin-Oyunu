package burhangok.saytahminet;

/*
    Android Sayı Tahmin Etme Oyunu

    Bu proje yeni başlayanlar için geliştirilmiş olup MIT Open Source GNU License dahilindedir.

    Sorularınız ve görüşleriniz için burhangok@yahoo.com adresine mail atabilirsiniz.

    Burhan GÖK

 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SayiTahminEt extends AppCompatActivity {

    // Global degiskenlerimizi olusturuyoruz.
    Button tahminEt, yenidenOyna;
    EditText gelenSayi;
    public int rastgeleSayi;
    public int girilenSayi;


    /*
        onCreate metodu activity yani uygulama ilk acildiginda calisacak metodumuz.
        activity_sayi_tahmin_et layoutunda olusturdugumuz nesneleri burdaki degiskenlerimize
        tanıtıyoruz. Daha sonra bu degiskenlerimiz sayesinde kullanici ile etkilesim halinde olacagiz.
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayi_tahmin_et);

        // Layouttan id ye gore nesnelerimizin atama islemlerini yapiyoruz.
        tahminEt = (Button) findViewById(R.id.tahminEt);
        yenidenOyna = (Button) findViewById(R.id.yenidenOyna);
        gelenSayi = (EditText) findViewById(R.id.yazi);

        // Math sınıfının Random methodunu kullanarak 1-100 arasi rastgele sayi olusturuyoruz.
        rastgeleSayi = (int) (((Math.random()) * 100) + 1);

        /*
           Yerlesimde olusturdugumuz butona yani burdaki adiyla dugme degiskenimize tiklanildiginda
           yani click olayinda calismasini istedigimiz kodlari buraya yaziyoruz. Burada "click" olayi degilde
           baska bir event de kullanabilirsiniz.
                */
        tahminEt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)

            {

                /*
                    Edit Text ' e girilen degeri toString() ile string olarak alip
                    rastgeleSayi ile karsilastirmak icin Integer sınıfının parseInt() metodu ile
                    integer'a donusturuyoruz.
                */
                girilenSayi = Integer.parseInt(gelenSayi.getText().toString());

                // girlenSayi ile rastgeleSayi karsilastirilip sonucu kullaniciya
                // Toast widgeti ile altta cikan bir mesaj ile gosteriliyor.

                if (girilenSayi > rastgeleSayi) {
                    Toast.makeText(SayiTahminEt.this, "Daha Küçük Sayı Gir", Toast.LENGTH_SHORT).show();
                } else if (girilenSayi < rastgeleSayi) {
                    Toast.makeText(SayiTahminEt.this, "Daha Büyük Sayı Gir", Toast.LENGTH_SHORT).show();
                } else if (girilenSayi == rastgeleSayi) {
                    Toast.makeText(SayiTahminEt.this, "Tebrikler Sayiyi Buldun !  Sayı : " + rastgeleSayi, Toast.LENGTH_SHORT).show();

                }

            }
        });

        // Kullanici yenidenOyna id li butona tikladiginda metodumuz yeni bir rastgele sayi
        // olusuturup kullanicinin yeni oyun oynamasini sagliyor.
        yenidenOyna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Yeniden 1-100 arasi rastgele bir sayi olusturuyoruz.
                rastgeleSayi = (int) (((Math.random()) * 100) + 1);

                // Kullaniciya oyunun yeniden basladigini iletiyoruz.
                Toast.makeText(SayiTahminEt.this, "Oyun Yeniden Başladı !", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
