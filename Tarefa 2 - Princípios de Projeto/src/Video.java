public class Video extends Publicacao{
    private String editor;
    private String autor;
    private float duracao;

    public Video (String t, int a, float d, String ed, String aut){
        super(t,a);
        this.duracao = d;
        this.editor = ed;
        this.autor = aut;
    }

    public String toString(){
        return "Video: " + titulo + " Autor: " + autor + " Editor: " + editor + " Duração: " + duracao + " Ano: " + ano;
    }

    public float getDuracao() {
        return duracao;
    }

    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }
}