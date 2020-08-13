/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.GeneroDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Genero;

/**
 *
 * @author Sandro
 */
@FacesConverter("generoConverter")
public class GeneroConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int codigo = Integer.parseInt(value);
        Genero genero = new GeneroDAO().findById(codigo);
        return genero;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ""+((Genero) value).getGenCodigo();
    }
    
}
