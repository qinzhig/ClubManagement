package sg.edu.nus.clubmanagement.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import sg.edu.nus.clubmanagement.R;
import sg.edu.nus.clubmanagement.application.App;

public class AddMemberActivity extends AppCompatActivity {
  private EditText etFirstName, etSecondName, etSurname;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_member);

    etFirstName = (EditText) findViewById(R.id.et_first_name);
    etSecondName = (EditText) findViewById(R.id.et_second_name);
    etSurname = (EditText) findViewById(R.id.et_sur_name);

    Button btnSave = (Button) findViewById(R.id.btn_save);
    btnSave.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if (isValid()) {
          App.club.addMember(etSurname.getText().toString().trim(),
              etFirstName.getText().toString().trim(), etSecondName.getText().toString().trim());
          Toast.makeText(AddMemberActivity.this, getString(R.string.save_successful),
              Toast.LENGTH_SHORT).show();
          finish();
        }
      }
    });
  }

  private boolean isValid() {
    boolean isValid = true;
    if (TextUtils.isEmpty(etFirstName.getText().toString().trim())) {
      etFirstName.setError(getString(R.string.first_name_validation_msg));
      isValid = false;
    }
    if (TextUtils.isEmpty(etSecondName.getText().toString().trim())) {
      etSecondName.setError(getString(R.string.second_name_validation_msg));
      isValid = false;
    }
    if (TextUtils.isEmpty(etSurname.getText().toString().trim())) {
      etSurname.setError(getString(R.string.sur_name_validation_msg));
      isValid = false;
    }
    return isValid;
  }
}
