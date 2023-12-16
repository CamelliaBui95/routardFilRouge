package fr.routard.RoutardFilRouge.dao;

import fr.routard.RoutardFilRouge.metier.Continent;
import fr.routard.RoutardFilRouge.metier.Country;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CountryDAO extends DAO<Country, Country> {
    @Override
    public ArrayList<Country> getAll() {
        ArrayList<Country> countries = new ArrayList<>();
        String req = "{call ps_searchCountry}";
        try {
            CallableStatement stm = connection.prepareCall(req);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                String continentCode = rs.getString("CODE_CONTINENT");
                String continentName = rs.getString("NOM_CONTINENT");
                Continent continent = new Continent(continentCode, continentName);

                String countryCode = rs.getString("CODE_PAYS");
                String countryName = rs.getString("NOM_PAYS");
                Country country = new Country(countryCode,countryName,continent);
                countries.add(country);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return countries;
    }
}
