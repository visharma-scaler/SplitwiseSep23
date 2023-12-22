package com.scaler.splitwisesep23;

import com.scaler.splitwisesep23.commandExecutor.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;

@EnableJpaAuditing
@SpringBootApplication
public class SplitwiseSep23Application implements CommandLineRunner {

    private final Scanner scanner = new Scanner(System.in);
    private final CommandExecutor commandExecutor;

    @Autowired
    public SplitwiseSep23Application(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            String input = scanner.nextLine();
            commandExecutor.execute(input);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseSep23Application.class, args);
    }

}
