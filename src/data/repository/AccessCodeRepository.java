package data.repository;

import data.models.AccessCode;

public interface AccessCodeRepository {
    public AccessCode save(AccessCode code);
    public AccessCode findByCode(String code);
}
