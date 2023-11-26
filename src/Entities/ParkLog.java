package src.Entities;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkLog {
    int idPkLog;
    //LocalDateTime data_emitida, data_entrada, data_saida;
    float valor;

    private static final ArrayList<Integer> idPkLogList = new ArrayList<>();
    private static final AtomicInteger idGenerator = new AtomicInteger(1);
    private int idUser;
    private int idCar;

    public ParkLog(int idPkLog, float valor, int idUser, int idCar) {
        this.idPkLog = idPkLog;
        this.valor = valor;
        this.idUser = idUser;
        this.idCar = idCar;
    }

    public int getIdPkLog() {
        return idPkLog;
    }
    public int getIdP() {
        return idUser;
    }
    public int getIdCar() {
        return idCar;
    }
    public void setIdP(int idP) {
        this.idUser = idP;
    }
    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }


}