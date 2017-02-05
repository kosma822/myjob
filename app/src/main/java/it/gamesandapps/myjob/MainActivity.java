package it.gamesandapps.myjob;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import it.gamesandapps.myjob.adapters.UserAdapter;
import it.gamesandapps.myjob.objects.Review;
import it.gamesandapps.myjob.objects.User;
import it.gamesandapps.myjob.utils.UserFunctions;

public class MainActivity extends AppCompatActivity {

    private UserFunctions functions;
    private ArrayList<User> usersList;
    private UserAdapter adapter;
    private ListView lv_users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usersList = new ArrayList<>();
        adapter = new UserAdapter(this, usersList);
        lv_users = (ListView)findViewById(R.id.lv_users);
        lv_users.setAdapter(adapter);

        new GetUsers().execute();

    }
    private class GetUsers extends AsyncTask<String,String,String>{
        @Override
        protected String doInBackground(String... params) {
            functions = new UserFunctions();
            return functions.getUsers(null);
        }

        @Override
        protected void onPostExecute(String s) {
            if(s!=null)
                if(!s.isEmpty())
                    try {
                        JSONArray users = new JSONObject(s).getJSONArray("users");

                        if(users.length()!=0)
                            for (int i = 0; i < users.length(); i++) {

                                JSONObject user = users.getJSONObject(i);

                                User u = new User();

                                u.setName(user.getString("name"));
                                u.setSurname(user.getString("surname"));
                                u.setEmail(user.getString("email"));
                                u.setReviewsCount(user.getString("reviews_count"));

                                if(user.has("reviews")) {
                                    JSONArray u_reviews_list = user.getJSONArray("reviews");
                                    if (u_reviews_list.length() != 0) {

                                        List<Review> reviewsList = new ArrayList<>();

                                        for (int j = 0; j < u_reviews_list.length(); j++) {

                                            JSONObject review = u_reviews_list.getJSONObject(j);

                                            Review r = new Review();
                                            r.setVote(review.getString("vote"));

                                            reviewsList.add(r);
                                        }

                                        u.setReviews(reviewsList);
                                    }
                                }

                                usersList.add(u);

                            }

                        adapter.notifyDataSetChanged();


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


        }
    }
}
