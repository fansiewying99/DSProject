package DSAssignment;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Node {
    public ArrayList <Node>children=new ArrayList<>();
    Node parent;
    String id;
    String password;
//    String decryptedName;
    String encryptedName;
    double revenue;
    double profit;
    double paid;
    double payment;
    public Node(String encryptedName, String id){
        parent=null;
        this.children=new ArrayList<>();
        this.id=id;
        this.encryptedName=encryptedName;
        this.revenue=0;
        this.profit=0;
        this.payment=0;
        this.password=null;
    }
    public void setData(String encryptedName, String pass, double revenue, double paid, double payment, Node parent, ArrayList children){
        this.password=pass;
        this.parent=parent;
        this.children=children;
//        this.id=id;
        this.encryptedName=encryptedName;
        this.paid=paid;
        this.revenue=revenue;
        this.profit=0;
        this.payment=payment;
    }
    public String getUserID(){
        return id;
    }
    public String getEncryptedName(){
        return encryptedName;
    }
    public Node getNode(){
        return this;
    }
    public Node(){}
    public double getPayment(){
        return this.payment;
    }
    public boolean hasPaid(){
        if(this.paid>0)
            return true;
        else
            return false;
    }
    public String viewChildren(){
        String str="";
        for(int i=0; i<children.size(); i++){
            str+=children.get(i).id+" ";
        }
        return str;
    }
    public int getUserDownlineSize(){
        return children.size();
    }
    public String setPassword(String pass){
        this.password=pass;
        return pass;
    }

}
