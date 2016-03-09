package pic.pipic1.powerchat.View.TopicList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pic.pipic1.powerchat.Model.MessageText;
import pic.pipic1.powerchat.Model.Sujet;
import pic.pipic1.powerchat.R;
import pic.pipic1.powerchat.View.Adapter.SujetAdapter;

/**
 * Created by emimo on 02/03/2016.
 */
public class ListTopicFragment extends Fragment{


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Sujet> sujetList = new ArrayList(){{add(new Sujet("Sujet 1","sujet test voici une courte description"));
        add(new Sujet("Sujet 2","sujet test voici une courte description"));
        add(new Sujet("Sujet 3","sujet test voici une courte description"));
        add(new Sujet("Sujet 4","sujet test voici une courte description"));
        add(new Sujet("Sujet 5","sujet test voici une courte description"));
        add(new Sujet("Sujet 6","sujet test voici une courte description"));
        add(new Sujet("Sujet 7","sujet test voici une courte description"));
        add(new Sujet("Sujet 8","sujet test voici une courte description"));
        add(new Sujet("Sujet 9","sujet test voici une courte description"));
        add(new Sujet("Sujet 10","sujet test voici une courte description"));
        add(new Sujet("Sujet 11","sujet test voici une courte description"));
        add(new Sujet("Sujet 12","sujet test voici une courte description"));
        add(new Sujet("Sujet 13","sujet test voici une courte description"));
        add(new Sujet("Sujet 14","sujet test voici une courte description"));
        add(new Sujet("Sujet 15","sujet test voici une courte description"));
        add(new Sujet("Sujet 16","sujet test voici une courte description"));
        add(new Sujet("Sujet 17","sujet test voici une courte description"));
        add(new Sujet("Sujet 18","sujet test voici une courte description"));
        add(new Sujet("Sujet 19","sujet test voici une courte description"));}};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentlisttopic,null);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);



        //sujetList.get(1).addMessage(new MessageText("Le premier message du sujet 1"));
        //sujetList.get(1).addMessage(new MessageText("Le second message du sujet 1"));
       // sujetList.get(1).addMessage(new MessageText("Le troisieme message du sujet 1"));
        //sujetList.get(1).addMessage(new MessageText("Le quatrième message du sujet 1"));
        //sujetList.get(1).addMessage(new MessageText("Le cinquieme message du sujet 1"));
        //sujetList.get(1).addMessage(new MessageText("Le sixieme message du sujet 1"));


        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);


        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this.getContext());

        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new SujetAdapter(sujetList);

        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
