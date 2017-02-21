package sg.edu.nus.clubmanagement.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import sg.edu.nus.clubmanagement.R;
import sg.edu.nus.clubmanagement.activity.AddBookingActivity;
import sg.edu.nus.clubmanagement.adapter.BookingListAdapter;

public class BookingFragment extends Fragment {
  private TextView tvEmpty;
  private BookingListAdapter bookingListAdapter;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment

    View fragmentView = inflater.inflate(R.layout.fragment_booking, container, false);

    ListView bookingList = (ListView) fragmentView.findViewById(R.id.lv_booking_list);
    tvEmpty = (TextView) fragmentView.findViewById(R.id.tv_empty_value);
    bookingListAdapter = new BookingListAdapter(getActivity());
    bookingList.setAdapter(bookingListAdapter);

    FloatingActionButton floatingActionButton =
        (FloatingActionButton) fragmentView.findViewById(R.id.fab);

    floatingActionButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        getActivity().startActivity(new Intent(getActivity(), AddBookingActivity.class));
      }
    });

    return fragmentView;
  }

  @Override public void onResume() {
    super.onResume();
    bookingListAdapter.refreshBookings();
    tvEmpty.setVisibility(bookingListAdapter.getCount() == 0 ? View.VISIBLE : View.GONE);
  }
}
