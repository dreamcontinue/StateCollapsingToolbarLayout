package party.danyang.statecollapsingtoolbarlayout.ui;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import party.danyang.statecollapsingtoolbarlayout.R;
import statecollapsingtoolbarlayout.StateCollapsingToolbarLayout;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                supportFinishAfterTransition();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final ImageView imageView = (ImageView) findViewById(R.id.image);
        final StateCollapsingToolbarLayout toolbarLayout = (StateCollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolbarLayout.setBackgroundColor(getResources().getColor(R.color.md_deep_purple_400));
        toolbarLayout.setContentScrimColor(getResources().getColor(R.color.md_deep_purple_400));
        toolbarLayout.setStatusBarScrimColor(getResources().getColor(R.color.md_deep_purple_400));

        final AppBarLayout appBar=(AppBarLayout)findViewById(R.id.app_bar);

        toolbarLayout.setOnStateChangedListener(new StateCollapsingToolbarLayout.OnStateChangedListener() {
            @Override
            public void onExpanded() {
                toolbarLayout.setTitle("Expended");
                Snackbar.make(appBar,"Expended",Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onCollapsed() {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                toolbarLayout.setTitle("Collapsed");
                Snackbar.make(appBar,"Collapsed",Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onInternediateFromExpand() {
                imageView.setImageResource(R.drawable.a2);
                toolbarLayout.setTitle("InternediateFromExpand");
                Snackbar.make(appBar,"InternediateFromExpand",Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onInternediateFromCollapsed() {
                imageView.setImageResource(R.drawable.expended);
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                toolbarLayout.setTitle("InternediateFromCollapsed");
                Snackbar.make(appBar,"InternediateFromCollapsed",Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onInternediate() {
                toolbarLayout.setTitle(getString(R.string.title_activity_scrolling));
            }
        });
    }
}
