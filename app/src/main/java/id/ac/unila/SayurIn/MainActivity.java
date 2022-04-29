package id.ac.unila.SayurIn;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import id.ac.unila.SayurIn.Model.Session;

public class MainActivity extends AppCompatActivity {
    private Session session;
    private TextView usernameValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//          session = Application.getSession();
        session = new Session(this);
        usernameValue = findViewById(R.id.text_home);


        String username = getIntent().getStringExtra("username");
        usernameValue.setText("Hallo " +username+ " !");

        //logika untuk mengatur apabila telah ada session maka tidak diperlukan untuk melakukan login
        if (!session.isLoggedIn()) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void handleHome (View view){
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);

    }

    public void handleMenu (View view){
        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        startActivity(intent);


    }

    public void handleCart (View view){
        Intent intent = new Intent(MainActivity.this, CartActivity.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (@NonNull MenuItem item){
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_logout) {
            session.logout();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return false;
    }
}
