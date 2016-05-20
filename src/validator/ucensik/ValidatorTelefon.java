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
public class ValidatorTelefon implements ComponentValidator {

    @Override
    public void validate(Object val) throws Exception {
        String s = (String)val;
        s= s.trim();
        if(s!=null && s.length() !=0){
            if(s.matches("^(\\+0?1\\s)?\\(?\\d{3}\\)?[\\s./]\\d{7}$")){
                
            }else{
                throw new Exception("Neispravan telefonski broj, dozvoljeni formar unosa je (011/1234567)");
            }
        }else{
            throw new Exception("Nije unet telefonski broj");
        }
    }
    
}
