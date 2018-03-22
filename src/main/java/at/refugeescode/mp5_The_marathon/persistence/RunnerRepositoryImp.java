package at.refugeescode.mp5_The_marathon.persistence;

import at.refugeescode.mp5_The_marathon.models.Runner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class RunnerRepositoryImp implements RunnerRepository {

    private List<Runner> repository = new ArrayList<>();

    @Override
    public void add(Runner runner) {
        repository.add(runner);
    }

    @Override
    public List<Runner> returnAllRuners() {
        return new ArrayList<>(repository);
    }

    @Override
    public Optional<Runner> returnFastestRunner() {
        return repository.stream().min(Comparator.comparing(Runner::getFinishTime));
    }

}
