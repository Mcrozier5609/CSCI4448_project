package com.petget.app;

import java.sql.Timestamp;

/**
 * Created by Michael Crozier on 4/27/2017.
 */
public class AdoptionRequest {
    int id;
    Timestamp dateRequested;
    Timestamp duration;
    boolean accepted;
    Timestamp decisionTime;

    public void remindCustomer(){

    }

    public void remindStaff() {

    }
}
