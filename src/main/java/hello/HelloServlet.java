
package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");            
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String msg = "";
        String msg2 = "";
        String img = "";
        String valor[];
        valor = new String[2];
        valor[0]="teste";
        valor[1]="dia";
        
        String lang = request.getParameter("lang");
        if(lang==null)
            lang = "pt";
        switch(lang){
            case "pt":
                msg = "Alô, ";
                valor = saudacao(lang);
                msg2 = valor[0];
                img = valor[1];
                break;
            case "en":
                msg = "Hello, ";
                valor = saudacao(lang);
                msg2 = valor[0];
                img = valor[1];
                break;
            case "fr":
                msg = "Bonjour, ";
                valor = saudacao(lang);
                msg2 = valor[0];
                img = valor[1];
                break;
            case "de":
                msg = "Hallo, ";
                valor = saudacao(lang);
                msg2 = valor[0];
                img = valor[1];
                break;
        }
        
        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Fulano";
        
        msg = msg+nome+"!";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">"); 
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("<p>" + msg2 + "</p>");
            out.println("<img src=img/"+img+".jpg alt=Minha Figura>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg = "";
        String msg2 = "";
        String img = "";
        String valor[];
        valor = new String[2];
        valor[0]="teste";
        valor[1]="dia";
        
        String lang = request.getParameter("lang");
        if(lang==null)
            lang = "pt";
        switch(lang){
            case "pt":
                msg = "Alô, ";
                valor = saudacao(lang);
                msg2 = valor[0];
                img = valor[1];
                break;
            case "en":
                msg = "Hello, ";
                valor = saudacao(lang);
                msg2 = valor[0];
                img = valor[1];
                break;
            case "fr":
                msg = "Bonjour, ";
                valor = saudacao(lang);
                msg2 = valor[0];
                img = valor[1];
                break;
            case "de":
                msg = "Hallo, ";
                valor = saudacao(lang);
                msg2 = valor[0];
                img = valor[1];
                break;
        }
        
        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Fulano";
        
        msg = msg+nome+"!";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">"); 
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("<p>" + msg2 + "</p>");
            out.println("<img src=img/"+img+".jpg alt=Minha Figura>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private String[] saudacao(String local){
        String valor[];
        String img;
        String msg2;
        valor = new String[2];
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
                    valor[0] = "Bom dia!";
                    valor[1] = "dia";
                }
                else if(horaSP>=12 && horaSP<18){
                    valor[0] = "Boa tarde!";
                    valor[1] = "tarde";
                }
                else {
                    valor[0] = "Boa noite!";
                    valor[1] = "noite";
                }
                break;               
            case "en":
                if(horaNY>=6 && horaNY<12){
                    valor[0] = "Good morning!";
                    valor[1] = "dia";
                }
                else if(horaNY>=12 && horaNY<18){
                    valor[0] = "Good afternoon!";
                    valor[1] = "tarde";
                }
                else {
                    valor[0] = "Good night!";
                    valor[1] = "noite";
                }
                break;
            case "fr":
                if(horaFR>=6 && horaFR<12){
                    valor[0] = "Bonjour!";
                    valor[1] = "dia";
                }
                else if(horaFR>=12 && horaFR<18){
                    valor[0] = "Bon après-midi!";
                    valor[1] = "tarde";
                }
                else {
                    valor[0] = "Bonne nuit!";
                    valor[1] = "noite";
                }
                break;
            case "de":
                if(horaDE>=6 && horaDE<12){
                    valor[0] = "Guten Morgen!";
                    valor[1] = "dia";
                }
                else if(horaDE>=12 && horaDE<18){
                    valor[0] = "Guten Tag!";
                    valor[1] = "tarde";
                }
                else {
                    valor[0] = "Gute Nacht!";
                    valor[1] = "noite";
                }
                break;       
        }
        return valor;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
