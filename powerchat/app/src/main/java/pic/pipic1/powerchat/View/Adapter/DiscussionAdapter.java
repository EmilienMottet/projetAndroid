package pic.pipic1.powerchat.View.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pic.pipic1.powerchat.Model.Message;
import pic.pipic1.powerchat.Model.MessageText;
import pic.pipic1.powerchat.Model.Sujet;
import pic.pipic1.powerchat.R;
import pic.pipic1.powerchat.View.Discussion.DiscussionActivity;

/**
 * Created by ppier on 09/03/2016.
 */
public class DiscussionAdapter extends RecyclerView.Adapter<DiscussionAdapter.ViewHolder>{

    public List<Message> topic_messages;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private View messageView;

        private TextView message;
        private  TextView date;

        public ViewHolder(View itemView) {
            super(itemView);
            messageView = itemView;
            message = (TextView) itemView.findViewById(R.id.message);
            date = (TextView) itemView.findViewById(R.id.dateSingleMessage);
        }


<<<<<<< HEAD
        private void setMessage(final Message message){
            ((TextView)messageView.findViewById(R.id.message)).setText(message.getMessage());
            ((TextView)messageView.findViewById(R.id.dateSingleMessage)).setText(DateFormat.format("dd MMMM à hh:mm", message.getSendDate()));
            //Snackbar??
        }
=======
    }

    private void setMessage(Message message, ViewHolder vh){
        vh.message.setText(message.getMessage());
        vh.date.setText(message.getSendDate().toString());
>>>>>>> f7daa26b9f5871b08cf9e7eb6178ed3251d78c5c
    }

    public DiscussionAdapter(List<Message> messages){
        topic_messages = messages;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_discussion_singlemessage, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        setMessage(topic_messages.get(position),holder);
    }

    @Override
    public int getItemCount() {
        return topic_messages.size();
    }
}
