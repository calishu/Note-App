package dev.calishu.noteapp.db;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// import jakarta.annotation.PostConstruct;

@Component
public class Submit {
    @Autowired
    DatabaseRepo repo;

    // @PostConstruct
    public void submitData(String data, Integer date) {
        Database entry = new Database();
        entry.setText(data);
        entry.setDate(date);
        repo.save(entry);

        System.out.println("---- Data submitted to db successfull ----");
    }

    public void updateData(Integer id, String data, Integer date) {
        Optional<Database> optionalEntry = repo.findById(id);
        if (optionalEntry.isPresent()) {
            Database entry = optionalEntry.get();
            entry.setText(data);
            entry.setDate(date);
            repo.save(entry);

            System.out.println("---- Data updated in db successfully ----");
        }
    }

    // @PostConstruct
    public Optional<Database> getData(Integer id) {
        return repo.findById(id);
    }

    public List<Database> getAllIds() {
        return ((Collection<Database>) repo.findAll()).stream()
                .sorted((d1, d2) -> d2.getId().compareTo(d1.getId()))
                .collect(Collectors.toList());
    }

    public void deleteData(Integer id) {
        repo.deleteById(id);
        System.out.println("---- Data deleted from db successfully ----");
    }

}
