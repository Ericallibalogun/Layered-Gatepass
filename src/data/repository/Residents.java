package data.repository;

import data.models.Resident;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Residents implements ResidentRepository{

    private List<Resident> residents = new ArrayList<>();


    @Override
    public Resident save(Resident resident) {
        if(isNew(resident)) saveNew(resident); else update(resident);
        return resident;

    }

    private void update(Resident resident) {
        for(int i = 0; i < residents.size(); i++){
            if(residents.get(i).getId() == resident.getId()){
                residents.set(i, resident);
            }
        }

    }

    private void saveNew(Resident resident) {
        resident.setId(generateId());
        residents.add(resident);
    }

    private boolean isNew(Resident resident) {
        return resident.getId() == 0;
    }

    private int generateId() {
        return 1;
    }

    @Override
    public Optional<Resident> findById(int id) {
        for (Resident resident : residents) {
            if(resident.getId() == id){
                return Optional.of(resident);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Resident> findByFullName(String fullName) {
        return Optional.empty();
    }

    @Override
    public List<Resident> findAll() {
        return List.of();
    }

    @Override
    public int count() {
        return residents.size();
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteById(int id) {

    }
}
