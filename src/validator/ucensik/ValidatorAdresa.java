/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator.ucensik;

import validator.ComponentValidator;

/**
 *
 * @author Mladen
 */
public class ValidatorAdresa implements ComponentValidator {

    @Override
    public void validate(Object val) throws Exception {
        String s = (String)val;
        s= s.trim();
        if(s!=null && s.length() !=0){
            if(s.length() <=50){
                                    
                            
            }else{
                throw new Exception("Ime mora imati manje od 50 karaktera");
            }
        }else{
            throw new Exception("Nije uneto ime");
    }
    
    }
}