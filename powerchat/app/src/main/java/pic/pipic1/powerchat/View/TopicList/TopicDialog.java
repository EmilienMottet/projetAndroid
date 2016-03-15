package pic.pipic1.powerchat.View.TopicList;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;

import pic.pipic1.powerchat.Model.Sujet;
import pic.pipic1.powerchat.R;

/**
 * Created by ppier on 14/03/2016.
 */
public class TopicDialog extends DialogFragment {
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
//                ListTopicFragment ltf = new ListTopicFragment();
//                ltf.addSujet(new Sujet("test","et"));
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

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        // request a window without the title
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

}
