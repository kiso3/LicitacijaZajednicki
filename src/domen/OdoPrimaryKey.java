/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author Mladen
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface OdoPrimaryKey {
    String[] primaryKey();
}
