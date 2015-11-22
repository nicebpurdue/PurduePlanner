package com.purdueplanner.purdueplanner;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.facebook.FacebookGraphResponseException;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FriendsActivity extends AppCompatActivity {
    static LoginButton loginButton;
    static CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/me/friends",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse response) {
                               Log.i("INFO", response.toString()); //DISPLAYS ON LOGCAT
//                               JSONObject jsonObject = response.getJSONObject();
//                                if (jsonObject != null){
//                                    try {
//                                        JSONArray array = jsonObject.getJSONArray("data");
//                                    } catch (JSONException e){
//                                        e.printStackTrace();
//                                    }
//                                }

                    }

                }
        ).executeAsync();



//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        loginButton = LoginActivity.getLoginButton();
//        callbackManager = LoginActivity.getCallbackManager();
//        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(),
//                        new GraphRequest.GraphJSONObjectCallback() {
//                            @Override
//                            public void onCompleted(JSONObject object, GraphResponse response) {
//                                try {
//                                    object = response.getJSONObject();
//                                    Log.d("LoginActivity", response.toString());
//                                    String id = object.getString("id");
//
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//
//                            }
//                        });
//                Bundle parameters = new Bundle();
//                parameters.putString("fields", "friendslists");
//                request.setParameters(parameters);
//                request.executeAsync();
//            }
//
//            @Override
//            public void onCancel() {
//
//            }
//
//            @Override
//            public void onError(FacebookException e) {
//                e.printStackTrace();
//            }
//        });


    }

}
