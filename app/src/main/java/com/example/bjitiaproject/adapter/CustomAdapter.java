package com.example.bjitiaproject.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bjitiaproject.R;
import com.example.bjitiaproject.model.Student;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<Student> arrayList;

    public CustomAdapter(Context context, ArrayList<Student> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
        //return null;
    }

    @Override
    public long getItemId(int i) {
        return arrayList.indexOf(getItem(i));
        //return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // we need to inflate our layout through LayoutInflater to use it
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View custom_layout = inflater.inflate(R.layout.item_layout, null); // this view will be returned...

        TextView tVUserName, tVCGPA;
        ImageView iVCallIcon;
        tVUserName = custom_layout.findViewById(R.id.textViewUserName);
        tVCGPA = custom_layout.findViewById(R.id.textViewCGPA);
        iVCallIcon = custom_layout.findViewById(R.id.imageViewCallIcon);
        tVUserName.setText(arrayList.get(i).getUserName());
        //tVCGPA.setText(arrayList.get(i).getPhoneNo());
        tVCGPA.setText("CGPA: "+arrayList.get(i).getCgpa());
        iVCallIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                //Intent intent = new Intent(Intent.ACTION_CALL);
                String uri = arrayList.get(i).getPhoneNo();
                intent.setData(Uri.parse("tel:"+uri));
                context.startActivity(intent);
            }
        });
        custom_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = "Username: " + arrayList.get(i).getUserName() + '\n' +
                            "Email: " + arrayList.get(i).getEmail() + '\n' +
                            "Phone No.: " + arrayList.get(i).getPhoneNo() + '\n' +
                            "CGPA: " +arrayList.get(i).getCgpa();
                AlertDialog alertDialog = new AlertDialog.Builder(context)
                        .setTitle("Student Details")
                        .setMessage(msg)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // nothing to do here...
                            }
                        })
                        .show();
            }
        });
        return  custom_layout;

        //return null;
    }
}
