package in.indekode.collegebuddy;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    public SliderAdapter(Context context){
        this.context = context;
    }

    Context context;
    LayoutInflater layoutInflater;

    public int[] events_img = {
            R.drawable.delhievnt,
            R.drawable.img2,
            R.drawable.img1
    };

    public String[] event_titles = {
            "Event 1", "Event 2", "Event 3"
    };

    public  String[] event_details = {
            "This is event 1 description",
            "This is event 2 description",
            "This is event 3 description"
    };

    public int[] events_bgcolor = {
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(1,188,212)
    };

    @Override
    public int getCount() {
        return event_titles.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == (LinearLayout)o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slides_viewpager, container, false);
        LinearLayout layout =  view.findViewById(R.id.slider_layout);
        ImageView imageView = view.findViewById(R.id.slider_img);
        TextView tvtitle = view.findViewById(R.id.title_slider);
        TextView tvdetails = view.findViewById(R.id.detail_slider);
        layout.setBackgroundColor(events_bgcolor[position]);
        imageView.setImageResource(events_img[position]);
        tvtitle.setText(event_titles[position]);
        tvdetails.setText(event_details[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
