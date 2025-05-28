package services;

import data.models.Resident;
import data.repository.ResidentRepository;
import data.repository.Residents;
import dtos.requests.LoginResidentRequest;
import dtos.requests.RegisterResidentRequest;
import dtos.responses.LoginResidentResponse;
import dtos.responses.RegisterResidentResponse;



public class ResidentServicesImpl implements ResidentServices{
    private ResidentRepository residentRepository = new Residents();
    Resident resident = new Resident();


    @Override
    public RegisterResidentResponse register(RegisterResidentRequest request) {
        resident.setFullName(request.getFullName());
        resident.setEmail(request.getEmail());
        resident.setPhoneNumber(request.getPhoneNumber());
        resident.setAddress(request.getAddress());
        resident.setPassword(request.getPassword());
        verifyIfEmailExist(request.getEmail());
        verifyPhoneNumber(request.getPhoneNumber());
        residentRepository.save(resident);
        return new RegisterResidentResponse("Registration successful!");
    }
    public LoginResidentResponse login(LoginResidentRequest request) {
        Resident resident = residentRepository.findByEmail(request.getEmail());
        boolean residentIsEmpty = resident == null;
        if (residentIsEmpty) throw new RuntimeException("User not found");

        boolean passwordIsNotFound = !resident.getPassword().equals(request.getPassword());
        if (passwordIsNotFound) throw new RuntimeException("Invalid password");

        return new LoginResidentResponse(resident.getId(), resident.getFullName(),
                "Welcome back " + resident.getFullName() + "! Your ID is " + resident.getId()
        );
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
