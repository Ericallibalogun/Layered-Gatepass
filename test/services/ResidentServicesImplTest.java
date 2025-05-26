package services;

import data.repository.ResidentRepository;
import data.repository.Residents;
import dtos.requests.RegisterResidentRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertEquals(1, residentRepository.count());
    }
    @Test
    public void testRegisterOneResidents_AndLogin(){
        registerRequest.setFullName("Moses Idowu");
        registerRequest.setPassword("121212");
        registerRequest.setAddress("Lagos");
        registerRequest.setPhoneNumber("0704445566");
        registerRequest.setEmail("allieric71@gmail.com");
        residentServices.register(registerRequest);
        assertEquals(1,residentRepository.count());

        registerRequest.setFullName("Moses Idowu");
        registerRequest.setPassword("121212");
        residentServices.login(registerRequest);
    }
    @Test
    public void testRegisterTwoResidentsWithTheSameEmail_ThrowErrorMessage(){
        registerRequest.setFullName("Eric Allibalogun");
        registerRequest.setPassword("123456");
        registerRequest.setAddress("Abuja");
        registerRequest.setPhoneNumber("07066527323");
        registerRequest.setEmail("allieric71@gmail.com");
        residentServices.register(registerRequest);

        registerRequest.setFullName("Alade Amidat");
        registerRequest.setPassword("546363");
        registerRequest.setAddress("ikeja");
        registerRequest.setPhoneNumber("172866454287");
        registerRequest.setEmail("allieric71@gmail.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> residentServices.register(registerRequest));
        String expectedMessage = "Email has already been used";
        assertEquals(expectedMessage,exception.getMessage());
    }
    @Test
    public void testRegisterTwoResidentsWithTheSamePhoneNumber_ThrowErrorMessage(){
        registerRequest.setFullName("Eric Allibalogun");
        registerRequest.setPassword("123456");
        registerRequest.setAddress("Abuja");
        registerRequest.setPhoneNumber("07066527323");
        registerRequest.setEmail("allieric1@gmail.com");
        residentServices.register(registerRequest);

        registerRequest.setFullName("Alade Amidat");
        registerRequest.setPassword("546363");
        registerRequest.setAddress("ikeja");
        registerRequest.setPhoneNumber("07066527323");
        registerRequest.setEmail("allieric71@gmail.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> residentServices.register(registerRequest));
        String expectedMessage = "Phone number is already used";
        assertEquals(expectedMessage,exception.getMessage());

    }

}