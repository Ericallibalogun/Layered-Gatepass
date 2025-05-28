package data.repository;

import data.models.AccessCode;
import data.models.Resident;

import java.util.List;
import java.util.Optional;

public interface AccessCodeRepository {
     AccessCode save(AccessCode code, Resident resident);
     Integer count();
     List<AccessCode> findByCreatedDate(String date);
     List<AccessCode> findByExpiryDate(String date);
     List<AccessCode> findByUseDate(String date);
     List<AccessCode> findAllByToken();
     List<AccessCode> findAll();
     List<AccessCode> findById(int id);
     Optional<AccessCode> findByToken(int id);
     List<AccessCode> findByResident(Resident resident);




}
