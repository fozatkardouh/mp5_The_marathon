package at.refugeescode.mp5_The_marathon.endpoints;

import at.refugeescode.mp5_The_marathon.models.Runner;
import at.refugeescode.mp5_The_marathon.persistence.RunnerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping
@RestController
@AllArgsConstructor
public class RunnersEndpoint {

    private final RunnerRepository runnerRepository;

    @GetMapping("/runners")
    public List<Runner> getAllRunners() {
        return runnerRepository.returnAllRuners();
    }

    @PostMapping("/runners")
    public void addRunner(@RequestBody Runner runner) {
        runnerRepository.add(runner);
    }

    @GetMapping("/winner")
    public Optional<Runner> getWinner() {
        return runnerRepository.returnFastestRunner();
    }

}
