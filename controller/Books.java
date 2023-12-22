package application;

public class Books {
	
  String kitapAdi;
  String yazarAdi;
  int sayfaSayisi;
  String turu;

    public Books(String kitapAdi, String yazarAdi, int sayfaSayisi, String turu) {
	  super();
	  this.kitapAdi = kitapAdi;
	  this.yazarAdi = yazarAdi;
	  this.sayfaSayisi = sayfaSayisi;
	  this.turu = turu;
     }

	public String getKitapAdi() {
		return kitapAdi;
	}

	public void setKitapAdi(String kitapAdi) {
		this.kitapAdi = kitapAdi;
	}

	public String getYazarAdi() {
		return yazarAdi;
	}

	public void setYazarAdi(String yazarAdi) {
		this.yazarAdi = yazarAdi;
	}

	public int getSayfaSayisi() {
		return sayfaSayisi;
	}

	public void setSayfaSayisi(int sayfaSayisi) {
		this.sayfaSayisi = sayfaSayisi;
	}

	public String getTuru() {
		return turu;
	}

	public void setTuru(String turu) {
		this.turu = turu;
	}
     

}
