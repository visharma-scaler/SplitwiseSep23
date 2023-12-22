package com.scaler.splitwisesep23.commandExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {

    private final List<Command> commands = new ArrayList<>();

    @Autowired
    public CommandExecutor(UserSettleUpCommand userSettleUpCommand,
                           ExitCommand exitCommand) {
        this.add(userSettleUpCommand);
        this.add(exitCommand);
    }


    public void add(Command command) {
        commands.add(command);
    }

    public void remove(Command command) {
        commands.remove(command);
    }


    public void execute(String input) {
        commands.stream()
                .filter(command -> command.matches(input))
                .findFirst()
                .ifPresent(command -> command.execute(input));


//        for(Command command: commands) {
//            if (command.matches(input)) {
//                command.execute(input);
//                break;
//            }
//        }
    }
}
