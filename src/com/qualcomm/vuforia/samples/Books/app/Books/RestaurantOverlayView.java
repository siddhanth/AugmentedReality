/*===============================================================================
Copyright (c) 2012-2014 Qualcomm Connected Experiences, Inc. All Rights Reserved.

Vuforia is a trademark of QUALCOMM Incorporated, registered in the United States 
and other countries. Trademarks of QUALCOMM Incorporated are used with permission.
===============================================================================*/

package com.qualcomm.vuforia.samples.Books.app.Books;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.qualcomm.vuforia.samples.Books.R;

// Custom View with Restaurant Overlay Data
public class RestaurantOverlayView extends RelativeLayout
{
	Context context;
	
    public RestaurantOverlayView(Context context)
    {
        this(context, null);
        this.context = context; 
    }
    
    
    public RestaurantOverlayView(Context context, AttributeSet attrs)
    {
        this(context, attrs, 0);
    }
    
    
    public RestaurantOverlayView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        inflateLayout(context);
        
    }
    
    
    // Inflates the Custom View Layout
    private void inflateLayout(Context context)
    {
        
        final LayoutInflater inflater = LayoutInflater.from(context);
        
        // Generates the layout for the view
        inflater.inflate(R.layout.bitmap_layout, this, true);
    }
    
    
    public void setRestTitle(String restTitle)
    {
        TextView tv = (TextView) findViewById(R.id.textview_restaurant_name);
        tv.setText(restTitle);
    }
    
    
    public void setRestDec(String restDesc)
    {
        TextView tv = (TextView) findViewById(R.id.textview_restaurant_desc);
        tv.setText(restDesc);
    }
    
    
    public void setCallButton(String phoneNumber)
    {
        Button callButton = (Button) findViewById(R.id.button_call);
        callButton.setText(phoneNumber);
        final String ph = phoneNumber;
        Toast.makeText(context, "clicked call button", Toast.LENGTH_LONG).show();
        callButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				
				callIntent.setData(Uri.parse("tel:" + ph));
				context.startActivity(callIntent);				
			}
		});
    }
    
    
    public void setRating(double rating)
    {
        RatingBar rb = (RatingBar) findViewById(R.id.ratingbar_restaurant_rating);
        rb.setRating((float) rating);
    }
    
    public void setRestImage(){
    	ImageView restLogo = (ImageView) findViewById(R.id.image_restaurant_logo);
    	restLogo.setImageResource(R.drawable.badge_background);
    }
}
