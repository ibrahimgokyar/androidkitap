package com.msb.fragmentornek;

/*Transfering isimli bir arayüz oluşturduk. Bu arayüz ile fragment bileşenleri arasında veri
transferi yapabiliriz. Bu arayüzü MainActivity isimli sınıfa implements anahtar kelimesi
ile uyguladığınız zaman sistem sizden aşağıda verilen metodu eklemenizi ister.
Arayüzler interface anahtar kelimesi ile oluşturulur.*/
public interface Transfering {
	 void dataTransfer(String text);
}
