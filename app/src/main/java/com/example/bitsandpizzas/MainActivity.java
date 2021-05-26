 package com.example.bitsandpizzas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

 public class MainActivity extends AppCompatActivity {
     private ShareActionProvider shareActionProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar= (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
     public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.main_menu,menu);
         MenuItem menuItem=menu.findItem(R.id.action_share);
         shareActionProvider= (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
         setShareActionIntent("want to join us for pizza");
         return super.onCreateOptionsMenu(menu);
     }

     private void setShareActionIntent(String text) {
        Intent intent =new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(intent.EXTRA_TEXT,text);
        shareActionProvider.setShareIntent(intent);


     }


     @Override
     public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_create_order:
                startActivity(new Intent(MainActivity.this,orderActivity.class));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
         return super.onOptionsItemSelected(item);

     }
 }