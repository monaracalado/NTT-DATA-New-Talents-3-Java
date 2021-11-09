package dio.everis;

import java.time.chrono.MinguoDate;

public class ListaDuplamenteEncadeada<T> {

    private dio.everis.NoDuplo<T> primeiroNo;
    private dio.everis.NoDuplo<T> ultimoNo;

    private int tamanhoLista;

    public ListaDuplamenteEncadeada(){
        this.primeiroNo = null;
        this.ultimoNo= null;
        this.tamanhoLista = 0;
    }

    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    public void add(T elemento){
        dio.everis.NoDuplo<T> novoNo = new dio.everis.NoDuplo<>(elemento);
        novoNo.setNoProximo(null);
        novoNo.setNoPrevio(ultimoNo);
        if (primeiroNo == null){
            primeiroNo = novoNo;
        }
        if (ultimoNo != null){
            ultimoNo.setNoProximo(novoNo);
        }
        ultimoNo = novoNo;
        tamanhoLista++;
    }

    public void add(int index, T elemento){
        dio.everis.NoDuplo<T> noAuxiliar = getNo(index);
        dio.everis.NoDuplo<T> novoNo = new dio.everis.NoDuplo<>(elemento);
        novoNo.setNoProximo(noAuxiliar);
        if (novoNo.getNoProximo() != null){
            novoNo.setNoPrevio(noAuxiliar.getNoPrevio());
            novoNo.getNoProximo().setNoPrevio(novoNo);
        }
        else{
            novoNo.setNoPrevio(ultimoNo);
            ultimoNo = novoNo;
        }
        if (index == 0){
            primeiroNo = novoNo;
        }
        else{
            novoNo.getNoPrevio().setNoProximo(novoNo);
        }
        tamanhoLista++;
    }

    public void remove(int index){
        if (index == 0){
            primeiroNo = primeiroNo.getNoProximo();
            if (primeiroNo != null){
                primeiroNo.setNoPrevio(null);
            }
            else{
                dio.everis.NoDuplo<T> noAuxiliar = getNo(index);
                noAuxiliar.getNoPrevio().setNoProximo(noAuxiliar.getNoProximo());
                if (noAuxiliar != ultimoNo){
                    noAuxiliar.getNoProximo().setNoPrevio(noAuxiliar.getNoPrevio());
                }
                else{
                    ultimoNo = noAuxiliar;
                }
            }
        }

        this.tamanhoLista--;
    }


    private dio.everis.NoDuplo<T> getNo(int index){
        dio.everis.NoDuplo<T> noAuxiliar = primeiroNo;
        for (int i = 0; (i < index) && (noAuxiliar != null); i++){
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        return noAuxiliar;
    }

    public int size(){
        return tamanhoLista;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        dio.everis.NoDuplo<T> noAuxiliar = primeiroNo;
        for (int i = 0; i < size(); i++){
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() + "}]--->";
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        strRetorno += "null";
        return strRetorno;
    }
}