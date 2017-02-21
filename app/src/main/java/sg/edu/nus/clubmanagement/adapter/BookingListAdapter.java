package sg.edu.nus.clubmanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import sg.edu.nus.clubmanagement.ClubFolder.Booking;
import sg.edu.nus.clubmanagement.R;
import sg.edu.nus.clubmanagement.application.App;

public class BookingListAdapter extends ArrayAdapter<Booking> {

  private Context context;
  private List<Booking> bookings = new ArrayList<Booking>();

  public BookingListAdapter(Context context) {
    super(context, R.layout.booking_row_layout);
    this.context = context;
    refreshBookings();
  }

  @Override public View getView(final int position, View convertView, ViewGroup parent) {
    BookingListAdapter.ViewHolder viewHolder;
    if (convertView == null) {
      LayoutInflater inflater =
              (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      convertView = inflater.inflate(R.layout.mem_fac_row_layout, parent, false);
      viewHolder = new BookingListAdapter.ViewHolder();
      viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
      viewHolder.btnRemove = (Button) convertView.findViewById(R.id.btn_remove);
      convertView.setTag(viewHolder);
    } else {
      viewHolder = (BookingListAdapter.ViewHolder) convertView.getTag();
    }

    final Booking booking = bookings.get(position);
    viewHolder.tvName.setText(booking.toString());
    viewHolder.btnRemove.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        App.club.removeBooking(booking);
        refreshBookings();
      }
    });
    return convertView;
  }

  public void refreshBookings() {
    bookings.clear();
    Date start_date= new Date("1-Jan-2017 05:00");
    Date end_date= new Date("1-Jan-2019 05:00");
    bookings.addAll(App.club.getBookings("Room1",start_date,end_date));
    bookings.addAll(App.club.getBookings("Room2",start_date,end_date));
    bookings.addAll(App.club.getBookings("Main Hall",start_date,end_date));
    notifyDataSetChanged();
  }

  @Override public int getCount() {
    return bookings.size();
  }

  static class ViewHolder {
    TextView tvName;
    Button btnRemove;
  }
}
