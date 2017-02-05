package it.gamesandapps.myjob.adapters;

import android.content.Context;
import android.opengl.Visibility;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import it.gamesandapps.myjob.R;
import it.gamesandapps.myjob.objects.Review;
import it.gamesandapps.myjob.objects.User;

public class UserAdapter extends ArrayAdapter<User>{

    private Context ctx;
    private List<User> users;

    public UserAdapter(Context ctx, List<User> users) {
        super(ctx, -1, users);
        this.ctx = ctx;
        this.users = users;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final Holder holder;

        if(convertView == null){

            convertView = inflater.inflate(R.layout.row_user, null);
            holder = new Holder();
            holder.iv_user = (ImageView) convertView.findViewById(R.id.iv_user);
            holder.tv_name = (TextView)convertView.findViewById(R.id.tv_name);
            holder.tv_reviews_count = (TextView)convertView.findViewById(R.id.tv_reviews);
            holder.tv_email = (TextView)convertView.findViewById(R.id.tv_email);
            holder.ll_details = (LinearLayout) convertView.findViewById(R.id.ll_details);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        User user = users.get(position);

        if(user!=null){

            holder.tv_name.setText(user.getName()+ " " + user.getSurname());
            holder.tv_reviews_count.setText(user.getReviewsCount());
            holder.tv_email.setText(user.getEmail());


            if(user.getReviews()!=null){

                for (Review r : user.getReviews()) {
                    TextView tv = new TextView(ctx);
                    tv.setText(r.getVote());
                    holder.ll_details.addView(tv);
                }

            }
        }

        holder.iv_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.ll_details.getVisibility() == View.GONE)
                    holder.ll_details.setVisibility(View.VISIBLE);
                else
                    holder.ll_details.setVisibility(View.GONE);
            }
        });

        return convertView;
    }

    static class Holder {
        ImageView iv_user;
        TextView tv_name;
        TextView tv_email;
        TextView tv_reviews_count;
        LinearLayout ll_details;
    }
}
