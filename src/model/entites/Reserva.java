
package model.entites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer numQuarto;
    private Date checkIn;
    private Date checkOut;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
   
    public Reserva(){
        
    }

    public Reserva(Integer numQuarto, Date checkIn, Date checkOut) {
        this.numQuarto = numQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(Integer numQuarto) {
        this.numQuarto = numQuarto;
    }

    public Date getCheckIn() {
        return checkIn;
    }
    public Date getCheckOut() {
        return checkOut;
    }
    public long duracao(){
        long dif = checkOut.getTime()-checkIn.getTime();
        return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
    }
    public String atualizacaoReserva(Date checkIn, Date checkOut){
        Date agora = new Date();
            if (!checkIn.after(agora)|| !checkOut.after(agora)) {
                return "Erro de reserva: as datas de reserva devem ser datas futuras";
            }
            if (!checkOut.after(checkIn)) {
                return "Erro na reserva: data de check-out anterior a data de check-in";
            } else {
                this.checkIn = checkIn;
                this.checkOut = checkOut;
                return null;
        }
    }
    @Override
    public String toString() {
        return "Reserva: " + "numQuarto: " + numQuarto + ", checkIn: " + sdf.format(checkIn) + ", checkOut: " + sdf.format(checkOut) +", " + duracao() + " noites";
    }

}
