/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

/**
 *
 * @author Mladen
 */
public class TekstPolje {
 private ComponentValidator validator;
private Object val;
    public TekstPolje(ComponentValidator validator, Object val) {
        this.validator = validator;
        this.val = val;
    }
 
    public boolean isValid() {
        try {
         validator.validate(val);   
         return true;
        } catch (Exception e) {
          return false;
        }         
    }
}
