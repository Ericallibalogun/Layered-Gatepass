package data.repository;

import data.models.Resident;


import java.util.List;
import java.util.Optional;

public interface ResidentRepository  {
    List<Resident> getResident();
    Resident save(Resident resident);
    Optional<Resident> findById(int id);
    Optional<Resident> findByFullName(String fullName);
    List<Resident> findAll();
    int count();
    void deleteAll();
    void deleteById(int id);
    void delete(Resident resident);
    Resident findByEmail(String resident);
    Resident findByPhoneNumber(String phoneNumber);
}