import pachete.functie.FunctieCumparare;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class jocuriVi {
    
    private static ArrayList<Joc> jocuriVii = new ArrayList<>();
    Joc jm, jd, jt, jg, jl;
    


    public JPanel afiseazaJocuriVi(){
        JPanel panelJocuriVi = new JPanel();
        panelJocuriVi.setBounds(50, 50, 250, 250);
        panelJocuriVi.setLayout(new BoxLayout(panelJocuriVi, BoxLayout.Y_AXIS));
        
        jocuriVii.add(new Joc("Minecraft", 30));
        JButton cumparM = new JButton("Cumpara Minecrfat");
        
        JTextField field = InterfataMagJoc.getField();
        double sumaS = InterfataMagJoc.getSuma();

        jm = jocuriVii.get(0);

        cumparM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent m){
                
                double pretJ = jm.getPret();
            
                if(sumaS < pretJ){
                    JOptionPane.showMessageDialog(panelJocuriVi, "Fond insuficient!");
                }
                    double sumtotalM = sumaS - pretJ;
                    field.setText(String.valueOf(sumtotalM));
                    JOptionPane.showMessageDialog(cumparM, "Ai achizitionat Minecraft!");
                
            }
        });
        jocuriVii.add(new Joc("DOOM", 35));
        JButton cumparD = new JButton("Cumpara DOOM");

        jd = jocuriVii.get(1);

        cumparD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent d){
               
                double sumaD = InterfataMagJoc.getSuma();
                double pretJ = jd.getPret();

                if(sumaD < pretJ){
                   JOptionPane.showMessageDialog(panelJocuriVi, "Fond insuficient!");
                }else{
                    double sumtotalD = sumaD - pretJ;
                    field.setText(String.valueOf(sumtotalD));
                    JOptionPane.showMessageDialog(cumparD, "Ai achizitionat DOOM!"); 
                }
                
            }
        });
        jocuriVii.add(new Joc("Terraria", 9.99));
        JButton cumparT = new JButton("Cumpara Terraria");

        jt = jocuriVii.get(2);

        cumparT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent t){
                
                double sumaD = InterfataMagJoc.getSuma();
                double pretJ = jt.getPret();

                if(sumaD < pretJ){
                   JOptionPane.showMessageDialog(panelJocuriVi, "Fond insuficient!");
                }else{
                    double sumtotalT = sumaD - pretJ;
                    field.setText(String.valueOf(sumtotalT));
                    JOptionPane.showMessageDialog(cumparD, "Ai achizitionat Terraria!"); 
                }
            }
        });



        jocuriVii.add(new Joc("God of War", 49.99));
        JButton cumparGoW = new JButton("Cumpara God of War");

        jg = jocuriVii.get(3);

        cumparGoW.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent g){
                
                double sumaD = InterfataMagJoc.getSuma();
                double pretJ = jg.getPret();

                if(sumaD < pretJ){
                   JOptionPane.showMessageDialog(panelJocuriVi, "Fond insuficient!");
                }else{
                    double sumtotalG = sumaD - pretJ;
                    field.setText(String.valueOf(sumtotalG));
                    JOptionPane.showMessageDialog(cumparGoW, "Ai achizitionat God of War!"); 
                }
            }
        });

        jocuriVii.add(new Joc("Lord of the Rings", 59.99));
        JButton cumparLotr = new JButton("Cumpara Lord of the Rings");

        jl = jocuriVii.get(4);

        
        cumparLotr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent l){
                
                double sumaD = InterfataMagJoc.getSuma();
                double pretJ = jl.getPret();

                if(sumaD < pretJ){
                   JOptionPane.showMessageDialog(panelJocuriVi, "Fond insuficient!");
                }else{
                    double sumtotalL = sumaD - pretJ;
                    field.setText(String.valueOf(sumtotalL));
                    JOptionPane.showMessageDialog(cumparLotr, "Ai achizitionat Lord of The Rings!"); 
                }
            }
        });

        for(Joc joc : jocuriVii){
            JLabel vii = new JLabel(joc.getNume() + " " + "$" + joc.getPret());
            panelJocuriVi.add(vii);
        }
        panelJocuriVi.add(cumparM);
        panelJocuriVi.add(cumparD);
        panelJocuriVi.add(cumparT);
        panelJocuriVi.add(cumparGoW);
        panelJocuriVi.add(cumparLotr);
        return panelJocuriVi;
    }

}
