package services;

import data.models.Resident;
import data.repository.ResidentRepository;
import data.repository.Residents;
import dtos.requests.RegisterResidentRequest;
import dtos.responses.RegisterResidentResponse;

public class ResidentServicesImpl implements ResidentServices{
    private ResidentRepository residentRepository = new Residents();

    @Override
    public RegisterResidentResponse register(RegisterResidentRequest request) {
        Resident resident = new Resident();
        resident.setFullName(resident.getFullName());
        resident.setEmail(resident.getEmail());
        resident.setPhoneNumber(resident.getPhoneNumber());
        residentRepository.save(resident);
        return null;
    }
    public RegisterResidentResponse login(RegisterResidentRequest request){
        Resident resident = new Resident();
        resident.setEmail(resident.getEmail());
        residentRepository.save(resident);
        return null;
    }
}
