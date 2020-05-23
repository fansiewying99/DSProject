package DSAssignment;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import GUI.NameIncorrect;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author User
 */
public final class adminNode extends Node{
    Node user;
    double companyRevenue;
    Node head=null;
    ArrayList <Node>allUser=new ArrayList<>();
    private Node [][] generation;
    private double[]generationRevenue;
    //default fee and commission
    private double registrationFee=50.0;
    private double commission1=0.5;
    private double commission2=0.12;
    private double commission3=0.09;
    private double commission4=0.06;
    private double commission5=0.03;
    private String key="asdfghjkl";//default key;
    int generationSize;
    int deleteSize=0;
    public adminNode() {
//        head=head;
        head=new Node("", "-");
        head.id="-";
//        saveCompanyData(companyRevenue, registrationFee, commission1, commission2, commission3, commission4, commission5, key);
        retrieveOldData();
//        this.companyRevenue=0;
        getGeneration();
    }
    public Node getHead(){
        return head;
    }
    //I have COMPANY_REVENUE
    //I can see the company’s revenue
    public double getcompanyRevenue(){
//        this.companyRevenue=head.revenue;
        return this.companyRevenue;
    }
    public int getCompanyDownlineSize(){
        return allUser.size();
    }
    //I can see the company’s revenue of each generation

    //I can check every user’s revenue
    public double getUserRevenue(String id) {
        Node temp=getUserNode(id);
        return temp.revenue;
    }
    //I can CRUD (Create/Retrieve/Update/Delete) users
    //user to add child
    //I collect all the remaining profit after commissions are paid (in other words, i will earn at least 20% of every membership signup)
    public void addUserChild(String parentId, String name, String childId) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException, Exception{
        Node temp=createUser(name, childId);
        user=this.getUserNode(parentId);
        temp.parent=user;
        user.children.add(temp);
        updateUserAddChild(parentId, childId);
        saveUserParent(parentId, childId);
        this.generation=getGeneration();
    }
    public void addCompanyChild(String name, String id) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException, Exception{
        Node temp=createUser(name, id);
        temp.parent=head;
        head.children.add(temp);
//        head.profit=temp.payment;
//        this.companyRevenue+=head.profit; 
        saveUserParent("-", id);
//        updateCompanyRevenue(head.profit, this.companyRevenue);
        this.generation=getGeneration();
    }
    public void deleteUser(String id){
        Node temp=getUserNode(id);
        deleteSize++;
        temp.id=Integer.toString(deleteSize);
        temp.payment=0;
        temp.encryptedName="";
        temp.paid=0;
        temp.revenue=0;
        temp.profit=0;
        deleteID(id);
        
        this.generation=getGeneration();
    }

    public Node createUser(String name, String id) throws IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, NoSuchPaddingException, Exception{
        //also need to create encrypted name
        String enc=encryption(name, this.key);
        Node temp=new Node(enc, id);
        temp.payment=getRegistrationFee();
        allUser.add(temp);
        System.out.println("createUser: "+enc);
        saveUserData(enc, id, temp.revenue, 0);
        saveID(id);
        temp.id=id;
        temp.encryptedName=enc;
//        temp.payment=getRegistrationFee();
        
        return temp;
    }
    
