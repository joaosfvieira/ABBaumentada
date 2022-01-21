public class Node 
{
    private int chave;
    private Node esq, dir;
    private int profundidade = 0;
    private int altura;

    public Node(int chave)
    {
        this.chave = chave;
        esq = null;
        dir = null;
    }

    public int getChave() 
    {
        return this.chave;
    }

    public void setChave(int chave) 
    {
        this.chave = chave;
    }

    public Node getEsq() 
    {
        return this.esq;
    }

    public void setEsq(Node esq) 
    {
        this.esq = esq;
    }

    public Node getDir() 
    {
        return this.dir;
    }

    public void setDir(Node dir) 
    {
        this.dir = dir;
    }

    public int getProfundidade() 
    {
        return this.profundidade;
    }

    public void setProfundidade(int profundidade) 
    {
        this.profundidade = profundidade;
    }

    public int getAltura() 
    {
        return this.altura;
    }

    public void setAltura(int altura) 
    {
        this.altura = altura;
    }

}
