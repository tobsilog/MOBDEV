package ph.edu.usc.monsalud_midterms;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyTripsAdapter extends RecyclerView.Adapter<MyTripsAdapter.ViewHolder> {
    private List<Trip> tripList;
    private Context context;

    public MyTripsAdapter(List<Trip> tripList, Context context) {
        this.tripList = tripList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trip, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Trip trip = tripList.get(position);

        holder.tvTripName.setText(trip.getName());
        holder.tvTripDate.setText("Date: " + trip.getDate());
        holder.tvTripStatus.setText("Status: " + trip.getStatus());

        holder.btnViewTrip.setOnClickListener(v -> {
            Intent intent = new Intent(context, TripDetailsActivity.class);
            intent.putExtra("tripName", trip.getName());
            intent.putExtra("tripDate", trip.getDate());
            intent.putExtra("tripStatus", trip.getStatus());
            intent.putExtra("tripType", trip.getType());
            context.startActivity(intent);
        });

        holder.btnCancelTrip.setOnClickListener(v -> {
            Toast.makeText(context, "Booking Canceled: " + trip.getName(), Toast.LENGTH_SHORT).show();
            tripList.remove(position);
            notifyItemRemoved(position);
        });
    }

    @Override
    public int getItemCount() {
        return tripList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTripName, tvTripDate, tvTripStatus;
        Button btnViewTrip, btnCancelTrip;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTripName = itemView.findViewById(R.id.tv_trip_name);
            tvTripDate = itemView.findViewById(R.id.tv_trip_date);
            tvTripStatus = itemView.findViewById(R.id.tv_trip_status);
            btnViewTrip = itemView.findViewById(R.id.btn_view_trip);
            btnCancelTrip = itemView.findViewById(R.id.btn_cancel_trip);
        }
    }
}

