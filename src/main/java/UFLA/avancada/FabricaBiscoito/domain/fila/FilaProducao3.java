package UFLA.avancada.FabricaBiscoito.domain.fila;

import UFLA.avancada.FabricaBiscoito.domain.biscoito.Biscoito;
import UFLA.avancada.FabricaBiscoito.domain.forno.Forno2;
import UFLA.avancada.FabricaBiscoito.domain.linha.*;
import java.util.List;
import java.util.Vector;

public class FilaProducao3 implements Fila {
    private List<Biscoito> biscoitoLista = new Vector<Biscoito>();
    private LinhaProducao3 linhaProducao;
    private LinhaProducao3b linhaProducaob;
    private LinhaProducao3c linhaProducaoc;
    private Forno2 forno;

    private int tamanho = 0;

    public FilaProducao3(LinhaProducao3 linhaProducao, LinhaProducao3b linhaProducaob, LinhaProducao3c linhaProducaoc, Forno2 forno ) {
        this.linhaProducao = linhaProducao;
        this.linhaProducaob = linhaProducaob;
        this.linhaProducaoc = linhaProducaoc;
        this.forno = forno;
    }

    @Override
    public void run() {
        synchronized (this.linhaProducao) {
            System.out.println("procesando biscoito linha de produção 1");
            linhaProducao.montar();
        }

        synchronized (this.linhaProducaob) {
            linhaProducaob.montar();
        }

        synchronized (this.linhaProducaoc) {
            linhaProducaoc.montar();
        }

        synchronized (this.forno) {
            System.out.println("Assando biscoito forno 1");
            forno.assar(biscoitoLista.remove(0));
            biscoitoPronto();
        }
    }

    @Override
    public List<Biscoito> getBiscoitoLista(){
        return this.biscoitoLista;
    }

    @Override
    public int getBiscoitoListaSize() {
        return this.biscoitoLista.size();
    }

    @Override
    public boolean getPermiteRecheado() {
        return false;
    }

    @Override
    public void adicionaBiscoito(Biscoito biscoito) {
        this.biscoitoLista.add(biscoito);
        this.tamanho++;
    }

    @Override
    public Linha getLinha() {
        return this.linhaProducao;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public void biscoitoPronto() {
        this.tamanho--;
    }
}
