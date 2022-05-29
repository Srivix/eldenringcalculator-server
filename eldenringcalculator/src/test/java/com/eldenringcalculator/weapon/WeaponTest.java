package com.eldenringcalculator.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.eldenringcalculator.weapon.model.WeaponDto;

@SpringBootTest
@Transactional
public class WeaponTest {

	@Autowired
	private WeaponController weaponController;
	
	@Test
	public void findWeaponListShouldReturnAllWeaponsInDB() {
		
		assertNotNull(weaponController);
		
		long weaponsSize = 48;
		
		List<WeaponDto> weapons = weaponController.get();
		
		assertNotNull(weapons);
		assertEquals(weaponsSize, weapons.size());
		
	}
	
}