    public Node userUpdateName(String id, String decryptedName, String newName) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, Exception{
        Node temp=getUserNode(id);
        String enc=temp.encryptedName;
        String dec=decryption(enc, this.key);
        if(dec.equals(decryptedName)){
            temp.encryptedName=encryption(newName, this.key);
        }
        else{
            NameIncorrect ni=new NameIncorrect();
            ni.setVisible(true);
        }
        updateUserName(id, temp.encryptedName);
        return temp;
    }
    //to call user in ui(login)
    public Node getUserNode(String id) {
        Node temp=null;
        if(existID(id)){
            for(int i=0; i<allUser.size(); i++){// later try read from file which store all the id
                if(id.equals(allUser.get(i).id)){
                    temp=allUser.get(i);
                    break;
                }
            }
        }
        else if(!existID(id)){
            System.out.println("not registered id");
        }
        return temp;
    }
    public String getRealName(String id) throws IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, NoSuchPaddingException, Exception{
        String enc=getUserNode(id).encryptedName;
        String dec=decryption(enc, this.key);
        return dec;
    }
    public boolean checkPassword(String id, String pass){
        Node temp=getUserNode(id);
        if(temp.password.equals(pass))
            return true;
//        else if(temp.password==null){
//            return false;
//        }
        else
            return false;
    }
    public void setPassword(String id, String pass){
        Node temp=getUserNode(id);
        temp.setPassword(pass);
        try {
            savePassword(id, pass);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(adminNode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(adminNode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(adminNode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(adminNode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(adminNode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public double getCompanyRevenue(){
        return this.companyRevenue;
    }
    public void userPay(String id){
        Node user=getUserNode(id);
        user.paid=user.payment;
        updateUserPayment(id, user.paid);
        Node current=user;
        double totalUserProfit=0;
        for(int i=1; i<=5; i++){
            current=current.parent;
            if(!current.id.equals("")){
                if(current==head){
                    break;
                }
                else if(i==1){
                    current.profit=user.paid*commission1;
                    current.revenue+=current.profit;
                }
                else if(i==2){
                    current.profit=user.paid*commission2;
                    current.revenue+=current.profit;
                }
                else if(i==3){
                    current.profit=user.paid*commission3;
                    current.revenue+=current.profit;
                }
                else if(i==4){
                    current.profit=user.paid*commission4;
                    current.revenue+=current.profit;
                }
                else if(i==5){
                    current.profit=user.paid*commission5;
                    current.revenue+=current.profit;
                }
            }
            else if(current.id.equals("")){
                current.revenue=0;
                current.profit=0;
            }
            updateUserRevenue(current.id, current.profit, current.revenue);
            totalUserProfit+=current.profit;
        }
        head.profit=user.paid-totalUserProfit;
        this.companyRevenue+=head.profit;
        this.generationRevenue=setGenerationRevenue();
        updateCompanyRevenue(head.profit, this.companyRevenue);
    }

    // I can  change  the  registration  fee  and  commission  from  time  to time 
    public void setRegristrationFee(double fee){
        this.registrationFee=fee;
        updateRegistrationFee(fee);
    }
    public double getRegistrationFee(){
        return this.registrationFee;
    }
    public void setCommission1(double commission){
        updateCommission(1, commission);
        this.commission1=commission;
    }
    public void setCommission2(double commission){
        updateCommission(2, commission);
        this.commission2=commission;
    }
    public void setCommission3(double commission){
        updateCommission(3, commission);
        this.commission3=commission;
    }
    public void setCommission4(double commission){
        updateCommission(4, commission);
        this.commission4=commission;
    }
    public void setCommission5(double commission){
        updateCommission(5, commission);
        this.commission5=commission;
    }
    public double getCommission1(){
        return commission1;
    }
    public double getCommission2(){
        return commission2;
    }
    public double getCommission3(){
        return commission3;
    }
    public double getCommission4(){
        return commission4;
    }
    public double getCommission5(){
        return commission5;
    }
    
    //I can see the entire tree of users

    public Node[][] getGeneration(){
        Node [][] generation=new Node[100][100];
        generation[0][0]=head;
        int max=0;
        for(int i=0; i<allUser.size(); i++){
            Node t=allUser.get(i);
            Node current=t;
            for(int j=1; ; j++){
                if(current.parent==head){
                    for(int l=0; ;l++){
                        if(generation[j][l]==null){
                            generation[j][l]=t;
                            break;
                        }
                    }
                    if(j>max)
                        max=j;
                    break;
                }
                current=current.parent;
            }
//            }
            this.generation=generation;
            this.generationSize=max;
        }
        return generation;
    }
    public String[][]getGenerationID(){
        String[][] id=new String[100][100];
        for(int i=0; i<getGenerationSize()+1; i++){
            for(int j=0; ; j++){
                if(this.generation[i][j]==null)
                    break;
                else
                    id[i][j]=this.generation[i][j].getUserID();
            }
        }
        return id;
    }
    public int getGenerationSize(){
        return generationSize;
    }
    public double[] setGenerationRevenue(){
        double[]generationRevenue=new double[100];
        for(int i=0; i<getGenerationSize()+1; i++){
            for(int j=0; ;j++){
                if(generation[i][j]==null)
                    break;
                else{
                    generationRevenue[i]+=generation[i][j].revenue;
                }
            }
        }
        return generationRevenue;
    }
    public double getGenerationRevenue(int i){
        return this.generationRevenue[i];
    }

    
    
    //I can save and load all users and data in a file
    //save files
     public void saveID(String str){ 
        try{
            PrintWriter pw=new PrintWriter(new FileWriter("allID.txt", true));
            pw.println(str);
            pw.close();
        }catch(IOException e){
            System.out.println("Error"+e);
        }
     }
     public boolean existID(String id){
         boolean exist=false;
             try{
                 Scanner s=new Scanner(new FileInputStream("allID.txt"));
                     while(s.hasNext()){
                         if(s.nextLine().equals(id)){
                             exist=true;
                             break;
                         }
                         else
                             exist=false;
                     }
                 s.close();
             }catch(IOException e){
                 System.out.println("Error: "+e);
             }
         return exist;
     }
     public void saveUserData(String encryptedName, String id, double revenue, double payment){ 
        try{
            PrintWriter pw=new PrintWriter(new FileWriter(id+" Data.txt", true));
            pw.println("Encrypted Name: "+encryptedName);
            pw.println("User ID: "+id);
            pw.println("Password: ");//pass saved using encryption with pass as string and enc name as key
            pw.println("Registration Fee Paid: RM"+payment);
            pw.println("Current Revenue: "+"RM"+revenue);
            pw.println("Agent ID: ");
            pw.println("Children: ");
            pw.println("Activities:");
            pw.close();
        }catch(IOException e){
            System.out.println("Error"+e);
        }
     }
     public void saveUserParent(String parentID, String id){
         try{
            Scanner s=new Scanner(new FileInputStream(id+" Data.txt"));
            ArrayList <String>list=new ArrayList();
            while(s.hasNext()){
                String str=s.nextLine();
                if(str.contains("Agent ID: ")){
                    str+=parentID;
                }
                list.add(str);
            }
             PrintWriter p=new PrintWriter(new FileWriter(id+" Data.txt"));
            PrintWriter pw=new PrintWriter(new FileWriter(id+" Data.txt", true));
            p.flush();
            p.close();
            for(int i=0; i<list.size(); i++){
                pw.println(list.get(i));
            }
            pw.close();
        }catch(IOException e){
            System.out.println("Error"+e);
        }
     }
     public void saveCompanyData(double revenue, double payment, double c1, double c2, double c3, double c4, double c5, String key){
         try{
             PrintWriter pw=new PrintWriter(new FileWriter("companyData.txt"), true);
             pw.println("Revenue: RM"+revenue);
             pw.println("Registration Fee: RM"+payment);
             pw.println("1st Commission: "+c1);
             pw.println("2nd Commission: "+c2);
             pw.println("3rd Commission: "+c3);
             pw.println("4th Commission: "+c4);
             pw.println("5th Commission: "+c5);
             pw.println("Encryption Key: "+key);
             pw.println("Activity:");
             pw.close();
         }catch(IOException e){
             System.out.println(e);
         }
     }
     public void savePassword(String id, String password) throws IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, NoSuchPaddingException, Exception{
        try{
            Scanner s=new Scanner(new FileInputStream(id+" Data.txt"));
            ArrayList <String>list=new ArrayList();
            Node temp=getUserNode(id);
            while(s.hasNext()){
                String str=s.nextLine();
                if(str.contains("Password: ")){
                     str=str.substring(0, 10);
                     str+=encryption(password, temp.encryptedName);
                }
                list.add(str);
            }
             PrintWriter p=new PrintWriter(new FileWriter(id+" Data.txt"));
            PrintWriter pw=new PrintWriter(new FileWriter(id+" Data.txt", true));
            p.flush();
            p.close();
            for(int i=0; i<list.size(); i++){
                pw.println(list.get(i));
            }
            pw.close();
        }catch(IOException e){
            System.out.println("Error"+e);
        }
     }
     public void updateCompanyRevenue(double profit, double revenue){
        try{
            Scanner s=new Scanner(new FileInputStream("companyData.txt"));
            ArrayList <String>list=new ArrayList();
            while(s.hasNext()){
                String str=s.nextLine();
                if(str.contains("Revenue: RM")){
                     str=str.substring(0, 11);
                     str+=revenue;
                }
                list.add(str);
            }
             PrintWriter p=new PrintWriter(new FileWriter("companyData.txt"));
            PrintWriter pw=new PrintWriter(new FileWriter("companyData.txt", true));
            p.flush();
            p.close();
            for(int i=0; i<list.size(); i++){
                pw.println(list.get(i));
            }
            pw.println(new Date()+": RM"+revenue+" (+RM"+profit+")");
            pw.close();
        }catch(IOException e){
            System.out.println("Error"+e);
        }
     }
     public void updateRegistrationFee(double fee){
         try{
            Scanner s=new Scanner(new FileInputStream("companyData.txt"));
            ArrayList <String>list=new ArrayList();
            while(s.hasNext()){
                String str=s.nextLine();
                if(str.contains("Registration Fee: RM")){
                     str=str.substring(0, 20);
                     str+=fee;
                }
                list.add(str);
            }
             PrintWriter p=new PrintWriter(new FileWriter("companyData.txt"));
            PrintWriter pw=new PrintWriter(new FileWriter("companyData.txt", true));
            p.flush();
            p.close();
            for(int i=0; i<list.size(); i++){
                pw.println(list.get(i));
            }
            pw.println(new Date()+": update registration fee (RM"+fee+")");
            pw.close();
        }catch(IOException e){
            System.out.println("Error"+e);
        }
     }
     public void updateKey(String key){
         try{
            Scanner s=new Scanner(new FileInputStream("companyData.txt"));
            ArrayList <String>list=new ArrayList();
            while(s.hasNext()){
                String str=s.nextLine();
                if(str.contains("Encryption Key: ")){
                     str=str.substring(0, 16);
                     str+=key;
                }
                list.add(str);
            }
             PrintWriter p=new PrintWriter(new FileWriter("companyData.txt"));
            PrintWriter pw=new PrintWriter(new FileWriter("companyData.txt", true));
            p.flush();
            p.close();
            for(int i=0; i<list.size(); i++){
                pw.println(list.get(i));
            }
            pw.println(new Date()+": update encryption key ("+key+")");
            pw.close();
        }catch(IOException e){
            System.out.println("Error"+e);
        }
     }
     public void updateCommission(int n, double c){
         try{
            Scanner s=new Scanner(new FileInputStream("companyData.txt"));
            ArrayList <String>list=new ArrayList();
            while(s.hasNext()){
                String str=s.nextLine();
                if(str.contains("Commission")){
                     str=str.substring(0, 10);
                     str+=n+": "+c;
                }
                list.add(str);
            }
             PrintWriter p=new PrintWriter(new FileWriter("companyData.txt"));
            PrintWriter pw=new PrintWriter(new FileWriter("companyData.txt", true));
            p.flush();
            p.close();
            for(int i=0; i<list.size(); i++){
                pw.println(list.get(i));
            }
            pw.println(new Date()+": update commission "+n+": "+c);
            pw.close();
        }catch(IOException e){
            System.out.println("Error"+e);
        }
     }
     public void updateUserRevenue(String id, double profit, double revenue){
        try{
            Scanner s=new Scanner(new FileInputStream(id+" Data.txt"));
            ArrayList <String>list=new ArrayList();
            while(s.hasNext()){
                String str=s.nextLine();
                if(str.contains("Current Revenue: RM")){
                     str=str.substring(0, 19);
                     str+=revenue;
                }
                list.add(str);
            }
             PrintWriter p=new PrintWriter(new FileWriter(id+" Data.txt"));
            PrintWriter pw=new PrintWriter(new FileWriter(id+" Data.txt", true));
            p.flush();
            p.close();
            for(int i=0; i<list.size(); i++){
                pw.println(list.get(i));
            }
            pw.println(new Date()+": RM"+revenue+" (+RM"+profit+")");
            pw.close();
        }catch(IOException e){
            System.out.println("Error"+e);
        }
     }
     public void updateUserPayment(String id, double paid){
        try{
            Scanner s=new Scanner(new FileInputStream(id+" Data.txt"));
            ArrayList <String>list=new ArrayList();
            while(s.hasNext()){
                String str=s.nextLine();
                if(str.contains("Registration Fee Paid: RM")){
                     str=str.substring(0, 25);
                     str+=paid;
                }
                list.add(str);
            }
             PrintWriter p=new PrintWriter(new FileWriter(id+" Data.txt"));
            PrintWriter pw=new PrintWriter(new FileWriter(id+" Data.txt", true));
            p.flush();
            p.close();
            for(int i=0; i<list.size(); i++){
                pw.println(list.get(i));
            }
            pw.close();
        }catch(IOException e){
            System.out.println("Error"+e);
        }
     }
     public void updateUserName(String id, String enc){
        try{
            Scanner s=new Scanner(new FileInputStream(id+" Data.txt"));
            ArrayList <String>list=new ArrayList();
            while(s.hasNext()){
                String str=s.nextLine();
                if(str.contains("Encrypted Name: ")){
                     str=str.substring(0, 16);
                     str+=enc;
                }
                list.add(str);
            }
             PrintWriter p=new PrintWriter(new FileWriter(id+" Data.txt"));
            PrintWriter pw=new PrintWriter(new FileWriter(id+" Data.txt", true));
            p.flush();
            p.close();
            for(int i=0; i<list.size(); i++){
                pw.println(list.get(i));
            }
            pw.close();
        }catch(IOException e){
            System.out.println("Error"+e);
        }
     }
     public void updateUserAddChild(String id, String childID){
         try{
            Scanner s=new Scanner(new FileInputStream(id+" Data.txt"));
            ArrayList <String>list=new ArrayList();
            while(s.hasNext()){
                String str=s.nextLine();
                if(str.contains("Children: ")){
                    if(str.length()==10)
                        str+=childID;
                    else
                        str+=", "+childID;
                }
                list.add(str);
            }
             PrintWriter p=new PrintWriter(new FileWriter(id+" Data.txt"));
            PrintWriter pw=new PrintWriter(new FileWriter(id+" Data.txt", true));
            p.flush();
            p.close();
            for(int i=0; i<list.size(); i++){
                pw.println(list.get(i));
            }
            pw.println("Add child (ID): "+childID);
            pw.close();
        }catch(IOException e){
            System.out.println("Error"+e);
        }
     }
     public void deleteID(String id){
         try{
            Scanner s=new Scanner(new FileInputStream("allID.txt"));
            ArrayList <String>list=new ArrayList();
            for(int i=0; s.hasNext(); i++){
                String str=s.nextLine();
                if(str.equals(id)){
                    str=Integer.toString(deleteSize);
                    File file=new File(id+" Data.txt");
                    file.delete();
                }
//                else
                    list.add(str);
            }
             PrintWriter p=new PrintWriter(new FileWriter("allID.txt"));
            PrintWriter pw=new PrintWriter(new FileWriter("allID.txt", true));
            PrintWriter pc=new PrintWriter(new FileWriter("companyData.txt", true));
            p.flush();
            p.close();
            for(int i=0; i<list.size(); i++){
                pw.println(list.get(i));
            }
            pc.println(new Date()+": Delete user ("+id+")");
            pc.close();
            pw.close();
        }catch(IOException e){
            System.out.println("Error"+e);
        }
     }
     public ArrayList<String> viewActivity(String id){
         ArrayList<String> act=new ArrayList<>();
         try{
             String file="";
             if(id.equals("-"))
                 file="companyData.txt";
             else
                 file=id+" Data.txt";
             Scanner s=new Scanner(new FileInputStream(file));
             String str="";
             do{
                 str=s.nextLine();
                 
             }while(!str.contains("Activities:"));
//             if(s.hasNext()){
                 while(s.hasNext()){System.out.println("asdfasd "+ str);
                     str=s.nextLine();
                    act.add(str);
                 }
//             }
             s.close();
         }catch(IOException e){
         System.out.println("error: "+e);
         }
         return act;
     }
     public void readAllData(){
        try{
            PrintWriter pw=new PrintWriter(new FileOutputStream("allData.txt"));
            for(int i=0; i<allUser.size(); i++){
                try{Scanner s=new Scanner(new FileInputStream(allUser.get(i).id+" Data.txt"));
                    while(s.hasNext()){
                        String read=s.nextLine();
                        pw.println(read);
                    }
                    s.close();
                }catch(IOException e){
                    System.out.println("error "+e);
                }
                pw.println();
            }
            pw.close();
         }catch(IOException e){
             System.out.println("error: "+e);
         }
     }
     public void retrieveOldData() {
         try{
             Scanner sa=new Scanner(new FileInputStream("companyData.txt"));
             while(sa.hasNext()){
                this.companyRevenue=Double.parseDouble(sa.nextLine().substring(11));
                 this.registrationFee=Double.parseDouble(sa.nextLine().substring(20));
                 this.commission1=Double.parseDouble(sa.nextLine().substring(16));
                 this.commission2=Double.parseDouble(sa.nextLine().substring(16));
                 this.commission3=Double.parseDouble(sa.nextLine().substring(16));
                 this.commission4=Double.parseDouble(sa.nextLine().substring(16));
                 this.commission5=Double.parseDouble(sa.nextLine().substring(16));
                 this.key=sa.nextLine().substring(16);
                 break;
             }
             sa.close();
             Scanner sc=new Scanner(new FileInputStream("allID.txt"));
             while(sc.hasNext()){
                 Scanner sd=new Scanner(new FileInputStream(sc.nextLine()+" Data.txt"));
                 String encryptedName=sd.nextLine().substring(16);
                 String id=sd.nextLine().substring(9);
                 Node user=new Node(encryptedName, id);
                 allUser.add(user);
                 sd.close();
             }
             sc.close();
             Scanner si=new Scanner(new FileInputStream("allID.txt"));
             while(si.hasNext()){
                 Scanner sd=new Scanner(new FileInputStream(si.nextLine()+" Data.txt"));
                 String encryptedName=sd.nextLine().substring(16);
                 String id=sd.nextLine().substring(9);
                 String pass=sd.nextLine().substring(10);
                 double paid=Double.parseDouble(sd.nextLine().substring(25));
                 double revenue=Double.parseDouble(sd.nextLine().substring(19));
                 String parentID=sd.nextLine().substring(10);
                 String childID=sd.nextLine().substring(10);
                 childID=childID.replace(", ", "");
                 Node parent;
                 ArrayList<Node> children=new ArrayList<>();
                 for(int i=0; i<childID.length(); i++){
                         String str=String.valueOf(childID.charAt(i));
                         children.add(getUserNode(str));
                 }
                 if(parentID.equals("-")){ 
                     parent=head;
                 }
                 else{
                     parent=getUserNode(parentID);
                 }
                 for(int j=0; j<allUser.size(); j++){
                     if(id.equals(allUser.get(j).id)){
                         String dec="";
                         if(!pass.equals(""))
                             dec=decryption(pass, encryptedName);
                        allUser.get(j).setData(encryptedName, dec, revenue, paid, getRegistrationFee(), parent, children);
                        break;
                     }
                 }
                 sd.close();
            }
             si.close();
         }catch(FileNotFoundException e){
             System.out.println("error" +e);
         } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(adminNode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(adminNode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(adminNode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(adminNode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(adminNode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(adminNode.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
     public String encryption(String name, String key) throws UnsupportedEncodingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, NoSuchPaddingException, Exception{
        DesEncrypter encrypter = new DesEncrypter(key);
        String enc = encrypter.encrypt(name);
        return enc;
     }
     public String decryption(String encryptedName, String key) throws UnsupportedEncodingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, NoSuchPaddingException, Exception{
        DesEncrypter encrypter = new DesEncrypter(key);
         String dec = encrypter.decrypt(encryptedName);
        return dec;
     }
     public void setKey(String key) throws IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, NoSuchPaddingException, Exception{
         for(int i=0; i<allUser.size(); i++){
             String dec=decryption(allUser.get(i).encryptedName, this.key);
             String enc=encryption(dec, key);
             allUser.get(i).encryptedName=enc;
             updateUserName(allUser.get(i).id, enc);
         }
         this.key=key;
         updateKey(key);
     }
     public String getKey(){
         return this.key;
     }
     public boolean checkKey(String key){
         if(key.equals(this.key)){
             return true;
         }
         else
             return false;
     }
//     public static void main(String[]args){
//         
//     }

}
