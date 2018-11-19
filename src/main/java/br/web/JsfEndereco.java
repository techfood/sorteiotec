/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Filipe
 */
@Named(value = "jsfEndereco")
@ManagedBean
@RequestScoped
public class JsfEndereco {

    /**
     * Creates a new instance of JsfEndereco
     */
    public JsfEndereco() {
    }
    
}
