package kz.bitlab.g130springjdbc.service;

import kz.bitlab.g130springjdbc.entity.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final Connection connection;

    public List<Country> getAllCountries() {
        List<Country> countries = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM countries");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Country country = new Country();
                country.setId(resultSet.getLong("id"));
                country.setName(resultSet.getString("name"));
                country.setCode(resultSet.getString("code"));
                countries.add(country);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }

    public void addCountry(Country country) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO countries(NAME, CODE) VALUES (?, ?)"
            );
            statement.setString(1, country.getName());
            statement.setString(2, country.getCode());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editCountry(Country country) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE countries SET name = ?, code = ? WHERE id = ?"
            );
            statement.setString(1, country.getName());
            statement.setString(2, country.getCode());
            statement.setLong(3, country.getId());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Country getCountryById(Long id) {
        Country country = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM countries WHERE id = ?"
            );
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                country = new Country();
                country.setId(resultSet.getLong("id"));
                country.setName(resultSet.getString("name"));
                country.setCode(resultSet.getString("code"));
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }

    public void deleteCountryById(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM countries WHERE id = ?"
            );
            statement.setLong(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
