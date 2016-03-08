package pic.pipic1.powerchat.View.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pic.pipic1.powerchat.Model.Sujet;
import pic.pipic1.powerchat.R;
import pic.pipic1.powerchat.View.Discussion.DiscussionActivity;

/**
 * Created by emimo on 06/03/2016.
 */
public class SujetAdapter extends RecyclerView.Adapter<SujetAdapter.ViewHolder>{

    private List<Sujet> sujetList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private View mView;
        public ViewHolder(View v){
            super(v);
            mView = v;
        }
        private void setSujet(final Sujet s){
            ((TextView)mView.findViewById(R.id.sujettitre)).setText(s.getTitre());
            ((TextView)mView.findViewById(R.id.sujetdescription)).setText(s.getDescription());
            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("onClick","on a cliqueez sur : "+s.getTitre());
                    Intent intent = new Intent(v.getContext(), DiscussionActivity.class);
//                    intent.putExtra("SujetAAfficher",s);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }



    public SujetAdapter(List<Sujet> sujets){
        sujetList = sujets;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.describe_topic_layout,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setSujet(sujetList.get(position));
    }

    @Override
    public int getItemCount() {
        return sujetList.size();
    }
}
