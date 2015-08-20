package com.example.www.helloworld01;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;


public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {


    private String[] menus;

    private ListView mMenuListView;

    private DrawerLayout drawerLayout;


    private Toolbar toobar;
    private View showView;

    /** 菜单打开/关闭状态 */
    private boolean isDirection_left = false;
    /** 右边栏打开/关闭状态 */
    private boolean isDirection_right = false;
    private RelativeLayout right_drawer;
    private ActionBarDrawerToggle mActionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menus = getResources().getStringArray(R.array.menu_array);
        toobar= (Toolbar) findViewById(R.id.id_toolbar);
         setSupportActionBar(toobar);
        mMenuListView = (ListView) findViewById(R.id.left_drawer);

        right_drawer = (RelativeLayout) findViewById(R.id.right_drawer);
        mMenuListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menus));
        mMenuListView.setOnItemClickListener(this);
        drawerLayout= (DrawerLayout) findViewById(R.id.drawerLayout);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout, toobar, R.string.open, R.string.close);
        mActionBarDrawerToggle.syncState();
        drawerLayout.setDrawerListener(mActionBarDrawerToggle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        FragmentManager manager = getSupportFragmentManager();
        Fragment contentFragment = new ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key", String.valueOf(position));
        contentFragment.setArguments(bundle);
        android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content, contentFragment).commit();
        drawerLayout.closeDrawer(mMenuListView);


    }
}
