public class Pilha {
    private int capacidade;
    private Object[] a;
    private int topoV;
    private int topoP;

    public Pilha(int capacidade, int crescimento) {

        this.capacidade = capacidade;
        this.topoP = capacidade;
        topoV = -1;
        this.a = new Object[capacidade];
        if (crescimento <= 0){
            crescimento = 0;
        }
    }
    public int size(){
        return topoV+1;
    }

    public boolean isEmpty(){
        if (this.size() == 0) {
            return true;
        }
        return false;
    }
      public void aumenta_pilha(){
        //duplica array quando as pilhas se encontrarem
        if (topoV + 1 == topoP) {
            int novaCapacidade = capacidade * 2;
            Object[] novo_array = new Object[novaCapacidade];
            for (int i = 0; i <= topoV; i++) {
                novo_array[i] = a[i];
            }
            //copia pilha preta (do final)
            int novoTopoP = novaCapacidade - (capacidade - topoP);
            for (int i = capacidade - 1; i >= topoP; i--) {
                novo_array[novoTopoP + (i - topoP)] = a[i];
            }
            topoP = novoTopoP;
            capacidade = novaCapacidade;
            a = novo_array;
        }
    }
    public void reducao_pilha(){
        int totalElementos = (topoV + 1) + (capacidade - topoP);
        if (capacidade > 1 && totalElementos <= (capacidade / 3)) {
            int novaCapacidade = Math.max(1, capacidade / 2);
            Object[] novo_array = new Object[novaCapacidade];
            //copia pilha vermelha
            for (int i = 0; i <= topoV; i++) {
                novo_array[i] = a[i];
            }
            //copia pilha preta
            int novoTopoP = novaCapacidade - (capacidade - topoP);
            for (int i = capacidade - 1; i >= topoP; i--) {
                novo_array[novoTopoP + (i - topoP)] = a[i];
            }
            topoP = novoTopoP;
            capacidade = novaCapacidade;
            a = novo_array;
        }
    }
    public Object top_vermelho () throws PilhaVaziaExcecao{
        if(isEmpty()){
            throw new PilhaVaziaExcecao("A pilha está vazia"); 
        }
        return a[topoV];
    }
    public void push_vermelho(Object o){
        aumenta_pilha();
        a[++topoV] = o;


    }
    public Object pop_vermelho() throws PilhaVaziaExcecao{
         if(isEmpty()){
            throw new PilhaVaziaExcecao("A pilha está vazia"); 
        }
        Object r=a[topoV--];
        reducao_pilha();
        return r;
    }
  
    public void push_preto(Object o){
        aumenta_pilha();
        a[--topoP] = o;
    }
    public Object pop_preto() throws PilhaVaziaExcecao{
        if(topoP == capacidade){
            throw new PilhaVaziaExcecao("A pilha está vazia");
}
        Object r = a[topoP++];
        reducao_pilha();
        return r;
    }
    public Object top_preto() throws PilhaVaziaExcecao {
        if (topoP == capacidade) {
            throw new PilhaVaziaExcecao("A pilha preta está vazia");
        }
        return a[topoP];
}

}