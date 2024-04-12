package ch.kunz.joshua.flugbuchungsapi.hello;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class HelloDataService {

    private HelloDataRepository helloDataRepository;

    public HelloDataService(HelloDataRepository helloDataRepository) {
        this.helloDataRepository = helloDataRepository;
    }

    public List<HelloData> findAll() {
        return helloDataRepository.findAll();
    }

    public Optional<HelloData> findById(long id) {
        return helloDataRepository.findById(id);
    }

    public HelloData save(HelloData helloData) {
        return helloDataRepository.save(helloData);
    }

    public void delete(long id) {
        helloDataRepository.deleteById(id);
    }
}
