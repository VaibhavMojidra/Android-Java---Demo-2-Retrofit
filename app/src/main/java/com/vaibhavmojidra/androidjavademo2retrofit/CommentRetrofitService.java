package com.vaibhavmojidra.androidjavademo2retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CommentRetrofitService {
    @GET("/comments")
    Call<Comments> getAllComments();

    @GET("/comments")
    Call<Comments> getCommentsWithPostId(@Query("postId") int postId);

    @GET("/comments/{id}")
    Call<CommentItem> getCommentWithId(@Path("id") int id);

}
