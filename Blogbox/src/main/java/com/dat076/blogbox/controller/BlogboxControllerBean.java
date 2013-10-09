/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dat076.blogbox.controller;

import com.dat076.blogbox.User;
import com.dat076.blogbox.model.BlogboxModelBean;
import com.dat076.blogbox.view.BlogboxViewBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author larsson152
 */
@Named
@RequestScoped
public class BlogboxControllerBean {

    @Inject
    private BlogboxModelBean blogboxModelBean;
    @Inject
    private BlogboxViewBean blogboxViewBean;

    public void onSetNewUser(ActionEvent e) {

        for (int i = 0; i < blogboxModelBean.getUsers().size(); i++) {
            if (blogboxModelBean.getUsers().get(i).getName().toLowerCase().equals(blogboxViewBean.getName().toLowerCase())) {
                FacesContext.getCurrentInstance().validationFailed();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User already exists"));
            }
        }
        blogboxModelBean.getUsers().add(new User(blogboxViewBean.getName()));
    }
}
