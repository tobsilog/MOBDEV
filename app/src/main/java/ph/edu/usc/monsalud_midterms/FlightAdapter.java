package ph.edu.usc.monsalud_midterms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FlightAdapter extends RecyclerView.Adapter<FlightAdapter.FlightViewHolder> {

    private List<Flight> flightList;
    private OnItemClickListener onItemClickListener;

    // Constructor
    public FlightAdapter(List<Flight> flightList) {
        this.flightList = flightList;
    }

    @Override
    public FlightViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.flight_item, parent, false);
        return new FlightViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FlightViewHolder holder, int position) {
        Flight flight = flightList.get(position);
        holder.textViewAirline.setText(flight.getAirlineName());
        holder.textViewFlightNumber.setText(flight.getFlightNumber());
        holder.textViewDepartureTime.setText(flight.getDepartureTime());
        holder.textViewArrivalTime.setText(flight.getArrivalTime());
        holder.textViewPrice.setText(String.valueOf(flight.getPrice()));

        // Set the "Book Flight" button listener
        holder.buttonBookFlight.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return flightList.size();
    }

    // ViewHolder class to hold the views
    public static class FlightViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewAirline, textViewFlightNumber, textViewDepartureTime, textViewArrivalTime, textViewPrice;
        public Button buttonBookFlight;

        public FlightViewHolder(View view) {
            super(view);
            textViewAirline = view.findViewById(R.id.textViewAirlineName);
            textViewFlightNumber = view.findViewById(R.id.textViewFlightNumber);
            textViewDepartureTime = view.findViewById(R.id.textViewDepartureTime);
            textViewArrivalTime = view.findViewById(R.id.textViewArrivalTime);
            textViewPrice = view.findViewById(R.id.textViewPrice);
            buttonBookFlight = view.findViewById(R.id.buttonBookFlight);
        }
    }

    // Interface for handling clicks
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    // Method to set the click listener
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
