package at.refugeescode.mp5_The_marathon.endpoints;

import at.refugeescode.mp5_The_marathon.models.Runner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class RunnersEndpointTest {

    @Test
    void getAllRunners() {
        List<Runner> expected = new ArrayList<>();

        Runner runner1 = new Runner();
        runner1.setName("Fozat");
        Duration duration1 = Duration.ofMinutes(16);
        runner1.setFinishTime(duration1);
        expected.add(runner1);

        Runner runner2 = new Runner();
        runner2.setName("L");
        Duration duration2 = Duration.ofMinutes(18);
        runner2.setFinishTime(duration2);
        expected.add(runner2);

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/runners";

        ResponseEntity<Runner[]> response = restTemplate.getForEntity(url, Runner[].class);
        List<Runner> result = Arrays.asList(response.getBody());

        Assertions.assertEquals(expected, result);
    }

    @Test
    void addRunner() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/runners";

        ResponseEntity<Runner[]> response1 = restTemplate.getForEntity(url, Runner[].class);
        List<Runner> resultBefore = Arrays.asList(response1.getBody());
        int sizeBefore = resultBefore.size();

        Runner newRunner = new Runner();
        newRunner.setName("Yazan");
        Duration duration = Duration.ofMinutes(17);
        newRunner.setFinishTime(duration);

        ResponseEntity<Runner> addedRunner= restTemplate.postForEntity(url, newRunner, Runner.class);

        ResponseEntity<Runner[]> response2 = restTemplate.getForEntity(url, Runner[].class);
        List<Runner> resultAfter = Arrays.asList(response2.getBody());
        int sizeAfter = resultAfter.size();

        Assertions.assertEquals(sizeAfter, sizeBefore + 1);
    }

    @Test
    void getWinner() {
        Runner expected = new Runner();
        expected.setName("Fozat");
        Duration duration1 = Duration.ofMinutes(16);
        expected.setFinishTime(duration1);

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/winner";

        ResponseEntity<Runner> response = restTemplate.getForEntity(url, Runner.class);
        Runner result = response.getBody();

        Assertions.assertEquals(expected, result);
    }

}