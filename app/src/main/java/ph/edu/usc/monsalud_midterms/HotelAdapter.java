package ph.edu.usc.monsalud_midterms;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import ph.edu.usc.monsalud_midterms.BookingDetailsActivity;
import ph.edu.usc.monsalud_midterms.HotelModel;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder> {
    private List<HotelModel> list;
    private Context context;

    public HotelAdapter(List<HotelModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hotel, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HotelModel model = list.get(position);
        holder.tvName.setText(model.getName());
        holder.tvPrice.setText("Price: " + model.getPrice());
        holder.tvRating.setText("Rating: " + model.getRating());

        holder.btnBook.setOnClickListener(v -> {
            Intent intent = new Intent(context, BookingDetailsActivity.class);
            intent.putExtra("name", model.getName());
            intent.putExtra("price", model.getPrice());
            intent.putExtra("rating", model.getRating());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPrice, tvRating;
        Button btnBook;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvRating = itemView.findViewById(R.id.tv_rating);
            btnBook = itemView.findViewById(R.id.btn_book);
        }
    }
}
