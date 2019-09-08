package com.gcomputers.policymanagement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dard
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO: Create UI
        // TODO: Create File Parser
        // TODO: Create PowerShell Commands
        // TODO: Create Backup/Restore Feature
        System.out.println("Running STIGs");
        powershellExecutor pse = new powershellExecutor();
        pse.setRegistryKeyCMD();
    }
    
}
