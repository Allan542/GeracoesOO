package geracoes;
public class Pessoa {
    String nome;
    private String geracao;
    private int anonasc;
    
    public Pessoa(){    
    }
    public String getNome(){
    return nome;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public int getAnonasc(){
        return anonasc;
    }
    public void setAnonasc(int anonasc){
    this.anonasc=anonasc;
}
    public String getGeracao(){
        return geracao;
    }
    
    public void indicarGeracao(int anonasc){
              
        if (anonasc >= 1950 && anonasc <= 1964)
           this.geracao="Geração Baby Boomers (de 1950 a 1964) - utilizava telefones fixos";
        else if(anonasc >= 1965 && anonasc <= 1981)
            this.geracao="Geração X (de 1965 a 1981) - falavam usando celulares";
        else if (anonasc >= 1982 && anonasc <= 1993)
            this.geracao="Geração Y (de 1982 a 1993 - escreviam e-mails";
        else if (anonasc >= 1994 && anonasc <= 2010)
            this.geracao="Geração Z (de 1994 a 2010) - usam mídias sociais e apps por smartphones";
        else this.geracao="Você não faz parte de nenhuma das gerações ou digitou um ano inválido.";
    }
}
