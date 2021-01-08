 package com.example.residencia.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.residencia.R;
import com.example.residencia.adapters.SliderAdapter;
import com.example.residencia.models.SliderItem;
import com.example.residencia.providers.PostProvider;
import com.example.residencia.providers.UsersProvider;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

 public class PostDetailActivity extends AppCompatActivity {

    SliderView mSliderView;
    SliderAdapter mSliderAdapter;
    List<SliderItem> mSliderItems = new ArrayList<>();
    PostProvider mPostProvider;
     UsersProvider mUsersProvider;


     String mExtraPostId;

    TextView mTextViewTitle;
    TextView mTextViewDescription;
    TextView mTextViewUsername;
    TextView mTextViewPhone;
     TextView mTextViewAddress;
     CircleImageView mCircleImageViewProfile;
     Button mButtonShowProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        mSliderView = findViewById(R.id.imageSlider);
        mTextViewTitle = findViewById(R.id.textViewTitle);
        mTextViewDescription = findViewById(R.id.textViewDescription);
        mTextViewUsername = findViewById(R.id.textViewUsername);
        mTextViewPhone = findViewById(R.id.textViewPhone);
        mTextViewAddress = findViewById(R.id.textViewAddress);
        mCircleImageViewProfile = findViewById(R.id.circleImageProfile);
        mButtonShowProfile = findViewById(R.id.btnShowProfile);

        mPostProvider = new PostProvider();
        mUsersProvider = new UsersProvider();


        mExtraPostId = getIntent().getStringExtra("id");

        getPost();
    }

    private void instanceSlider() {
        mSliderAdapter = new SliderAdapter(PostDetailActivity.this, mSliderItems);
        mSliderView.setSliderAdapter(mSliderAdapter);
        mSliderView.setIndicatorAnimation(IndicatorAnimations.THIN_WORM);
        mSliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        mSliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);
        mSliderView.setIndicatorSelectedColor(Color.WHITE);
        mSliderView.setIndicatorUnselectedColor(Color.GRAY);
        mSliderView.setScrollTimeInSec(3);
        mSliderView.setAutoCycle(true);
        mSliderView.startAutoCycle();
    }

     private void getPost() {
         mPostProvider.getPostById(mExtraPostId).addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
             @Override
             public void onSuccess(DocumentSnapshot documentSnapshot) {
                 if (documentSnapshot.exists()) {

                     if (documentSnapshot.contains("image1")) {
                         String image1 = documentSnapshot.getString("image1");
                         SliderItem item = new SliderItem();
                         item.setImageUrl(image1);
                         mSliderItems.add(item);
                     }
                     if (documentSnapshot.contains("image2")) {
                         String image2 = documentSnapshot.getString("image2");
                         SliderItem item = new SliderItem();
                         item.setImageUrl(image2);
                         mSliderItems.add(item);
                     }
                     if (documentSnapshot.contains("title")) {
                         String title = documentSnapshot.getString("title");
                         mTextViewTitle.setText(title.toUpperCase());
                     }
                     if (documentSnapshot.contains("description")) {
                         String description = documentSnapshot.getString("description");
                         mTextViewDescription.setText(description);
                     }

                     if (documentSnapshot.contains("idUser")) {
                         String idUser = documentSnapshot.getString("idUser");
                         getUserInfo(idUser);
                     }

                     instanceSlider();
                 }
             }
         });
     }

     private void getUserInfo(String idUser) {
         mUsersProvider.getUser(idUser).addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
             @Override
             public void onSuccess(DocumentSnapshot documentSnapshot) {
                 if (documentSnapshot.exists()) {
                     if (documentSnapshot.contains("username")) {
                         String username = documentSnapshot.getString("username");
                         mTextViewUsername.setText(username);
                     }
                     if (documentSnapshot.contains("phone")) {
                         String phone = documentSnapshot.getString("phone");
                         mTextViewPhone.setText(phone);
                     }
                     if (documentSnapshot.contains("image_profile")) {
                         String imageProfile = documentSnapshot.getString("image_profile");
                         Picasso.with(PostDetailActivity.this).load(imageProfile).into(mCircleImageViewProfile);
                     }
                 }
             }
         });
     }
 }
