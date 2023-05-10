package LR6.service;

import jakarta.jws.WebService;
import LR6.entity.Phonetics;

import java.util.List;

@WebService
public interface PhoneticsService {
    List<Phonetics> getAll();
    List<Phonetics> getByPerformer(String performer);
    List<Phonetics> getByAlbum(String album);
}
