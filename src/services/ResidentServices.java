package services;

import dtos.requests.LoginResidentRequest;
import dtos.requests.RegisterResidentRequest;
import dtos.responses.LoginResidentResponse;
import dtos.responses.RegisterResidentResponse;



public interface ResidentServices {
    RegisterResidentResponse register(RegisterResidentRequest request);
    LoginResidentResponse login(LoginResidentRequest request);
}
