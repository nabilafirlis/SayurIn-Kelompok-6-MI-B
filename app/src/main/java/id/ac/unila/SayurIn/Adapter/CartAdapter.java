package id.ac.unila.SayurIn.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.ac.unila.SayurIn.Model.OrderModels;
import id.ac.unila.SayurIn.Model.Session;
import id.ac.unila.SayurIn.R;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    public List<OrderModels> data;
    LayoutInflater layoutInflater;
    Context c;
    Session session;

    public CartAdapter(){};

    public CartAdapter(Context c, List<OrderModels> data) {
        this.data = data;
        this.c = c;
        this.layoutInflater = LayoutInflater.from(this.c);
    }

    public void addCart(OrderModels cart, Context context){
        checkSesion(context);
        if (data == null){
            data = new ArrayList<>();
        }
        if (session.getCart().size() >0 ){
            data = session.getCart();
        }
        data.add(cart);
        session.addCart(data);
    }

    private void checkSesion(Context context){
        if (session == null){
            session = new Session(context);
        }
    }

    public void removeSession(Context context){
        checkSesion(context);
        if (data != null) {
            session.addCart(data);
        }
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_cart,parent,false);
        return new CartAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
//        final CartModels cartModels = data.get(position);
        OrderModels orderModels = data.get(position);
        final int sum = 0;

        holder.titleOrder.setText(orderModels.getgTitle());
        holder.imgOrder.setImageResource(orderModels.getgImg());
        holder.descOrder.setText(orderModels.getgDesc());
        holder.hargaOrder.setText(String.valueOf(orderModels.getgHarga()));
        holder.textOrder.setText(String.valueOf(orderModels.getJumlahPesan()));
        holder.totalOrderHarga.setText(String.valueOf(orderModels.getgHarga() * orderModels.getJumlahPesan() ));

    }

    @Override
    public int getItemCount() {
        return (data != null) ? data.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleOrder , descOrder , hargaOrder ,totalOrderHarga,textOrder;
        public ImageView imgOrder;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleOrder = itemView.findViewById(R.id.titleOrdered);
            imgOrder = itemView.findViewById(R.id.imageOrdered);
            descOrder = itemView.findViewById(R.id.descOrdered);
            hargaOrder = itemView.findViewById(R.id.hargaOrdered);
            textOrder = itemView.findViewById(R.id.textOrdered);
            totalOrderHarga = itemView.findViewById(R.id.totalOrderProc);
        }
    }
}
