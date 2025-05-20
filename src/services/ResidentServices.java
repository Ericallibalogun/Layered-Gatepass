package services;

import dtos.requests.RegisterResidentRequest;
import dtos.responses.RegisterResidentResponse;



public interface ResidentServices {
    RegisterResidentResponse register(RegisterResidentRequest request);
    RegisterResidentResponse login(RegisterResidentRequest request);
}
