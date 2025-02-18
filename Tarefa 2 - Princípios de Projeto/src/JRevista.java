import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JRevista extends JCadastro {
    private JTextField tOrg, tVol, tNum;

    public JRevista(ArrayList<Publicacao> publicacoes) {
        super("Revistas", publicacoes);
    }

    @Override
    public void montarFormulario() {
        tOrg = new JTextField(30);
        tVol = new JTextField(3);
        tNum = new JTextField(3);

        JPanel painelHead = new JPanel();
        adicionarAoPainel(painelHead, new FlowLayout(FlowLayout.CENTER),new JLabel("Revistas"));

        JPanel painelTitulo = new JPanel();
        adicionarAoPainel(painelTitulo, new FlowLayout(FlowLayout.LEFT, 10, 5), new JLabel("Título:"), tTitulo);

        JPanel painelOrg = new JPanel();
        adicionarAoPainel(painelOrg, new FlowLayout(FlowLayout.LEFT, 13, 5), new JLabel("Org:"), tOrg);

        JPanel painelDados = new JPanel();
        adicionarAoPainel(painelDados, new FlowLayout(FlowLayout.LEFT, 13, 5), new JLabel("Vol:"), tVol, new JLabel("Nro:"), tNum, new JLabel("Ano:"), tAno);

        JPanel painelBotoes = new JPanel();
        adicionarAoPainel(painelBotoes, new FlowLayout(), incluir, livros, videos, listagem);

        frame.setLayout(new GridLayout(5, 1));
        frame.add(painelHead);
        frame.add(painelTitulo);
        frame.add(painelOrg);
        frame.add(painelDados);
        frame.add(painelBotoes);
    }

    @Override
    public void adicionarEventos() {
        incluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String t = tTitulo.getText();
                String org = tOrg.getText();
                String nro = tNum.getText();
                String vol = tVol.getText();
                String ano = tAno.getText();

                if (t.isEmpty() || org.isEmpty() || ano.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Algum campo está vazio. Tente novamente.", "Erro :(", JOptionPane.ERROR_MESSAGE);
                } else {
                    //Verificando se ano é um número valido:
                    try {
                        int nroInt = Integer.parseInt(nro);
                        int volInt = Integer.parseInt(vol);
                        int anoInt = Integer.parseInt(ano); // se essa linha der errado, a exceção numberFormatException será jogada
                        if (anoInt < 0 || volInt <= 0 || nroInt <= 0) {
                            JOptionPane.showMessageDialog(null, "Formato inválido. Tente novamente.", "Erro :(", JOptionPane.ERROR_MESSAGE);
                            return;
                        } else {
                            publicacoes.add(new Revista(t, anoInt, org, volInt, nroInt));
                            tTitulo.setText("");
                            tAno.setText("");
                            tOrg.setText("");
                            tVol.setText("");
                            tNum.setText("");
                            JOptionPane.showMessageDialog(null, "Cadastro realizado :)", "Boa!", JOptionPane.INFORMATION_MESSAGE);
                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Formato inválido. Tente novamente.", "Erro :(", JOptionPane.ERROR_MESSAGE);
                    }
                }


            }
        });

        adicionarEventosComuns();
    }
}
