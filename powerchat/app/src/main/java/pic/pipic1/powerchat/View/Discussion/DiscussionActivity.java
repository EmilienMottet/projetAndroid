package pic.pipic1.powerchat.View.Discussion;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;
import com.firebase.ui.FirebaseRecyclerAdapter;
import com.firebase.ui.auth.core.FirebaseLoginBaseActivity;
import com.firebase.ui.auth.core.FirebaseLoginError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pic.pipic1.powerchat.Model.Message;
import pic.pipic1.powerchat.Model.MessageText;
import pic.pipic1.powerchat.Model.MessageTextSimple;
import pic.pipic1.powerchat.Model.Sujet;
import pic.pipic1.powerchat.R;
import pic.pipic1.powerchat.View.Adapter.DiscussionAdapter;
import pic.pipic1.powerchat.View.Adapter.TextSimpleAdapter;

public class DiscussionActivity extends FirebaseLoginBaseActivity {

    public static String TAG = "powerchat-iut.messages";
    private Toolbar toolbar;
    private Sujet sujet;
    private String idSujet;
    private List<Message> listMessage;
    private Firebase mRef;
    private String mName;
    private RecyclerView.Adapter mDiscussionAdapter;
    private RecyclerView recyclerView;
    private Query mChatRef;

    private ImageButton mImageButton;
    private EditText mMessageASend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_discussion);

        sujet = (Sujet) getIntent().getSerializableExtra("Subject");
        idSujet = (String)  getIntent().getSerializableExtra("idSujet");
        mRef = new Firebase("https://powerchat-iut.firebaseio.com/messages/"+idSujet);
        mChatRef = mRef.limitToLast(50);
        Log.i("PCidSujet",idSujet);
        mImageButton = (ImageButton) findViewById(R.id.imageButton);
        mMessageASend = (EditText) findViewById(R.id.editText);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessageTextSimple chat = new MessageTextSimple(mName, getAuth().getUid(), mMessageASend.getText().toString());

                mRef.push().setValue(chat, new Firebase.CompletionListener() {
                    @Override
                    public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                        if (firebaseError != null) {
                            Log.e(TAG, firebaseError.toString());
                        }
                    }
                });
                mMessageASend.setText("");
            }

        });


        recyclerView = (RecyclerView) findViewById(R.id.message_recycler_view);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDiscussionAdapter = new TextSimpleAdapter(mChatRef,this);

        recyclerView.setAdapter(mDiscussionAdapter);

        recyclerView.setHasFixedSize(false);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onFirebaseLoggedIn(AuthData authData) {
        Log.i(TAG, "Logged in to " + authData.getProvider().toString());

        switch (authData.getProvider()) {
            case "password":
                mName = (String) authData.getProviderData().get("email");
                break;
            default:
                mName = (String) authData.getProviderData().get("displayName");
                break;
        }

        if(mName != null){
          Log.i("PCajout","ici : "+mName);
        }

        invalidateOptionsMenu();
        mDiscussionAdapter.notifyDataSetChanged();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // API 5+ solution
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected Firebase getFirebaseRef() {
        return mRef;
    }

    @Override
    protected void onFirebaseLoginProviderError(FirebaseLoginError firebaseLoginError) {
        Log.e(TAG, "Login provider error: " + firebaseLoginError.toString());
        resetFirebaseLoginPrompt();
    }

    @Override
    protected void onFirebaseLoginUserError(FirebaseLoginError firebaseLoginError) {
        Log.e(TAG, "Login user error: "+firebaseLoginError.toString());
        resetFirebaseLoginPrompt();
    }



}
