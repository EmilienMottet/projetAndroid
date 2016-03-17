package pic.pipic1.powerchat.View.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.Query;
import com.firebase.ui.FirebaseRecyclerAdapter;

import pic.pipic1.powerchat.Model.MessageTextSimple;
import pic.pipic1.powerchat.R;

/**
 * Created by emimo on 17/03/2016.
 */
public class TextSimpleAdapter extends FirebaseRecyclerAdapter<MessageTextSimple, TextSimpleAdapter.MessageTextSimpleHolder> {

    private Context mContext;

    public TextSimpleAdapter(Query ref, Context context){
        super(MessageTextSimple.class, R.layout.activity_discussion_singlemessage, MessageTextSimpleHolder.class, ref);
        mContext = context;
    }

    @Override
    public void populateViewHolder(MessageTextSimpleHolder chatView, MessageTextSimple chat, int position) {
        chatView.setName(DateFormat.getDateFormat(mContext).format(chat.getDate()));
        chatView.setText(chat.getText());

    }

    public static class MessageTextSimpleHolder extends RecyclerView.ViewHolder {
        View mView;

        public MessageTextSimpleHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }


        public void setName(String name) {
            TextView field = (TextView) mView.findViewById(R.id.dateSingleMessage);
            field.setText(name);
        }

        public void setText(String text) {
            TextView field = (TextView) mView.findViewById(R.id.message);
            field.setText(text);
        }
    }
}
