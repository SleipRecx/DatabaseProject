package model;

import controller.Main;

import java.sql.Connection;

/**
 * Created by eddern on 15/03/16.
 */
public class Result {
    protected int result_id;
    protected int exercise_id_fk;
    protected int training_session_id_fk;
    protected Connection myConnection = Main.getDB().getConnection();

    public Result()

    public int getResult_id() {
        return result_id;
    }

    public void setResult_id(int result_id) {
        this.result_id = result_id;
    }

    public int getExercise_id_fk() {
        return exercise_id_fk;
    }

    public void setExercise_id_fk(int exercise_id_fk) {
        this.exercise_id_fk = exercise_id_fk;
    }

    public int getTraining_session_id_fk() {
        return training_session_id_fk;
    }

    public void setTraining_session_id_fk(int training_session_id_fk) {
        this.training_session_id_fk = training_session_id_fk;
    }



}
