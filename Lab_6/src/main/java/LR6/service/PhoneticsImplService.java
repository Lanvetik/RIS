package LR6.service;

import LR6.entity.Phonetics;
import jakarta.jws.WebService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebService(endpointInterface = "LR6.service.PhoneticsService")
public class PhoneticsImplService implements PhoneticsService {
    private final List<Phonetics> phonetics;
    private long id;

    public PhoneticsImplService() {
        phonetics = new ArrayList<>();
        phonetics.add(new Phonetics(1, "Исполнитель 1", "Альбом 1"));
        phonetics.add(new Phonetics(2, "Исполнитель 2", "Альбом 2"));
        phonetics.add(new Phonetics(3, "Исполнитель 3", "Альбом 3"));
        phonetics.add(new Phonetics(3, "Исполнитель 4", "Альбом 4"));
    }

    @Override
    public List<Phonetics> getAll() {
        return phonetics;
    }

    @Override
    public List<Phonetics> getByPerformer(String performer) {
        return phonetics
                .stream()
                .filter(phonetics -> phonetics.getPerformer().toLowerCase().contains(performer.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Phonetics> getByAlbum(String album) {
        return phonetics
                .stream()
                .filter(phonetics -> phonetics.getAlbum().equals(album))
                .collect(Collectors.toList());
    }
}