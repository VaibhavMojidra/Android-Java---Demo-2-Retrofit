package com.vaibhavmojidra.androidjavademo2retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.vaibhavmojidra.androidjavademo2retrofit.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private CommentRetrofitService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        service=RetrofitInstance.getRetrofitInstance().create(CommentRetrofitService.class);

        //All Comments
        service.getAllComments().enqueue(new Callback<Comments>() {
            @Override
            public void onResponse(Call<Comments> call, Response<Comments> response) {
                if(response.body()!=null){
                    for(CommentItem commentItem:response.body()){
                        binding.textView.append("ID: "+commentItem.getId()+"\nPost Id: "+commentItem.getPostId()+"\nName: "+commentItem.getName()+"\nEmail: "+commentItem.getEmail()+"\nBody: "+commentItem.getBody()+"\n\n\n");
                    }
                }
            }

            @Override
            public void onFailure(Call<Comments> call, Throwable t) {

            }
        });

        //All comments with specific postId
//        service.getCommentsWithPostId(2).enqueue(new Callback<Comments>() {
//            @Override
//            public void onResponse(Call<Comments> call, Response<Comments> response) {
//                if(response.body()!=null){
//                    for(CommentItem commentItem:response.body()){
//                        binding.textView.append("ID: "+commentItem.getId()+"\nPost Id: "+commentItem.getPostId()+"\nName: "+commentItem.getName()+"\nEmail: "+commentItem.getEmail()+"\nBody: "+commentItem.getBody()+"\n\n\n");
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Comments> call, Throwable t) {
//
//            }
//        });

        //Comment with id =7
//        service.getCommentWithId(7).enqueue(new Callback<CommentItem>() {
//            @Override
//            public void onResponse(Call<CommentItem> call, Response<CommentItem> response) {
//                CommentItem commentItem=response.body();
//                binding.textView.append("ID: "+commentItem.getId()+"\nPost Id: "+commentItem.getPostId()+"\nName: "+commentItem.getName()+"\nEmail: "+commentItem.getEmail()+"\nBody: "+commentItem.getBody()+"\n\n\n");
//            }
//
//            @Override
//            public void onFailure(Call<CommentItem> call, Throwable t) {
//
//            }
//        });
    }
}