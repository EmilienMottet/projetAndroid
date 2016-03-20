package pic.pipic1.powerchat.View.Adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.util.Base64;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.Query;
import com.firebase.ui.FirebaseRecyclerAdapter;

import java.text.SimpleDateFormat;

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
//        chatView.setName(DateFormat.getDateFormat(mContext).format(chat.getDate()));
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM hh:mm");
        chatView.setDate(formatter.format(chat.getDate()));
        chatView.setText(chat.getText());
        chatView.setPosition(chat.getLoc());
        chatView.setAuthor(chat.getName());
        if(chat.getPhoto() != null || !chat.getPhoto().equals("")){
            chatView.setImageView(chat.getPhoto());
        }
    }

    public static class MessageTextSimpleHolder extends RecyclerView.ViewHolder {
        private TextView mDate;
        private TextView mAuthor;
        private TextView mPosition;
        private TextView mText;
        private View mSeparator;
        private ImageView mImageView;

        public MessageTextSimpleHolder(View itemView) {
            super(itemView);
            mAuthor = (TextView) itemView.findViewById(R.id.author_textview);
            mDate = (TextView) itemView.findViewById(R.id.dateSingleMessage);
            mPosition = (TextView) itemView.findViewById(R.id.position_textview);;
            mText = (TextView) itemView.findViewById(R.id.message);
            mSeparator = itemView.findViewById(R.id.separator);
            mImageView =(ImageView) itemView.findViewById(R.id.photoview);
        }


        public void setDate(String name) {
            mText.setText(name);
        }


        public void setAuthor(String author) {
            mAuthor.setVisibility(View.VISIBLE);
            mSeparator.setVisibility(View.VISIBLE);
            mAuthor.setText(author);
        }

        public void setPosition(String position){
            mPosition.setText(position);
        }

        public void setText(String text) {
            mText.setText(text);
        }

        public  void setImageView(String image){
            byte[] decodedBytes = Base64.decode(image, 0);
            mImageView.setImageBitmap(BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length));;
        }
    }
}
