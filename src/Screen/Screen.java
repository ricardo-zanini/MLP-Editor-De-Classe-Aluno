package Screen;
import Alert.UserAlert;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Screen extends JFrame{

    public Screen(String name, int width, int height)
    {
        screenConfig(name, new File("img/AppIcon.png"), width, height);
    }

    private void screenConfig(String screenName, File screenIcon, int width, int height){

        setName(screenName);
        setTitle(screenName);

        setSize(width, height);
        setResizable(false);
        
        setLayout(null);
        getContentPane().setBackground(new Color(38,38,38));
        
        // Adiciona Icone na Toolbar da página
        try {
            setIconImage(ImageIO.read(screenIcon));
        } catch (IOException e) {
            UserAlert userAlert = new UserAlert("ERRO - Erro ao carregar imagem!");
        }
    }

    public static void deleteDuplicatedScreens(String screenName){
        Window[] allFrames = Window.getWindows();
        for(Window fr : allFrames){
            if(fr.getName().equals(screenName) && fr.isVisible()){
                fr.dispose();
            }
        }
    }

    public static boolean screenAlreadyExists(String screenName){
        Window[] allFrames = Window.getWindows();
        for(Window fr : allFrames){
            if(fr.getName().equals(screenName) && fr.isVisible()){
                return true;
            }
        }
        return false;
    }

}
