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
        holder.tvHotelName.setText(model.getName());
        holder.tvHotelPrice.setText(model.getFormattedPrice());  // Uses formatted price
        holder.tvHotelRating.setText(model.getFormattedRating());  // Uses formatted rating

        holder.btnBookHotel.setOnClickListener(v -> {
            Intent intent = new Intent(context, BookingDetailsActivity.class);
            intent.putExtra("name", model.getName());
            intent.putExtra("price", model.getPrice());  // Still sends double value
            intent.putExtra("rating", model.getRating());  // Still sends float value
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvHotelName, tvHotelPrice, tvHotelRating;
        Button btnBookHotel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHotelName = itemView.findViewById(R.id.tv_hotel_name);
            tvHotelPrice = itemView.findViewById(R.id.tv_hotel_price);
            tvHotelRating = itemView.findViewById(R.id.tv_hotel_rating);
            btnBookHotel = itemView.findViewById(R.id.btn_book_hotel);
        }
    }
}
