package ch.kunz.joshua.flugbuchungsapi.hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HelloDataController {

    private HelloDataService helloDataService;

    public HelloDataController(HelloDataService helloDataService) {
        this.helloDataService = helloDataService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @GetMapping("/api/hello")
    public ResponseEntity<List<HelloData>> apiHello() {
        return new ResponseEntity<>(helloDataService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/api/hello")
    public ResponseEntity<HelloData> apiHello(@RequestBody HelloData helloData) {
        return new ResponseEntity<>(helloDataService.save(helloData), HttpStatus.CREATED);
    }

    @GetMapping("/api/hello/{id}")
    public ResponseEntity<Optional<HelloData>> apiHelloId(@PathVariable Long id) {
        return new ResponseEntity<>(helloDataService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/api/hello/{id}")
    public ResponseEntity<HelloData> apiHelloUpdate(@PathVariable Long id, @RequestBody HelloData helloData) {
        helloData.setId(id);
        return new ResponseEntity<>(helloDataService.save(helloData), HttpStatus.OK);
    }

    @DeleteMapping("/api/hello/{id}")
    public ResponseEntity<HelloData> apiHelloDelete(@PathVariable Long id) {
        helloDataService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
