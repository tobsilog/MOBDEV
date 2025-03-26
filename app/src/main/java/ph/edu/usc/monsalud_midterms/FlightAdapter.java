package ph.edu.usc.monsalud_midterms;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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

        // 🔥 Ensure all TextViews are updated correctly
        holder.textViewDepartureCity.setText(flight.getDepartureCity());
        holder.textViewArrivalCity.setText(flight.getArrivalCity());
        holder.textViewDepartureTime.setText(flight.getDepartureTime());
        holder.textViewArrivalTime.setText(flight.getArrivalTime());
        holder.textViewDuration.setText(flight.getFlightDuration());
        holder.textViewPassengerName.setText(flight.getPassengerName());
        holder.textViewFlightNumber.setText(flight.getFlightNumber());
        holder.textViewSeatNumber.setText(flight.getSelectedSeat());
        holder.textViewAirlineName.setText(flight.getAirlineName());
        holder.textViewPrice.setText("$" + flight.getPrice());

        holder.buttonBookFlight.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), FlightDetails.class);
            intent.putExtra("flight", flight); // Pass the selected flight object
            v.getContext().startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return flightList.size();
    }

    // ViewHolder class to hold the views
    public static class FlightViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewAirlineName, textViewSeatNumber, textViewPassengerName, textViewDuration, textViewArrivalCity, textViewDepartureCity,textViewAirline, textViewFlightNumber, textViewDepartureTime, textViewArrivalTime, textViewPrice;
        public Button buttonBookFlight;

        public FlightViewHolder(View view) {
            super(view);

            // Map XML Views to Java Variables
            textViewDepartureCity = view.findViewById(R.id.textViewDepartureCity);
            textViewArrivalCity = view.findViewById(R.id.textViewArrivalCity);
            textViewDepartureTime = view.findViewById(R.id.textViewDepartureTime);
            textViewArrivalTime = view.findViewById(R.id.textViewArrivalTime);
            textViewDuration = view.findViewById(R.id.textViewDuration);
            textViewPassengerName = view.findViewById(R.id.textViewPassengerName);
            textViewFlightNumber = view.findViewById(R.id.textViewFlightNumber);
            textViewSeatNumber = view.findViewById(R.id.textViewSeatNumber);
            textViewAirlineName = view.findViewById(R.id.textViewAirlineName);
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
