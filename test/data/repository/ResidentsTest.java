package data.repository;

import data.models.Resident;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class ResidentsTest {
   private Residents residents;
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
        assertEquals(1, residents.count());

        Resident updatedResident = new Resident();
        residents.save(updatedResident);
        updatedResident.setId(savedResident.getId());

        assertEquals(1, residents.findById(updatedResident.getId()))                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                .get();
        assertEquals(1, residents.count());
    }



  
}