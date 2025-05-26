package data.repository;

import data.models.Resident;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Residents implements ResidentRepository{

    private static List<Resident> residents = new ArrayList<>();
    private int counter = 0;

    public static void reset() {
        residents.clear();
    }


    @Override
    public List<Resident> getResident() {
        return List.of();
    }

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
        return ++counter;

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
        for(Resident resident : residents){
            if(resident.getFullName().equals(fullName)){
                return Optional.of(resident);
            }
        }
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
        residents.clear();

    }

    @Override
    public void deleteById(int id) {
        if(findById(id).isPresent()) residents.remove(findById(id).get());
    }

    @Override
    public void delete(Resident resident) {

    }

    @Override
    public Resident findByEmail(String email) {
        for(Resident residentEmail : residents){
            if(residentEmail.getEmail().contains(email)) return residentEmail;
        }
        return null;
    }

    @Override
    public Resident findByPhoneNumber(String phoneNumber) {
        for(Resident residentPhone : residents){
            if(residentPhone.getPhoneNumber().contains(phoneNumber)) return residentPhone;
        }
        return null;
    }

}