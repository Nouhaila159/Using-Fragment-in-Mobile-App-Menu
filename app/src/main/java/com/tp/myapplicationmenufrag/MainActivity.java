package com.tp.myapplicationmenufrag;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.myDrawer);
        navigationView=findViewById(R.id.myNav);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportFragmentManager().beginTransaction().replace(R.id.myFrame,new HomeFragment()).commit();

        //==================================================================
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch(item.getItemId()){
                case R.id.home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.myFrame,new HomeFragment()).commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case R.id.exit:
                    getSupportFragmentManager().beginTransaction().replace(R.id.myFrame,new ExitFragment()).commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case R.id.info:
                    getSupportFragmentManager().beginTransaction().replace(R.id.myFrame,new InfoFragment()).commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case R.id.calc:
                    getSupportFragmentManager().beginTransaction().replace(R.id.myFrame,new CalcFragment()).commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case R.id.liste:
                    getSupportFragmentManager().beginTransaction().replace(R.id.myFrame,new ListeFragment()).commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case R.id.conv:
                    getSupportFragmentManager().beginTransaction().replace(R.id.myFrame,new ConvFragment()).commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case R.id.listH:
                    getSupportFragmentManager().beginTransaction().replace(R.id.myFrame,new HorizontalFragment()).commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
            }
            return true;
        }
    });
}
}