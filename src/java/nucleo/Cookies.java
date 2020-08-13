
package nucleo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class Cookies {
    
    public void setCookie(String nome, String valor){
        Cookie cookie = new Cookie(nome, valor);
        cookie.setMaxAge(60*60*24*365); //armazena por um ano
        HttpServletResponse res = null;
        res.addCookie(cookie);
    }
    
    public String getCookie(String nome){
        
        return "";
        
    }
    
}
