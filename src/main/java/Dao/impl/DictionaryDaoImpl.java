package Dao.impl;

import Dao.DictionaryDao;
import data.Database;
import model.Translate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Andrey Volinskiy on 09.02.2018.
 */
public class DictionaryDaoImpl implements DictionaryDao {

    public static final String GET = "SELECT * FROM table_dictionary";

    @Override
    public List<Translate> getList() {
        List<Translate> list = new LinkedList<>();

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Translate translate = new Translate();
                translate.setEng(resultSet.getString("eng"));
                translate.setUkr(resultSet.getString("ukr"));
                list.add(translate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
