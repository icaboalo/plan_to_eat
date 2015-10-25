package com.icaboalo.plantoeat.domain;

/**
 * Created by icaboalo on 10/23/2015.
 */
public class Steps {

    public Steps(String stepDescription) {
        mStepDescription = stepDescription;
    }

    String mStepDescription;
    int mStepNumber;

    public String getStepDescription() {
        return mStepDescription;
    }

    public int getStepNumber() {
        return mStepNumber;
    }

    public void setStepDescription(String stepDescription) {
        mStepDescription = stepDescription;
    }

    public void setStepNumber(int stepNumber) {
        mStepNumber = stepNumber;
    }
}
