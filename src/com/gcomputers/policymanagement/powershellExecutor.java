package com.gcomputers.policymanagement;


import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellNotAvailableException;
import com.profesorfalken.jpowershell.PowerShellResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dard
 */
public class powershellExecutor {
    private final String registryBackup = "regedit /e ";
    private final String regQuery =  "reg query ";
    private final String regAdd = "reg add ";
    
    public void backupRegistry(String backupLocation){
        backupLocation = "c:/backup.reg";
        try{
            Process process = Runtime.getRuntime().exec(registryBackup + backupLocation);
            process.destroyForcibly();
        } catch (Exception e){
            e.printStackTrace(System.err);
        }
    }
    public void backupRegistryKey(String key){
        
    }
    
    public void getRegistryKeyPS(){
        String key = "Get-ItemProperty -Path HKLM:\\SYSTEM\\CurrentControlSet\\Control\\Lsa\\SSO\\Passport1.4";
        
        try {
             PowerShell ps = PowerShell.openSession();
             PowerShellResponse response = ps.executeCommand(key);
             System.out.println(response.getCommandOutput());
             ps.close();
        } catch(PowerShellNotAvailableException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
    
    public void getRegistryKeyCMD(){
        String key = "HKLM\\SYSTEM\\CurrentControlSet\\Control\\Lsa\\SSO\\Passport1.4";
        try{
            Process process = Runtime.getRuntime().exec(regQuery + key);
  
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String s = null;
            System.out.println("Here is the standard output of the command:");
            while ((s = stdInput.readLine()) != null) {System.out.println(s);}
            
            System.out.println("Here is the standard error of the command (if any):");
            while ((s = stdError.readLine()) != null) {System.out.println(s);}
            
            process.destroyForcibly();
        } catch (Exception e){
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }
    public void setRegistryKeyCMD(){
        String key = "HKLM\\SYSTEM\\CurrentControlSet\\Control\\Lsa ";
        String value = "/v NoLMHash /t REG_DWORD /d 1 /f";
        
        try {
            Process process = Runtime.getRuntime().exec(regAdd + key + value);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String s = null;
            System.out.println("Here is the standard output of the command:");
            while ((s = stdInput.readLine()) != null) {System.out.println(s);}
            
            System.out.println("Here is the standard error of the command (if any):");
            while ((s = stdError.readLine()) != null) {System.out.println(s);}
            
            process.destroyForcibly();
        } catch (Exception e){
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }
}
