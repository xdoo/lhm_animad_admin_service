/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.muenchen.animad.admin.administration.security;

/**
 *
 * @author roland.werner
 */
enum ResourcesEnum {
    administration_READ_Animal, 
    administration_READ_Keeper, 
    administration_READ_Enclosure,
    administration_WRITE_Animal,
    administration_WRITE_Enclosure,
    administration_WRITE_Keeper,
    administration_DELETE_Animal,
    administration_DELETE_Enclosure,
    administration_DELETE_Keeper,
    administration_BUSINESSACTION_CreateAppointment
}
