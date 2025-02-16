import gui.PanelUniverso;
import universo.DatosUniverso;
import universo.Universo;
import javax.swing.*;
import java.io.IOException;
import java.util.Locale;

public class MainFichero {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        JFrame app = new JFrame();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelUniverso pu = new PanelUniverso();
        app.setContentPane(pu);
        app.setSize(1024,1024);
        app.setVisible(true);
        // Posibles ficheros de configuración
        // **********************************
        // 8star-rotation.txt
        //atom.txt
        // awesome.txt
        // chaosblossom.txt
        // dance10.txt
        // entropy-universe.txt
        // fourellipses.txt
        // hypnosis.txt
        // illusion.txt
        // planetsparty.txt
        // spiral.txt
        DatosUniverso du= DatosUniverso.leeDatos("data/universos/"+args[0]);
        ejemplo(pu,du);
    }

    public static void ejemplo(PanelUniverso pu, DatosUniverso du) {
        Universo un = du.universo();
        simula(pu,un,du.dt(),du.sleep());
    }

    public static void simula(PanelUniverso pu, Universo un, double dt, int sleep) {
        while(true) {
            un.avanza(dt);
            pu.pinta(un.particulas(), un.radio());
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
