package pic.pipic1.powerchat.View.TopicList;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import pic.pipic1.powerchat.R;

/*
powerchat.em.pp.iut
powerchatiut
 */

public class TopicListActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_list);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        
        // Setup drawer view
        setupDrawerContent(nvDrawer);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();


        mDrawer.setDrawerListener(drawerToggle);

        ListTopicFragment listTopicFragment = new ListTopicFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.accueil_topic, listTopicFragment, "fragmentListTopic");
        transaction.addToBackStack(null);
        transaction.commit();

        fab = (FloatingActionButton) findViewById(R.id.fabBtn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
//                LayoutInflater inflater = getLayoutInflater();
//                View dialoglayout = inflater.inflate(R.layout.add_layout_activity, null);
//                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
////                builder.setPositiveButton();
//                builder.setView(dialoglayout);
//                builder.show();

                Bundle args = new Bundle();
                args.putString("title", "Ajouter un sujet");
                TopicDialog actionbarDialog = new TopicDialog();
                actionbarDialog.setArguments(args);
                actionbarDialog.show(getFragmentManager(),"action_bar_frag");

            }
        });

    }

    public Activity getActivity(){
        return this;
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open,  R.string.drawer_close);
    }

    // `onPostCreate` called when activity start-up is complete after `onStart()`
    // NOTE! Make sure to override the method with only a single `Bundle` argument
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }

    //useless pour le moment mais je laisse au cas si on travail plus sur les menus dispo a gauche
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
/*        // Create a new fragment and specify the planet to show based on
        // position
        Fragment fragment = null;

        Class fragmentClass;
        switch(menuItem.getItemId()) {
            case R.id.nav_first_fragment:
                fragmentClass = FirstFragment.class;
                break;
            case R.id.nav_second_fragment:
                fragmentClass = SecondFragment.class;
                break;
            case R.id.nav_third_fragment:
                fragmentClass = ThirdFragment.class;
                break;
            default:
                fragmentClass = FirstFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // Highlight the selected item, update the title, and close the drawer
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawer.closeDrawers();*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_topic_list, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
