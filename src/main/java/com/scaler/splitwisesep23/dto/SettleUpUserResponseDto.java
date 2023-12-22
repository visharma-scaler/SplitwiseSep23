package com.scaler.splitwisesep23.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpUserResponseDto {
    private ResponseStatus status;
    private List<Transaction> transactions;
}
