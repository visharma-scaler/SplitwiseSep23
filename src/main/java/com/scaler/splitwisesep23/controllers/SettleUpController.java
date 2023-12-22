package com.scaler.splitwisesep23.controllers;

import com.scaler.splitwisesep23.dto.*;
import com.scaler.splitwisesep23.dto.ResponseStatus;
import com.scaler.splitwisesep23.services.SettleUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {

    private final SettleUpService settleUpService;

    @Autowired
    public SettleUpController(SettleUpService settleUpService) {
        this.settleUpService = settleUpService;
    }

    public SettleUpUserResponseDto settleUpUser(SettleUpUserRequestDto request) {
        SettleUpUserResponseDto response = new SettleUpUserResponseDto();
        try {
            List<Transaction> transactions = settleUpService.settleUpUser(request.getUserId());
            response.setStatus(ResponseStatus.SUCCESS);
            response.setTransactions(transactions);
        } catch (Exception e) {
            response.setStatus(ResponseStatus.FAILURE);
        }
        return response;
    }

    public SettleUpGroupResponseDto settleUpGroup(SettleUpGroupRequestDto request) {
        SettleUpGroupResponseDto response = new SettleUpGroupResponseDto();
        try {
            List<Transaction> transactions = settleUpService.settleUpGroup(request.getGroupId());
            response.setStatus(ResponseStatus.SUCCESS);
            response.setTransactions(transactions);
        } catch (Exception e) {
            response.setStatus(ResponseStatus.FAILURE);
        }
        return response;
    }
}
