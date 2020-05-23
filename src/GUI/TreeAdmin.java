/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author User
 */
import DSAssignment.Node;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
public class TreeAdmin extends JFrame
{
    private JTree tree;
    public TreeAdmin()
    {
        JButton b=new JButton("Back");
        b.setBounds(400, 400, 80, 30);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Main.it.play("sound//page flip.wav");dispose();
            }
        });
        String[][]list=new String[100][100];
        list=Main.it.getGenerationID();
        DefaultMutableTreeNode[][]listTree=new DefaultMutableTreeNode[100][100];
        for(int a=0; a<Main.it.getGenerationSize()+1; a++){
            for(int k=0; ; k++){
                if(list[a][k]==null){
                    break;
                }
                else if(isInt(list[a][k])){
                    DefaultMutableTreeNode node= new DefaultMutableTreeNode("(deleted)");
                    listTree[a][k]=node;
                    System.out.println("Go");
                }
                else if(a==0){
                    DefaultMutableTreeNode node= new DefaultMutableTreeNode("Company");
                    listTree[a][k]=node;
                }
                else{
                    DefaultMutableTreeNode node= new DefaultMutableTreeNode(list[a][k]);
                    listTree[a][k]=node;
                }System.out.println(list[a][k]);
            }
        }
        DefaultMutableTreeNode root = listTree[0][0];
        for(int x=0; x<list[1].length; x++){
            if(list[1][x]!=null){
                root.add(listTree[1][x]);
            }
            else
                break;
        }
        
        for(int i=1; i<Main.it.getGenerationSize()+1; i++){
            for(int j=0; ; j++){
                if(listTree[i][j]==null){
                    break;
                }
                else{
                    for(int x=0; x<list[i+1].length; x++){
                        if(list[i+1][x]!=null){
                            for(int y=0; y<Main.it.login(list[i][j]).children.size(); y++){
                                if(list[i+1][x].equals(Main.it.login(list[i][j]).children.get(y).getUserID())){
                                    listTree[i][j].add(listTree[i+1][x]);
                                }
                            }
                        }
                        else
                            break;
                    }
                }
            }
        }
        this.add(b);

        //create the tree by passing in the root node
        tree = new JTree(root);
        add(tree);
        
        this.setMinimumSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTree Example");       
        this.pack();
        this.setVisible(true);
        b.setVisible(true);
    }
    public boolean isInt(String str){
        int x=Character.getNumericValue(str.charAt(0));
        for(int i=0; i<10; i++){
            if(x==i)
                return true;
        }
        return false;
    }
//    public static void main(String[] args)
//    {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new TreeAdmin();
//            }
//        });
//    }       
}
