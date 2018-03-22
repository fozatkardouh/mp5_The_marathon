package at.refugeescode.mp5_The_marathon.initializer;

import at.refugeescode.mp5_The_marathon.models.Runner;
import at.refugeescode.mp5_The_marathon.persistence.RunnerRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
@AllArgsConstructor
public class Starter {

    private final RunnerRepository runnerRepository;

    @Bean
    public ApplicationRunner starterPoint() {
        return args -> {
            Runner runner1 = new Runner();
            runner1.setName("Fozat");
            Duration duration1 = Duration.ofMinutes(16);
            runner1.setFinishTime(duration1);
            runnerRepository.add(runner1);

            Runner runner2 = new Runner();
            runner2.setName("L");
            Duration duration2 = Duration.ofMinutes(18);
            runner2.setFinishTime(duration2);
            runnerRepository.add(runner2);
        };
    }

}
