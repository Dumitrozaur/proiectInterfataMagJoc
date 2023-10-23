import javax.swing.*;
import java.awt.*;
import java.util.Stack;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InterfataMagJoc{
    private static JTextField sumaField = new JTextField(10);
    private static Stack<JPanel> panelStack = new Stack<>();
    private static double suma = 0;
    //Initializam frameul
    JFrame frameP = new JFrame("Magazin Jocuri");
    JPanel panelU = new JPanel();
    
    public static double getSuma(){
        return suma;
    }

    public static JTextField getField(){
        return sumaField;
    }
    InterfataMagJoc(){

    sumaField.setBounds(20, 20, 50, 20);

    frameP.setSize(500, 300);
    frameP.setLocationRelativeTo(null);

    panelU.setBounds(50,50, 200, 350);
    frameP.add(panelU);
    
    //BUTONUL PENTRU AFISAT LISTA DE JOCURI
    JButton butonAfisJ = new JButton("1.Afisare Lista Jocuri");
    JButton butonCumpJ = new JButton("2.Cumpara joc");
    JButton butonAddS = new JButton("3.Adauga suma");
    JButton butonHome = new JButton("Inapoi");
    
    // Suma totala in cont
    JPanel sumaPanel = new JPanel();
    sumaPanel.add(new JLabel("Suma totala disponibila:"));
    sumaPanel.add(sumaField);
    sumaField.setText(String.valueOf(suma));
    
    
    //Proprietati butonHome
    butonHome.setBounds(50, 50, 155, 25);
    butonHome.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent h){
            if(!panelStack.isEmpty()){
                JPanel panelAnte = panelStack.pop();
                frameP.getContentPane().removeAll();
                panelU.add(sumaPanel);
                frameP.add(panelAnte);
                panelU.add(butonAfisJ);
                panelU.add(butonCumpJ);
                panelU.add(butonAddS);
                frameP.revalidate();
                frameP.repaint();
            }
        }
    });

    //Proprietati butonCumpJ
    butonCumpJ.setBounds(50, 50, 155, 25);
    butonCumpJ.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent c){

            try{
            jocuriVi v = new jocuriVi();
            JPanel meniuCumparareJoc = v.afiseazaJocuriVi();
            panelStack.push((JPanel) frameP.getContentPane().getComponent(0));
            frameP.getContentPane().removeAll();
            meniuCumparareJoc.add(butonHome);
            frameP.add(meniuCumparareJoc);
            frameP.revalidate();
            
            }catch(NullPointerException ex){
                JOptionPane.showMessageDialog(frameP, "Argument null" + ex.getMessage());
            }
        }
    });
    
    //Proprietati butonAfisJ
    butonAfisJ.setBounds(50, 50, 155, 25);
    butonAfisJ.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            afiseazaMeniu f = new afiseazaMeniu();
            JPanel meniuDeObtiuni = f.afiseazaMeniuu();
            
            panelStack.push((JPanel) frameP.getContentPane().getComponent(0));

            frameP.getContentPane().removeAll();
            meniuDeObtiuni.add(butonHome);
            frameP.add(meniuDeObtiuni);
            frameP.revalidate();
                   
        }
    });
    //Proprietati butonAddS

    butonAddS.setBounds(50, 50, 155, 25);
        butonAddS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent s){
                String adauga = JOptionPane.showInputDialog(frameP, "Adauga suma: ");
                if(adauga != null){
                    double sumaAdaugata = Double.parseDouble(adauga);
                    suma += sumaAdaugata;
                    sumaField.setText(String.valueOf(suma));
                }
                frameP.add(panelU);
                panelU.add(butonAfisJ);
                panelU.add(butonCumpJ);
                panelU.add(butonAddS);
                frameP.setVisible(true);
            }

        });

    //Proprietati frameP
    panelU.add(sumaPanel);
    panelU.add(butonAfisJ);  
    panelU.add(butonCumpJ);   
    panelU.add(butonAddS);  

    
    frameP.setLayout(new GridLayout(1, 5, 20, 20));
    frameP.setVisible(true);    
    
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new InterfataMagJoc();
            }
        });
    }
}