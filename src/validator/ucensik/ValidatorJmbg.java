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
public class ValidatorJmbg implements ComponentValidator {

    @Override
    public void validate(Object val) throws Exception {
        String s = (String)val;
        s= s.trim();
        if(s!=null && s.length() !=0){
            if(s.length() ==13){
                for (int i = 0; i < s.length(); i++) {
                    if(Character.isDigit(s.charAt(i))){
                    
                    }else{
                        throw new Exception("Jmbg mora biti sastavljen samo od brojeva");
                    };
                    
                }                
            }else{
                throw new Exception("Maticni broj mora imati 13 cifara");
            }
        }else{
            throw new Exception("Nije unet maticni broj");
        }
    }
    
}
