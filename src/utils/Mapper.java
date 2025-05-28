package utils;

import data.models.Resident;
import dtos.requests.RegisterResidentRequest;
import dtos.responses.LoginResidentResponse;
import dtos.responses.RegisterResidentResponse;

public class Mapper {


    public static  Resident map (RegisterResidentRequest request){
        Resident resident = new Resident();
        resident.setFullName(request.getFullName());
        resident.setEmail(request.getEmail());
        resident.setPhoneNumber(request.getPhoneNumber());
        resident.setAddress(request.getAddress());
        resident.setPassword(request.getPassword());
        return resident;
    }

    public static RegisterResidentResponse mapRegister(Resident resident){
        return new RegisterResidentResponse("Registered Successfully");
    }
    public static LoginResidentResponse mapLoginResponse(Resident resident){
        return new LoginResidentResponse(resident.getId(), resident.getFullName(),
                "Welcome back " + resident.getFullName() + "! Your ID is " + resident.getId()
        );
    }

}
