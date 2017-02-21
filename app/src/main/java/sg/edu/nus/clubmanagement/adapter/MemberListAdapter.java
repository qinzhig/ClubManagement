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
import sg.edu.nus.clubmanagement.ClubFolder.Member;
import sg.edu.nus.clubmanagement.R;
import sg.edu.nus.clubmanagement.application.App;

/**
 * Created by Swarna on 8/6/2016.
 */
public class MemberListAdapter extends ArrayAdapter<Member> {
  private Context context;
  private List<Member> members = new ArrayList<Member>();

  public MemberListAdapter(Context context) {
    super(context, R.layout.mem_fac_row_layout);
    this.context = context;
    refreshMembers();
  }

  @Override public View getView(final int position, View convertView, ViewGroup parent) {
    ViewHolder viewHolder;
    if (convertView == null) {
      LayoutInflater inflater =
          (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      convertView = inflater.inflate(R.layout.mem_fac_row_layout, parent, false);
      viewHolder = new ViewHolder();
      viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
      viewHolder.btnRemove = (Button) convertView.findViewById(R.id.btn_remove);
      convertView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder) convertView.getTag();
    }

    final Member member = members.get(position);
    viewHolder.tvName.setText(member.toString());
    viewHolder.btnRemove.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        App.club.removeMember(member.getMemberNumber());
        refreshMembers();
      }
    });
    return convertView;
  }

  public void refreshMembers() {
    members.clear();
    members.addAll(App.club.getMembers());
    notifyDataSetChanged();
  }

  @Override public int getCount() {
    return members.size();
  }

  static class ViewHolder {
    TextView tvName;
    Button btnRemove;
  }
}
