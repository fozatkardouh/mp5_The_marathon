package at.refugeescode.mp5_The_marathon.persistence;

import at.refugeescode.mp5_The_marathon.models.Runner;

import java.util.List;
import java.util.Optional;

public interface RunnerRepository {

    void add(Runner runner);

    List<Runner> returnAllRuners();

    Optional<Runner> returnFastestRunner();

}
