import javax.swing.*;
import java.util.ArrayList;


public class afiseazaMeniu {
    private boolean listaAfisata = false;
    private static ArrayList<Joc> listaJocuri = new ArrayList<>();

    public JPanel afiseazaMeniuu(){
        JPanel meniuPanel = new JPanel();
        meniuPanel.setBounds(50, 50, 250, 700);
        meniuPanel.setLayout(new BoxLayout(meniuPanel, BoxLayout.Y_AXIS));
        
        
        //Initializez obiectele din meniu
        listaJocuri.add(new Joc("Minecraft", 29.99));
        listaJocuri.add(new Joc("DOOM", 39.99));
        listaJocuri.add(new Joc("Terraria", 9.99));
        listaJocuri.add(new Joc("God of War", 49.99));
        listaJocuri.add(new Joc("Lord of the Rings", 59.99));
        if(!listaAfisata){
            for(Joc joc : listaJocuri){
                JLabel item = new JLabel(joc.getNume() + "$" + joc.getPret());
                meniuPanel.add(item);
            }
        }else{
            listaAfisata = true;
        }


        
    return meniuPanel;
    }
}
