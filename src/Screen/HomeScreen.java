package Screen;

import Alert.UserAlert;
import Classes.Aluno;
import Classes.Aluno.Niveis;
import Classes.Pessoa.Generos;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class HomeScreen extends Screen{

    private JLabel labelNome;
    private JTextField fieldNome;
    
    private JLabel labelDataNascimento;
    private JTextField fieldDataNascimento;
    
    private JLabel labelGenero;
    private Generos generoSelecionado = Generos.INDEFINIDO;
    private ArrayList<JButton> buttonsGeneros = new ArrayList<>();
    
    private JLabel labelNivel;
    private Niveis nivelSelecionado = Niveis.INDEFINIDO;
    private ArrayList<JButton> buttonsNiveis = new ArrayList<>();
    
    private JLabel labelMatricula;
    private JTextField fieldMatricula;

    private JButton buttonAdicionar;

    private ArrayList<Aluno> alunos = new ArrayList<>();


    private final Color colorBackgroundButtons= new Color(120, 90,148);
    private final Color colorBackgroundFields = new Color(33, 33, 33);
    private final Color colorTextFields       = new Color(204, 204, 204);
    private final Color colorTextLabels       = Color.white;
    private final Color colorButtonClicked    = new Color(88, 62, 112);
    

    public HomeScreen(){
        super("Tela Inicial", 400, 650);

        setLocation(20, 20);
        
        createComponents();
        configComponents();
        addComponents();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private void createComponents() {
        setLabelNome(new JLabel("- NOME -"));
        setFieldNome(new JTextField(""));

        setLabelDataNascimento(new JLabel("- DATA DE NASCIMENTO -"));
        setFieldDataNascimento(new JTextField("01/01/1970"));

        setLabelGenero(new JLabel("- GENERO -"));
        for(Generos i : Generos.values()){
            addButtonsGeneros(new JButton(i.getDescricao()));
        }

        setLabelNivel(new JLabel("- NIVEL -"));
        for(Niveis i : Niveis.values()){
            addButtonsNiveis(new JButton(i.getDescricao()));
        }

        setLabelMatricula(new JLabel("- MATRICULA -"));
        setFieldMatricula(new JTextField(""));

        setButtonAdicionar(new JButton("ADICIONAR"));
    }

    private void configComponents() {
        try{
            File fontStyle = new File("Fonts/pixelated_fancy_font.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle);
            
            labelNome.setFont(font.deriveFont(16f));
            fieldNome.setFont(font.deriveFont(16f));
            labelDataNascimento.setFont(font.deriveFont(16f));
            fieldDataNascimento.setFont(font.deriveFont(16f));
            labelGenero.setFont(font.deriveFont(16f));
            labelNivel.setFont(font.deriveFont(16f));
            labelMatricula.setFont(font.deriveFont(16f));
            fieldMatricula.setFont(font.deriveFont(16f));

            for(int i = 0; i < Generos.values().length; i++){
                buttonsGeneros.get(i).setFont(font.deriveFont(10f));
            }for(int i = 0; i < Niveis.values().length; i++){
                buttonsNiveis.get(i).setFont(font.deriveFont(10f));
            }

            buttonAdicionar.setFont(font.deriveFont(16f));
            
        }catch(FontFormatException | IOException e){
            UserAlert userAlert = new UserAlert("ERRO - Erro ao carregar Fonte"); 
        }

        //=====================================================================

        labelNome.setBounds(20, 20, 300, 50);
        labelNome.setForeground(colorTextLabels);

        fieldNome.setBounds(20, 65, 345, 40);
        fieldNome.setBackground(colorBackgroundFields);
        fieldNome.setBorder(new LineBorder(colorBackgroundFields,10));
        fieldNome.setForeground(colorTextFields);

        //=====================================================================

        labelDataNascimento.setBounds(20, 100, 300, 50);
        labelDataNascimento.setForeground(colorTextLabels);

        fieldDataNascimento.setBounds(20, 145, 345, 40);
        fieldDataNascimento.setBackground(colorBackgroundFields);
        fieldDataNascimento.setBorder(new LineBorder(colorBackgroundFields,10));
        fieldDataNascimento.setForeground(colorTextFields);

        //=====================================================================

        labelGenero.setBounds(20, 180, 300, 50);
        labelGenero.setForeground(colorTextLabels);


        for(int i = 0; i < Generos.values().length; i++){
            
            buttonsGeneros.get(i).setBounds(20 + (345 / Generos.values().length) * i, 225, (345 / Generos.values().length), 40);
            buttonsGeneros.get(i).setBackground(colorBackgroundButtons);
            buttonsGeneros.get(i).setBorder(new LineBorder(Color.BLACK,0));
            buttonsGeneros.get(i).setFocusable(false);
            buttonsGeneros.get(i).setForeground(Color.WHITE);
            buttonsGeneros.get(i).putClientProperty("id", Generos.values()[i]);
            
            final int aux = i;
            buttonsGeneros.get(i).addActionListener(event -> eventGeneros(aux));
        }

        //=====================================================================

        labelNivel.setBounds(20, 260, 300, 50);
        labelNivel.setForeground(colorTextLabels);

        for(int i = 0; i < Niveis.values().length; i++){
            
            buttonsNiveis.get(i).setBounds(20 + (345 / Niveis.values().length) * i, 305, (345 / Niveis.values().length), 40);
            buttonsNiveis.get(i).setBackground(colorBackgroundButtons);
            buttonsNiveis.get(i).setBorder(new LineBorder(Color.BLACK,0));
            buttonsNiveis.get(i).setFocusable(false);
            buttonsNiveis.get(i).setForeground(Color.WHITE);
            buttonsNiveis.get(i).putClientProperty("id", Niveis.values()[i]);
            
            final int aux = i;
            buttonsNiveis.get(i).addActionListener(event -> eventNiveis(aux));
        }

        //=====================================================================

        labelMatricula.setBounds(20, 340, 300, 50);
        labelMatricula.setForeground(colorTextLabels);

        fieldMatricula.setBounds(20, 385, 345, 40);
        fieldMatricula.setBackground(colorBackgroundFields);
        fieldMatricula.setBorder(new LineBorder(colorBackgroundFields,10));
        fieldMatricula.setForeground(colorTextFields);

        //=====================================================================


        buttonAdicionar.setBounds(20, 445, 345, 40);
        buttonAdicionar.setBackground(colorBackgroundButtons);
        buttonAdicionar.setBorder(new LineBorder(Color.BLACK,0));
        buttonAdicionar.setFocusable(false);
        buttonAdicionar.setForeground(Color.WHITE);

        buttonAdicionar.addActionListener(event -> eventAdicionaAluno());

    }
    
    private void addComponents() {
        add(labelNome);
        add(fieldNome);
        add(labelDataNascimento);
        add(fieldDataNascimento);
        add(labelGenero);
        for(int i = 0; i < Generos.values().length; i++){
            add(buttonsGeneros.get(i));
        }
        add(labelNivel);
        for(int i = 0; i < Niveis.values().length; i++){
            add(buttonsNiveis.get(i));
        }
        add(labelMatricula);
        add(fieldMatricula);
        add(buttonAdicionar);
    }

    private void eventGeneros(int atual){
        for(int i = 0; i < Generos.values().length; i++){
            buttonsGeneros.get(i).setBackground(colorBackgroundButtons);
        }
        buttonsGeneros.get(atual).setBackground(colorButtonClicked);
        setGeneroSelecionado((Generos)buttonsGeneros.get(atual).getClientProperty("id"));
    }

    private void eventNiveis(int atual){
        for(int i = 0; i < Niveis.values().length; i++){
            buttonsNiveis.get(i).setBackground(colorBackgroundButtons);
        }
        buttonsNiveis.get(atual).setBackground(colorButtonClicked);
        setNivelSelecionado((Niveis)buttonsNiveis.get(atual).getClientProperty("id"));
    }

    private void eventAdicionaAluno(){
        LocalDate date = null;

        try {
            date = LocalDate.parse(getFieldDataNascimento().getText(), DateTimeFormatter.ofPattern("dd/MM/uuuu"));
        } catch (Exception e) {
            UserAlert userAlert = new UserAlert("ERRO - Formato de data incorreto!");
            return;
        }

        addAlunos(new Aluno(
            getFieldNome().getText(),
            getGeneroSelecionado(),
            date,
            getNivelSelecionado(),
            getFieldMatricula().getText()
        ));
        
        for(Aluno i : getAlunos()){
            i.printAluno();
        }
    }

    public JLabel getLabelNome() {
        return labelNome;
    }
    public void setLabelNome(JLabel labelNome) {
        this.labelNome = labelNome;
    }


    public JLabel getLabelDataNascimento() {
        return labelDataNascimento;
    }
    public void setLabelDataNascimento(JLabel labelDataNascimento) {
        this.labelDataNascimento = labelDataNascimento;
    }


    public JLabel getLabelGenero() {
        return labelGenero;
    }
    public void setLabelGenero(JLabel labelGenero) {
        this.labelGenero = labelGenero;
    }


    public JLabel getLabelNivel() {
        return labelNivel;
    }
    public void setLabelNivel(JLabel labelNivel) {
        this.labelNivel = labelNivel;
    }


    public JLabel getLabelMatricula() {
        return labelMatricula;
    }
    public void setLabelMatricula(JLabel labelMatricula) {
        this.labelMatricula = labelMatricula;
    }

    //======================================================


    public JTextField getFieldNome() {
        return fieldNome;
    }
    public void setFieldNome(JTextField fieldNome) {
        this.fieldNome = fieldNome;
    }


    public JTextField getFieldDataNascimento() {
        return fieldDataNascimento;
    }
    public void setFieldDataNascimento(JTextField fieldDataNascimento) {
        this.fieldDataNascimento = fieldDataNascimento;
    }


    public Generos getGeneroSelecionado() {
        return generoSelecionado;
    }
    public void setGeneroSelecionado(Generos generoSelecionado) {
        this.generoSelecionado = generoSelecionado;
    }


    public Niveis getNivelSelecionado() {
        return nivelSelecionado;
    }
    public void setNivelSelecionado(Niveis nivelSelecionado) {
        this.nivelSelecionado = nivelSelecionado;
    }


    public JTextField getFieldMatricula() {
        return fieldMatricula;
    }
    public void setFieldMatricula(JTextField fieldMatricula) {
        this.fieldMatricula = fieldMatricula;
    }

    public ArrayList<JButton> getButtonsGeneros() {
        return buttonsGeneros;
    }
    public void setButtonsGeneros(ArrayList<JButton> buttonsGeneros) {
        this.buttonsGeneros = buttonsGeneros;
    }
    public void addButtonsGeneros(JButton buttonsGeneros) {
        this.buttonsGeneros.add(buttonsGeneros);
    }


    public ArrayList<JButton> getButtonsNiveis() {
        return buttonsNiveis;
    }
    public void setButtonsNiveis(ArrayList<JButton> buttonsNiveis) {
        this.buttonsNiveis = buttonsNiveis;
    }
    public void addButtonsNiveis(JButton buttonsNiveis) {
        this.buttonsNiveis.add(buttonsNiveis);
    }


    public JButton getButtonAdicionar() {
        return buttonAdicionar;
    }
    public void setButtonAdicionar(JButton buttonAdicionar) {
        this.buttonAdicionar = buttonAdicionar;
    }


    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }
    public void setaAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }
    public void addAlunos(Aluno aluno) {
        this.alunos.add(aluno);
    }
}