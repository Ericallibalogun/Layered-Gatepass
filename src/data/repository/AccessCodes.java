package data.repository;

import data.models.AccessCode;
import data.models.Resident;

import java.util.List;

public class AccessCodes implements AccessCodeRepository{

    @Override
    public AccessCode save(AccessCode code, Resident resident) {
        return null;
    }

    @Override
    public AccessCode findByCode(String code) {
        return null;
    }

    @Override
    public Integer count() {
        return 0;
    }

    @Override
    public List<AccessCode> findByStartedDate(String date) {
        return List.of();
    }

    @Override
    public List<AccessCode> findByExpiryDate(String date) {
        return List.of();
    }
}
