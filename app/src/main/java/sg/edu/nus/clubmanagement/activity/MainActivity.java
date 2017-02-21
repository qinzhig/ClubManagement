package sg.edu.nus.clubmanagement.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import sg.edu.nus.clubmanagement.R;
import sg.edu.nus.clubmanagement.adapter.PagerAdapter;
import sg.edu.nus.clubmanagement.application.App;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
    PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 3);
    viewPager.setAdapter(pagerAdapter);

    final TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

    tabLayout.addTab(tabLayout.newTab().setText("Members"));
    tabLayout.addTab(tabLayout.newTab().setText("Facilities"));
    tabLayout.addTab(tabLayout.newTab().setText("Bookings"));

    tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

      @Override public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
      }

      @Override public void onTabUnselected(TabLayout.Tab tab) {

      }

      @Override public void onTabReselected(TabLayout.Tab tab) {

      }
    });
    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
  }

  @Override protected void onStop() {
    App.clubStore.saveAll(this);
    super.onStop();
  }
}
