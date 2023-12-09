package projectuas.bookingticketmovie.service.impl;

import org.springframework.stereotype.Service;
import projectuas.bookingticketmovie.data.entity.Auditorium;
import projectuas.bookingticketmovie.data.repository.AuditoriumRepository;
import projectuas.bookingticketmovie.service.AuditoriumService;

import java.util.List;

@Service
public class AuditoriumServiceImpl implements AuditoriumService {

    private AuditoriumRepository auditoriumRepository;

    public AuditoriumServiceImpl(AuditoriumRepository auditoriumRepository) {
        this.auditoriumRepository = auditoriumRepository;
    }

    @Override
    public List<Auditorium> getAllAuditoriums() {
        List<Auditorium> auditoriumList = auditoriumRepository.findAll();
        return auditoriumList;
    }

    @Override
    public Auditorium getAuditoriumById(Long auditorium_id) {
        return auditoriumRepository.findById(auditorium_id).orElse(null);
    }

    @Override
    public Auditorium pushAuditorium(Auditorium newAuditorium) {
        return auditoriumRepository.save(newAuditorium);
    }

    @Override
    public Auditorium updateAuditorium(Auditorium updatedAuditorium, Long auditorium_id) {
        return auditoriumRepository.findById(auditorium_id).map(auditorium -> {
            auditorium.setSeats(updatedAuditorium.getSeats());
            auditorium.setSeatCount(updatedAuditorium.getSeatCount());
            auditorium.setScreenings(updatedAuditorium.getScreenings());
            return auditoriumRepository.save(auditorium);
        }).orElse(null);
    }

    @Override
    public void deleteAuditoriumById(Long auditorium_id) {
        auditoriumRepository.deleteById(auditorium_id);
    }
}
