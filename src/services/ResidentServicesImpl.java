package services;

import data.models.Resident;
import data.repository.ResidentRepository;
import data.repository.Residents;
import dtos.requests.LoginResidentRequest;
import dtos.requests.RegisterResidentRequest;
import dtos.responses.LoginResidentResponse;
import dtos.responses.RegisterResidentResponse;
import utils.Mapper;


public class ResidentServicesImpl implements ResidentServices{
    private ResidentRepository residentRepository = new Residents();



    @Override
    public RegisterResidentResponse register(RegisterResidentRequest request) {
        verifyIfEmailExist(request.getEmail());
        verifyPhoneNumber(request.getPhoneNumber());

        Resident resident = Mapper.map(request);
        residentRepository.save(resident);

        return Mapper.mapRegister(resident);
    }
    public LoginResidentResponse login(LoginResidentRequest request) {
        Resident resident = residentRepository.findByEmail(request.getEmail());

        boolean residentIsNull = resident == null;
        if (residentIsNull) throw new RuntimeException("User not found");

        boolean passwordIsNotFound = !resident.getPassword().equals(request.getPassword());
        if (passwordIsNotFound) throw new RuntimeException("Invalid password");

        return Mapper.mapLoginResponse(resident);
    }

    private void verifyIfEmailExist(String email) {
        Resident emailExists = residentRepository.findByEmail(email);
        if (emailExists != null) throw new IllegalArgumentException("Email has already been used");
    }
    private void verifyPhoneNumber(String phoneNumber){
        Resident phoneExist = residentRepository.findByPhoneNumber(phoneNumber);
        if (phoneExist != null) throw new IllegalArgumentException("Phone number is already used");
    }
}
