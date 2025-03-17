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

public class BusTrainAdapter extends RecyclerView.Adapter<BusTrainAdapter.ViewHolder> {
    private List<BusTrainModel> list;
    private Context context;

    public BusTrainAdapter(List<BusTrainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bus_train, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BusTrainModel model = list.get(position);
        holder.tvName.setText(model.getName());
        holder.tvRoute.setText(model.getDepartureCity() + " - " + model.getArrivalCity());
        holder.tvDate.setText("Date: " + model.getTravelDate());
        holder.tvPrice.setText("Price: " + model.getPrice());

        holder.btnBook.setOnClickListener(v -> {
            Intent intent = new Intent(context, BookingDetailsActivity.class);
            intent.putExtra("name", model.getName());
            intent.putExtra("route", model.getDepartureCity() + " - " + model.getArrivalCity());
            intent.putExtra("date", model.getTravelDate());
            intent.putExtra("price", model.getPrice());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvRoute, tvDate, tvPrice;
        Button btnBook;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_bus_train_name);
            tvRoute = itemView.findViewById(R.id.tv_bus_train_route);
            tvDate = itemView.findViewById(R.id.tv_bus_train_date);
            tvPrice = itemView.findViewById(R.id.tv_bus_train_price);
            btnBook = itemView.findViewById(R.id.btn_book_bus_train);
        }
    }
}


