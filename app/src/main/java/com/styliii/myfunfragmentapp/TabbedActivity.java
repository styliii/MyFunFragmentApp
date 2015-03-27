package com.styliii.myfunfragmentapp;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class TabbedActivity extends ActionBarActivity {
    AFragment fragmentA;
    BFragment fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);
        fragmentA = new AFragment();
        fragmentB = new BFragment();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tabbed, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onFragmentA(View view) {
        // 3 steps to runtime fragment
        // 1.  create a transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // 2.  modify the containers
            // "add fragment A to flContainer"
        ft.replace(R.id.flContainer, fragmentA);
        ft.addToBackStack("show fragment a");
        // 3.  execute the transaction
        ft.commit();

    }

    public void onFragmentB(View view) {
        // 3 steps to runtime fragment
        // 1.  create a transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // 2.  modify the containers
        // "add fragment A to flContainer"
        ft.replace(R.id.flContainer, fragmentB);
        // 3.  execute the transaction
        // the reason why you commit, is because it's looking to all the steps that have
        // been added, then redraws it all at once.  So it looks like one smooth change.
        // this transaction is like a snapshot.  like a git commit.  so i can revert using
        ft.addToBackStack("show fragment b");
        // this allows you to use the BACK button!
        ft.commit();
    }
}
