package at.refugeescode.mp5_The_marathon.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Data
@NoArgsConstructor
public class Runner {

    private String name;
    private Duration finishTime;

}
