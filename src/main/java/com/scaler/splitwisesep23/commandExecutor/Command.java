package com.scaler.splitwisesep23.commandExecutor;

public interface Command {
    boolean matches(String input);

    void execute(String input);
}
