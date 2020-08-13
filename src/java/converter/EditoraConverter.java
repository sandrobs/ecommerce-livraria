/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.EditoraDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Editora;

@FacesConverter("editoraConverter")
public class EditoraConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int codigo = Integer.parseInt(value);
        Editora editora = new EditoraDAO().findById(codigo);
        return editora;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ""+((Editora) value).getEdiCodigo();
    }
    
}
