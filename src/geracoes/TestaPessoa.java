package geracoes;
import javax.swing.JOptionPane;
public class TestaPessoa {
   static Pessoa arraypessoa[] = new Pessoa[10];
   
public static void ordenaGeracaoSelectionSort(int nropess) {
int posmaior, anonasc, i, j, ano, anoposmaior;
Pessoa anonascposmaior = new Pessoa();
Pessoa pess = new Pessoa();
Pessoa aux = new Pessoa();
for (i = 0; i < nropess - 1; i++) {
posmaior = i;
anonascposmaior = arraypessoa[i];
anoposmaior = anonascposmaior.getAnonasc ();
for (j = i + 1; j < nropess; j++) {
pess = arraypessoa[j];
ano = pess.getAnonasc();
if (ano > anoposmaior) {
posmaior = j;
anoposmaior = pess.getAnonasc();
}//if
}//for
aux = arraypessoa[posmaior];
arraypessoa[posmaior] = arraypessoa[i];
arraypessoa[i] = aux;
}//for
}//ordenaGeracaoSelectionSort

public static void mostraGeracao(int nropess, String nomeent){
    Pessoa pess;
   int k;
   String nome;
    boolean achou=false;
    pess = new Pessoa();
    StringBuilder mensagem = new StringBuilder();
    
    for(k=0; k<nropess; k++){
        pess = arraypessoa[k];
        nome = pess.getNome();
        if(nome.equals(nomeent)){
          mensagem.append ("Nome da Pessoa: " +pess.getNome()+"\n");
         mensagem.append ("Ano de nascimento da pessoa: " +pess.getAnonasc()+"\n");
         mensagem.append ("Geração que a pessoa pertence: " +pess.getGeracao()+"\n");

        JOptionPane.showMessageDialog(null,mensagem, "Geração da Pessoa",JOptionPane.INFORMATION_MESSAGE);
            achou= true;
            break;
        }//if
    }//for
    if (achou==false){
        JOptionPane.showMessageDialog(null,nomeent+" não está cadastrado");
        
    }//if
}//mostraGeracao

   public static void main (String[] args){
    Pessoa pess;
int k, nropess, anonasc;
String s, saida;
StringBuilder mensagem;

for (;;){
s=JOptionPane.showInputDialog("Quantas pessoas serão cadastrados (1 a "+arraypessoa.length+")? ");
try {
nropess = Integer.parseInt(s);
if (nropess < 1 || nropess > arraypessoa.length){
JOptionPane.showMessageDialog(null,"Valor inválido. Digite um número entre 1 e " +
arraypessoa.length + ". ", "Erro",
JOptionPane.ERROR_MESSAGE);
continue;
}//if
else
break;
} catch (NumberFormatException e) {
saida = "Não é possível converter a string "+s+ " para o tipo int nropess.\n";
JOptionPane.showMessageDialog(null,saida,"Exceção",JOptionPane.ERROR_MESSAGE);
continue;
}//catch
    } // for ;;
for (k=0; k < nropess; k++){
pess = new Pessoa();
//pede e lê os dados de uma pessoa
pess.setNome(JOptionPane.showInputDialog("Qual é o nome da "+(k+1)+"ª pessoa? "));
//exemplo de solicitação de um atributo com validação persistente e bloco try catch
for(;;){
s= JOptionPane.showInputDialog("Qual o ano a "+(k+1)+"ª pessoa nasceu (entre 1950 e 2010)? ");
try {
 anonasc = Integer.parseInt(s);
if (anonasc >= 1950 && anonasc <= 2010){
pess.setAnonasc(anonasc);
break;
}//if
else { JOptionPane.showMessageDialog(null,"Data de nascimento inválida, digite uma data entre 1950 e 2010", "Erro",
JOptionPane.ERROR_MESSAGE);
continue;
}//else
}//try
catch (NumberFormatException erro) {
saida = "Não é possível converter a string "+s+ " à variável int tipo anonasc\n";
JOptionPane.showMessageDialog(null,saida,"Exceção",JOptionPane.ERROR_MESSAGE);
continue;
}//catch
}//for ;;

pess.indicarGeracao(anonasc);
arraypessoa[k]= pess;

   }//for k;;



mensagem = new StringBuilder();
for (k=0; k < nropess; k++){
pess=arraypessoa[k];
//mostra os dados sem ordenação
mensagem.append ("Nome da Pessoa: " +pess.getNome()+"\n");
mensagem.append ("Ano de nascimento da pessoa: " +pess.getAnonasc()+"\n");
mensagem.append ("Geração que a pessoa pertence: " +pess.getGeracao()+"\n\n");
}//for
JOptionPane.showMessageDialog(null,mensagem, "Pessoas sem ordenação por ano",
JOptionPane.INFORMATION_MESSAGE);

ordenaGeracaoSelectionSort(nropess);

mensagem = new StringBuilder();
for (k=0; k < nropess; k++){
pess=arraypessoa[k];
//mostra os dados com ordenação
mensagem.append ("Nome da Pessoa: " +pess.getNome()+"\n");
mensagem.append ("Ano de nascimento da pessoa: " +pess.getAnonasc()+"\n");
mensagem.append ("Geração que a pessoa pertence: " +pess.getGeracao()+"\n\n");
}//for
JOptionPane.showMessageDialog(null,mensagem, "Pessoas com ordenação por ano",
JOptionPane.INFORMATION_MESSAGE);

mensagem = new StringBuilder();
for (;;){
    
        String nome = JOptionPane.showInputDialog("Digite o nome da pessoa ou * para finalizar");
    if (nome.equals("*")){
        mensagem.append ("Programa finalizado com sucesso, Tenha um bom dia!");
        JOptionPane.showMessageDialog(null,mensagem, "Pessoas com ordenação por ano",
        JOptionPane.WARNING_MESSAGE);
    break;
    }
    else{
    mostraGeracao(nropess, nome);
            }
    
}//for ;;

   }//main
   
   
}// classe TestaPessoa
