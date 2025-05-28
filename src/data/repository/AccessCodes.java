package data.repository;

import data.models.AccessCode;
import data.models.Resident;

import java.util.List;
import java.util.Optional;

public class AccessCodes implements AccessCodeRepository{


    @Override
    public AccessCode save(AccessCode code, Resident resident) {
        return null;
    }

    @Override
    public Integer count() {
        return 0;
    }

    @Override
    public List<AccessCode> findByCreatedDate(String date) {
        return List.of();
    }

    @Override
    public List<AccessCode> findByExpiryDate(String date) {
        return List.of();
    }

    @Override
    public List<AccessCode> findByUseDate(String date) {
        return List.of();
    }

    @Override
    public List<AccessCode> findAllByToken() {
        return List.of();
    }

    @Override
    public List<AccessCode> findAll() {
        return List.of();
    }

    @Override
    public List<AccessCode> findById(int id) {
        return List.of();
    }

    @Override
    public Optional<AccessCode> findByToken(int id) {
        return Optional.empty();
    }

    @Override
    public List<AccessCode> findByResident(Resident resident) {
        return List.of();
    }
}
