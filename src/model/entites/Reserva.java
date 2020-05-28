
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

    public Reserva(Integer numQuarto, Date checkIn, Date checkOut) throws DominioExcecao {
       if (!checkOut.after(checkIn)) {
                throw new DominioExcecao("Data de check-out anterior a data de check-in");
       }
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
    public void atualizacaoReserva (Date checkIn, Date checkOut) throws DominioExcecao{
        Date agora = new Date();
            if (!checkIn.after(agora)|| !checkOut.after(agora)) {
                throw new DominioExcecao("As datas de reserva devem ser datas futuras");
            }
            if (!checkOut.after(checkIn)) {
                throw new DominioExcecao("Data de check-out anterior a data de check-in");
            } else {
                this.checkIn = checkIn;
                this.checkOut = checkOut;
        }
    }
    @Override
    public String toString() {
        return "Reserva: " + "numQuarto: " + numQuarto + ", checkIn: " + sdf.format(checkIn) + ", checkOut: " + sdf.format(checkOut) +", " + duracao() + " noites";
    }

}
