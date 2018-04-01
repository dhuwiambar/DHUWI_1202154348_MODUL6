package com.example.lenovo.dhuwi_1202154348_modul6;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;



    public class fraghomeall extends Fragment {
        RecyclerView rv;
        DatabaseReference dataref;
        ArrayList<dBPost> list;
        AdpPost ap;


        public fraghomeall() {
            // Required empty public constructor
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.activity_fraghomeall, container, false);
            rv = v.findViewById(R.id.rvhomeall);
            list = new ArrayList<>();
            dataref = FirebaseDatabase.getInstance().getReference().child("post");
            ap = new AdpPost(list, this.getContext());

            rv.setHasFixedSize(true);
            rv.setLayoutManager(new LinearLayoutManager(this.getContext()));
            rv.setAdapter(ap);

            dataref.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    dBPost post = dataSnapshot.getValue(dBPost.class);
                    post.key = dataSnapshot.getKey();
                    list.add(post);
                    ap.notifyDataSetChanged();

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            return v;
        }

    }

