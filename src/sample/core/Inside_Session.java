package sample.core;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Inside_Session  extends  Session{

    public static final String VENTILATION_FIELD_NAME = "ventilation";

    public static final String SPECTATORS_FIELD_NAME = "spectators";

    private String ventilation;

    private int spectators;

    public Inside_Session(Date date, int duration, int spectators, String ventilation) {
        super(date, duration);
        this.spectators = spectators;
        this.ventilation = ventilation;

    }

    public void storeInsideSession(){
        try {
            Statement statement = myConnection.createStatement();
            String sql = String.format("hello");
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
