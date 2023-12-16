package fr.routard.RoutardFilRouge.dao;

public class DAOFactory {
    private static CountryDAO countryDAO;

    public static CountryDAO getCountryDAO() {
        if(countryDAO == null)
            countryDAO = new CountryDAO();

        return countryDAO;
    }
}
