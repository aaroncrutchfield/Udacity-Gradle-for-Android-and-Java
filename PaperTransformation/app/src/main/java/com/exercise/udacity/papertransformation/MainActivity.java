package com.exercise.udacity.papertransformation;

import android.animation.Animator;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static String baconTitle = "Bacon";
    static String baconText = "Bacon ipsum dolor amet pork belly meatball kevin spare ribs. Frankfurter swine corned beef meatloaf, strip steak.";
    static String veggieTitle = "Veggie";
    static String veggieText = "Veggies es bonus vobis, proinde vos postulo essum magis kohlrabi welsh onion daikon amaranth tatsoi tomatillo melon azuki bean garlic.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.recyclerview);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new RecyclerView.Adapter<ViewHolder>() {
            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new ViewHolder(getLayoutInflater().inflate(R.layout.list_item, parent, false));
            }

            @Override
            public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
                holder.text1.setText(baconTitle);
                holder.text2.setText(baconText);
            }

            @Override
            public int getItemCount() {
                return 10;
            }
        });
    }

    private static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView text1;
        TextView text2;
        static int green;
        static int white;

        public ViewHolder(View itemView) {
            super(itemView);
            text1 = itemView.findViewById(android.R.id.text1);
            text2 = itemView.findViewById(android.R.id.text2);
            itemView.setOnClickListener(this);

            if (green == 0)
                green = itemView.getContext().getResources().getColor(R.color.green);
            if (white == 0)
                white = itemView.getContext().getResources().getColor(R.color.white);

        }

        @Override
        public void onClick(View view) {
            boolean isVeggie = ((ColorDrawable)view.getBackground()) != null &&
                    ((ColorDrawable)view.getBackground()).getColor() == green;

            TransitionManager.beginDelayedTransition((ViewGroup) view);

            // Get the final radius using the largest side
            int finalRadius = Math.max(view.getWidth(), view.getHeight()) / 2;
            // We always start at 0; the smallest point
            int startRadius = 0;
            // Get center point by using half of the width and height
            int centerX = view.getWidth()/2;
            int centerY = view.getHeight()/2;

            // If already veggie, change back to bacon
            // Else animate circular reveal for veggie
            if (isVeggie) {
                text1.setText(baconTitle);
                text2.setText(baconText);
                view.setBackgroundColor(white);
            } else {
                Animator animator = ViewAnimationUtils.createCircularReveal(
                        view,
                        centerX,
                        centerY,
                        startRadius,
                        finalRadius);
                text1.setText(veggieTitle);
                text2.setText(veggieText);
                view.setBackgroundColor(green);
                animator.start();
            }
        }
    }
}
