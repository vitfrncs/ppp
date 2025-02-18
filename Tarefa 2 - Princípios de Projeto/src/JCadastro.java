import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public abstract class JCadastro {
    //atributos em comum das classes de cadastro:
    protected JFrame frame;
    protected JTextField tTitulo, tAno;
    protected JButton incluir, listagem, livros, revistas, videos;
    protected ArrayList<Publicacao> publicacoes;

    public JCadastro(String titulo, ArrayList<Publicacao> publicacoes){
        this.publicacoes = publicacoes;
        frame = new JFrame("Cadastro de " + titulo);
        frame.setSize(470, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(250, 250, 250));

        tTitulo = new JTextField(30);
        tAno = new JTextField(3);
        incluir = new JButton("Incluir");
        listagem = new JButton("Listagem");
        livros = new JButton("Livros");
        revistas = new JButton("Revistas");
        videos = new JButton("Vídeos");

        montarFormulario();
        adicionarEventos();

        frame.setVisible(true);

    }

    //esse método centraliza todas as inserções de componentes a um painel, o que melhora a manutenção do código
    protected void adicionarAoPainel(JPanel painel, LayoutManager layout, JComponent... componentes) {
        painel.setLayout(layout);
        for (JComponent c : componentes) {
            painel.add(c);
        }
    }



    public abstract void montarFormulario();
    public abstract void adicionarEventos();

    protected void adicionarEventosComuns() {
        revistas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new JRevista(publicacoes);
            }
        });

        listagem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new JListagem(publicacoes);
            }
        });

        livros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new JLivro(publicacoes);
            }
        });

        videos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new JVideo(publicacoes);
            }
        });
    }
}