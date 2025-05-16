package data.repository;

import data.models.Resident;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
public class ResidentsTest {
   private ResidentRepository residents;
   private Resident resident;

    @BeforeEach
    void setUp() {
       residents = new Residents();
       resident = new Resident();
    }
    @Test
    public void testCountIsZero(){
        assertEquals(0, new Residents().count());
    }
    @Test
    public void testCountIsOne(){
        Resident savedResident = new Resident();
        residents.save(savedResident);
        assertEquals(1, residents.count());
    }
    @Test
    public void testSaveTwoResidents_CountIsTwo(){
        Resident savedResident = new Resident();
        residents.save(savedResident);
        Resident savedResident2 = new Resident();
        residents.save(savedResident2);
        assertEquals(2, residents.count());
    }
    @Test
    public void testFindById_ReturnsResident(){
        Resident savedResident = new Resident();
        residents.save(savedResident);
        assertEquals(savedResident, residents.findById(savedResident.getId()).get());
    }
    @Test
    public void testSaveOneResident_AndUpdate(){
        Resident savedResident = new Resident();
        residents.save(savedResident);

        Resident updatedResident = new Resident();
        updatedResident.setId(savedResident.getId());
        residents.save(updatedResident);
        assertEquals(1, updatedResident.getId());
        assertEquals(1, residents.count());
    }
    @Test
    public void testSaveTwoResidents_AndUpdateAll(){
        Resident firstResident = new Resident();
        residents.save(firstResident);
        assertEquals(1, residents.count());

        Resident secondResident = new Resident();
        secondResident.setId(firstResident.getId());
        residents.save(secondResident);
        assertEquals(1, residents.count());
        assertEquals(1,secondResident.getId());

        Resident thirdResident = new Resident();
        residents.save(thirdResident);
        assertEquals(2, residents.count());

        Resident fourthResident = new Resident();
        fourthResident.setId(thirdResident.getId());
        residents.save(fourthResident);
        assertEquals(2,fourthResident.getId());
        assertEquals(2, residents.count());
    }
    @Test
    public void testThatResidentIsFoundByFullname(){
        Resident resident1 = new Resident();
        resident1.setFullName("Eric Allibalogun");
        residents.save(resident1);


        Resident resident2 = new Resident();
        resident2.setFullName("Monica karma");
        residents.save(resident2);

        assertEquals(resident1, residents.findByFullName("Eric Allibalogun").get());
        assertEquals(resident2, residents.findByFullName("Monica karma").get());
    }
    @Test
    public void testSaveTwoResidents_DeleteOne(){
        Resident firstResident = new Resident();
        residents.save(firstResident);
        assertEquals(1, residents.count());

        Resident secondResident = new Resident();
        residents.save(secondResident);
        assertEquals(2, residents.count());

        residents.deleteById(firstResident.getId());
        assertEquals(1, residents.count());
    }


  
}