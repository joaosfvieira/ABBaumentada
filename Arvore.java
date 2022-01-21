import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Arvore
{
    private Node raiz;
    private int quantidadeDeElementos;
    int alturaArvore = -1;

    public Node getRaiz() {
        return this.raiz;
    }

    public void setRaiz(Node raiz) {
        this.raiz = raiz;
    }

    public Arvore()
    {
        this.raiz = null;
        this.quantidadeDeElementos = 0;
    }

    Node buscaNo(Node raiz, int chave)
    {
        if(raiz == null)
            return null;

        if(raiz.getChave() == chave) 
            return raiz;

        else if(chave < raiz.getChave())

            return buscaNo(raiz.getEsq(), chave);
        else
            return buscaNo(raiz.getDir(), chave);
    }
   
    Node inserirRecursivo(Node raiz, int chave) 
    { 
        if (raiz == null) 
        { 
            raiz = new Node(chave);
            quantidadeDeElementos++;
            return raiz; 
        } 

        if (chave < raiz.getChave())
            raiz.setEsq(inserirRecursivo(raiz.getEsq(), chave)); 
        else if (chave > raiz.getChave())
            raiz.setDir(inserirRecursivo(raiz.getDir(), chave)); 
        
        return raiz; 
    } 

    void removerNo(int chave) 
    { 
        raiz = removerNoRecursivo(raiz, chave);
        quantidadeDeElementos--; 
    } 
   
    Node removerNoRecursivo(Node raiz, int chave)  
    { 
        if (raiz == null)  
            return raiz; 
   
        if (chave < raiz.getChave()) 
            raiz.setEsq(removerNoRecursivo(raiz.getEsq(), chave)); 
        else if (chave > raiz.getChave()) 
            raiz.setDir(removerNoRecursivo(raiz.getDir(), chave)); 
        else 
        { 
            if (raiz.getEsq() == null) 
                return raiz.getDir(); 
            else if (raiz.getDir() == null) 
                return raiz.getEsq(); 
                
            raiz.setChave(minValue(raiz.getDir())); 
            raiz.setDir(removerNoRecursivo(raiz.getDir(), raiz.getChave())); 
        } 
        return raiz; 
    } 
   
    int minValue(Node raiz)  
    { 
        int minval = raiz.getChave(); 

        while (raiz.getEsq() != null)  
        { 
            minval = raiz.getEsq().getChave(); 
            raiz = raiz.getEsq(); 
        } 
        return minval; 
    } 
    
    void ordemSimetrica() 
    {
        ordemSimetricaRecursivo(raiz); 
        System.out.println("\n"); 
    } 
   
    void ordemSimetricaRecursivo(Node raiz) 
    { 
        if (raiz != null) 
        { 
            ordemSimetricaRecursivo(raiz.getEsq()); 
            System.out.print(raiz.getChave() + " "); 
            ordemSimetricaRecursivo(raiz.getDir()); 
        } 
    } 

    static int contador = 0;
    void enesimoElementoRecursivo(Node raiz, int pos)
    {
        if(raiz == null)
            return;
        if(contador <= pos)
        {
            enesimoElementoRecursivo(raiz.getEsq(), pos);
            contador++;

            if(contador == pos)
                System.out.println(raiz.getChave());
            
            enesimoElementoRecursivo(raiz.getDir(), pos);
        }
    }

    int posicaoRecursivo(Node raiz, int chave, int cont)
    {
        if(raiz != null)
        {
            cont = posicaoRecursivo(raiz.getEsq(), chave, cont);
            if(cont !=0)
            {
                if(chave == raiz.getChave())
                    System.out.println("O elemento " + raiz.getChave() + " esta no localizado na posicao: " + cont + "\n");
                
                cont++;
            }
            cont = posicaoRecursivo(raiz.getDir(), chave, cont);
            return cont; 
        }
        else
        {
            if(cont ==0)
                return(cont+1);

            return cont;
        }
    }

    void mediana()
    {
        contador = 0;
        int posMediana = (quantidadeDeElementos+1)/2;
        enesimoElementoRecursivo(raiz, posMediana);
    }

    int acharAltura(Node raiz, int x)
    {
        acharAlturaRecursivo(raiz, x);
        return raiz.getAltura();
    }

    int acharAlturaRecursivo(Node raiz, int x)
    {
        if (raiz == null)
            return -1;

        int esqAltura = acharAlturaRecursivo(raiz.getEsq(), x);
        int dirAltura = acharAlturaRecursivo(raiz.getDir(), x);

        int altura = Math.max(esqAltura, dirAltura) + 1;

        if (raiz.getChave() == x)
            raiz.setAltura(altura);
    
        return altura;
    }

    void ehCheia()
    {
        if(ehCheiaRecursivo(raiz))
            System.out.println("Eh cheia!\n");
        else   
            System.out.println("Nao eh cheia.\n");
    }
    
    boolean ehCheiaRecursivo(Node no)
    {
        if(raiz == null) 
            return true;
         
        if(no.getEsq() == null && no.getDir() == null && acharProfundidade(this.raiz, no.getChave()) == acharAltura(this.raiz, this.raiz.getChave()))
            return true;
        
        if((no.getEsq() != null) && (no.getDir() != null))
            return (ehCheiaRecursivo(no.getEsq()) && ehCheiaRecursivo(no.getDir()));
         
        return false;
    }
    
    int acharProfundidade(Node raiz, int chave)
    {
        if(raiz == null)
            return -1;
        int profundidade = -1;

        if((raiz.getChave() == chave)|| (profundidade = acharProfundidade(raiz.getEsq(), chave)) >= 0 || (profundidade = acharProfundidade(raiz.getDir(), chave)) >= 0)
            return profundidade + 1;

        return profundidade;
    }

    void ehCompleta()
    {   
        if(ehCheiaRecursivo(this.raiz))
            System.out.println("Eh completa!\n");
        else if(ehCompletaRecursiva(raiz, 0, quantidadeDeElementos))
            System.out.println("Eh completa!\n");
        else 
            System.out.println("Nao eh completa!\n");
    }

    boolean ehCompletaRecursiva(Node raiz, int indice, int quantidadeDeElementos)
    {
        if (raiz == null)   
            return true;
  
        if (indice >= quantidadeDeElementos)
            return false;
  
        return (ehCompletaRecursiva(raiz.getEsq(), 2 * indice + 1, quantidadeDeElementos) && ehCompletaRecursiva(raiz.getDir(), 2 * indice + 2, quantidadeDeElementos));
    }

    public void lerArquivos(String[] args) throws FileNotFoundException
    {
        Scanner input = new Scanner(new File(args[0]));
        String str = input.nextLine();
        String[] numerosInseridosABB = str.split(" ");
        
        for(int i=0; i < numerosInseridosABB.length; i++)
            raiz = inserirRecursivo(raiz, Integer.parseInt(numerosInseridosABB[i]));

        Scanner input2 = new Scanner(new File(args[1]));
        ArrayList<String> leitorDoFile = new ArrayList<String>();

        while(input2.hasNextLine())
            leitorDoFile.add(input2.nextLine());
        
        for(String a : leitorDoFile)
        {
            switch (a)
            {
                case "CHEIA":
                    ehCheia();
                break;
                case "COMPLETA":
                    ehCompleta();
                break;
                case "MEDIANA":
                    mediana();
                break;
                case "IMPRIMA":
                    ordemSimetrica();
                break;
                default:

                String[] separaComandoDoNumero = a.split(" ");
                int indice = Integer.parseInt(separaComandoDoNumero[1]);

                switch(separaComandoDoNumero[0])
                {
                    case "ENESIMO":
                    enesimoElementoRecursivo(raiz, indice);
                    break;
                    case "POSICAO":
                    posicaoRecursivo(raiz, indice, 0);
                    break;
                    case "INSIRA":
                    raiz = inserirRecursivo(raiz, indice);
                    break;
                    case "REMOVA":
                    removerNo(indice);
                    break;
                }

                break;
            }
        }
    }

    public static void main(String[] args)
    {
        Arvore arvoreBinariaBusca = new Arvore();
        
        try
        {
            arvoreBinariaBusca.lerArquivos(args);
        }
        catch(FileNotFoundException ex)
        {
            ex.printStackTrace();
            System.exit(1);
        }
        
    }
}