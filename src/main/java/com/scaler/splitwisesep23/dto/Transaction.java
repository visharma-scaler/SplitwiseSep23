package com.scaler.splitwisesep23.dto;

import com.scaler.splitwisesep23.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    // A -> B = Rs. 100;

    private User payer;
    private User receiver;
    private int amount;
}
