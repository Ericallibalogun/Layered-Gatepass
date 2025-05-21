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
        resident.setFullName(request.getFullName());
        resident.setEmail(request.getEmail());
        resident.setPhoneNumber(request.getPhoneNumber());
        resident.setAddress(request.getAddress());
        resident.setPassword(request.getPassword());
        residentRepository.save(resident);
        return null;
    }
    public RegisterResidentResponse login(RegisterResidentRequest request){
        Resident resident = new Resident();
        resident.setFullName(request.getFullName());
        resident.setPassword(request.getPassword());
        residentRepository.save(resident);
        return null;
    }
    private boolean residentIsPresent(RegisterResidentRequest request){
        for(Resident residents : residentRepository.getResident()){
            return residents.equals(request);
        }
        return true;
    }
}
