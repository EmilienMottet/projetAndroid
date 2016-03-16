package pic.pipic1.powerchat.View.TopicList;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.firebase.ui.auth.core.FirebaseLoginError;

import pic.pipic1.powerchat.Model.Sujet;
import pic.pipic1.powerchat.R;

/**
 * Created by ppier on 14/03/2016.
 */
public class TopicDialog extends DialogFragment {

    private Firebase ref;
    private String name;
    private TopicDialog topicDialog = this;
    private  MainTopicListActivity mainTopicListActivity;
    private Toolbar toolbar;
    private Button button;
    private EditText et1;
    private EditText et2;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle args = getArguments();
        String title = args.getString("title");
        View v = inflater.inflate(R.layout.add_layout_activity, container, false);
        toolbar = (Toolbar) v.findViewById(R.id.toolbarAlertDialog);
        button = (Button) v.findViewById(R.id.validate_topic);
        et1 = (EditText) v.findViewById(R.id.subject_edit_text);
        et1 = (EditText) v.findViewById(R.id.description_edit_text);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Log.i("PCajout","val main : "+mainTopicListActivity);
                    Log.i("PCajout","val name : "+mainTopicListActivity.getName());
                    Log.i("PCajout","val uid : "+mainTopicListActivity.getAuth().getUid());
                    Sujet s = new Sujet(mainTopicListActivity.getName(),mainTopicListActivity.getAuth().getUid(),"test","la description");
                    mainTopicListActivity.getRef().push().setValue(s);
                    Log.i("PCajout","on a push un nouveau sujet");
                    mainTopicListActivity.invalidateOptionsMenu();
                    mainTopicListActivity.getListTopicFragment().getmAdapter().notifyDataSetChanged();
                }catch(Exception e){
                    AlertDialog.Builder builder = new AlertDialog.Builder(topicDialog.getActivity());
                    builder.setTitle("Vous n'etes pas connecter!");
                    builder.setPositiveButton("OK..", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.show();
                }

            }
        });



        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return true;
            }
        });
        toolbar.inflateMenu(R.menu.menu_topic_list);
        toolbar.setTitle(title);

        return v;
    }

    public void setMainTopicListActivity(MainTopicListActivity mainTopicListActivity) {
        this.mainTopicListActivity = mainTopicListActivity;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        // request a window without the title
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

}
