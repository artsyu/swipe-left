package com.aiyaa.swipeleft;

import android.animation.LayoutTransition;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


public class MorphAnimation {

    private final FrameLayout parentView;
    private View buttonContainer;
    private ViewGroup viewsContainer;
    private ViewGroup viewsContainer2;

    private boolean isPressed;
    private int initialWidth;
    private int initialGravity;

    public boolean isPressed() {
        return isPressed;
    }

    public MorphAnimation(View buttonContainer, FrameLayout parentView, ViewGroup viewsContainer, ViewGroup viewsContainer2) {
        this.buttonContainer = buttonContainer;
        this.parentView = parentView;
        this.viewsContainer = viewsContainer;
        this.viewsContainer2 = viewsContainer2;

        LayoutTransition layoutTransition = parentView.getLayoutTransition();
        layoutTransition.setDuration(400);
        layoutTransition.enableTransitionType(LayoutTransition.CHANGING);

        isPressed = false;

    }

    public void morphIntoForm() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) buttonContainer.getLayoutParams();

        initialWidth = layoutParams.width;
        initialGravity = layoutParams.gravity;

        layoutParams.gravity = Gravity.CENTER;
        layoutParams.width = FrameLayout.LayoutParams.MATCH_PARENT;
        buttonContainer.setLayoutParams(layoutParams);

        for (int i = 1; i < viewsContainer.getChildCount(); i++) {
            viewsContainer.getChildAt(i).setVisibility(View.VISIBLE);
        }

        for (int i = 0; i < viewsContainer2.getChildCount(); i++) {
            viewsContainer2.getChildAt(i).setVisibility(View.VISIBLE);
        }

        isPressed = true;
    }

    public void morphIntoButton() {
        for (int i = 1; i < viewsContainer.getChildCount(); i++) {
            viewsContainer.getChildAt(i).setVisibility(View.GONE);
        }

        for (int i = 0; i < viewsContainer2.getChildCount(); i++) {
            viewsContainer2.getChildAt(i).setVisibility(View.GONE);
        }

        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) buttonContainer.getLayoutParams();
        layoutParams.gravity = initialGravity;
        layoutParams.width = initialWidth;
        buttonContainer.setLayoutParams(layoutParams);

        isPressed = false;
    }

}