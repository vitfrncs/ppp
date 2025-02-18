import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JVideo extends JCadastro {
    private JTextField tAutor, tEditor, tDuracao;

    public JVideo (ArrayList<Publicacao> publicacoes){
        super("Vídeos", publicacoes);
    }

    public void montarFormulario(){

        tAutor = new JTextField(15);
        tEditor = new JTextField(15);
        tDuracao = new JTextField(3);

        JPanel painelHead = new JPanel();
        adicionarAoPainel(painelHead, new FlowLayout(FlowLayout.CENTER),new JLabel("Vídeos"));

        JPanel painelTitulo = new JPanel();
        adicionarAoPainel(painelTitulo, new FlowLayout(FlowLayout.LEFT, 10, 5),new JLabel("Título:"), tTitulo);

        JPanel painelAutor = new JPanel();
        adicionarAoPainel(painelAutor, new FlowLayout(FlowLayout.LEFT, 10, 5), new JLabel("Autor:"), tAutor, new JLabel("Ano:"), tAno);

        JPanel painelEditorDuracao = new JPanel();
        adicionarAoPainel(painelEditorDuracao, new FlowLayout(FlowLayout.LEFT, 10, 5), new JLabel("Editor:"), tEditor, new JLabel("Duração:"), tDuracao);

        JPanel painelBotoes = new JPanel();
        adicionarAoPainel(painelBotoes, new FlowLayout(), incluir, revistas, videos, listagem);

        frame.setLayout(new GridLayout(5, 1));
        frame.add(painelHead);
        frame.add(painelTitulo);
        frame.add(painelAutor);
        frame.add(painelEditorDuracao);
        frame.add(painelBotoes);

    }

    public void adicionarEventos(){

        incluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String t = tTitulo.getText();
                String autor = tAutor.getText();
                String ano = tAno.getText();
                String editor = tEditor.getText();
                String duracao = tDuracao.getText();

                if (t.isEmpty() || autor.isEmpty() || ano.isEmpty() || editor.isEmpty() || duracao.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Algum campo está vazio. Tente novamente.", "Erro :(", JOptionPane.ERROR_MESSAGE);
                } else{
                    try {
                        //Verificando validade do que foi escrito pelo usuário
                        int anoInt = Integer.parseInt(ano);// se essa linha der errado, a exceção numberFormatException será jogada
                        float duracaoFloat = Float.parseFloat(duracao);
                        if (anoInt < 0 || duracaoFloat < 0.0) {
                            JOptionPane.showMessageDialog(null, "Formato numérico inválido. Tente novamente.", "Erro :(", JOptionPane.ERROR_MESSAGE);
                            return;
                        } else {
                            publicacoes.add(new Video(t, anoInt, duracaoFloat, editor, autor));
                            tTitulo.setText("");
                            tAno.setText("");
                            tAutor.setText("");
                            tEditor.setText("");
                            tDuracao.setText("");
                            JOptionPane.showMessageDialog(null, "Cadastro realizado :)", "Boa!", JOptionPane.INFORMATION_MESSAGE);
                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Formato numérico inválido. Tente novamente.", "Erro :(", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        adicionarEventosComuns();
    }
}