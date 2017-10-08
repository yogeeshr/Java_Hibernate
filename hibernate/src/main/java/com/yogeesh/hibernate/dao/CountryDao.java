package com.yogeesh.hibernate.dao;

import com.yogeesh.hibernate.EntityFactory.EntityFactory;
import com.yogeesh.hibernate.entities.RiverCountryEntity;

import java.math.BigDecimal;

/**
 * Created by yogeesh.srkvs@gmail.com on 9/18/17.
 */
public class CountryDao {


    /**
     * Create country
     * @param populationCount
     * @param countryCode
     * @param countryName
     * @param area
     */
    public static boolean create(long populationCount, String countryCode, String countryName, BigDecimal area) {

        RiverCountryEntity country_entity = new RiverCountryEntity();

        country_entity.setPopulation(populationCount);
        country_entity.setCountryCode(countryCode.toUpperCase());
        country_entity.setName(countryName);
        country_entity.setAreaKm2(area);

        boolean isCountryCreated = EntityFactory.create(country_entity);
        EntityFactory.closeEntityManager();

        return isCountryCreated;

    }

    /**
     * Method to delete country in DB Table
     * @param countryCode
     * @return
     */
    public static boolean delete(String countryCode) {

        RiverCountryEntity countryEntity = new RiverCountryEntity();
        countryEntity.setCountryCode(countryCode.toUpperCase());

        boolean isCountryDeleted = EntityFactory.getAndDeleteCountry("SL");

        System.out.println(isCountryDeleted);

        return isCountryDeleted;

    }

    // Main method to test create
    public static void main(String[] args) {
        // create(1000000, "SL", "Sri Lanka", new BigDecimal(65610));
        // delete("SL");

    }

}
