package com.example.michael.myapplicationnew;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by MICHAEL on 4/8/2017.
 */

public class Gallary_custom extends PagerAdapter {
    private ViewPager viewPager;
    private  int[] image_resources={R.drawable.slide1,R.drawable.slide2,R.drawable.slide33,R.drawable.slide4,R.drawable.slide5,R.drawable.slide6,R.drawable.slide7,R.drawable.slide8,R.drawable.slide_1,R.drawable.concert_slide,R.drawable.concert_slide2,R.drawable.concert_slide3,R.drawable.concert_slide5,R.drawable.concrt_slide6};
    private Context context;
    private LayoutInflater layoutInflater;
    public Gallary_custom(Context context){
        this.context=context;
    }


    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==((LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view=layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageView=(ImageView) item_view.findViewById(R.id.image_viewer);
        TextView textView=(TextView)item_view.findViewById(R.id.image_title);
        imageView.setImageResource(image_resources[position]);
        textView.setText("Slide: "+position);
        switch(position){
            case 0:
                textView.setText("Slide 1: "+ "  Convocation ");
                break;
            case 1:
                textView.setText("Slide 2: "+ "  Convocation b");
                break;
            case 2:
                textView.setText("Slide 3: "+ "  Convocation c");
                break;
            case 3:
                textView.setText("Slide 4: "+ "  Convocation d");
                break;
            case 4:
                textView.setText("Slide 5: "+ "  Convocation e");
                break;
            case 5:
                textView.setText("Slide 6: "+ "  Convocation f");
                break;
            case 6:
                textView.setText("Slide 7: "+ "  Convocation g");
                break;
            case 7:
                textView.setText("Slide 8 : "+ "  Convocation h");
                break;
            case 8:
                textView.setText("Slide 9: "+ "  Convocation I");
                break;
            case 9:
                textView.setText("Slide 10: "+ "  Convocation J");
                break;
            case 10:
                textView.setText("Slide 11: "+ "  Convocation K");
                break;
            case 11:
                textView.setText("Slide 12 : "+ "  Convocation L");
                break;
            case 12:
                textView.setText("Slide 13: "+ "  Convocation M");
                break;
            case 13:
                textView.setText("Slide 14: " +"  Convocation N");
                break;
            default:
                textView.setText("Slide 0: "+ "  Convocation a");
                break;
        }

        container.addView(item_view);


        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
