package services;

import data.repository.ResidentRepository;
import data.repository.Residents;
import dtos.requests.RegisterResidentRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ResidentServicesImplTest {
    RegisterResidentRequest registerRequest;
    ResidentRepository residentRepository;
    ResidentServices residentServices;
    @BeforeEach
    void setUp() {
        registerRequest = new RegisterResidentRequest();
        residentRepository = new Residents();
        residentServices = new ResidentServicesImpl();
    }
    @Test
    void testRegisterOneResidents_shouldSaveAll() {
        registerRequest.setFullName("Moses Idowu");
        registerRequest.setPassword("121212");
        registerRequest.setAddress("Lagos");
        registerRequest.setPhoneNumber("0704445566");
        registerRequest.setEmail("allieric@gmail.com");
        residentServices.register(registerRequest);
        Assertions.assertEquals(1, residentRepository.count());
    }
    @Test
    public void testRegisterOneResidents_AndLogin(){
        registerRequest.setFullName("Moses Idowu");
        registerRequest.setPassword("121212");
        registerRequest.setAddress("Lagos");
        registerRequest.setPhoneNumber("0704445566");
        registerRequest.setEmail("allieric@gmail.com");
        residentServices.register(registerRequest);
        Assertions.assertEquals(1,residentRepository.count());

        registerRequest.setFullName("Moses Idowu");
        registerRequest.setPassword("121212");
        residentServices.login(registerRequest);
        Assertions.assertEquals(1,residentRepository.count());

    }

}