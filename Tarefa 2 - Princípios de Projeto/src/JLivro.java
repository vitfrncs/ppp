import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JLivro extends JCadastro {
    private JTextField tAutor;

    public JLivro(ArrayList<Publicacao> publicacoes) {
        super("Livros", publicacoes);
    }

    @Override
    public void montarFormulario() {
        tAutor = new JTextField(30);

        JPanel painelHead = new JPanel();
        adicionarAoPainel(painelHead, new FlowLayout(FlowLayout.CENTER),new JLabel("Livros"));

        JPanel painelTitulo = new JPanel();
        adicionarAoPainel(painelTitulo, new FlowLayout(FlowLayout.LEFT, 10, 5),new JLabel("Título:"), tTitulo);

        JPanel painelAutor = new JPanel();
        adicionarAoPainel(painelAutor, new FlowLayout(FlowLayout.LEFT, 10, 5), new JLabel("Autor:"), tAutor);

        JPanel painelAno = new JPanel();
        adicionarAoPainel(painelAno, new FlowLayout(FlowLayout.LEFT, 10, 5), new JLabel("Ano:"), tAno);

        JPanel painelBotoes = new JPanel();
        adicionarAoPainel(painelBotoes, new FlowLayout(), incluir, revistas, videos, listagem);

        frame.setLayout(new GridLayout(5, 1));
        frame.add(painelHead);
        frame.add(painelTitulo);
        frame.add(painelAutor);
        frame.add(painelAno);
        frame.add(painelBotoes);
    }

    @Override
    public void adicionarEventos() {
        incluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String t = tTitulo.getText();
                String autor = tAutor.getText();
                String ano = tAno.getText();

                if (t.isEmpty() || autor.isEmpty() || ano.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Algum campo está vazio. Tente novamente.", "Erro :(", JOptionPane.ERROR_MESSAGE);
                } else {
                    //Verificando se ano é um número valido:
                    try {
                        int anoInt = Integer.parseInt(ano); // se essa linha der errado, a exceção numberFormatException será jogada
                        if (anoInt < 0) {
                            JOptionPane.showMessageDialog(null, "Ano inválido. Tente novamente.", "Erro :(", JOptionPane.ERROR_MESSAGE);
                            return;
                        } else {
                            publicacoes.add(new Livro(t, anoInt, autor));
                            tTitulo.setText("");
                            tAno.setText("");
                            tAutor.setText("");
                            JOptionPane.showMessageDialog(null, "Cadastro realizado :)", "Boa!", JOptionPane.INFORMATION_MESSAGE);
                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Ano inválido. Tente novamente.", "Erro :(", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });


        adicionarEventosComuns();
    }
}
