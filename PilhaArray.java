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
    @Override
    public int size(){
        return t+1;
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
        return a[t];
    }
    @Override
    public void push(Object o){

    }
    @Override
    public Object pop() throws PilhaVaziaExcecao{
        Object r=a[t--];
        return r;
    }
}





