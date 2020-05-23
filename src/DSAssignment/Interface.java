package DSAssignment;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import GUI.Main;
import GUI.Payment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


/**
 *
 * @author User
 */
public class Interface {
    adminNode admin;
    public Node user=null;

    public Interface(){
            this.admin = new adminNode();
    }
    //login page
    public void isAdmin(){
//        admin= ;
    }
    public Node getHead(){
        return admin.getHead();
    }
    
    //under admin
    //set regestration fee and commission
    public void setRegistrationFee(double fee){
        admin.setRegristrationFee(fee);
    }
    public void setCommission1(double commission){
        admin.setCommission1(commission);
    }
    public void setCommission2(double commission){
        admin.setCommission2(commission);
    }
    public void setCommission3(double commission){
        admin.setCommission3(commission);
    }
    public void setCommission4(double commission){
        admin.setCommission4(commission);
    }
    public void setCommission5(double commission){
        admin.setCommission5(commission);
    }
    public double getCommission1(){
        return admin.getCommission1();
    }
    public double getCommission2(){
        return admin.getCommission2();
    }
    public double getCommission3(){
        return admin.getCommission3();
    }
    public double getCommission4(){
        return admin.getCommission4();
    }
    public double getCommission5(){
        return admin.getCommission5();
    }
    public int getUserDownlineSize(){
        return user.getUserDownlineSize();
    }
    public int getCompanyDownlineSize(){
        return admin.getCompanyDownlineSize();
    }
    public Node[][] getGeneration(){
        return admin.getGeneration();
    }
    public String[][]getGenerationID(){
        return admin.getGenerationID();
    }
    public int getGenerationSize(){
        return admin.getGenerationSize();
    }
    //create, retrieve, delete, update user
    public void createUserUnderAdmin(String name, String id) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException, Exception{
        admin.addCompanyChild(name, id);
    }
    public void createUserUnderAgent(String agentID, String userName, String userID) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException, Exception{
        admin.addUserChild(agentID, userName, userID);
    }
    public String getRealName(String id) throws NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, NoSuchPaddingException, Exception{
        return admin.getRealName(id);
    }
    public void retrieveUser(String id){
        user=admin.getUserNode(id);
    }
    public void deleteUser(String id){
        admin.deleteUser(id);
    }
    public Node userUpdateName(String id, String oldName, String newName) throws InvalidKeyException, NoSuchPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, Exception{
        return admin.userUpdateName(id, oldName, newName);
    }
    public double getCompanyRevenue(){
        return admin.getCompanyRevenue();
    }
    public void setKey(String key) throws NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, NoSuchPaddingException, Exception{
        admin.setKey(key);
    }
    public String getKey(){
        return admin.getKey();
    }
    public boolean checkKey(String k){
        return admin.checkKey(k);
    }
    public String decryptName(String encryptedName, String key) throws IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, NoSuchPaddingException, Exception{
        String dec=admin.decryption(encryptedName, key);
        return dec;
    }

    public boolean isExist(String id){
        return admin.existID(id);
    }
    public void readAllData(){
        admin.readAllData();
    }
    //under user
    public Node login(String id) {
        user=admin.getUserNode(id);
        return user;
    }
    public void setPassword(String id, String pass) throws BadPaddingException, InvalidKeyException{
        admin.setPassword(id, pass);
    }
    public boolean checkPassword(String id, String pass){
        return admin.checkPassword(id, pass);
    }
    public String getUserChildren(){
        return user.viewChildren();
    }
    public double getUserRevenue(){
        return user.revenue;
    }
    public double getGenerationRenevue(int i){
        return admin.getGenerationRevenue(i);
    }
    public boolean hasPaid(){
        if(admin.hasPaid())
            return true;
        else 
            return false;
    }
    public double getFee(){
        return admin.getRegistrationFee();
    }
    public double getUserPayment(){
        System.out.println(user.id);
        return user.getPayment();
    }
    public void userPay(String id){
        admin.userPay(id);
    }
    public String getUserID(){
        return user.id;
    }
    public ArrayList<String> viewActivity(){
        return admin.viewActivity(user.id);
    }
    public ArrayList<String> viewCompanyAct(){
        return admin.viewActivity("-");
    }

    // sound
    public static void play(String url){   
        try{
            InputStream in = new FileInputStream(new File(url));
            AudioStream audioStream = new AudioStream(in);
             AudioPlayer.player.start(audioStream);
        }catch(Exception error){
              System.out.println("File Not Found");
              System.out.println(error);
        }
    }

}
