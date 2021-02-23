package hello;

import java.beans.*;
import java.io.Serializable;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class MessageBean implements Serializable {
     
    private String msg;
    private String msg2;
    private String img;
    
        
    public MessageBean() {
    }
    
    public String getMsg() {
        return msg;
    }
    public String getMsg2() {
        return msg2;
    }
    public String getImg() {
        return img;
    }
    
    public void setMsg(String value) {
        switch (value){
            case "":
            case "pt":
                msg = "Alô";
                break;
            case "en":
                msg = "Hello";
                break;
            case "de":
                msg = "Hallo";
                break;
            case "fr":
                msg = "Bonjour";
                break;
        }
    }
    public void setMsg2(String local){
        ZoneId tz_SP = ZoneId.of("America/Sao_Paulo");
        ZoneId tz_NY = ZoneId.of("America/New_York");
        ZoneId tz_FR = ZoneId.of("Europe/Paris");
        ZoneId tz_DE = ZoneId.of("Europe/Berlin");

        ZonedDateTime agoraSP = ZonedDateTime.now(tz_SP);
        ZonedDateTime agoraNY = ZonedDateTime.now(tz_NY);
        ZonedDateTime agoraParis = ZonedDateTime.now(tz_FR);
        ZonedDateTime agoraBerlin = ZonedDateTime.now(tz_DE);

        int horaSP = agoraSP.getHour();
        int horaNY = agoraNY.getHour();
        int horaFR = agoraParis.getHour();
        int horaDE = agoraBerlin.getHour();
        
        switch(local){
            case "pt":
                if(horaSP>=6 && horaSP<12){
                    msg2 = "Bom dia!";
                    img = "<img src=img/dia.jpg alt=Minha Figura>";
                }
                else if(horaSP>=12 && horaSP<18){
                    msg2 = "Boa tarde!";
                    img = "<img src=img/tarde.jpg alt=Minha Figura>";
                }
                else {
                    msg2 = "Boa noite!";
                    img = "<img src=img/noite.jpg alt=Minha Figura>";
                }
                break;               
            case "en":
                if(horaNY>=6 && horaNY<12){
                    msg2 = "Good morning!";
                    img = "<img src=img/dia.jpg alt=Minha Figura>";
                }
                else if(horaNY>=12 && horaNY<18){
                    msg2 = "Good afternoon!";
                    img = "<img src=img/tarde.jpg alt=Minha Figura>";
                }
                else {
                    msg2 = "Good night!";
                    img = "<img src=img/noite.jpg alt=Minha Figura>";
                }
                break;
            case "fr":
                if(horaFR>=6 && horaFR<12){
                    msg2 = "Bonjour!";
                    img = "<img src=img/dia.jpg alt=Minha Figura>";
                }
                else if(horaFR>=12 && horaFR<18){
                    msg2 = "Bon après-midi!";
                    img = "<img src=img/tarde.jpg alt=Minha Figura>";
                }
                else {
                    msg2 = "Bonne nuit!";
                    img = "<img src=img/noite.jpg alt=Minha Figura>";
                }
                break;
            case "de":
                if(horaDE>=6 && horaDE<12){
                    msg2 = "Guten Morgen!";
                    img = "<img src=img/dia.jpg alt=Minha Figura>";
                }
                else if(horaDE>=12 && horaDE<18){
                    msg2 = "Guten Tag!";
                    img = "<img src=img/tarde.jpg alt=Minha Figura>";
                }
                else {
                    msg2 = "Gute Nacht!";
                    img = "<img src=img/noite.jpg alt=Minha Figura>";
                }
                break;       
        }
    }
}
