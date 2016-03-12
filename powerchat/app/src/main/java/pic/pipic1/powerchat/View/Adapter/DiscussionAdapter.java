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

        public ViewHolder(View itemView) {
            super(itemView);
            messageView = itemView;
            //message = (TextView) itemView.findViewById(R.id.message);
            //date = (TextView) itemView.findViewById(R.id.dateSingleMessage);
        }


        private void setMessage(final Message message){
            ((TextView)messageView.findViewById(R.id.message)).setText(message.getMessage());
            ((TextView)messageView.findViewById(R.id.dateSingleMessage)).setText(DateFormat.format("dd MMMM à hh:mm", message.getSendDate()));
            //Snackbar??
        }
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
        holder.setMessage(topic_messages.get(position));
    }

    @Override
    public int getItemCount() {
        return topic_messages.size();
    }
}
