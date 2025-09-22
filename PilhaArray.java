public class PilhaArray implements Pilha {
    private int capacidade;
    private Object[] a;
    private int topoV;
    private int topoP;

    public PilhaArray(int capacidade, int crescimento) {

        this.capacidade = capacidade;
        this.topoP = capacidade;
        topoV = -1;
        this.a = new Object[capacidade];
        if (crescimento <= 0){
            crescimento = 0;
        }
    }
    // Vou usar o override para os metodos da pilha vermelha. Os métodos da pilha preta serão implementados sem override.
    @Override
    public int size(){
        return topoV+1;
    }

    @Override
    public boolean isEmpty(){
        if (this.size() == 0) {
            return true;
        }
        return false;
    }
    @Override
    public Object top () throws PilhaVaziaExcecao{
        if(isEmpty()){
            throw new PilhaVaziaExcecao("A pilha está vazia"); 
        }
        return a[topoV];
    }
    @Override
    public void push(Object o){
        aumenta_pilha_vermelha();
        a[++topoV] = o;


    }
    @Override
    public Object pop() throws PilhaVaziaExcecao{
         if(isEmpty()){
            throw new PilhaVaziaExcecao("A pilha está vazia"); 
        }
        Object r=a[topoV--];
        return r;
    }
    public void aumenta_pilha(){
        if (topoV+1 == capacidade){
            capacidade = capacidade*2;
            Object[] novo_array = new Object[capacidade];
            for(int i = 0; i< a.length; i++){
                novo_array[i] = a[i];
            }
            a = novo_array;
        }
    }
    public void reducao_pilha(){
        if((topoV+1 + capacidade - topoP) <= capacidade)
    }
}





