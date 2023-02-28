package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetAdministrator {
    private String DbUrl;
    private String DbUser;
    private String DbPassword;

    public PetAdministrator(String dbUrl, String dbUser, String dbPassword) {
        DbUrl = dbUrl;
        DbUser = dbUser;
        DbPassword = dbPassword;
    }

    public List<Owner> getOwnersWhoCanAdoptPets() {
        final String SQL = """
                SELECT o.name, city, max_number_of_pets, count(*) as current_pets 
                from owners o 
                left join pets p on o.name = p.current_owner 
                group by o.name, city, max_number_of_pets 
                having count(*) < max_number_of_pets;
                """;

        try(Connection con = DriverManager.getConnection(DbUrl,DbUser,DbPassword)){
            PreparedStatement st = con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();

            List<Owner> owners = new ArrayList<>();

            while (rs.next()){
                Owner owner = new Owner();
                owner.setName(rs.getString(1));
                owner.setCity(rs.getString(2));
                owner.setMax_number_of_pets(rs.getInt(3));

                owners.add(owner);
            }
            return owners;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Owner getOwnerWithMostPets() {
        final String SQL = """
                SELECT o.name, city, max_number_of_pets, count(*) as current_pets 
                from owners o 
                left join pets p 
                    on o.name = p.current_owner 
                group by o.name, city, max_number_of_pets 
                order by current_pets desc 
                limit 1;
                """;

        try(Connection con = DriverManager.getConnection(DbUrl,DbUser,DbPassword)){
            PreparedStatement st = con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();
            Owner owner = new Owner();
            while (rs.next()){
                owner.setName(rs.getString(1));
                owner.setCity(rs.getString(2));
                owner.setMax_number_of_pets(rs.getInt(3));

            }
            return owner;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Pet> getPetsOrderedByAgeDesc() {
        final String SQL = """
                SELECT name, species, age, current_owner 
                from pets  
                order by age desc;
                """;

        try(Connection con = DriverManager.getConnection(DbUrl,DbUser,DbPassword)){
            PreparedStatement st = con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();
            List<Pet> pets = new ArrayList<>();
            while (rs.next()){
                Pet pet = new Pet();
                pet.setName(rs.getString(1));
                pet.setSpecies(rs.getString(2));
                pet.setAge(rs.getInt(3));
                pet.setCurrent_owner(rs.getString(4));
                pets.add(pet);

            }
            return pets;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Pet> getPetsOfOwner(Owner owner) {
        final String SQL = """
                SELECT name, species, age, current_owner 
                from pets 
                where current_owner = ?;
                """;

        try(Connection con = DriverManager.getConnection(DbUrl,DbUser,DbPassword)){
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1,owner.getName());
            ResultSet rs = st.executeQuery();
            List<Pet> pets = new ArrayList<>();
            while (rs.next()){
                Pet pet = new Pet();
                pet.setName(rs.getString(1));
                pet.setSpecies(rs.getString(2));
                pet.setAge(rs.getInt(3));
                pet.setCurrent_owner(rs.getString(4));
                pets.add(pet);

            }
            return pets;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
