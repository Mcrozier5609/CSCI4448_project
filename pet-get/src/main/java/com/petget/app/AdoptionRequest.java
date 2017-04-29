package com.petget.app;

import java.sql.Timestamp;

/**
 * Created by Michael Crozier on 4/27/2017.
 */
public class AdoptionRequest {
    int id;
    int dateRequested; //timestamps later
    int duration;
    boolean accepted;
    int decisionTime;

    public AdoptionRequest(int i) {
        id = i;
        dateRequested = 0;
        duration = 0;
        accepted = false;
        decisionTime = 0;
    }

    public void remindCustomer(){

    }

    public void remindStaff() {

    }
}
