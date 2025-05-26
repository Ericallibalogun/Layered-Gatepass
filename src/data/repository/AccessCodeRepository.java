package data.repository;

import data.models.AccessCode;
import data.models.Resident;

import java.util.List;

public interface AccessCodeRepository {
     AccessCode save(AccessCode code, Resident resident);
     AccessCode findByCode(String code);
     Integer count();
     List<AccessCode> findByStartedDate(String date);
     List<AccessCode> findByExpiryDate(String date);


}
