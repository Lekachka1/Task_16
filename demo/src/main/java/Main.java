import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
public class Main {
    private static String cookie;
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();

    public void get(){
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String GET = "http://94.198.50.185:7081/api/users";

        ResponseEntity<String> result = restTemplate.exchange(GET, HttpMethod.GET, entity, String.class);

        cookie = result.getHeaders().getFirst("Set-Cookie");

        System.out.println(result);
    }

    public void create() {
        User user = new User(3L, "James", "Brown", (byte) 36);

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Cookie", cookie);

        HttpEntity<User> entity = new HttpEntity<>(user, headers);

        String POST = "http://94.198.50.185:7081/api/users";

        ResponseEntity<String> result = restTemplate.exchange(POST, HttpMethod.POST, entity, String.class);

        System.out.println(result.getBody());
    }

    public void update(){

        User user1 = new User(3L, "Thomas", "Shelby", (byte) 36);

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        headers.set("Cookie",cookie);

        HttpEntity<User> entity = new HttpEntity<User>(user1, headers);

        String PUT = "http://94.198.50.185:7081/api/users";

        ResponseEntity<String> result = restTemplate.exchange(PUT, HttpMethod.PUT, entity, String.class);

        System.out.println(result.getBody());
    }

    public void delete(){

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        headers.set("Cookie",cookie);

        HttpEntity<User> entity = new HttpEntity<User>(headers);

        String DELETE = "http://94.198.50.185:7081/api/users/3";

        ResponseEntity<String> result = restTemplate.exchange(DELETE, HttpMethod.DELETE, entity, String.class);

        System.out.println(result.getBody());
    }
    public static void main(String[] args) {

        Main main = new Main();
        main.get();
        main.create();
        main.update();
        main.delete();
    }
}


