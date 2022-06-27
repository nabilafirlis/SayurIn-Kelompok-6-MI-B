package id.ac.unila.SayurIn.Model;

import java.util.ArrayList;
import java.util.List;

public class CartModels {
    public String title;
    public int harga;
    public  int totalOrder;
    public int jumlahPesanan, image;
    public String desc;
    private List<CartModels> cartModels;

    public CartModels(String title, int harga, int totalOrder, int jumlahPesanan, int image, String desc) {
        this.title = title;
        this.harga = harga;
        this.totalOrder = totalOrder;
        this.jumlahPesanan = jumlahPesanan;
        this.image = image;
        this.desc = desc;
        this.cartModels = new ArrayList<CartModels>();
    }
    
