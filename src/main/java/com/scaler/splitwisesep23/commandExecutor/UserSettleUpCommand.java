package com.scaler.splitwisesep23.commandExecutor;

import com.scaler.splitwisesep23.controllers.SettleUpController;
import com.scaler.splitwisesep23.dto.SettleUpUserRequestDto;
import com.scaler.splitwisesep23.dto.SettleUpUserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSettleUpCommand implements Command {

    // u1 SettleUp

    private final SettleUpController settleUpController;

    @Autowired
    public UserSettleUpCommand(SettleUpController settleUpController) {
        this.settleUpController = settleUpController;
    }

    @Override
    public boolean matches(String input) {
        String[] words = input.split(" ");
        return words.length == 2 && words[1].equalsIgnoreCase("SettleUp");
    }

    @Override
    public void execute(String input) {
        String[] words = input.split(" ");
        Long userId = Long.valueOf(words[0]);

        SettleUpUserRequestDto request = new SettleUpUserRequestDto();
        request.setUserId(userId);

        SettleUpUserResponseDto response = settleUpController.settleUpUser(request);

        System.out.println(response.getStatus());
    }
}
